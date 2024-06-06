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

STRING=\"([^\"\\]|\\.)*\"
NUMBER=(\+|\-)?[:digit:]*
COMMENT=#.*
METHOD=(GET|POST|PUT|DELETE|PATCH|HEAD|OPTIONS)
WHITE_SPACE=[ \t\n\x0B\f\r]+
URL=(https?:"//"[^ \t\n\x0B\f\r]*)(\{\{.*\}\}[^ \t\n\x0B\f\r]*|[^ \t\n\x0B\f\r]*)
IDENTIFIER=[a-zA-Z_0-9]+
JSON_ID=[:letter:][a-zA-Z_0-9]*

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }

  "true|false"        { return BOOLEAN; }
  "null"              { return NULL; }
  ","                 { return COMMA; }
  ":"                 { return COLON; }
  "["                 { return LBRACKET; }
  "]"                 { return RBRACKET; }
  "{"                 { return LBRACE; }
  "}"                 { return RBRACE; }
  "ANY"               { return ANY; }

  {STRING}            { return STRING; }
  {NUMBER}            { return NUMBER; }
  {COMMENT}           { return COMMENT; }
  {METHOD}            { return METHOD; }
  {WHITE_SPACE}       { return WHITE_SPACE; }
  {URL}               { return URL; }
  {IDENTIFIER}        { return IDENTIFIER; }
  {JSON_ID}           { return JSON_ID; }

}

[^] { return BAD_CHARACTER; }
