package com.github.jazzytomato.hurl.language.psi;

import com.github.jazzytomato.hurl.language.HurlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HurlTokenType extends IElementType {

    public static final HurlTokenType GET = new HurlTokenType("GET");
    public static final HurlTokenType POST = new HurlTokenType("POST");
    public static final HurlTokenType PUT = new HurlTokenType("PUT");
    public static final HurlTokenType DELETE = new HurlTokenType("DELETE");
    public static final HurlTokenType URL = new HurlTokenType("URL");
    public static final HurlTokenType IDENTIFIER = new HurlTokenType("IDENTIFIER");
    public static final HurlTokenType COMMENT = new HurlTokenType("COMMENT");

    public HurlTokenType(@NotNull @NonNls String debugName) {
        super(debugName, HurlLanguage.INSTANCE);
    }

    @Override
    public String toString() {
        return "HurlTokenType." + super.toString();
    }

}
