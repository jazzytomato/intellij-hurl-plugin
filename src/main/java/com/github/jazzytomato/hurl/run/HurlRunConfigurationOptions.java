package com.github.jazzytomato.hurl.run;

import com.intellij.execution.configurations.RunConfigurationOptions;
import com.intellij.openapi.components.StoredProperty;

public class HurlRunConfigurationOptions extends RunConfigurationOptions {

    private final StoredProperty<String> hurlPath =
            string("/opt/homebrew/bin/hurl").provideDelegate(this, "Hurl executable path:");

    public String getHurlPath() {
        return hurlPath.getValue(this);
    }

    public void setHurlPath(String scriptName) {
        hurlPath.setValue(this, scriptName);
    }

}