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

COMMENT=#.*
METHOD=(GET|POST|PUT|DELETE|PATCH|HEAD|OPTIONS)
WHITE_SPACE=[ \t\n\x0B\f\r]+
URL=(https?:"//"[^ \t\n\x0B\f\r]*)(\{\{.*\}\}[^ \t\n\x0B\f\r]*|[^ \t\n\x0B\f\r]*)
IDENTIFIER=[a-zA-Z_0-9]+
LBRACE=\{
RBRACE=\}
ANY=[^ \t\n\x0B\f\r]

%%
<YYINITIAL> {
  {WHITE_SPACE}       { return WHITE_SPACE; }


  {COMMENT}           { return COMMENT; }
  {METHOD}            { return METHOD; }
  {WHITE_SPACE}       { return WHITE_SPACE; }
  {URL}               { return URL; }
  {IDENTIFIER}        { return IDENTIFIER; }
  {LBRACE}            { return LBRACE; }
  {RBRACE}            { return RBRACE; }
  {ANY}               { return ANY; }

}

[^] { return BAD_CHARACTER; }
