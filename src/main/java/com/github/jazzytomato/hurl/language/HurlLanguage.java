package com.github.jazzytomato.hurl.language;

import com.intellij.lang.Language;

public class HurlLanguage extends Language {

    public static final HurlLanguage INSTANCE = new HurlLanguage();

    private HurlLanguage() {
        super("Hurl");
    }
}
