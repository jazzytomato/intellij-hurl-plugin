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

COMMENT=#.*
METHOD=(GET|POST|PUT|DELETE|PATCH|HEAD|OPTIONS)
//WHITE_SPACE=[ \t\n\x0B\f\r]+
URL=(https?:"//"[^ \t\n\x0B\f\r]*)(\{\{.*\}\}[^ \t\n\x0B\f\r]*|[^ \t\n\x0B\f\r]*)
IDENTIFIER=[a-zA-Z_0-9]+
LBRACE=\{
RBRACE=\}
ANY=[^ \t\n\x0B\f\r]

%%

<YYINITIAL> {
 {WHITE_SPACE}                       { return TokenType.WHITE_SPACE; }
 {COMMENT}                           { return HurlTypes.COMMENT; }
 {METHOD}                            { return HurlTypes.METHOD; }
 {URL}                               { return HurlTypes.URL; }
 {EOL}                               { return TokenType.NEW_LINE_INDENT; }
 {IDENTIFIER}                        { return HurlTypes.IDENTIFIER; }
 {LBRACE}                            { return HurlTypes.LBRACE; }
 {RBRACE}                            { return HurlTypes.RBRACE; }
 {ANY}                               { return HurlTypes.ANY; }
}
[^]                                             { return TokenType.BAD_CHARACTER; }
