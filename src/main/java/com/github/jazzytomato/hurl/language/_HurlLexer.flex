package com.github.jazzytomato.hurl.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.github.jazzytomato.hurl.language.psi.HurlTypes.*;

%%

%{
  public _HurlLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _HurlLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

NEW_LINE=\n+
WHITE_SPACE=[ \t\n\x0B\f\r]+
NUMBER=([0-9]+)?[eE]?[+\-]?[0-9]+(\.[0-9]+)?
JSON_ID=\"([^\"\\]|\\.)*\":
STRING=\"([^\"\\]|\\.)*\"
TEMPLATE=\{\{[^}]*\}\}
COMMENT=#.*
METHOD=(GET|POST|PUT|DELETE|PATCH|HEAD|OPTIONS|CONNECT|TRACE|LINK|UNLINK|PURGE|LOCK|UNLOCK|PROPFIND|VIEW)
URL=(\{\{.*\}\})*(https?:"//"[^ \t\n\x0B\f\r]*)(\{\{.*\}\}[^ \t\n\x0B\f\r]*|[^ \t\n\x0B\f\r]*)
HTTP_VERSION=(HTTP"/"1.0|HTTP"/"1.1|HTTP"/"2|HTTP"/"3|HTTP"/"\*|HTTP)
ALPHANUM=[A-Za-z0-9]+
IDENTIFIER=[A-Za-z0-9_-]+
ANY=[^\s,\{\}\[\]]

%%
<YYINITIAL> {
  {WHITE_SPACE}               { return WHITE_SPACE; }

  "null"                      { return NULL; }
  "[BasicAuth]"               { return S_BASIC_AUTH; }
  "[QueryStringParams]"       { return S_QUERY_STRING_PARAMS; }
  "[FormParams]"              { return S_FORM_PARAMS; }
  "[MultipartFormData]"       { return S_MULTIPART_FORM_DATA; }
  "[Cookies]"                 { return S_COOKIES; }
  "[Options]"                 { return S_OPTIONS; }
  "[Captures]"                { return S_CAPTURES; }
  "[Asserts]"                 { return S_ASSERTS; }
  "[Headers]"                 { return S_HEADERS; }
  "```"                       { return BACKQUOTE_3; }
  "<="                        { return LESS_OR_EQUAL; }
  ">="                        { return GREATER_OR_EQUAL; }
  "["                         { return LBRACKET; }
  "]"                         { return RBRACKET; }
  "{"                         { return LBRACE; }
  "}"                         { return RBRACE; }
  "("                         { return LPAR; }
  ")"                         { return RPAR; }
  "_"                         { return UNDERSCORE; }
  "-"                         { return DASH; }
  "."                         { return DOT; }
  "@"                         { return AT; }
  "!"                         { return BANG; }
  "\\"                        { return BACKSLASH; }
  "/"                         { return SLASH; }
  "$"                         { return DOLLAR; }
  "?"                         { return QMARK; }
  "="                         { return EQ; }
  "&"                         { return AMPERSAND; }
  "%"                         { return PERCENT; }
  ","                         { return COMMA; }
  ":"                         { return COLON; }
  ";"                         { return SEMI; }
  "+"                         { return PLUS; }
  "*"                         { return STAR; }
  ">"                         { return GREATER; }
  "<"                         { return LESS; }
  "`"                         { return BACKQUOTE; }
  "~"                         { return TILDE; }
  "^"                         { return CARET; }
  "|"                         { return PIPE; }
  "\""                        { return QUOTE; }

  {NEW_LINE}                  { return NEW_LINE; }
  {WHITE_SPACE}               { return WHITE_SPACE; }
  {NUMBER}                    { return NUMBER; }
  {JSON_ID}                   { return JSON_ID; }
  {STRING}                    { return STRING; }
  {TEMPLATE}                  { return TEMPLATE; }
  {COMMENT}                   { return COMMENT; }
  {METHOD}                    { return METHOD; }
  {URL}                       { return URL; }
  {HTTP_VERSION}              { return HTTP_VERSION; }
  {ALPHANUM}                  { return ALPHANUM; }
  {IDENTIFIER}                { return IDENTIFIER; }
  {ANY}                       { return ANY; }

}

[^] { return BAD_CHARACTER; }
