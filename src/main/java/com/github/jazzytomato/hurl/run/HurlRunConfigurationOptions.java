package com.github.jazzytomato.hurl.run;

import com.intellij.execution.configurations.LocatableRunConfigurationOptions;
import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class HurlRunConfigurationOptions extends LocatableRunConfigurationOptions {

    private final StoredProperty<String> hurlPath =
            string("/opt/homebrew/bin/hurl").provideDelegate(this, "Hurl executable path:");

    public String getHurlPath() {
        return hurlPath.getValue(this);
    }

    public void setHurlPath(String scriptName) {
        hurlPath.setValue(this, scriptName);
    }

    private final StoredProperty<String> hurlArgs =
            string("").provideDelegate(this, "Hurl arguments:");

    public String getHurlArgs() {
        return hurlArgs.getValue(this);
    }

    public void setHurlArgs(String args) {
        hurlArgs.setValue(this, args);
    }
}