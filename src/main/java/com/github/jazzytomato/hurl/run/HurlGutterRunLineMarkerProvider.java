package com.github.jazzytomato.hurl.run;

import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.intellij.execution.lineMarker.ExecutorAction;
import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HurlGutterRunLineMarkerProvider extends RunLineMarkerContributor implements DumbAware {

    @Nullable
    @Override
    public Info getInfo(@NotNull PsiElement element) {
        if (element.getNode().getElementType() == HurlTypes.GET_METHOD || element.getNode().getElementType() == HurlTypes.POST_METHOD || element.getNode().getElementType() == HurlTypes.PUT_METHOD || element.getNode().getElementType() == HurlTypes.DELETE_METHOD) {
            return new Info(AllIcons.RunConfigurations.TestState.Run, it -> "Run request", ExecutorAction.getActions());
        }
        return null;
    }
}
