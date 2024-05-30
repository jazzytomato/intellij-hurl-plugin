package com.github.jazzytomato.hurl.language;

import com.intellij.openapi.fileTypes.LanguageFileType;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class HurlFileType extends LanguageFileType {

    public static final HurlFileType INSTANCE = new HurlFileType();

    private HurlFileType() {
        super(HurlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public String getName() {
        return "Hurl File";
    }

    @NotNull
    @Override
    public String getDescription() {
        return "Hurl language file";
    }

    @NotNull
    @Override
    public String getDefaultExtension() {
        return "hurl";
    }

    @Override
    public Icon getIcon() {
        return HurlIcons.FILE;
    }

}