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

CRLF=\R
WHITE_SPACE=[\ \n\t\f]
IDENTIFIER=[a-zA-Z0-9_.-]+
COMMENT=("#")[^\r\n]*
URL=([a-zA-Z][a-zA-Z0-9+.-]*:\/\/)[a-zA-Z0-9.-]+(\/[a-zA-Z0-9_.-]*)?(\?[a-zA-Z0-9=&]*)?
%%

<YYINITIAL> {COMMENT}                           { return HurlTypes.COMMENT; }
<YYINITIAL> "GET"                               { return HurlTypes.GET_METHOD; }
<YYINITIAL> "POST"                              { return HurlTypes.POST_METHOD; }
<YYINITIAL> "PUT"                               { return HurlTypes.PUT_METHOD; }
<YYINITIAL> "DELETE"                            { return HurlTypes.DELETE_METHOD; }
<YYINITIAL> {URL}                               { return HurlTypes.URL; }
<YYINITIAL> {CRLF}                              { return TokenType.NEW_LINE_INDENT; }
<YYINITIAL> {WHITE_SPACE}                       { return TokenType.WHITE_SPACE; }
<YYINITIAL> {IDENTIFIER}                        { return HurlTypes.IDENTIFIER; }
[^]                                             { return TokenType.BAD_CHARACTER; }
