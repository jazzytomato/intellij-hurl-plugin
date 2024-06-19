package com.github.jazzytomato.hurl.run;

import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.ConfigurationFromContext;
import com.intellij.execution.actions.LazyRunConfigurationProducer;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
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
        configuration.setName(context.getPsiLocation().getContainingFile().getName());
        return true;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context) {
        return Objects.requireNonNull(context.getPsiLocation()).getContainingFile().getName().equals(configuration.getName());
    }
}
