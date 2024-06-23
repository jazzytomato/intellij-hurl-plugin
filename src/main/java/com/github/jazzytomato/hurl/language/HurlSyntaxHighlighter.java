package com.github.jazzytomato.hurl.language;

import com.github.jazzytomato.hurl.language.psi.HurlTokenSets;
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

    // FUNCTION_DECLARATION INSTANCE_METHOD STATIC_METHOD gold
    // METADATA yellow
    // KEYWORD orange
    // STRING green
    // LINE_COMMENT gray
    // NUMBER blue
    // CONSTANT STATIC_FIELD purple
    // BAD_CHARACTER red
    // DOC_COMMENT_TAG_VALUE brown
    // DOC_COMMENT_MARKUP DOC_COMMENT_TAG light green
    // HIGHLIGHTED_REFERENCE underlined
    // INLINE_PARAMETER_HINT TEMPLATE_LANGUAGE_COLOR highlighted dark gray
    // INLINE_PARAMETER_HINT_HIGHLIGHTED highlighted light gray
    // INLINE_PARAMETER_HINT_CURRENT highlighted blue

    public static final TextAttributesKey METHOD =
            createTextAttributesKey("HURL_METHOD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey URL =
            createTextAttributesKey("HURL_URL", DefaultLanguageHighlighterColors.HIGHLIGHTED_REFERENCE);
    public static final TextAttributesKey STRING =
            createTextAttributesKey("HURL_STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey COMMENT =
            createTextAttributesKey("HURL_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey NUMBER =
            createTextAttributesKey("HURL_NUMBER", DefaultLanguageHighlighterColors.NUMBER);
    public static final TextAttributesKey SECTION =
            createTextAttributesKey("HURL_SECTION", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BAD_CHARACTER =
            createTextAttributesKey("HURL_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);
    public static final TextAttributesKey TEMPLATE = createTextAttributesKey("HURL_TEMPLATE", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey IDENTIFIER = createTextAttributesKey("HURL_IDENTIFIER", DefaultLanguageHighlighterColors.CONSTANT);
    public static final TextAttributesKey BRACES = createTextAttributesKey("HURL_BRACES", DefaultLanguageHighlighterColors.BRACES);
    public static final TextAttributesKey HTTP_VERSION = createTextAttributesKey("HURL_HTTP_VERSION", DefaultLanguageHighlighterColors.STATIC_METHOD);
    public static final TextAttributesKey[] KEY_STRING = new TextAttributesKey[]{DefaultLanguageHighlighterColors.CONSTANT};

    private static final TextAttributesKey[] METHOD_KEYS = new TextAttributesKey[]{METHOD};
    private static final TextAttributesKey[] URL_KEYS = new TextAttributesKey[]{URL};
    private static final TextAttributesKey[] COMMENT_KEYS = new TextAttributesKey[]{COMMENT};
    private static final TextAttributesKey[] TEMPLATE_KEYS = new TextAttributesKey[]{TEMPLATE};
    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];
    private static final TextAttributesKey[] IDENTIFIER_KEYS = new TextAttributesKey[]{IDENTIFIER};
    private static final TextAttributesKey[] BRACE_KEYS = new TextAttributesKey[]{BRACES};
    private static final TextAttributesKey[] NUMBER_KEYS = new TextAttributesKey[]{NUMBER};
    private static final TextAttributesKey[] SECTION_KEYS = new TextAttributesKey[]{SECTION};
    private static final TextAttributesKey[] HTTP_VERSION_KEYS = new TextAttributesKey[]{HTTP_VERSION};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] KEY_KEYS = new TextAttributesKey[]{KEY_STRING[0]};

    @NotNull
    @Override
    public Lexer getHighlightingLexer() {
        return new HurlLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(HurlTypes.METHOD)) {
            return METHOD_KEYS;
        }
        if (tokenType.equals(HurlTypes.TEMPLATE)) {
            return TEMPLATE_KEYS;
        }
//        if (tokenType.equals(HurlTypes.IDENTIFIER)) {
//            return IDENTIFIER_KEYS;
//        }
        if (tokenType.equals(HurlTypes.LBRACE) || tokenType.equals(HurlTypes.RBRACE)) {
            return BRACE_KEYS;
        }
        if (tokenType.equals(HurlTypes.URL)) {
            return URL_KEYS;
        }
        if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        }
        if (HurlTokenSets.NUMBERS.contains(tokenType)) {
            return NUMBER_KEYS;
        }
        if (HurlTokenSets.COMMENTS.contains(tokenType)) {
            return COMMENT_KEYS;
        }
        if (HurlTokenSets.SECTIONS.contains(tokenType)) {
            return SECTION_KEYS;
        }
        if (tokenType.equals(HurlTypes.HTTP_VERSION)) {
            return HTTP_VERSION_KEYS;
        }
        if (tokenType.equals(HurlTypes.STRING)) {
            return STRING_KEYS;
        }
        if (tokenType.equals(HurlTypes.KEY_STRING)) {
            return KEY_KEYS;
        }
        return EMPTY_KEYS;
    }
}
