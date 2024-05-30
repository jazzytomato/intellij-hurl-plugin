package com.github.jazzytomato.hurl.run;

import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.ConfigurationType;
import com.intellij.execution.configurations.ConfigurationTypeBase;
import com.intellij.icons.AllIcons;
import com.intellij.openapi.util.NotNullLazyValue;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import javax.swing.*;
final class HurlRunConfigurationType extends ConfigurationTypeBase {

    static final String ID = "HurlRunConfiguration";

    HurlRunConfigurationType() {
        super(ID, "Hurl", "Hurl run configuration type",
                NotNullLazyValue.createValue(() -> AllIcons.Nodes.Console));
        addFactory(new HurlRunConfigurationFactory(this));
    }

}
