package com.github.jazzytomato.hurl.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.icons.AllIcons;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;

public class HurlRunConfigurationType implements ConfigurationType {

    @Override
    @NotNull
    public String getDisplayName() {
        return "Hurl";
    }

    @Override
    public String getConfigurationTypeDescription() {
        return "Run Hurl files";
    }

    @Override
    public Icon getIcon() {
        return AllIcons.RunConfigurations.Application;
    }

    @NotNull
    @Override
    public String getId() {
        return "HURL_RUN_CONFIGURATION";
    }

    @Override
    public ConfigurationFactory[] getConfigurationFactories() {
        return new ConfigurationFactory[]{new HurlRunConfigurationFactory(this)};
    }

    @Nullable
    public static HurlRunConfigurationType getInstance() {
        return ConfigurationType.CONFIGURATION_TYPE_EP.findExtension(HurlRunConfigurationType.class);
    }
}
