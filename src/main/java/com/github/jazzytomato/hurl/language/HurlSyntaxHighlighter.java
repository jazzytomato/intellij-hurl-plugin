package com.github.jazzytomato.hurl.language;

import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.intellij.lexer.Lexer;
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors;
import com.intellij.openapi.editor.HighlighterColors;
import com.intellij.openapi.editor.colors.TextAttributesKey;
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase;
import com.intellij.psi.TokenType;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NotNull;

import static com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey;

public class HurlSyntaxHighlighter extends SyntaxHighlighterBase {

    public static final TextAttributesKey METHOD =
            createTextAttributesKey("HURL_METHOD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey URL =
            createTextAttributesKey("HURL_URL", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("HURL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("HURL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] METHOD_KEYS = new TextAttributesKey[]{METHOD};
    private static final TextAttributesKey[] URL_KEYS = new TextAttributesKey[]{URL};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new HurlLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(HurlTypes.GET_METHOD) || tokenType.equals(HurlTypes.POST_METHOD) ||
                tokenType.equals(HurlTypes.PUT_METHOD) || tokenType.equals(HurlTypes.DELETE_METHOD)) {
            return METHOD_KEYS;
        }
        if (tokenType.equals(HurlTypes.URL)) {
            return URL_KEYS;
        }
        if (tokenType.equals(HurlTypes.COMMENT)) {
            return COMMENT_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        return EMPTY_KEYS;
    }
}
