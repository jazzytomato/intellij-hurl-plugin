package com.github.jazzytomato.hurl.run;

import com.intellij.openapi.fileChooser.FileChooserDescriptorFactory;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.ui.TextFieldWithBrowseButton;
import com.intellij.util.ui.FormBuilder;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public class HurlSettingsEditor extends SettingsEditor<HurlRunConfiguration> {

    private final JPanel myPanel;
    private final TextFieldWithBrowseButton hurlPathField;
    private final TextFieldWithBrowseButton hurlFilePathField;
    private final JTextField hurlArgsField;

    public HurlSettingsEditor() {
        hurlArgsField = new JTextField();
        hurlPathField = new TextFieldWithBrowseButton();
        hurlFilePathField = new TextFieldWithBrowseButton();
        hurlFilePathField.addBrowseFolderListener("Select Hurl File", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor());
        hurlPathField.addBrowseFolderListener("Select Hurl Executable", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor());
        myPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Hurl executable path", hurlPathField)
                .addLabeledComponent("Hurl file path", hurlFilePathField)
                .addLabeledComponent("Arguments", hurlArgsField)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(HurlRunConfiguration runConfig) {
        hurlPathField.setText(runConfig.getHurlPath());
        hurlFilePathField.setText(runConfig.getHurlFilePath());
        hurlArgsField.setText(runConfig.getHurlArgs());
    }

    @Override
    protected void applyEditorTo(@NotNull HurlRunConfiguration runConfig) {
        runConfig.setHurlPath(hurlPathField.getText());
        runConfig.setHurlFilePath(hurlFilePathField.getText());
        runConfig.setHurlArgs(hurlArgsField.getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return myPanel;
    }

}
