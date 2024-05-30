package com.github.jazzytomato.hurl.run;

import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.intellij.execution.lineMarker.ExecutorAction;
import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.icons.AllIcons;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HurlGutterRunLineMarkerProvider extends RunLineMarkerContributor {

    @Nullable
    @Override
    public Info getInfo(@NotNull PsiElement element) {
        if (element.getNode().getElementType() == HurlTypes.GET_METHOD) {
            new Info(AllIcons.Actions.RunAll, it -> "run the main function", ExecutorAction.getActions());
        }
        return null;
    }
}
