package com.github.jazzytomato.hurl.run;

import com.github.jazzytomato.hurl.language.psi.HurlFile;
import com.github.jazzytomato.hurl.language.psi.HurlTypes;
import com.github.jazzytomato.hurl.language.psi.impl.HurlRequestImpl;
import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.ConfigurationFromContext;
import com.intellij.execution.actions.LazyRunConfigurationProducer;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import com.intellij.psi.impl.source.tree.LeafPsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.Objects;

public class HurlRunConfigurationProducer extends LazyRunConfigurationProducer<HurlRunConfiguration> {

    @NotNull
    @Override
    public ConfigurationFactory getConfigurationFactory() {
        return new HurlRunConfigurationFactory(ConfigurationTypeUtil.findConfigurationType(HurlRunConfigurationType.class));
    }

    @Override
    protected boolean setupConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context, @NotNull Ref<PsiElement> sourceElement) {
        if (sourceElement.get().getClass() == HurlFile.class) {
            configuration.setName(context.getPsiLocation().getContainingFile().getName());
            return true;
        }
        if (sourceElement.get().getNode().getElementType() == HurlTypes.METHOD) {
            String method = sourceElement.get().getText();
            String url = ((HurlRequestImpl) ((LeafPsiElement) sourceElement.get().getNode()).getParent()).getUrlOrTemplate().getText();
            configuration.setName(method + " " + url + " - " + context.getPsiLocation().getContainingFile().getName());

            PsiElement[] entries = Arrays.stream(sourceElement.get().getContainingFile().getChildren()).filter(node -> node.getNode().getElementType() == HurlTypes.ENTRY).toArray(PsiElement[]::new);

            int currentRequestIndex = Arrays.asList(entries).indexOf(sourceElement.get().getParent().getParent());

            configuration.setHurlArgs("--from-entry " + (currentRequestIndex + 1) + " --to-entry " + (currentRequestIndex + 1));
            return true;
        }
        return false;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context) {
        if (context.getPsiLocation().getContainingFile().getClass() == HurlFile.class) {
            return Objects.equals(configuration.getName(), context.getPsiLocation().getContainingFile().getName());
        }
        if (context.getPsiLocation().getNode().getElementType() == HurlTypes.METHOD) {
            String method = context.getPsiLocation().getText();
            String url = ((HurlRequestImpl) ((LeafPsiElement) context.getPsiLocation().getNode()).getParent()).getUrlOrTemplate().getText();
            String expectedName = method + " " + url + " - " + context.getPsiLocation().getContainingFile().getName();
            return Objects.equals(configuration.getName(), expectedName);
        }
        return false;
    }
}
