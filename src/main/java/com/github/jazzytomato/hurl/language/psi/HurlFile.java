package com.github.jazzytomato.hurl.language.psi;

import com.github.jazzytomato.hurl.language.HurlFileType;
import com.github.jazzytomato.hurl.language.HurlLanguage;
import com.intellij.extapi.psi.PsiFileBase;
import com.intellij.openapi.fileTypes.FileType;
import com.intellij.psi.FileViewProvider;
import org.jetbrains.annotations.NotNull;

public class HurlFile extends PsiFileBase {

    public HurlFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, HurlLanguage.INSTANCE);
    }

    @NotNull
    @Override
    public FileType getFileType() {
        return HurlFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Hurl File";
    }

}
