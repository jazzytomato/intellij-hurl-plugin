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

    public HurlSettingsEditor() {
        hurlPathField = new TextFieldWithBrowseButton();
        hurlPathField.addBrowseFolderListener("Select Script File", null, null,
                FileChooserDescriptorFactory.createSingleFileDescriptor());
        myPanel = FormBuilder.createFormBuilder()
                .addLabeledComponent("Hurl executable path", hurlPathField)
                .getPanel();
    }

    @Override
    protected void resetEditorFrom(HurlRunConfiguration demoRunConfiguration) {
        hurlPathField.setText(demoRunConfiguration.getHurlPath());
    }

    @Override
    protected void applyEditorTo(@NotNull HurlRunConfiguration demoRunConfiguration) {
        demoRunConfiguration.setHurlPath(hurlPathField.getText());
    }

    @NotNull
    @Override
    protected JComponent createEditor() {
        return myPanel;
    }

}
