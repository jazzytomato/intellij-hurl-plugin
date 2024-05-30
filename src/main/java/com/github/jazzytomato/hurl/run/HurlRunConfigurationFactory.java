package com.github.jazzytomato.hurl.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.openapi.components.BaseState;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

public class HurlRunConfigurationFactory extends ConfigurationFactory {

    protected HurlRunConfigurationFactory(ConfigurationType type) {
        super(type);
    }

    @Override
    public @NotNull String getId() {
        return HurlRunConfigurationType.ID;
    }

    @NotNull
    @Override
    public RunConfiguration createTemplateConfiguration(
            @NotNull Project project) {
        return new HurlRunConfiguration(project, this, "Hurl");
    }

    @Nullable
    @Override
    public Class<? extends BaseState> getOptionsClass() {
        return HurlRunConfigurationOptions.class;
    }

}