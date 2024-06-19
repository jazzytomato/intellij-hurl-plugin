package com.github.jazzytomato.hurl.run;

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

import java.util.Objects;

public class HurlRunConfigurationProducer extends LazyRunConfigurationProducer<HurlRunConfiguration> {

    @NotNull
    @Override
    public ConfigurationFactory getConfigurationFactory() {
        return new HurlRunConfigurationFactory(ConfigurationTypeUtil.findConfigurationType(HurlRunConfigurationType.class));
    }

    @Override
    protected boolean setupConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context, @NotNull Ref<PsiElement> sourceElement) {
        if (sourceElement.get().getNode().getElementType() == HurlTypes.METHOD) {
            String method = sourceElement.get().getText();
            String url = ((HurlRequestImpl) ((LeafPsiElement) sourceElement.get().getNode()).getParent()).getUrlOrTemplate().getText();
            configuration.setName(method + " " + url + " - " + context.getPsiLocation().getContainingFile().getName());
            return true;
        }
        return false;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context) {
        return Objects.requireNonNull(context.getPsiLocation()).getContainingFile().getName().equals(configuration.getName());
    }
}
