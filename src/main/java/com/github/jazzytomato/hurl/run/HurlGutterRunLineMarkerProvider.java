package com.github.jazzytomato.hurl.run;

import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.intellij.execution.lineMarker.ExecutorAction;
import com.intellij.execution.lineMarker.RunLineMarkerContributor;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.project.DumbAware;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiFile;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HurlGutterRunLineMarkerProvider extends RunLineMarkerContributor implements DumbAware {

    @Nullable
    @Override
    public Info getInfo(@NotNull PsiElement element) {
        // Add a run all requests icon to the gutter for the first line of a Hurl file

        if (element.getNode().getElementType() == HurlTypes.METHOD && ((LeafPsiElement) element.getNode()).getParent().getNode().getElementType() == HurlTypes.REQUEST) {
            return new Info(AllIcons.RunConfigurations.TestState.Run, it -> "Run request", ExecutorAction.getActions());
        }
        return null;
    }
}
