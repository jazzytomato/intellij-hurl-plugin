package com.github.jazzytomato.hurl.run;

import com.intellij.execution.ExecutionException;
import com.intellij.execution.Executor;
import com.intellij.execution.configurations.CommandLineState;
import com.intellij.execution.configurations.ConfigurationFactory;
import com.intellij.execution.configurations.GeneralCommandLine;
import com.intellij.execution.configurations.RunConfiguration;
import com.intellij.execution.configurations.RunConfigurationBase;
import com.intellij.execution.configurations.RunProfileState;
import com.intellij.execution.process.OSProcessHandler;
import com.intellij.execution.process.ProcessHandler;
import com.intellij.execution.process.ProcessHandlerFactory;
import com.intellij.execution.process.ProcessTerminatedListener;
import com.intellij.execution.runners.ExecutionEnvironment;
import com.intellij.openapi.actionSystem.CommonDataKeys;
import com.intellij.openapi.options.SettingsEditor;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.InvalidDataException;
import com.intellij.openapi.util.JDOMExternalizerUtil;
import com.intellij.openapi.vfs.VirtualFile;
import org.intellij.lang.annotations.Language;
import org.jdom.Element;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.Arrays;
import java.util.List;

public class HurlRunConfiguration extends RunConfigurationBase<HurlRunConfigurationOptions> {

    public static final String KEY_HURL_PATH = "hurl.path";
    public static final String KEY_HURL_ARGS = "hurl.args";

    protected HurlRunConfiguration(Project project,
                                   ConfigurationFactory factory,
                                   String name) {
        super(project, factory, name);
    }

    @NotNull
    @Override
    protected HurlRunConfigurationOptions getOptions() {
        return (HurlRunConfigurationOptions) super.getOptions();
    }

    public String getHurlPath() {
        return getOptions().getHurlPath();
    }

    public void setHurlPath(String scriptName) {
        getOptions().setHurlPath(scriptName);
    }

    public String getHurlArgs() {
        return getOptions().getHurlArgs();
    }

    public void setHurlArgs(String args) {
        getOptions().setHurlArgs(args);
    }

    @Override
    public void readExternal(@NotNull Element element) throws InvalidDataException {
        super.readExternal(element);
        setHurlPath(JDOMExternalizerUtil.readField(element, KEY_HURL_PATH));
        setHurlArgs(JDOMExternalizerUtil.readField(element, KEY_HURL_ARGS));
    }

    @Override
    public void writeExternal(@NotNull Element element) {
        super.writeExternal(element);
        JDOMExternalizerUtil.writeField(element, KEY_HURL_PATH, getHurlPath());
        JDOMExternalizerUtil.writeField(element, KEY_HURL_ARGS, getHurlArgs());
    }

    @NotNull
    @Override
    public SettingsEditor<? extends RunConfiguration> getConfigurationEditor() {
        return new HurlSettingsEditor();
    }

    @Nullable
    @Override
    public RunProfileState getState(@NotNull Executor executor,
                                    @NotNull ExecutionEnvironment environment) {
        return new CommandLineState(environment) {
            @NotNull
            @Override
            protected ProcessHandler startProcess() throws ExecutionException {
                VirtualFile file = environment.getDataContext().getData(CommonDataKeys.VIRTUAL_FILE);
                if (file == null) {
                    throw new ExecutionException("No file selected");
                }

                GeneralCommandLine commandLine = getCommandLine(file);

                OSProcessHandler processHandler = ProcessHandlerFactory.getInstance()
                        .createColoredProcessHandler(commandLine);
                ProcessTerminatedListener.attach(processHandler);
                return processHandler;
            }
        };
    }

    private @NotNull GeneralCommandLine getCommandLine(VirtualFile file) {
        String filePath = file.getPath();
        String hurlPath = getOptions().getHurlPath();
        String hurlArgs = getOptions().getHurlArgs();
        String[] argsList = hurlArgs.split("\\s+");
        GeneralCommandLine commandLine = new GeneralCommandLine();
        commandLine.setExePath(hurlPath);
        commandLine.addParameter(filePath);
        for (String arg : argsList) {
            commandLine.addParameter(arg);
        }
        return commandLine;
    }

}