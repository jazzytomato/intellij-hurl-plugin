package com.github.jazzytomato.hurl.run;

import com.intellij.execution.actions.ConfigurationContext;
import com.intellij.execution.actions.ConfigurationFromContext;
import com.intellij.execution.actions.RunConfigurationProducer;
import com.intellij.execution.configurations.ConfigurationTypeUtil;
import com.intellij.openapi.util.Ref;
import com.intellij.psi.PsiElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HurlRunConfigurationProducer extends RunConfigurationProducer<HurlRunConfiguration> {

    protected HurlRunConfigurationProducer() {
        super(new HurlRunConfigurationFactory(ConfigurationTypeUtil.findConfigurationType(HurlRunConfigurationType.class)));
    }

    @Override
    protected boolean setupConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context, @NotNull Ref<PsiElement> sourceElement) {
        // Set up the configuration from the context (e.g., selected file)
        configuration.setName(context.getPsiLocation().getContainingFile().getName());
        return true;
    }

    @Override
    public boolean isConfigurationFromContext(@NotNull HurlRunConfiguration configuration, @NotNull ConfigurationContext context) {
        // Check if the configuration matches the context
        return context.getPsiLocation().getContainingFile().getName().equals(configuration.getName());
    }

    @Override
    public @Nullable ConfigurationFromContext findOrCreateConfigurationFromContext(@NotNull ConfigurationContext context) {
        return super.findOrCreateConfigurationFromContext(context);
    }
}
