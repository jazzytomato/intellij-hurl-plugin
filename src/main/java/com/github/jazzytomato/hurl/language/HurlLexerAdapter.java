package com.github.jazzytomato.hurl.language;

import com.intellij.lexer.FlexAdapter;

public class HurlLexerAdapter extends FlexAdapter {

    public HurlLexerAdapter() {
        super(new HurlLexer(null));
    }

}
