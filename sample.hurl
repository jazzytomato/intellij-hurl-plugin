####  ./assert_body.hurl
# Implicit body asserts (base64, multiline, file):

GET http://localhost:8000/assert-body
HTTP 200
```
line1
line2
line3
```

GET http://localhost:8000/assert-body
HTTP 200
file,assert_body.bin;


# Test body response with line ending LF and CRLF.
# We receive the text body "line1\nline2\r\nline3\n"
#
# $ printf "line1\nline2\r\nline3\n" | base64
# bGluZTEKbGluZTINCmxpbmUzCg==

GET http://localhost:8000/assert-body-with-crlf
HTTP 200
base64,bGluZTEKbGluZTINCmxpbmUzCg==;


# Explicit body asserts

GET http://localhost:8000/assert-body
HTTP 200
[Asserts]
body == "line1\nline2\nline3\n"
bytes == file,assert_body.bin;
bytes == hex,6c696e65310a6c696e65320a6c696e65330a;



####  ./assert_header.hurl
GET http://localhost:8000/assert-header
HTTP 200
Content-Type: text/html; charset=utf-8
Set-Cookie: cookie1=value1; Path=/
Set-Cookie: cookie2=value2; Path=/
[Asserts]
header "Custom" not exists
header "Content-Type" exists
header "Header1" == "value1"
header "ETag" == "\"33a64df551425fcc55e4d42a148795d9f25f89d4\""
header "Expires" == "Wed, 21 Oct 2015 07:28:00 GMT"
header "Expires" toDate "%a, %d %b %Y %H:%M:%S GMT" format "%Y" == "2015"
header "Expires" toDate "%a, %d %b %Y %H:%M:%S GMT" daysBeforeNow > 1000
header "Set-Cookie" exists
header "Set-Cookie" count == 3
header "Set-Cookie" includes "cookie1=value1; Path=/"
header "Set-Cookie" not includes "cookie4=value4; Path=/"
header "X-Fruit" isCollection
header "x-fruit" count == 4
header "X-Fruit" nth 0 == "Banana"
header "x-fruit" nth 1 == "Lemon"
header "X-Fruit" nth 2 != "Lemon"
header "X-Fruit" nth 2 == "Grape"
header "X-Fruit" nth 3 == "Strawberry"
header "X-Fruit" includes "Strawberry"


# Same request as previously, but now we check that we can capture the header "X-Fruit" collection as a variable
# before asserting it s values.
GET http://localhost:8000/assert-header
HTTP 200
[Captures]
fruits: header "X-fruit"
[Asserts]
header "X-Fruit" isCollection
variable "fruits" isCollection
variable "fruits" count == 4
variable "fruits" nth 0 == "Banana"
variable "fruits" nth 3 == "Strawberry"


####  ./assert_json.hurl
GET http://localhost:8000/assert-json
[Options]
variable: one=1
variable: two=2
variable: three=3
variable: four=4
variable: five=5
variable: foo=abc
insecure: false
HTTP 200
[Captures]
count: jsonpath "$.count"
[Asserts]
jsonpath "$.count" == 5
jsonpath "$.count" == 5.0
jsonpath "$.count" == {{five}}
jsonpath "$.count" != 4
jsonpath "$.count" != {{four}}
jsonpath "$.count" not == 4
jsonpath "$.count" > 1
jsonpath "$.count" > {{one}}
jsonpath "$.count" > 1.0
jsonpath "$.success" == false
jsonpath "$.success" != null
jsonpath "$.success" exists
jsonpath "$.success" isBoolean
jsonpath "$.errors" count == 2
jsonpath "$.errors" isCollection
jsonpath "$.failures" count == 1
jsonpath "$.failures" isCollection
jsonpath "$.warnings" count == 0
jsonpath "$.warnings" isEmpty
jsonpath "$.toto" not exists
jsonpath "$.failures" exists
jsonpath "$.warnings" exists
jsonpath "$.errors[0]" exists
jsonpath "$.errors[0]" isCollection
jsonpath "$.errors[0].id" == "error1"
jsonpath "$.errors[0].id" isString
jsonpath "$.errors[0]['id']" == "error1"
jsonpath "$.errors[*].id" includes "error1"
jsonpath "$.errors[0,1].id" includes "error1"
jsonpath "$.errors[:2].id" count == 2
jsonpath "$.errors[0:].id" count == 2
jsonpath "$.errors[?(@.id)].id" nth 0 == "error1"
jsonpath "$.errors[?(@.id=='error1')].id" nth 0 == "error1"
jsonpath "$.failures[*].id" includes "failure1"
jsonpath "$.duration" == 1.5
jsonpath "$.duration" <= 2.0
jsonpath "$.duration" < 2
jsonpath "$.duration" < {{two}}
jsonpath "$.duration" isFloat
jsonpath "$.duration" isNumber
jsonpath "$.duration" not isInteger
jsonpath "$.nullable" == null
jsonpath "$.tags[0]" == "test"
jsonpath "$.tags[0]" > "te"
jsonpath "$.tags[0]" < "testabc"
jsonpath "$.tags[0]" <= "test"
jsonpath "$.tags[0]" > "{{foo}}"
jsonpath "$.profile-id" == "123abc"
jsonpath "$['profile-id']" == "123abc"
jsonpath "$.errors[0]" not isEmpty
jsonpath "$.empty" isEmpty
jsonpath "$.*" count == 11
jsonpath "$.errors..*" count == 4
jsonpath "$..id" count == 3
jsonpath "$.dates[0]" isIsoDate
jsonpath "$.dates[1]" isIsoDate
jsonpath "$.tags[0]" not isIsoDate
jsonpath "$.tags[0]" not isNumber


# FIXME do we accept count filter on object?
# jsonpath "$.empty" count == 0
{
  "count": 5,
  "success": false,
  "errors": [{"id":"error1"},{"id":"error2"}],
  "failures": [{"id":"failure1"}],
  "warnings": [],
  "duration": 1.5,
  "tags": ["test"],
  "nullable": null,
  "profile-id": "123abc",
  "dates": [
    "2022-10-31T09:00:00.594Z",
    "2024-03-20T11:23:56.773+02:00"
  ],
  "empty": {}
}


GET http://localhost:8000/assert-json/index
HTTP 200
[Captures]
index: body


GET http://localhost:8000/assert-json
HTTP 200
[Asserts]
jsonpath "$.errors[{{index}}].id" == "error2"
jsonpath "$.tags" includes "test"
jsonpath "$.tags" not includes "prod"
jsonpath "$.tags" not includes null


GET http://localhost:8000/assert-json/list
HTTP 200
[Asserts]
jsonpath "$" count == 2
jsonpath "$.[0].name" == "Bob"
jsonpath "$[0].name" == "Bob"
jsonpath "$.[?(@.id == 1)].name" nth 0 == "Bob"
jsonpath "$[?(@.id == 1)].name" nth 0 == "Bob"


GET http://localhost:8000/assert-json/filter
HTTP 200
[Asserts]
jsonpath "$.fruit[?(@.price.US==200)].name" nth 0 == "grape"
jsonpath "$.fruit.[?(@.US == 100)]" count == 0   # To be clarified with spec: the first fruit is return by jsonpath.com
{
    "fruit": [
        {
            "name": "apple",
            "price": {
                "US": 100,
                "UN": 110
            }
        },
        {
            "name": "grape",
            "price": {
                "US": 200,
                "UN": 150
            }
        }
    ]
}


GET http://localhost:8000/assert-json/filter-by-name
HTTP 200
[Asserts]

jsonpath "$..*[?(@.name)]" count == 5
jsonpath "$..*[?(@.name=='car')].id" nth 0 == 1
jsonpath "$..*[?(@.name=='wheel')].id" nth 0 == 4

jsonpath "$..items[?(@.name)]" count == 5
jsonpath "$..items[?(@.name=='car')].id" nth 0 == 1
jsonpath "$..items[?(@.name=='wheel')].id" nth 0 == 4

jsonpath "$.main.items[?(@.name)]" count == 3
jsonpath "$.main.items[?(@.name=='car')].id" nth 0 == 1
jsonpath "$.main.items[?(@.name=='wheel')].id" isEmpty

jsonpath "$.main..items[?(@.name)]" count == 4
jsonpath "$.main..items[?(@.name=='car')].id" nth 0 == 1
jsonpath "$.main..items[?(@.name=='wheel')].id" nth 0 == 4

{
  "main": {
    "items": [
      {
        "id": 1,
        "name": "car"
      },
      {
        "id": 2,
        "name": "bike",
        "items": [
          {
            "id": 4,
            "name": "wheel"
          }
        ]
      },
      {
        "id": 3,
        "name": "plane"
      }
    ]
  },
  "more": {
    "items": [
      {
        "id": 5,
        "name": "scooter"
      }
    ]
  }
}


GET http://localhost:8000/assert-json/big-number
HTTP 200
[Asserts]
jsonpath "$.big_integer" == 1000000000000000000000
{
  "big_integer": 1000000000000000000000
}


####  ./assert_match.hurl
GET http://localhost:8000/assert-match
HTTP 200
[Asserts]
jsonpath "$.date1" matches "\\d{4}-\\d{2}-\\d{2}"
jsonpath "$.date1" matches /\d{4}-\d{2}-\d{2}/
jsonpath "$.date2" matches /\d{4}-\d{2}-\d{2}/
jsonpath "$.date1" matches /^\d{4}-\d{2}-\d{2}$/
jsonpath "$.date2" not matches /^\d{4}-\d{2}-\d{2}$/
jsonpath "$.path1" matches /aa\/bb/
jsonpath "$.path2" matches /aa\\bb/


####  ./assert_regex.hurl
GET http://localhost:8000/assert-regex
HTTP 200
[Asserts]
regex "Hello ([0-9]+)!" not exists
regex /Hello ([0-9]+)!/ not exists
body regex /Hello ([0-9]+)!/ not exists
regex "Hello ([a-zA-Z]+)!" == "World"
regex /Hello ([a-zA-Z]+)!/ == "World"


####  ./assert_status_code.hurl
GET http://localhost:8000/assert-status-code
HTTP 201


# Assert HTTP 1.1
GET http://localhost:8000/assert-status-code
HTTP/1.1 201


# Simply check that the status code is not 200
# Do not run implicit assert of HTTP response version and code
GET http://localhost:8000/assert-status-code
HTTP *
[Asserts]
status != 200


# Simply check that the status code is OK
GET http://localhost:8000/assert-status-code
HTTP *
[Asserts]
status >= 200
status < 300


####  ./assert_xpath.hurl
GET http://localhost:8000/assert-xpath
HTTP 200
[Asserts]
xpath "normalize-space(//data)" == "café"
xpath "normalize-space(//data)" == "caf\u{00e9}"
xpath "normalize-space(//data)" > "CAFÉ"
xpath "//toto" not exists

<data>café</data>


# Test XPath assert with XML namespace.
GET http://localhost:8000/assert-xpath-simple-namespaces
HTTP 200
[Asserts]

xpath "string(//bk:book/bk:title)" == "Cheaper by the Dozen"
xpath "string(//*[name()='bk:book']/*[name()='bk:title'])" == "Cheaper by the Dozen"
xpath "string(//*[local-name()='book']/*[local-name()='title'])" == "Cheaper by the Dozen"

xpath "string(//bk:book/isbn:number)" == "1568491379"
xpath "string(//*[name()='bk:book']/*[name()='isbn:number'])" == "1568491379"
xpath "string(//*[local-name()='book']/*[local-name()='number'])" == "1568491379"


# Test XPath assert with default XML namespace.
# _ can be used to target a default namespace.
GET http://localhost:8000/assert-xpath-svg
HTTP 200
[Asserts]
xpath "//_:svg/_:g/_:circle" count == 3
xpath "//*[local-name()='svg']/*[local-name()='g']/*[local-name()='circle']" count == 3
xpath "//*[name()='svg']/*[name()='g']/*[name()='circle']" count == 3


# Test XPath assert with default and prefixed XML namespace.
# _ can be used to target a default namespace.
GET http://localhost:8000/assert-xpath-namespaces
HTTP 200
[Asserts]
xpath "string(//_:book/_:title)" == "Cheaper by the Dozen"
xpath "string(//_:book/_:title)" > "Cheaper"
xpath "string(//_:book/isbn:number)" == "1568491379"
xpath "//*[name()='book']/*[name()='notes']" count == 1
xpath "//*[local-name()='book']/*[local-name()='notes']" count == 1
xpath "//_:book/_:notes/*[local-name()='p']" count == 1



####  ./aws_sigv4_option.hurl
POST http://localhost:8000/aws-sigv4
[Options]
aws-sigv4: aws:amz:eu-central-1:hurltest
user: someAccessKeyId:someSecretKey
[FormParams]
test: test
HTTP 200



####  ./basic_authentication.hurl
GET http://localhost:8000/basic-authentication
HTTP 200
`You are authenticated`




####  ./basic_authentication_per_request.hurl
# Authentication with:
#   username=bob@email.com
#   password=secret

# the '@' must be url-escaped
GET http://bob%40email.com:secret@localhost:8000/basic-authentication-per-request
HTTP 200
`You are authenticated`


# Header value can be computed with `echo -n 'bob@email.com:secret' | base64`
GET http://localhost:8000/basic-authentication-per-request
Authorization: Basic Ym9iQGVtYWlsLmNvbTpzZWNyZXQ=
HTTP 200
`You are authenticated`


# We can also use a `[BasicAuth]` section to specify user and password
# without any base64 encoding.
# Note that spaces surrounded user and password are trimmed. If you
# really want a space in your password (!!), you could use Hurl
# unicode literal \u{20}.
GET http://localhost:8000/basic-authentication-per-request
[BasicAuth]
bob@email.com: secret
HTTP 200
`You are authenticated`


# Finally `--user` option can be used per request
GET http://localhost:8000/basic-authentication-per-request
[Options]
user: bob@email.com:secret
HTTP 200
`You are authenticated`


# Variables can also be used with `--user`
GET http://localhost:8000/basic-authentication-per-request
[Options]
variable: user=bob@email.com
variable: password=secret
user: {{user}}:{{password}}
HTTP 200
`You are authenticated`


####  ./bytes.hurl
GET http://localhost:8000/bytes
HTTP 200
Content-Type: application/octet-stream
[Asserts]
bytes == hex,010203;
bytes == base64,AQID;
bytes == file,bytes.bin;
bytes count == 3
bytes startsWith hex,01;
bytes endsWith hex,03;
bytes contains hex,02;
sha256 == hex,039058c6f2c0cb492c533b0a4d14ef77cc0f78abccced5287d84a1a2011cfb81;
md5 == hex,5289df737df57326fcdd22597afb1fac;


####  ./bytes_empty.hurl
GET http://localhost:8000/empty_bytes
HTTP 200
Content-Type: application/octet-stream
[Asserts]
bytes isEmpty
bytes count == 0


####  ./captures.hurl
GET http://localhost:8000/captures
HTTP 200
[Captures]
param1: header "header1"
param2: header "header2" regex "Hello (.*)!"
param3: header "header2" regex /Hello (.*)!/
# With the next captures, we test that the captured variable
# can be immediately used in the next captures + asserts
data1: body
data2: variable "data1"
[Asserts]
header "header1" == "{{param1}}"
variable "param1" == "value1"
variable "param2" == "Bob"
variable "param3" == "Bob"
variable "data2" == "Hello world!"


GET http://localhost:8000/captures-check
[QueryStringParams]
param1: {{param1}}
param2: {{param2}}
HTTP 200


GET http://localhost:8000/captures-xml
HTTP 200
[Captures]
a_node_set: xpath "//p"
[Asserts]
variable "a_node_set" count == 2


GET http://localhost:8000/captures-cookie
HTTP 200
[Captures]
a_cookie_value_attr: cookie "foo"
a_cookie_path_attr: cookie "foo[Path]"
a_cookie_expires_attr: cookie "foo[Expires]"
a_cookie_domain_attr: cookie "foo[Domain]"
a_cookie_max_age_attr: cookie "foo[Max-Age]"
a_cookie_http_only_attr: cookie "foo[HttpOnly]"
[Asserts]
variable "a_cookie_value_attr" == "value1"
variable "a_cookie_value_attr" == {{a_cookie_value_attr}}
variable "a_cookie_path_attr" == "/bar"
variable "a_cookie_path_attr" == {{a_cookie_path_attr}}
variable "a_cookie_expires_attr" format "%Y-%m-%dT%H:%M:%S%.fZ" == "2078-01-13T22:23:01Z"
# FIXME: the next assert should pass
# variable "a_cookie_expires_attr" == {{a_cookie_expires_attr}}
variable "a_cookie_domain_attr" == "localhost"
variable "a_cookie_domain_attr" == {{a_cookie_domain_attr}}
variable "a_cookie_max_age_attr" == 2592000
variable "a_cookie_max_age_attr" == {{a_cookie_max_age_attr}}
variable "a_cookie_http_only_attr" exists



GET http://localhost:8000/captures-json
HTTP 200
[Captures]
an_object: jsonpath "$['an_object']"
a_list: jsonpath "$['a_list']"
a_null: jsonpath "$['a_null']"
an_integer: jsonpath "$['an_integer']"
a_big_integer: jsonpath "$['a_big_integer']"
a_float: jsonpath "$['a_float']"
a_bool: jsonpath "$['a_bool']"
a_string: jsonpath "$['a_string']"
a_date_like_string: jsonpath "$['a_date_like_string']"
a_date: variable "a_date_like_string" toDate "%Y-%m-%dT%H:%M:%S%.fZ"
some_bytes: bytes
all: jsonpath "$"
[Asserts]
variable "a_null" exists
variable "undefined" not exists
variable "a_null" == {{a_null}}
variable "an_integer" == {{an_integer}}
variable "a_big_integer" == {{a_big_integer}}
variable "a_float" == {{a_float}}
variable "a_bool" == {{a_bool}}
variable "a_string" == {{a_string}}
variable "a_string" == "{{a_string}}"
variable "a_list" == {{a_list}}
variable "a_date_like_string" == "2012-04-23T18:25:43.511Z"
variable "some_bytes" startsWith hex,7b22615f6e756c6c223a6e;





####  ./charset.hurl
GET http://localhost:8000/charset/default
HTTP 200
Content-Type: text/html; charset=utf-8
`<p>
    Hello World!
</p>`


GET http://localhost:8000/charset/latin1
HTTP 200
Content-Type: text/html; charset=latin1
[Asserts]
body == "<p>café</p>"


GET http://localhost:8000/charset/latin1/uppercase-key
HTTP 200
Content-Type: text/html; CHARSET=latin1
[Asserts]
body == "<p>café</p>"


GET http://localhost:8000/charset/gb2312
HTTP 200
Content-Type: text/html; charset=gb2312
[Asserts]
body == "<p>你好世界</p>"


GET http://localhost:8000/charset/cp1256
HTTP 200
Content-Type: text/html; charset=cp1256
[Asserts]
body == "<p>مرحبا بالعالم</p>"


GET http://localhost:8000/charset/uppercase-value
HTTP 200
Content-Type: text/html; charset=UTF-8
[Asserts]
body == "<p>Hello World!</p>"


GET http://localhost:8000/charset/many-keys
HTTP 200
Content-Type: text/plain; version=0.0.4; charset=utf-8; escaping=values
[Asserts]
body == "<p>Hello World!</p>"


####  ./color.hurl




####  ./compressed.hurl
# Uncompressed body tests:
# ---------------------------
# --compressed has no effect on non compressed.

GET http://localhost:8000/compressed/none
HTTP 200
Content-Length: 12
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`

# Test base64 implicit body:
GET http://localhost:8000/compressed/none
HTTP 200
base64,SGVsbG8gV29ybGQh;

# Test hex implicit body:
GET http://localhost:8000/compressed/none
HTTP 200
hex,48656c6c6f20576f726c6421;

# Test file implicit body:
GET http://localhost:8000/compressed/none
HTTP 200
file,hello.txt;


# GZip compressed body tests:
# ---------------------------

GET http://localhost:8000/compressed/gzip
HTTP 200
Content-Length: 32
Content-Encoding: gzip
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`

# Test base64 implicit body:
GET http://localhost:8000/compressed/gzip
HTTP 200
base64,SGVsbG8gV29ybGQh;

# Test hex implicit body:
GET http://localhost:8000/compressed/gzip
HTTP 200
hex,48656c6c6f20576f726c6421;

# Test file implicit body:
GET http://localhost:8000/compressed/gzip
HTTP 200
file,hello.txt;


# ZLib compressed body tests:
# ---------------------------

GET http://localhost:8000/compressed/zlib
HTTP 200
Content-Length: 20
Content-Encoding: deflate
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`

# Test base64 implicit body:
GET http://localhost:8000/compressed/zlib
HTTP 200
base64,SGVsbG8gV29ybGQh;

# Test hex implicit body:
GET http://localhost:8000/compressed/zlib
HTTP 200
hex,48656c6c6f20576f726c6421;

# Test file implicit body:
GET http://localhost:8000/compressed/zlib
HTTP 200
file,hello.txt;


# Brotli compressed body tests:
# ---------------------------

GET http://localhost:8000/compressed/brotli
HTTP 200
Content-Length: 17
Content-Encoding: br
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`

# Test base64 implicit body:
GET http://localhost:8000/compressed/brotli
HTTP 200
base64,SGVsbG8gV29ybGQh;

# Test hex implicit body:
GET http://localhost:8000/compressed/brotli
HTTP 200
hex,48656c6c6f20576f726c6421;

# Test file implicit body:
GET http://localhost:8000/compressed/brotli
HTTP 200
file,hello.txt;

# Test a large brotli compressed body:
GET http://localhost:8000/compressed/brotli_large
HTTP 200
Content-Encoding: br
Content-Type: image/jpeg
[Asserts]
bytes startsWith hex,ffd8ffe0;   # JPEG magic number
file,cat.jpg;

GET http://localhost:8000/compressed/brotli_identity
HTTP 200
Content-Length: 17
Content-Encoding: br, identity
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`


####  ./compressed_option.hurl
# Uncompressed body tests:
# ---------------------------
# --compressed has no effect on non compressed.

GET http://localhost:8000/compressed/none
[Options]
compressed: true
HTTP 200
Content-Length: 12
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`


GET http://localhost:8000/compressed/none
[Options]
compressed: false
HTTP 200
Content-Length: 12
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`


# Test base64 implicit body:
GET http://localhost:8000/compressed/none
[Options]
compressed: true
HTTP 200
base64,SGVsbG8gV29ybGQh;


# Test hex implicit body:
GET http://localhost:8000/compressed/none
[Options]
compressed: true
HTTP 200
hex,48656c6c6f20576f726c6421;

# Test file implicit body:
GET http://localhost:8000/compressed/none
[Options]
compressed: true
HTTP 200
file,hello.txt;


# GZip compressed body tests:
# ---------------------------

GET http://localhost:8000/compressed/gzip
[Options]
compressed: true
HTTP 200
Content-Length: 32
Content-Encoding: gzip
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`


# Test base64 implicit body:
GET http://localhost:8000/compressed/gzip
[Options]
compressed: true
HTTP 200
base64,SGVsbG8gV29ybGQh;


# Test hex implicit body:
GET http://localhost:8000/compressed/gzip
[Options]
compressed: true
HTTP 200
hex,48656c6c6f20576f726c6421;


# Test file implicit body:
GET http://localhost:8000/compressed/gzip
[Options]
compressed: true
HTTP 200
file,hello.txt;


# ZLib compressed body tests:
# ---------------------------

GET http://localhost:8000/compressed/zlib
[Options]
compressed: true
HTTP 200
Content-Length: 20
Content-Encoding: deflate
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
`Hello World!`


# Test base64 implicit body:
GET http://localhost:8000/compressed/zlib
[Options]
compressed: true
HTTP 200
base64,SGVsbG8gV29ybGQh;


# Test hex implicit body:
GET http://localhost:8000/compressed/zlib
[Options]
compressed: true
HTTP 200
hex,48656c6c6f20576f726c6421;


# Test file implicit body:
GET http://localhost:8000/compressed/zlib
[Options]
compressed: true
HTTP 200
file,hello.txt;


# Brotli compressed body tests:
# ---------------------------

GET http://localhost:8000/compressed/brotli
[Options]
compressed: true
HTTP 200
Content-Length: 17
Content-Encoding: br
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
```Hello World!```


# Test base64 implicit body:
GET http://localhost:8000/compressed/brotli
[Options]
compressed: true
HTTP 200
base64,SGVsbG8gV29ybGQh;


# Test hex implicit body:
GET http://localhost:8000/compressed/brotli
[Options]
compressed: true
HTTP 200
hex,48656c6c6f20576f726c6421;


# Test file implicit body:
GET http://localhost:8000/compressed/brotli
[Options]
compressed: true
HTTP 200
file,hello.txt;


# Test a large brotli compressed body:
GET http://localhost:8000/compressed/brotli_large
[Options]
compressed: true
HTTP 200
Content-Encoding: br
Content-Type: image/jpeg
[Asserts]
bytes startsWith hex,ffd8ffe0;   # JPEG magic number
file,cat.jpg;


GET http://localhost:8000/compressed/brotli_identity
[Options]
compressed: true
HTTP 200
Content-Length: 17
Content-Encoding: br, identity
Content-Type: text/html; charset=utf-8
[Asserts]
body startsWith "Hello"
bytes startsWith hex,48656c6c6f;
sha256 == hex,7f83b1657ff1fc53b92dc18148a1d65dfc2d4b1fa3d677284addd200126d9069;
md5 == hex,ed076287532e86365e841e92bfc50d8c;
```Hello World!```


####  ./connect_to.hurl
GET http://foo.com/connect-to
HTTP 200
`Hello World!`


GET http://bar.com/connect-to
HTTP 200
`Hello World!`


GET http://baz.com/connect-to
HTTP 200
`Hello World!`


####  ./connect_to_option.hurl
GET http://foo.com/connect-to
[Options]
connect-to: foo.com:80:localhost:8000
HTTP 200
`Hello World!`


GET http://bar.com/connect-to
[Options]
# We test that we can define multiple connect-to options.
connect-to: foo.com:80:localhost:8000
connect-to: bar.com:80:localhost:8000
connect-to: baz.com:80:localhost:8000
HTTP 200
`Hello World!`


GET http://baz.com/connect-to
[Options]
connect-to: foo.com:80:localhost:8000
connect-to: bar.com:80:localhost:8000
connect-to: baz.com:80:localhost:8000
HTTP 200
`Hello World!`


####  ./content_type.hurl
# In various body requests (JSON, XML, form etc...) there is
# no need to provide a Content-Type header, Hurl will infer the right
# content type header depending of the request. That said, user has always
# control over this header and can explicitly override it.

POST http://localhost:8000/content-type-json
{
    "name": "Bob",
    "age": 30
}
HTTP 200

# JSON body using multilines strings:
POST http://localhost:8000/content-type-json
```json
{
    "name": "Bob",
    "age": 30
}
```
HTTP 200

# Without language hints:
POST http://localhost:8000/content-type-json
Content-Type: application/json
```
{
    "name": "Bob",
    "age": 30
}
```
HTTP 200

POST http://localhost:8000/content-type-json
```graphql
{
  project(name: "GraphQL") {
    tagline
  }
}
```
HTTP 200

POST http://localhost:8000/content-type-json
Content-Type: application/json
{
    "name": "Bob",
    "age": 30
}
HTTP 200

POST http://localhost:8000/content-type-vnd-json
Content-Type: application/vnd.api+json
{
    "name": "Bob",
    "age": 30
}
HTTP 200

# "content-type vs "Content-Type": explicit content-type header must override implicit
# content type even if name of the header is in lowercase
POST http://localhost:8000/content-type-vnd-json
content-type: application/vnd.api+json
{
    "name": "Bob",
    "age": 30
}
HTTP 200


POST http://localhost:8000/content-type-form
[FormParams]
field1: foo
field2: bar
field2: baz
HTTP 200

POST http://localhost:8000/content-type-multipart
[MultipartFormData]
field1: foo
field2: bar
field2: baz
HTTP 200

POST http://localhost:8000/content-type-xml
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
HTTP 200

# XML body using multilines strings:
POST http://localhost:8000/content-type-xml
```xml
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```
HTTP 200

# XML body using multilines strings:
POST http://localhost:8000/content-type-xml
Content-Type: application/xml
```
<note>
    <to>Tove</to>
    <from>Jani</from>
    <heading>Reminder</heading>
    <body>Don't forget me this weekend!</body>
</note>
```
HTTP 200


####  ./cookie_file.hurl
GET http://localhost:8000/cookie_file
HTTP 200


####  ./cookie_jar.hurl
# We test the [`--cookie-jar`](https://hurl.dev/docs/manual.html#cookie-jar) option
# that dumps the cookie storage to a file. Due to various support level among
# libcurl implementation for cookie secure export, we limit this test to non secure cookie.

GET http://localhost:8000/cookie-jar
HTTP 200
Set-Cookie: LSID=DQAAAKEaem_vYg; Expires=Thu, 13 Jan 2078 22:23:01 GMT; HttpOnly; Path=/accounts
Set-Cookie: HSID=AYQEVnDKrdst; Domain=localhost; Expires=Thu, 13 Jan 2078 22:23:01 GMT; HttpOnly; Path=/
Set-Cookie: SSID=Ap4PGTEq; Domain=localhost; Expires=Thu, 13 Jan 2078 22:23:01 GMT; HttpOnly; Path=/
[Asserts]
header "Set-Cookie" count == 3
cookie "LSID" == "DQAAAKEaem_vYg"
cookie "LSID[Value]" == "DQAAAKEaem_vYg"
cookie "LSID[Expires]" exists
cookie "LSID[Expires]" format "%a, %d %b %Y %H:%M:%S" == "Thu, 13 Jan 2078 22:23:01"
cookie "LSID[Max-Age]" not exists
cookie "LSID[Domain]" not exists
cookie "LSID[Path]" == "/accounts"
cookie "LSID[Secure]" not exists
cookie "LSID[HttpOnly]" exists
cookie "LSID[SameSite]" not exists


####  ./cookie_storage.hurl
#
# experimental feature
# manage cookie store
#

# @cookie_storage_set: localhost    FALSE   /   FALSE   0   cookie1 valueA
GET http://localhost:8000/cookie-storage/assert-that-cookie1-is-valueA
HTTP 200

# @cookie_storage_clear
GET http://localhost:8000/cookie-storage/assert-that-cookie1-is-not-in-session
HTTP 200




####  ./cookies.hurl
# Request Cookie

GET http://localhost:8000/cookies/set-request-cookie1-valueA
[Cookies]
cookie1: valueA
HTTP 200


# The cookie is not added in the cookie storage
GET http://localhost:8000/cookies/assert-that-cookie1-is-not-in-session
HTTP 200


GET http://localhost:8000/cookies/set-multiple-request-cookies
[Cookies]
user1: Bob
user2: Bill
user3: {{name}}
HTTP 200


# Session Cookie

GET http://localhost:8000/cookies/set-session-cookie2-valueA
HTTP 200
[Asserts]
cookie "cookie1" not exists
cookie "cookie2" == "valueA"
cookie "cookie2[Path]" == "/"
cookie "cookie2[Expires]" not exists


GET http://localhost:8000/cookies/assert-that-cookie2-is-valueA
HTTP 200


GET http://localhost:8000/cookies/assert-that-cookie2-is-valueA-and-valueB
[Cookies]
cookie2: valueB
HTTP 200


GET http://localhost:8000/cookies/delete-cookie2
HTTP 200
[Asserts]
cookie "cookie2" == ""
cookie "cookie2[Max-Age]" == 0


GET http://localhost:8000/cookies/assert-that-cookie2-is-not-in-session
HTTP 200


GET http://localhost:8000/cookies/set
HTTP 200
Set-Cookie: LSID=DQAAAKEaem_vYg; Expires=Wed, 13 Jan 2021 22:23:01 GMT; Secure; HttpOnly; Path=/accounts
Set-Cookie: HSID=AYQEVnDKrdst; Domain=localhost; Expires=Wed, 13 Jan 2021 22:23:01 GMT; HttpOnly; Path=/
Set-Cookie: SSID=Ap4PGTEq; Domain=localhost; Expires=Wed, 13 Jan 2021 22:23:01 GMT; Secure; HttpOnly; Path=/
[Asserts]
header "Set-Cookie" count == 3
cookie "LSID" == "DQAAAKEaem_vYg"
cookie "LSID[Value]" == "DQAAAKEaem_vYg"
cookie "LSID[Expires]" exists
cookie "LSID[Expires]" format "%a, %d %b %Y %H:%M:%S" == "Wed, 13 Jan 2021 22:23:01"
cookie "LSID[Max-Age]" not exists
cookie "LSID[Domain]" not exists
cookie "LSID[Path]" == "/accounts"
cookie "LSID[Secure]" exists
cookie "LSID[HttpOnly]" exists
cookie "LSID[SameSite]" not exists




####  ./delay.hurl
# First, start a timer
GET http://localhost:8000/delay-init
HTTP 200

# This request must reach the server at least 1000ms after the previous request
GET http://localhost:8000/delay
HTTP 200

# This request must reach the server at least 1000ms after the previous request
GET http://localhost:8000/delay
HTTP 200


####  ./delay_option.hurl
# First, start a timer
GET http://localhost:8000/delay-init
HTTP 200

# This request must reach the server at least 1000ms after the first request
GET http://localhost:8000/delay
[Options]
delay: 1000
HTTP 200


####  ./deprecated.hurl
# HTTP/* is deprecated, use HTTP instead
GET http://localhost:8000/hello
HTTP/* 200

# ```Hello World!``` is deprecated, use `Hello World!` instead
GET http://localhost:8000/hello
HTTP/* 200
```Hello World!```


####  ./empty.hurl




####  ./empty_sections.hurl
GET http://localhost:8000/hello
[Options]
[QueryStringParams]
# FIXME: [BasicAuth] section can't be empty
#[BasicAuth]
[FormParams]
[MultipartFormData]
[Cookies]
HTTP 200
`Hello World!`


####  ./encoding.hurl
GET http://localhost:8000/encoding/utf8
HTTP 200
Content-Type: text/html; charset=utf-8
[Asserts]
body == "caf\u{e9}"


GET http://localhost:8000/encoding/latin1
HTTP 200
Content-Type: text/html; charset=ISO-8859-1
[Asserts]
body == "caf\u{e9}"




####  ./entry.hurl
GET http://localhost:8000/to-entry/1
[Options]
output: -
HTTP 200
`Reached entry 1\n`

GET http://localhost:8000/to-entry/2
[Options]
output: -
HTTP 200
`Reached entry 2\n`

GET http://localhost:8000/to-entry/3
[Options]
output: -
HTTP 200
`Reached entry 3\n`

GET http://localhost:8000/to-entry/4
[Options]
output: -
HTTP 200
`Reached entry 4\n`

GET http://localhost:8000/to-entry/5
[Options]
output: -
HTTP 200
`Reached entry 5\n`

GET http://localhost:8000/to-entry/6
[Options]
output: -
HTTP 200
`Reached entry 6\n`


####  ./env_var.hurl
GET http://localhost:8000/env-var
[QueryStringParams]
name: {{name}}
HTTP 200



####  ./expect.hurl
POST http://localhost:8000/expect
Expect: 100-continue
`data`
HTTP 200


####  ./fileroot.hurl
# --file-root access is currently used for input and output files that are referenced in a Hurl file.
# User explicitly sets a "file root" through the command line, which acts as the parent of relatives path used
# in the Hurl file. Without specifying this "file root", the Hurl file's directory is used as "file root".

GET http://localhost:8000/fileroot
[Options]
output: fileroot.bin
HTTP 200


POST http://localhost:8000/fileroot
file,fileroot.bin;
HTTP 200


# Paths are OK if they are descendant of the file root.
POST http://localhost:8000/fileroot
file,../build/fileroot.bin;
HTTP 200


####  ./filter.hurl
GET http://localhost:8000/filter
HTTP 200
[Captures]
url: jsonpath "$.url"
text: jsonpath "$.text"
[Asserts]
jsonpath "$.list" count == 3
jsonpath "$.list" nth 1 == 2
jsonpath "$.message" regex /Hello (.*)!/ == "Bob"
jsonpath "$.url" == "https://mozilla.org/?x=шеллы"
jsonpath "$.url" urlEncode == "https%3A//mozilla.org/%3Fx%3D%D1%88%D0%B5%D0%BB%D0%BB%D1%8B"
jsonpath "$.encoded_url" urlDecode == "https://mozilla.org/?x=шеллы"
variable "url" urlEncode urlDecode == "{{url}}"
jsonpath "$.text" == "a > b && a < c"
jsonpath "$.text" htmlEscape == "a &gt; b &amp;&amp; a &lt; c"
jsonpath "$.escaped_html[0]" htmlUnescape == "a > b && a < c"
jsonpath "$.escaped_html[1]" htmlUnescape == "Foo © bar 𝌆 baz ☃ qux"
jsonpath "$.escaped_html[2]" htmlUnescape == "A foo"
variable "text" htmlEscape htmlUnescape == "{{text}}"
jsonpath "$.id" toInt == 123
jsonpath "$.score" toInt == 1
jsonpath "$.ips" split ", " count == 3
jsonpath "$.ips" replace ", " "|" == "192.168.2.1|10.0.0.20|10.0.0.10"
jsonpath "$.json" jsonpath "$.message" == "Hello"
{
  "list": [1,2,3],
  "message": "Hello Bob!",
  "url": "https://mozilla.org/?x=шеллы",
  "encoded_url": "https://mozilla.org/?x=%D1%88%D0%B5%D0%BB%D0%BB%D1%8B",
  "text": "a > b && a < c",
  "escaped_html": [
    "a &gt; b &amp;&amp; a &lt; c",
    "Foo &#xA9; bar &#x1D306; baz &#x2603; qux",
    "&#65 foo"
  ],
  "id": "123",
  "score": 1.6,
  "ips": "192.168.2.1, 10.0.0.20, 10.0.0.10",
  "json": "{\"message\": \"Hello\"}"
}


####  ./float.hurl
GET http://localhost:8000/float
HTTP 200
[Asserts]
jsonpath "$[1]" == 0.0
jsonpath "$[2]" != 0.0
jsonpath "$[2]" == 0.0000000000000001
jsonpath "$[3]" == 0.000000000000001
jsonpath "$[4]" == 0.333
jsonpath "$[4]" != 0.3333333333333333
jsonpath "$[5]" == 0.3333333333333333
jsonpath "$[5]" == 0.333333333333333333  # exceeding floating-point precision in expected value
jsonpath "$[6]" == 0.333333333333333333  # exceeding floating-point precision in json response
jsonpath "$[7]" == 1.0
jsonpath "$[7]" == 1                     # using an expected integer
jsonpath "$[8]" == 1.001
jsonpath "$[9]" == 1.07
jsonpath "$[9]" == 1.070                 # additional trailing zero in expected value
jsonpath "$[10]" == 1.07                 # additional trailing zero in json response
jsonpath "$[11]" == 1.1
jsonpath "$[12]" == 1.5
[ -2.2, 0.0, 0.0000000000000001, 0.000000000000001, 0.333, 0.3333333333333333, 0.333333333333333333, 1.0, 1.001, 1.07, 1.070, 1.1, 1.5 ]


####  ./follow_redirect.hurl
# Hurl implements curl's behaviour on redirect:
#
# From <https://curl.se/docs/manpage.html#-L>:
# > When curl follows a redirect and if the request is a POST, it sends the following request
# > with a GET if the HTTP response was 301, 302, or 303. If the response code was any other 3xx
# > code, curl resends the following request using the same unmodified method.
#
# In the following test, we send an `Accept` header to check that any header (except `Authorization`
# are redirected to the final URL.

GET http://localhost:8000/follow-redirect
Accept: text/plain
HTTP 200
[Asserts]
url == "http://localhost:8000/followed-redirect"
`Followed redirect!`


# On 301, 302, 303, redirected request switch to GET.
# Otherwise, method are untouched.
POST http://localhost:8000/follow-redirect
Accept: text/plain
HTTP 200
[Asserts]
url == "http://localhost:8000/followed-redirect"
`Followed redirect!`

# Check relative redirection
GET http://localhost:8000/follow-redirect/relative/foo
Accept: text/plain
HTTP 200
[Asserts]
url == "http://localhost:8000/follow-redirect/bar"
`Followed relative redirect!`


# Do not forward `Authorization` header to a different host
GET http://localhost:8000/follow-redirect-basic-auth?change_host=true
Authorization: Basic Ym9iQGVtYWlsLmNvbTpzZWNyZXQ=
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect without Authorization header!`


# Same has previous but the host doesn't change during redirection.
# Back checks will insure that `Authorization` is forwarded.
GET http://localhost:8000/follow-redirect-basic-auth?change_host=false
Authorization: Basic Ym9iQGVtYWlsLmNvbTpzZWNyZXQ=
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect with Authorization header!`


# Another kinds of user authentication with `--user` in `[Options]` section:
GET http://localhost:8000/follow-redirect-basic-auth?change_host=true
[Options]
user: bob@email.com:secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect without Authorization header!`


GET http://localhost:8000/follow-redirect-basic-auth?change_host=false
[Options]
user: bob@email.com:secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect with Authorization header!`


# Another kinds of user authentication with `[BasicAuth]` section:
GET http://localhost:8000/follow-redirect-basic-auth?change_host=true
[BasicAuth]
bob@email.com: secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect without Authorization header!`


GET http://localhost:8000/follow-redirect-basic-auth?change_host=false
[BasicAuth]
bob@email.com: secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect with Authorization header!`


POST http://localhost:8000/follow-redirect-308
Accept: text/plain
HTTP 200
[Asserts]
url == "http://localhost:8000/followed-redirect-post"
`Followed redirect POST!`


####  ./follow_redirect_option.hurl
# By default, redirect are not followed
GET http://localhost:8000/follow-redirect
Accept: text/plain
HTTP 302
[Asserts]
header "Location" == "http://localhost:8000/following-redirect"


GET http://localhost:8000/follow-redirect
Accept: text/plain
[Options]
location: false
HTTP 302
[Asserts]
header "Location" == "http://localhost:8000/following-redirect"


GET http://localhost:8000/follow-redirect
Accept: text/plain
[Options]
location: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect!`


# On 301, 302, 303, redirected request switch to GET.
# Otherwise, method are untouched.
POST http://localhost:8000/follow-redirect
Accept: text/plain
[Options]
location: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect!`


POST http://localhost:8000/follow-redirect-308
Accept: text/plain
[Options]
location: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect POST!`


GET http://localhost:8000/follow-redirect/relative/foo
Accept: text/plain
[Options]
location: true
HTTP 200
[Asserts]
url == "http://localhost:8000/follow-redirect/bar"
`Followed relative redirect!`


# Do not forward `Authorization` header to a different host
GET http://localhost:8000/follow-redirect-basic-auth?change_host=true
Authorization: Basic Ym9iQGVtYWlsLmNvbTpzZWNyZXQ=
[Options]
location: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect without Authorization header!`


# Same has previous but the host doesn't change during redirection.
# Back checks will insure that `Authorization` is forwarded.
GET http://localhost:8000/follow-redirect-basic-auth?change_host=false
Authorization: Basic Ym9iQGVtYWlsLmNvbTpzZWNyZXQ=
[Options]
location: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect with Authorization header!`


# Another kinds of user authentication with `--user` in `[Options]` section:
GET http://localhost:8000/follow-redirect-basic-auth?change_host=true
[Options]
location: true
user: bob@email.com:secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect without Authorization header!`


GET http://localhost:8000/follow-redirect-basic-auth?change_host=false
[Options]
location: true
user: bob@email.com:secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect with Authorization header!`


# Another kinds of user authentication with `[BasicAuth]` section:
GET http://localhost:8000/follow-redirect-basic-auth?change_host=true
[Options]
location: true
[BasicAuth]
bob@email.com: secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect without Authorization header!`


GET http://localhost:8000/follow-redirect-basic-auth?change_host=false
[Options]
location: true
[BasicAuth]
bob@email.com: secret
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect with Authorization header!`


# Forward authorization header to a different host explicitly
GET http://localhost:8000/follow-redirect-basic-auth-trusted
Authorization: Basic Ym9iQGVtYWlsLmNvbTpzZWNyZXQ=
[Options]
location-trusted: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect Basic Auth!`


####  ./form_params.hurl
POST http://localhost:8000/form-params
[FormParams]
param1: value1
param2:
param3: a=b
param4: a%3db
values\u{5b}0\u{5d}: 0
values[1]: 1
HTTP 200

# same version as raw
POST http://localhost:8000/form-params
Content-Type: application/x-www-form-urlencoded
`param1=value1&param2=&param3=a%3db&param4=a%253db&values[0]=0&values[1]=1`
HTTP 200


####  ./gb2312.hurl
# In this test, the data returned by the server is encoded using GB2312.
# Meanwhile, the 'Content-Type' HTTP response header doesn't precise
# any charset.
GET http://localhost:8000/gb2312
HTTP 200
[Asserts]
header "Content-Type" == "text/html"
bytes contains hex,c4e3bac3cac0bde7; # 你好世界 encoded in GB2312
bytes decode "gb2312" contains "你好"



####  ./get_large.hurl
GET http://localhost:8000/get_large
HTTP 200
Content-Type: application/octet-stream
Content-Length: 536870912
[Asserts]
duration <= 30000   # Duration in ms



####  ./graphql.hurl
# An unnamed simple query
POST http://localhost:8000/graphql
```graphql
{
  allFilms {
    films {
      title
      director
      releaseDate
    }
  }
}
```
HTTP 200
[Asserts]
jsonpath "$.data.allFilms.films" count == 6
jsonpath "$.data.allFilms.films[0].title" == "A New Hope"
jsonpath "$.data.allFilms.films[0].director" == "George Lucas"
jsonpath "$.data.allFilms.films[0].releaseDate" == "1977-05-25"
jsonpath "$.data.allFilms.films[0].openingCrawl" not exists
jsonpath "$.data.allFilms.films[1].title" == "The Empire Strikes Back"
jsonpath "$.data.allFilms.films[2].title" == "Return of the Jedi"


# Equivalent syntax by posting a JSON body
POST http://localhost:8000/graphql
Content-Type: application/json
{"query":"{\n  allFilms {\n    films {\n      title\n      director\n      releaseDate\n    }\n  }\n}"}
HTTP 200
[Asserts]
jsonpath "$.data.allFilms.films" count == 6


# Full syntax for query
POST http://localhost:8000/graphql
```graphql
query Query {
  allFilms {
    films {
      title
      director
      releaseDate
    }
  }
}
```
HTTP 200
[Asserts]
jsonpath "$.data.allFilms.films" count == 6


# Query with variables:
POST http://localhost:8000/graphql
```graphql
query Person($id: ID!) {
  person(id: $id) {
    name
  }
}

variables {
  "id": "cGVvcGxlOjQ="
}
```
HTTP 200
[Asserts]
jsonpath "$.data.person.name" == "Darth Vader"


# Hurl variables can also be used:
POST http://localhost:8000/graphql
[Options]
variable: id=cGVvcGxlOjQ=
```graphql
query Person($id: ID!) {
  person(id: $id) {
    name
  }
}

variables {
  "id": "{{id}}"
}
```
HTTP 200
[Asserts]
jsonpath "$.data.person.name" == "Darth Vader"


####  ./head.hurl
HEAD http://localhost:8000/head
HTTP 200
Content-Type: text/html; charset=utf-8
Content-Length: 10
Server: Flask Server
[Asserts]
bytes count == 0



####  ./headers.hurl
GET http://localhost:8000/default-headers
HTTP 200

GET http://localhost:8000/default-headers
User-Agent: hurl/1.0
Host: localhost:8000  # Comment
HTTP 200

GET http://localhost:8000/default-headers
User-Agent: hurl/1.0
Host: localhost:8000  # Comment
HTTP 200

GET http://localhost:8000/custom-headers
Fruit: Raspberry
Fruit: Apple
Fruit: Banana
Fruit: Grape
Color: Green
HTTP 200

GET http://localhost:8000/custom-headers
# Headers name/value can use templates
{{key}}: Raspberry
{{key}}: Apple
{{key}}: Banana
{{key}}: {{foo}}
Color: {{color}}
[Options]
variable: key=Fruit
variable: color=Green
variable: foo=Grape
HTTP 200

GET http://localhost:8000/custom-headers-utf8
Beverage: café  # Send the utf8 string - expected to be decoded as ascii in the server side
HTTP 200

GET http://localhost:8000/custom-headers-value
Id: \#123       # Send a hash in the value
HTTP 200

GET http://localhost:8000/custom-headers-quote
Header1: '
HTTP 200

GET http://localhost:8000/response-headers
HTTP 200
Beverage: cafe  # TBC send utf8


####  ./hello.hurl
GET http://localhost:8000/hello
HTTP 200
Content-Type: text/html; charset=utf-8
Content-Length: 12
[Asserts]
header "Date" exists
`Hello World!`

GET http://localhost:8000/hello
HTTP 200
file, data.txt;

GET http://localhost:8000/hello
HTTP 200
hex, 48656c6c6f20576f726c6421;

GET http://localhost:8000/hello
HTTP 200
base64, SGVsbG8gV29ybGQh;


####  ./hello_gb2312.hurl
# In this test, the data returned by the server is encoded using GB2312.

# The 'Content-Type' HTTP response header precise the charset 'gb2312'
# so any text based assert are using GB2312 and can be used.
# See the sibling fail test where there is no charset => tests_failed/hello_gb2312_failed.hurl
GET http://localhost:8000/hello_gb2312
HTTP 200
[Asserts]
header "Content-Type" == "text/html; charset=gb2312"
bytes contains hex,c4e3bac3cac0bde7; # 你好世界 encoded in GB2312
xpath "string(//body)" == "你好世界"


# The 'Content-Type' HTTP response header does not precise the charset 'gb2312'
# so body must be decoded explicitly by Hurl before processing any text based assert
GET http://localhost:8000/hello_gb2312_implicit
HTTP 200
[Asserts]
header "Content-Type" == "text/html"
bytes contains hex,c4e3bac3cac0bde7; # 你好世界 encoded in GB2312
bytes decode "gb2312" xpath "string(//body)" == "你好世界"


####  ./http_version_10.hurl
GET http://localhost:8000/http_version/10
HTTP 200


####  ./http_version_11.hurl
GET http://localhost:8000/http_version/11
HTTP 200


####  ./http_version_2_option.hurl
# Live tests on google.com
HEAD https://google.com
HTTP/2 *


HEAD https://google.com
[Options]
http2: true
HTTP/2 *


HEAD https://google.com
[Options]
http2: false
HTTP/1.1 *


HEAD https://google.com
HTTP/2 *


HEAD https://google.com
HTTP/2 *


####  ./http_version_3_option.hurl
# Live tests on google.com
HEAD https://google.com
HTTP/2 *


HEAD https://google.com
[Options]
http3: true
HTTP/3 *


HEAD https://google.com
[Options]
http3: false
HTTP/2 *


# Downgrade to HTTP 2 is working
HEAD https://google.com
[Options]
http2: true
HTTP/2 *


# Downgrade to HTTP 1.1 is working
HEAD https://google.com
[Options]
http1.1: true
HTTP/1.1 *


####  ./http_version_option.hurl
GET http://localhost:8000/http_version/10
[Options]
http1.0: true
HTTP 200

# RFC 2616 requires that HTTP servers always begin their responses with
# the highest HTTP version that they claim to support. So the HTTP version can
# be different from what the client used in their request.
# See <https://serverfault.com/questions/1059870/why-does-apache-send-http-1-1-when-client-requests-http-1-0-and-many-other-very>
# We validate on the Flask endpoint `http_version.py` that the version asked by the client is the right one.
GET http://localhost:8000/http_version/10
[Options]
http1.0: true
HTTP/1.1 200

# Default HTTP version for Flask is HTTP/1.1
GET http://localhost:8000/http_version/11
HTTP 200

GET http://localhost:8000/http_version/11
[Options]
http1.1: true
HTTP 200

# The last option win
GET http://localhost:8000/http_version/11
[Options]
http1.0: true
http1.1: true
HTTP 200

GET http://localhost:8000/http_version/11
[Options]
http1.0: false
HTTP 200

# Live test on google.fr
HEAD https://google.com
[Options]
http1.0: true
HTTP/1.0 *

HEAD https://google.com
[Options]
http1.1: true
HTTP/1.1 *


####  ./ignore_asserts.hurl
GET http://localhost:8000/ignore_asserts
HTTP 666
[Asserts]
body == "Whatever"


####  ./include.hurl
GET http://localhost:8000/include
HTTP 200
`Hello`



####  ./insecure_option.hurl
GET http://localhost:8000/hello
[Options]
# Option insecure has no effect on HTTP endpoint
insecure: false
HTTP 200
`Hello World!`


####  ./json_output.hurl
# A test file with asserts, captures, redirection
# to test structured JSON output (with --json).


# Simple GET
GET http://localhost:8000/hello
HTTP 200
`Hello World!`


# Cookies!
GET http://localhost:8000/cookies/set-session-cookie2-valueA
HTTP 200
[Asserts]
cookie "cookie2" == "valueA"


# No redirect
GET http://localhost:8000/follow-redirect
Accept: text/plain
HTTP 302
[Asserts]
header "Location" == "http://localhost:8000/following-redirect"


# With redirect
GET http://localhost:8000/follow-redirect
Accept: text/plain
[Options]
location: true
HTTP 200
[Asserts]
header "Location" not exists
`Followed redirect!`


# Some Captures
GET http://localhost:8000/captures
HTTP 200
[Captures]
param1: header "header1"
param2: header "header2" regex "Hello (.*)!"
param3: header "header2" regex /Hello (.*)!/
data1: body
data2: variable "data1"


# Some JSON asserts
GET http://localhost:8000/assert-json
HTTP 200
[Asserts]
jsonpath "$.errors[1].id" == "error2"
jsonpath "$.tags" includes "test"
jsonpath "$.tags" not includes "prod"
jsonpath "$.tags" not includes null




####  ./jsonpath_store.hurl
# Example from https://goessner.net/articles/JsonPath/
GET http://localhost:8000/json/store
HTTP 200
[Asserts]
jsonpath "$.store.book[*].author" count == 4                             # the authors of all books in the store
jsonpath "$.store.book[*].author" nth 0 == "Nigel Rees"
jsonpath "$.store.book[*].author" nth 1 == "Evelyn Waugh"
jsonpath "$.store.book[*].author" nth 2 == "Herman Melville"
jsonpath "$.store.book[*].author" nth 3 == "J. R. R. Tolkien"
jsonpath "$..author" count == 4	                                           # all authors
jsonpath "$..author" nth 0 == "Nigel Rees"
jsonpath "$..author" nth 1 == "Evelyn Waugh"
jsonpath "$..author" nth 2 == "Herman Melville"
jsonpath "$..author" nth 3 == "J. R. R. Tolkien"
jsonpath "$.store.*" count == 2                             	           # all things in store, which are some books and a red bicycle.
jsonpath "$.store..price" count == 5                 	                   #  the price of everything in the store.
jsonpath "$..book[2].title" nth 0 == "Moby Dick"                           # the third book
#jsonpath "$..book[(@.length-1)]" nth 0 == "fiction"                       # not supported yet
jsonpath "$..book[-1:].title" nth 0 == "The Lord of the Rings"             # the last book in order.
jsonpath "$..book[0,1]" count == 2                                         # the first two books
jsonpath "$..book[0,1].title" nth 0 == "Sayings of the Century"
jsonpath "$..book[0,1].title" nth 1 == "Sword of Honour"
jsonpath "$..book[:2]" count == 2
jsonpath "$..book[:2].title" nth 0 == "Sayings of the Century"
jsonpath "$..book[:2].title" nth 1 == "Sword of Honour"
jsonpath "$..book[?(@.isbn)]" count == 2                                   # filter all books with isbn number
jsonpath "$..book[?(@.isbn)].title" nth 0 == "Moby Dick"
jsonpath "$..book[?(@.isbn)].title" nth 1 == "The Lord of the Rings"
jsonpath "$..book[?(@.price<10)]" count == 2                               # filter all books cheaper than 10
jsonpath "$..book[?(@.price<10)].title" nth 0 == "Sayings of the Century"
jsonpath "$..book[?(@.price<10)].title" nth 1 == "Moby Dick"
jsonpath "$..*" count == 27             	                               # all Elements in XML document. All members of JSON structure.

{
  "store": {
    "book": [
      { "category": "reference",
        "author": "Nigel Rees",
        "title": "Sayings of the Century",
        "price": 8.95
      },
      { "category": "fiction",
        "author": "Evelyn Waugh",
        "title": "Sword of Honour",
        "price": 12.99
      },
      { "category": "fiction",
        "author": "Herman Melville",
        "title": "Moby Dick",
        "isbn": "0-553-21311-3",
        "price": 8.99
      },
      { "category": "fiction",
        "author": "J. R. R. Tolkien",
        "title": "The Lord of the Rings",
        "isbn": "0-395-19395-8",
        "price": 22.99
      }
    ],
    "bicycle": {
      "color": "red",
      "price": 19.95
    }
  }
}


####  ./key_template.hurl
# Test template in the different Hurl "keys"

GET http://localhost:8000/key-template/header
{{key}}: value
[Options]
variable: key=name
HTTP 200

GET http://localhost:8000/key-template/querystring
[Options]
variable: key=name
[QueryStringParams]
{{key}}: value
HTTP 200

POST http://localhost:8000/key-template/form
[Options]
variable: key=name
[FormParams]
{{key}}: value
HTTP 200

POST http://localhost:8000/key-template/multipart-form-data
[Options]
variable: key1=name
variable: key2=file
[MultipartFormData]
{{key1}}: value
{{key2}}: file,data.txt;
HTTP 200

GET http://localhost:8000/key-template/cookie
[Options]
variable: key=name
[Cookies]
{{key}}: value
HTTP 200

GET http://localhost:8000/key-template/capture
[Options]
variable: key=name
HTTP 200
[Captures]
{{key}}: body
[Asserts]
variable "name" == "Hello"



####  ./method.hurl
GET http://localhost:8000/methods/get
HTTP 200

HEAD http://localhost:8000/methods/head
HTTP 200

POST http://localhost:8000/methods/post
HTTP 200

PUT http://localhost:8000/methods/put
HTTP 200

DELETE http://localhost:8000/methods/delete
HTTP 200

CONNECT http://localhost:8000/methods/connect
HTTP 200

OPTIONS http://localhost:8000/methods/options
HTTP 200

TRACE http://localhost:8000/methods/trace
HTTP 200

PATCH http://localhost:8000/methods/patch
HTTP 200

LINK http://localhost:8000/methods/link
HTTP 200

UNLINK http://localhost:8000/methods/unlink
HTTP 200

PURGE http://localhost:8000/methods/purge
HTTP 200

LOCK http://localhost:8000/methods/lock
HTTP 200

UNLOCK http://localhost:8000/methods/unlock
HTTP 200

PROPFIND http://localhost:8000/methods/propfind
HTTP 200

VIEW http://localhost:8000/methods/view
HTTP 200


####  ./multilines.hurl
# In each request, we sent a multiline body and get
# the same body as response. Request body is tested server side
# and we assert the response here.

POST http://localhost:8000/multilines/plain-text
```
line1
line2
line3
```
HTTP 200
# Different ways of testing body response:
# with explicit asserts:
[Asserts]
body == "line1\nline2\nline3\n"
body == ```
line1
line2
line3
```
# Or we can just test the body (implicit assert):
```
line1
line2
line3
```


POST http://localhost:8000/multilines/json
```json
{
  "foo": "bar",
  "baz": 123456
}
```
HTTP 200
# Different ways of testing body response:
# with explicit asserts:
[Asserts]
body == "{\n  \"foo\": \"bar\"\n  \"baz\": 123456\n}\n"
body == ```json
{
  "foo": "bar",
  "baz": 123456
}
```
# Or we can just test the body (implicit assert):
```json
{
  "foo": "bar",
  "baz": 123456
}
```



POST http://localhost:8000/multilines/xml
```xml
<?xml version="1.0"?>
<catalog>
    <book id="bk101">
        <author>Gambardella, Matthew</author>
        <title>XML Developer's Guide</title>
        <genre>Computer</genre>
        <price>44.95</price>
        <publish_date>2000-10-01</publish_date>
        <description>An in-depth look at creating applications
        with XML.</description>
    </book>
</catalog>
```
HTTP 200
# Different ways of testing body response:
# with explicit asserts:
[Asserts]
body == "<?xml version=\"1.0\"?>\n<catalog>\n    <book id=\"bk101\">\n        <author>Gambardella, Matthew</author>\n        <title>XML Developer's Guide</title>\n        <genre>Computer</genre>\n        <price>44.95</price>\n        <publish_date>2000-10-01</publish_date>\n        <description>An in-depth look at creating applications\n        with XML.</description>\n    </book>\n</catalog>\n"
body == ```xml
<?xml version="1.0"?>
<catalog>
    <book id="bk101">
        <author>Gambardella, Matthew</author>
        <title>XML Developer's Guide</title>
        <genre>Computer</genre>
        <price>44.95</price>
        <publish_date>2000-10-01</publish_date>
        <description>An in-depth look at creating applications
        with XML.</description>
    </book>
</catalog>
```
# Or we can just test the body (implicit assert):
```xml
<?xml version="1.0"?>
<catalog>
    <book id="bk101">
        <author>Gambardella, Matthew</author>
        <title>XML Developer's Guide</title>
        <genre>Computer</genre>
        <price>44.95</price>
        <publish_date>2000-10-01</publish_date>
        <description>An in-depth look at creating applications
        with XML.</description>
    </book>
</catalog>
```



POST http://localhost:8000/multilines/graphql
```graphql
{
  hero {
    name
    # Queries can have comments!
    friends {
      name
    }
  }
}
```
HTTP 200
# Different ways of testing body response:
# with explicit asserts:
[Asserts]
body == "{\"query\":\"{\\n  hero {\\n    name\\n    # Queries can have comments!\\n    friends {\\n      name\\n    }\\n  }\\n}\"}"
body == ```graphql
{
  hero {
    name
    # Queries can have comments!
    friends {
      name
    }
  }
}
```
# Or we can just test the body (implicit assert):
```graphql
{
  hero {
    name
    # Queries can have comments!
    friends {
      name
    }
  }
}
```


####  ./multipart_form_data.hurl
# On can use the dedicated [MultipartFormData] section
POST http://localhost:8000/multipart-form-data
[MultipartFormData]
key1: value1
upload1: file,data.txt;
upload2: file,data.html;
upload3: file,data.txt; text/html
HTTP 200


# Or, as an alternative to the [MultipartFormData] section, we can just use
# a multiline string body, constructing boundaries by hand (see https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/POST).
# The downside of this method is that we must inline the files content (for the moment).
POST http://localhost:8000/multipart-form-data
Content-Type: multipart/form-data; boundary="boundary"
```
--boundary
Content-Disposition: form-data; name="key1"

value1
--boundary
Content-Disposition: form-data; name="upload1"; filename="data.txt"
Content-Type: text/plain

Hello World!
--boundary
Content-Disposition: form-data; name="upload2"; filename="data.html"
Content-Type: text/html

<div>Hello <b>World</b>!</div>
--boundary
Content-Disposition: form-data; name="upload3"; filename="data.txt"
Content-Type: text/html

Hello World!
--boundary--
```
HTTP 200


####  ./netrc.hurl
GET http://localhost:8000/basic-authentication
HTTP 200


####  ./netrc_option.hurl
GET http://localhost:8000/basic-authentication
[Options]
netrc-file: tests_ok/netrc_file.netrc
HTTP 200


####  ./no_entry.hurl
# all the entries
# have been commented


####  ./no_output.hurl
# Test the option --no-output (see <https://hurl.dev/docs/manual.html#no-output>)
GET http://localhost:8000/no-output
HTTP 200


####  ./non_utf8.hurl
GET http://localhost:8000/non-utf8
HTTP 200



####  ./options_template.hurl
# Reuse existing tests with options
# using template

GET http://localhost:8000/redirect-absolute
[Options]
variable: redirect=true
location: {{redirect}}

GET http://localhost:8000/delay-init
HTTP 200

GET http://localhost:8000/delay # This request must reach the server at least 1000ms after the previous request
[Options]
variable: duration=1000
delay: {{duration}}
HTTP 200

GET http://bar.com:8000/resolve
[Options]
variable: port=8000
resolve: bar.com:{{port}}:127.0.0.1
HTTP 200
`Hello World!`


####  ./output.hurl
# Test the option --output (see <https://hurl.dev/docs/manual.html#output>)
POST http://localhost:8000/output/endpoint1
{ "user": "bob" }
HTTP 200


GET http://localhost:8000/output/endpoint2
HTTP 200


####  ./output_option.hurl
POST http://localhost:8000/output/endpoint1
[Options]
output: ../build/output_request_1.bin
{ "user": "bob" }
HTTP 200


# output options supports templating
GET http://localhost:8000/output/endpoint2
[Options]
variable: filename=output_request_2
output: ../build/{{filename}}.bin
HTTP 200


GET http://localhost:8000/output/endpoint3
HTTP 200


####  ./parallel.hurl
GET http://localhost:8000/parallel/hello?name={{name}}
[Options]
delay: 5000
HTTP 200
`Hello Bob from a parallel world!\n`


####  ./parallel_a.hurl
GET http://localhost:8000/parallel/hello?name=A
HTTP 200
`Hello A from a parallel world!\n`


####  ./parallel_b.hurl
GET http://localhost:8000/parallel/hello?name=B
HTTP 200
`Hello B from a parallel world!\n`


####  ./parallel_c.hurl
GET http://localhost:8000/parallel/hello?name=C
HTTP 200
`Hello C from a parallel world!\n`


####  ./parallel_d.hurl
GET http://localhost:8000/parallel/hello?name=D
HTTP 200
`Hello D from a parallel world!\n`


####  ./parallel_e.hurl
GET http://localhost:8000/parallel/hello?name=E
HTTP 200
`Hello E from a parallel world!\n`


####  ./parallel_f.hurl
GET http://localhost:8000/parallel/hello?name=F
HTTP 200
`Hello F from a parallel world!\n`


####  ./parallel_g.hurl
GET http://localhost:8000/parallel/hello?name=G
HTTP 200
`Hello G from a parallel world!\n`


####  ./patch.hurl
# Sample from https://developer.mozilla.org/en-US/docs/Web/HTTP/Methods/PATCH
PATCH http://localhost:8000/patch/file.txt
Host: www.example.com
Content-Type: application/example
If-Match: "e0023aa4e"
HTTP 204
Content-Location: /file.txt
ETag: "e0023aa4f"


####  ./path_as_is.hurl
# Setting the option path-as-is
# the path is sent as it is (provided in the url)
GET http://localhost:8000/path-as-is/../resource
HTTP 200




####  ./path_as_is_option.hurl
# Dot segments are removed by default
# the sequence "any/../" evaluate to nothing
# therefore the url sent is http://localhost:8000/hello
GET http://localhost:8000/any/../hello
HTTP 200
`Hello World!`

# Setting the option path-as-is
# the path is sent as it is (provided in the url)
GET http://localhost:8000/path-as-is/../resource
[Options]
path-as-is: true
HTTP 200




####  ./post_base64.hurl
POST http://localhost:8000/post-base64
base64,SGVsbG8gV29ybGQh;  # Hello World!
HTTP 200


####  ./post_bytes.hurl
POST http://localhost:8000/post-bytes
Content-Type: application/octet-stream
base64,AQID;  # echo -e -n '\x01\x02\x03' | base64
HTTP 200


####  ./post_file.hurl
POST http://localhost:8000/post-file
file,data.bin;
HTTP 200

POST http://localhost:8000/post-file
file,{{filename}};
HTTP 200

POST http://localhost:8000/post-file
file,post_file_with\ space;
HTTP 200


####  ./post_json.hurl
POST http://localhost:8000/post-json
{
    "name": "Bob",
    "password": "&secret\\'<>",
    "age": 30,
    "strict": true,
    "spacing": "\n",
    "g_clef": "\uD834\uDD1E",
    "items": [true, "true", 1],
    "variable": "{{string_variable}}"
}
HTTP 200


POST http://localhost:8000/post-json-array
[1,2,3]
HTTP 200


POST http://localhost:8000/post-json-array-empty
[]
HTTP 200


POST http://localhost:8000/post-json-string
"Hello"
HTTP 200


POST http://localhost:8000/post-json-number
100
HTTP 200


POST http://localhost:8000/post-json-numbers
{
    "natural": 100,
    "negative": -1,
    "float": 3.333333333333333,
    "float_with_00": 123.00,
    "exponent": 100e100
}
HTTP 200


POST http://localhost:8000/post-json-boolean
true
HTTP 200

#
# Use variable in your input json
#
GET http://localhost:8000/get-name
HTTP 200
[Captures]
name: body


POST http://localhost:8000/check_name
{
    "name": "{{name}}"
}


####  ./post_large.hurl
# Post a relatively large payload (~ 15M)
POST http://localhost:8000/post_large
Content-Type: application/octet-stream
file,post_large.bin;
HTTP 200
[Asserts]
body toInt == 15728640


####  ./post_multilines.hurl
POST http://localhost:8000/post-multilines
```
name,age
bob,10
bill,22
```
HTTP 200


GET http://localhost:8000/get-bob-age
HTTP 200
[Captures]
bob_age: body


POST http://localhost:8000/post-multilines
```
name,age
bob,{{bob_age}}
bill,22
```
HTTP 200


####  ./post_xml.hurl
POST http://localhost:8000/post-xml
<?xml version="1.0"?>
<drink>café</drink>
HTTP 200


POST http://localhost:8000/post-xml-no-prolog
<drink>café</drink>
HTTP 200


POST http://localhost:8000/post-xml-large
<?xml version='1.0' ?>
<root>
    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name>MH of San Francisco,</bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items>
                8
            </num_items>
            <num_bids></num_bids>
            <started_at>$9</started_at>
            <bid_increment>$10</bid_increment>
            <location></location>
            <opened></opened>
            <closed>Mon Nov 27, 2:00 pm PT</closed>
            <id_num>
                3699803
            </id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
                $2459
            </highest_bid_amount>
            <quantity>1</quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu>
                900MHz
            </cpu>
            <brand>HP Pavilion</brand>
            <description>The Pavilion 9780C gives you
                everything you need in a home
                PC, from the exhilarating
                multimedia experience of DVD to
                the customized music-making
                abilities of the HP CD-Writer
                Plus - it's all in a hot
                translucent blue case! Monitor
                not included.


            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items></num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed></closed>
            <id_num></id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand></brand>
            <description>
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items></num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed></closed>
            <id_num></id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand></brand>
            <description>
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name>tx of Santa Clara</seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items>2</num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed>Mon Nov 27, 2:30 pm PT</closed>
            <id_num>
                3699948
            </id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
                $3837
            </highest_bid_amount>
            <quantity>2</quantity>
        </bid_history>
        <item_info>
            <memory>128MB high-performance PC133 ECC SDRAM Maximum: 4GB memory
                capacity (3.3GB maximum usable memory)
            </memory>
            <hard_drive>Open bay - none installed or includedSupports 9.1GB and 18.2GB 7,200rpm Ultra2
                SCSI disk drivesSupports 9.1GB, 18.2GB, and 36.4GB 10,000rpm Ultra2 SCSI disk
                drives
            </hard_drive>
            <cpu>Intel Pentium III 800MHz</cpu>
            <brand>Hewlett Packard NetServer LH3000 Pentium III 800MHz
                128MB RAM/Open Bay/32X CD/No OS
            </brand>
            <description>
                HP NetServer LH 3000 Pentium III 800MHzThis rack mount HP
                NetServer LH 3000 brings higher performance and reliability to
                meet your demanding departmental server requirements.
                Incorporating performance, storage, and high-availability
                technologies, this workhorse is loaded with features you'd
                expect only in high-end servers.Key Features At a Glance:
                Extraordinary performance -- dual Intel Pentium III processor
                capability (one 800MHz processor included)- with 133MHz front
                side bus, PC 133MHz ECC SDRAM, and performance-boosting
                integrated RAID controller. Best-in-class reliability and
                uptime -- with fully hot-swappable/hot-pluggable components,
                including disk drives, power supplies, fans, and hot-plug PCI
                slots. Includes widely adopted, fault-tolerant RAID 5
                technology-using an embedded, dual-channel NetRAID controller
                with optional battery backup, hardware-based parity (XOR)
                logic, and 32MB cache-expandable to 128MB. Excellent
                investment protection -- the HP NetServer LH 3000's design
                makes it easily upgradable as higher scalability Xeon servers
                and new processor enhancements become available. HP OpenView
                ManageX Event Manager -- for simplified NOS and high
                availability system management. Intelligent management -- a
                comprehensive tool set to monitor your server hardware and
                software from anywhere, anytime. Simple installation-rack
                mount form factor version.
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name>LW of Sugar Land</bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items>1</num_items>
            <num_bids></num_bids>
            <started_at>
                $9
            </started_at>
            <bid_increment>
                $20
            </bid_increment>
            <location></location>
            <opened></opened>
            <closed>
                Mon Nov 27, 2:30 pm PT
            </closed>
            <id_num>3699893</id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>$2392
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand>Hewlett Packard NetServe</brand>
            <description>Refurbished and warranted by
                manufacturer! Dual processing
                capability (one 800MHz Pentium
                III processor provided)!!!
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name>BT of Los Angeles</bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items>2</num_items>
            <num_bids></num_bids>
            <started_at>$9</started_at>
            <bid_increment>$20</bid_increment>
            <location></location>
            <opened></opened>
            <closed>Mon Nov 27, 2:30 pm PT</closed>
            <id_num>
                3699928
            </id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
                $2475
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory>AM memory
                expandable to 4GB (128MB
                provided)
            </memory>
            <hard_drive></hard_drive>
            <cpu>800MHz Pentium III processor</cpu>
            <brand></brand>
            <description>Dual processing capability(one
                800MHz Pentium III processor
                providedd)!! RAM memory
                expandable to 4GB (128MB
                provided)!! Refurbished and
                warranted by manufacturer!!HP NetServer LC 2000 Pentium III 800MHz -- The rock-solid
                workgroup server your growing business can depend on --This HP
                NetServer LC 2000 offers an innovative solution that delivers
                top quality to corporate workgroups, branch offices and
                quickly-growing small businesses with: High tech and high
                touch -- designed to be simple to install, configure and
                upgrade, all HP NetServer LC 2000 components are easily
                accessible and designed for tool-less service -- accented by
                color-coded "touch points" High availability -- created to
                deliver the most essential uptime-protecting technologies to
                meet your computing needs. With more hot-swappable and
                redundant components in a workgroup server, the LC 2000
                creates a super-reliable foundation for the growing network
                Intelligent management -- the HP NetServer LC 2000 is
                complemented by a hardware and NOS management suite that
                combines unmatched flexibility with simplicity for precise
                control. HP management tools ensure that your workgroup and
                remote office IT professionals can manage the LC 2000 from any
                location. Best-in-class uptime protection -- with up to six
                hot-swappable disk drive bays, standard redundant,
                hot-swappable fans, optional hot-swappable redundant power
                supplies, support for redundant NICS, and duplexing Freedom
                to expand -- with dual processing capability (one 800MHz
                Pentium III processor provided), capacity for up to 4GB SDRAM
                (128MB standard), expandable storage capability and six open
                PCI slots, the HP NetServer LC 2000 offers room for growth
                that is unprecedented in a workgroup serverThis LC 2000
                provides top quality in a server for corporate workgroups,
                branch offices and quickly growing small businesses that want
                enterprise-level system reliability features. Designed with
                simplicity for easy installation, the HP NetServer LC 2000
                meets the demands of your quickly growing business today and
                offers the capability to expand as your workplace computing
                needs increase in the
                future.********************************** -- F E A T U R E S A
                T A GLANCE --PROCESSOR:One Intel Pentium III 800MHz (dual
                capability with upgrade) with 133MHz front-side bus256K on-die
                write-back cacheMEMORY: Standard: 128MB SDRAM PC-133 DIMM per
                slotMaximum: 4GB Four DIMM sockets HARD DISK DRIVE : Open
                baySTORAGE : Diskette drive: 3.5" 1.44MBCD-ROM drive: Maximum
                32X IDENETWORK CONTROLLER:Integrated 10/100TX NIC (supports
                redundant NICs)BUS SPEED:133MHz front-side bus EXPANSION
                SLOTS:Two 64-bit and four 32-bit PCI slotsPeer 32-bit/64-bit
                PCI buses, both at 33MHzPORTS:One serial portOne 25-pin
                parallel portOne SCSI knockout port for external
                connectionsOne server management port (serial)Video
                port-SVGAMini-DIN keyboard and mouse portsSTORAGE
                CONTROLLER:Embedded dual channel Ultra-2 SCSIVIDEO:Embedded
                ATI Rage IIc video controller1024x768, 64K color at 75Hz2MB
                SGRAMPOWER SUPPLY:349 Watts (Nominal, 100-127/200-240V AC,
                50/60Hz; range, 90-140/180-264V AC, 47/63Hz)FORM
                648mm (25.5") without bezelOPERATING SYSTEM:None installed or
                includedOPTIONAL OPERATING SYSTEMS SUPPORTED:Microsoft Windows
                NT 4.0Windows2000Novell NetWare 4.2, 5.0Red Hat LinuxSCO
                OpenServerUnixWare****************************************HP
                NetServer LC 2000 -- the rock-solid workgroup server your
                growing business can depend on!

            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name>RP of Cleveland</bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items>1</num_items>
            <num_bids></num_bids>
            <started_at>$9</started_at>
            <bid_increment>
                $10
            </bid_increment>
            <location></location>
            <opened></opened>
            <closed>Mon Nov 27, 3:00 pm PT</closed>
            <id_num>
                3697285
            </id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>$3000
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory>28MB PC133 SDRAM 168-Pin Memory, 3.3 volt Non-ECC, Non-Buffered, 7.5ns
                Speed
            </memory>
            <hard_drive>30GB 7200 RPM IDE Hard Drive with UltraDMA 66 interface to ensure maximum data
                throughput
            </hard_drive>
            <cpu>III 800MHz Processor with 133MHz Bus</cpu>
            <brand></brand>
            <description>Elite PC PIII 800MHz 128MB RAM 30GB HD 10X DVD
                32MB VID/56K/NIC/3D SND/No OS
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items></num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed></closed>
            <id_num></id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand></brand>
            <description>
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items></num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed></closed>
            <id_num></id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand></brand>
            <description>
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items></num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed></closed>
            <id_num></id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand></brand>
            <description>
            </description>
        </item_info>
    </listing>

    <listing>
        <seller_info>
            <seller_name></seller_name>
            <seller_rating></seller_rating>
        </seller_info>
        <payment_types>
        </payment_types>
        <shipping_info>
        </shipping_info>
        <buyer_protection_info>
        </buyer_protection_info>
        <auction_info>
            <current_bid></current_bid>
            <time_left></time_left>
            <high_bidder>
                <bidder_name></bidder_name>
                <bidder_rating></bidder_rating>
            </high_bidder>
            <num_items></num_items>
            <num_bids></num_bids>
            <started_at></started_at>
            <bid_increment></bid_increment>
            <location></location>
            <opened></opened>
            <closed></closed>
            <id_num></id_num>
            <notes></notes>
        </auction_info>
        <bid_history>
            <highest_bid_amount>
            </highest_bid_amount>
            <quantity></quantity>
        </bid_history>
        <item_info>
            <memory></memory>
            <hard_drive></hard_drive>
            <cpu></cpu>
            <brand></brand>
            <description>
            </description>
        </item_info>
    </listing>
</root>
HTTP 200


####  ./predicates_number.hurl
# testing predicates
# on the number types: integer, float and big integer
GET http://localhost:8000/predicates-number
HTTP 200
[Asserts]

jsonpath "$.integer" exists
jsonpath "$.integer" isInteger
jsonpath "$.integer" not isFloat
jsonpath "$.integer" == 1
jsonpath "$.integer" <= 2
jsonpath "$.integer" > 0
jsonpath "$.integer" > 0.0
jsonpath "$.integer" != null

jsonpath "$.float" exists
jsonpath "$.float" isFloat
jsonpath "$.float" not isInteger
jsonpath "$.float" == 1.0
jsonpath "$.float" <= 2.0
jsonpath "$.float" > 0.0
jsonpath "$.float" > 0
jsonpath "$.float" != null

# 0.1 in 64-bit floating-point format is really 0.10000000000000000555111512312578270211815834045410
# both 0.1 and 0.100000000000000005 have the same 64-bit float value
jsonpath "$.small_float1" isFloat
jsonpath "$.small_float1" == 0.1
jsonpath "$.small_float1" == 0.10000000000000000555111512312578270211815834045410
jsonpath "$.small_float1" == 0.100000000000000005
jsonpath "$.small_float1" > 0.0999999940395355224609375000000000000000
jsonpath "$.small_float2" == 0.1

# 1000000000000000000000.5 is really 1000000000000000000000.0 if 64-bit float
jsonpath "$.big_float1" isFloat
jsonpath "$.big_float1" == 1000000000000000000000.0
jsonpath "$.big_float1" == 1000000000000000000000.5
jsonpath "$.big_float2" == 1000000000000000000000.0

jsonpath "$.big_integer" == 1000000000000000000000
jsonpath "$.big_integer" isInteger

{
  "integer": 1,
  "float": 1.0,
  "small_float1": 0.1,
  "small_float2": 0.100000000000000005,
  "big_float1": 1000000000000000000000.0,
  "big_float2": 1000000000000000000000.5,
  "big_integer": 1000000000000000000000
}



####  ./predicates_string.hurl
GET http://localhost:8000/predicates-string
HTTP 200
[Asserts]
body == "Hello World!"
body startsWith "Hello"
body endsWith "!"
body contains "llo"
body matches "Hello [a-zA-Z]+!"
body matches /Hello [a-zA-Z]+!/


GET http://localhost:8000/predicates-string-empty
HTTP 200
[Asserts]
body == ""
body exists


GET http://localhost:8000/predicates-string-unicode
HTTP 200
[Asserts]
body == "\u{2708}"
bytes count == 3


####  ./proxy.hurl
# Go through proxy
# The proxy adds header "From-Proxy:Hello" for both request and response
GET http://127.0.0.1:8000/proxy
HTTP 200
From-Proxy: Hello


####  ./proxy_option.hurl
# Go through proxy
# The proxy adds header "From-Proxy:Hello" for both request and response
GET http://127.0.0.1:8000/proxy
[Options]
proxy: localhost:3128
HTTP 200
From-Proxy: Hello

# Using ipv4
GET http://127.0.0.1:8000/proxy
[Options]
proxy: 127.0.0.1:3128
HTTP 200
From-Proxy: Hello


####  ./put.hurl
PUT http://localhost:8000/put
HTTP 200
[Asserts]
body == ""


####  ./querystring_params.hurl
GET http://localhost:8000/querystring-params
[QueryStringParams]
param1: value1
param2:
param3: a=b
param4: 1,2,3
$top: 5
HTTP 200


# same version as raw
GET http://localhost:8000/querystring-params?param1=value1&param2=&param3=a%3db&param4=1,2,3&$top=5
HTTP 200


# combine version
GET http://localhost:8000/querystring-params?param1=value1
[QueryStringParams]
param2:
param3: a=b
param4: 1,2,3
$top: 5
HTTP 200


# encoding slash
GET http://localhost:8000/querystring-params-encoded?value1=/&value2=%2F
[QueryStringParams]
value3: /
HTTP 200


####  ./reason.hurl
# This file tests an HTTP endpoint that returns a localized HTTP reason phrase.
# Some HTTP clients doesn't like it, curl does not care.
GET http://localhost:8000/reason-french
HTTP 200


####  ./redirect.hurl
GET http://localhost:8000/redirected
HTTP 200
[Asserts]
url == "http://localhost:8000/redirected"
`Redirected`


# Absolute redirects

GET http://localhost:8000/redirect-absolute
HTTP 302
Location: http://localhost:8000/redirected
[Asserts]
url == "http://localhost:8000/redirect-absolute"


GET http://localhost:8000/redirect-absolute
[Options]
location: true
HTTP 200
[Asserts]
url == "http://localhost:8000/redirected"
`Redirected`


# Relative redirects

GET http://localhost:8000/redirect-relative
HTTP 302
Location: /redirected
[Asserts]
url == "http://localhost:8000/redirect-relative"


GET http://localhost:8000/redirect-relative
[Options]
location: true
HTTP 200
[Asserts]
url == "http://localhost:8000/redirected"
`Redirected`


####  ./repeat_a.hurl
GET http://localhost:8000/repeat/hello?name=A
HTTP 200


####  ./repeat_b.hurl
GET http://localhost:8000/repeat/hello?name=B
HTTP 200


####  ./repeat_c.hurl
GET http://localhost:8000/repeat/hello?name=C
HTTP 200


####  ./request_content_length.hurl
POST http://localhost:8000/request-content-length
Content-Length: 1
`Hello`


####  ./resolve.hurl
GET http://foo.com:8000/resolve
HTTP 200
`Hello World!`


GET http://bar.com:8000/resolve
HTTP 200
`Hello World!`


GET http://baz.com:8000/resolve
HTTP 200
`Hello World!`


####  ./resolve_option.hurl
# --resolve option allow to us custom address for a specific host and port pair.
GET http://foo.com:8000/resolve
[Options]
resolve: foo.com:8000:127.0.0.1
HTTP 200
`Hello World!`


GET http://bar.com:8000/resolve
[Options]
resolve: bar.com:8000:127.0.0.1
HTTP 200
`Hello World!`


GET http://baz.com:8000/resolve
[Options]
resolve: baz.com:8000:127.0.0.1
HTTP 200
`Hello World!`


####  ./retry.hurl
# Create a new job
POST http://localhost:8000/jobs
HTTP 201
[Captures]
job_id: jsonpath "$.id"
[Asserts]
jsonpath "$.state" == "RUNNING"


# Pull job status until it is completed
GET http://localhost:8000/jobs/{{job_id}}
HTTP 200
[Asserts]
jsonpath "$.state" == "COMPLETED"


# Delete the job
DELETE http://localhost:8000/jobs/{{job_id}}
HTTP 200


GET http://localhost:8000/jobs/{{job_id}}
HTTP 404


####  ./retry_option.hurl
# Create a new job
POST http://localhost:8000/jobs
HTTP 201
[Captures]
job_id: jsonpath "$.id"
[Asserts]
jsonpath "$.state" == "RUNNING"


# Pull job status until it is completed
GET http://localhost:8000/jobs/{{job_id}}
[Options]
retry: 10
retry-interval: 100
HTTP 200
[Asserts]
jsonpath "$.state" == "COMPLETED"


# Delete the job
DELETE http://localhost:8000/jobs/{{job_id}}
HTTP 200


GET http://localhost:8000/jobs/{{job_id}}
HTTP 404


####  ./retry_until_200.hurl
GET http://localhost:8000/retry/until-200
[Options]
retry: 4
HTTP 200
`OK`


####  ./skip.hurl
GET http://localhost:8000/skip/init
HTTP 200
`0`

GET http://localhost:8000/skip/increment
[Options]
skip: true
HTTP 200
`whatever`

GET http://localhost:8000/skip/get
HTTP 200
`0`

GET http://localhost:8000/skip/increment
[Options]
skip: false
HTTP 200
`1`

GET http://localhost:8000/skip/get
HTTP 200
`1`


####  ./stdout.hurl
GET http://localhost:8000/stdout/text
[Options]
output: -
HTTP 200
`Hello`





####  ./test.1.hurl
GET http://localhost:8000/hello
HTTP 200
`Hello World!`


####  ./test.2.hurl
GET http://localhost:8000/hello
HTTP 200
`Hello World!`


GET http://localhost:8000/hello
HTTP 200
`Goodbye World!`


####  ./test.3.hurl
GET http://localhost:8000/hello
HTTP 200
`Hello World!`


####  ./unix_socket.hurl
GET http://example/hello
HTTP 200
[Asserts]
`Hello World!`


####  ./url.hurl
GET http://localhost:8000/~user
HTTP 200
`user`

GET http://localhost:8000/%7Euser
HTTP 200
`user`

# TODO: add single quote (needs to be escaped in curl command-line)
GET http://localhost:8000/!$&()*+,;=:@[]
HTTP 200
`weird`



####  ./user_agent.hurl
GET http://localhost:8000/user-agent/a
HTTP 200

GET http://localhost:8000/user-agent/b
User-Agent: Mozilla/5.0 B
HTTP 200

GET http://localhost:8000/user-agent/a
HTTP 200



####  ./utf8.hurl
GET http://localhost:8000/utf8
HTTP 200
[Asserts]
xpath "normalize-space(//data)" == "café"
xpath "normalize-space(//data)" == "caf\u{e9}"
bytes == hex,3c646174613e636166c3a93c2f646174613e;


####  ./variables.hurl
# Variables can be set from:
# - an external properties file
# - at the command-line with the --variable option
# - with HURL_xxx environment variable
# - in the Hurl File in the [Options] section

POST http://localhost:8000/variables
Name: {{name}}
Age: {{age}}
Height: {{height}}
Female: {{female}}
Id: {{my-id}}
A-Null: {{a_null}}
Country: {{country}}
Planet: {{planet}}
Galaxy: {{galaxy}}
[Options]
variable: country=Italy
variable: planet=The Earth
{
  "name": "{{name}}",
  "age": {{age}},
  "height": {{height}},
  "female": {{female}},
  "id": "{{my-id}}",
  "a_null": {{a_null}},
  "country": "{{country}}",
  "planet": "{{planet}}",
  "galaxy": "{{galaxy}}"
}
HTTP 200
[Asserts]
variable "name" == "Jennifer"
variable "female" == true
variable "age" == 30
variable "height" == 1.70
variable "a_null" == null
variable "my-id" == "123"
variable "country" == "Italy"
variable "planet" == "The Earth"
variable "galaxy" == "Milky Way"


# `country` and `planet` variable are still available
# for the next entries, even if they've been defined in the
# previous `[Options]` request section.
GET http://localhost:8000/variable/country
HTTP 200
`{{country}}`

GET http://localhost:8000/variable/planet
HTTP 200
`{{planet}}`


####  ./verbose.hurl
GET http://localhost:8000/verbose



####  ./verbose_option.hurl
GET http://localhost:8000/hello


GET http://localhost:8000/hello
[Options]
verbose: true
HTTP 200
`Hello World!`


GET http://localhost:8000/hello


GET http://localhost:8000/hello
[Options]
very-verbose: true


####  ./very_verbose.hurl
GET http://localhost:8000/very-verbose/redirect
HTTP 200

GET http://localhost:8000/very-verbose/encoding/latin1
HTTP 200

POST http://localhost:8000/very-verbose/compressed/brotli
Accept-Encoding: brotli
{
    "foo": "bar",
    "baz": true
}
HTTP 200

GET http://localhost:8000/very-verbose/cat
HTTP 200

POST http://localhost:8000/very-verbose/update-cat
[MultipartFormData]
cat: file,cat.jpg; image/jpeg
HTTP 200

GET http://localhost:8000/very-verbose/done
x-foo: bar
HTTP 200


