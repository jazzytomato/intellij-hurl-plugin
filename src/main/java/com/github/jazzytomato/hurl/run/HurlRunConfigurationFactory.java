package com.github.jazzytomato.hurl.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

public class HurlRunConfigurationFactory extends ConfigurationFactory {

    protected HurlRunConfigurationFactory(@NotNull ConfigurationType type) {
        super(type);
    }

    @NotNull
    @Override
    public HurlRunConfiguration createTemplateConfiguration(@NotNull Project project) {
        return new HurlRunConfiguration(project, this, "Hurl");
    }
}
