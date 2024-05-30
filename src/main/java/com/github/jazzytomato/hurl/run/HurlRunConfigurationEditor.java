package com.github.jazzytomato.hurl.run;

import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class HurlRunConfigurationEditor extends SettingsEditor<HurlRunConfiguration> {

    private JPanel panel;

    public HurlRunConfigurationEditor(Project project) {
        panel = new JPanel(); // Add your UI components here
    }

    @Override
    protected void resetEditorFrom(@NotNull HurlRunConfiguration s) {
        // Reset editor fields from configuration
    }

    @Override
    protected void applyEditorTo(@NotNull HurlRunConfiguration s) {
        // Apply changes to the configuration
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return panel;
    }
}
