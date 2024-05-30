# Get home:
GET https://example.org/{{hello}} # hi GET https://example.org/
HTTP 200
[Captures] # wat
csrf_token: xpath "string(//meta[@name='_csrf_token']/@content)"


# Get home:
GET {{hello}} # hi
HTTP 200
[Captures] # wat
csrf_token: xpath "string(//meta[@name='_csrf_token']/@content)"


# Do login!
POST https://example.org/login?user=toto&password=1234
X-CSRF-TOKEN: asdw21 123445 !!!! @@@ {{abc}}
HTTP 302

# yo...
POST https://example.org/login?user=toto&password=1234 # wassup
X-CSRF-TOKEN: {{csrf_token}} # hi
HTTP 302
