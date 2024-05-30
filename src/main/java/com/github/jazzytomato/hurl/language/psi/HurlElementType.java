package com.github.jazzytomato.hurl.language.psi;

import com.github.jazzytomato.hurl.language.HurlLanguage;
import com.intellij.psi.tree.IElementType;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

public class HurlElementType extends IElementType {

    public HurlElementType(@NotNull @NonNls String debugName) {
        super(debugName, HurlLanguage.INSTANCE);
    }

}