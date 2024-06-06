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

EOL=\R
WHITE_SPACE=\s+

STRING=\"([^\"\\]|\\.)*\"
NUMBER=(\+|\-)?[:digit:]*
COMMENT=#.*
METHOD=(GET|POST|PUT|DELETE|PATCH|HEAD|OPTIONS)
//WHITE_SPACE=[ \t\n\x0B\f\r]+
URL=(https?:"//"[^ \t\n\x0B\f\r]*)(\{\{.*\}\}[^ \t\n\x0B\f\r]*|[^ \t\n\x0B\f\r]*)
IDENTIFIER=[a-zA-Z_0-9]+
JSON_ID=[:letter:][a-zA-Z_0-9]*

%%

<YYINITIAL> {
 {WHITE_SPACE}                       { return TokenType.WHITE_SPACE; }

  "true|false"        { return HurlTypes.BOOLEAN; }
  "null"              { return HurlTypes.NULL; }
  ","                 { return HurlTypes.COMMA; }
  ":"                 { return HurlTypes.COLON; }
  "{"                 { return HurlTypes.LBRACE; }
  "}"                 { return HurlTypes.RBRACE; }
  "["                 { return HurlTypes.LBRACKET; }
  "]"                 { return HurlTypes.RBRACKET; }

 {STRING}                            { return HurlTypes.STRING; }
 {NUMBER}                            { return HurlTypes.NUMBER; }
 {COMMENT}                           { return HurlTypes.COMMENT; }
 {METHOD}                            { return HurlTypes.METHOD; }
 {URL}                               { return HurlTypes.URL; }
 {IDENTIFIER}                        { return HurlTypes.IDENTIFIER; }
 {JSON_ID}                           { return HurlTypes.JSON_ID; }
}
[^]                                             { return TokenType.BAD_CHARACTER; }
