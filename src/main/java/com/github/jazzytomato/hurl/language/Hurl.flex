package com.github.jazzytomato.hurl.language;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;
import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.intellij.psi.TokenType;

%%

%class HurlLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

NEW_LINE=\n+
WHITE_SPACE=\s+
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
  {NEW_LINE}                  { return HurlTypes.NEW_LINE; }
  {WHITE_SPACE}               { return TokenType.WHITE_SPACE; }

  "null"                      { return HurlTypes.NULL; }
  "[BasicAuth]"               { return HurlTypes.S_BASIC_AUTH; }
  "[QueryStringParams]"       { return HurlTypes.S_QUERY_STRING_PARAMS; }
  "[FormParams]"              { return HurlTypes.S_FORM_PARAMS; }
  "[MultipartFormData]"       { return HurlTypes.S_MULTIPART_FORM_DATA; }
  "[Cookies]"                 { return HurlTypes.S_COOKIES; }
  "[Options]"                 { return HurlTypes.S_OPTIONS; }
  "[Captures]"                { return HurlTypes.S_CAPTURES; }
  "[Asserts]"                 { return HurlTypes.S_ASSERTS; }
  "[Headers]"                 { return HurlTypes.S_HEADERS; }
  "```"                       { return HurlTypes.BACKQUOTE_3; }
  "<="                        { return HurlTypes.LESS_OR_EQUAL; }
  ">="                        { return HurlTypes.GREATER_OR_EQUAL; }
  "["                         { return HurlTypes.LBRACKET; }
  "]"                         { return HurlTypes.RBRACKET; }
  "{"                         { return HurlTypes.LBRACE; }
  "}"                         { return HurlTypes.RBRACE; }
  "("                         { return HurlTypes.LPAR; }
  ")"                         { return HurlTypes.RPAR; }
  "_"                         { return HurlTypes.UNDERSCORE; }
  "-"                         { return HurlTypes.DASH; }
  "."                         { return HurlTypes.DOT; }
  "@"                         { return HurlTypes.AT; }
  "!"                         { return HurlTypes.BANG; }
  "\\"                        { return HurlTypes.BACKSLASH; }
  "/"                         { return HurlTypes.SLASH; }
  "$"                         { return HurlTypes.DOLLAR; }
  "?"                         { return HurlTypes.QMARK; }
  "="                         { return HurlTypes.EQ; }
  "&"                         { return HurlTypes.AMPERSAND; }
  "%"                         { return HurlTypes.PERCENT; }
  ","                         { return HurlTypes.COMMA; }
  ":"                         { return HurlTypes.COLON; }
  ";"                         { return HurlTypes.SEMI; }
  "+"                         { return HurlTypes.PLUS; }
  "*"                         { return HurlTypes.STAR; }
  ">"                         { return HurlTypes.GREATER; }
  "<"                         { return HurlTypes.LESS; }
  "`"                         { return HurlTypes.BACKQUOTE; }
  "~"                         { return HurlTypes.TILDE; }
  "^"                         { return HurlTypes.CARET; }
  "|"                         { return HurlTypes.PIPE; }
  "\""                        { return HurlTypes.QUOTE; }

  {NUMBER}                    { return HurlTypes.NUMBER; }
  {JSON_ID}                   { return HurlTypes.JSON_ID; }
  {STRING}                    { return HurlTypes.STRING; }
  {TEMPLATE}                  { return HurlTypes.TEMPLATE; }
  {COMMENT}                   { return HurlTypes.COMMENT; }
  {METHOD}                    { return HurlTypes.METHOD; }
  {URL}                       { return HurlTypes.URL; }
  {HTTP_VERSION}              { return HurlTypes.HTTP_VERSION; }
  {ALPHANUM}                  { return HurlTypes.ALPHANUM; }
  {IDENTIFIER}                { return HurlTypes.IDENTIFIER; }
  {ANY}                       { return HurlTypes.ANY; }

}

[^] { return TokenType.BAD_CHARACTER; }
