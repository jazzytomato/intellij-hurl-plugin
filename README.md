# intellij-hurl-plugin

## WIP - This plugin is not currently working or published

- [x] File type registration and icon
- [x] Basic parser
- [x] Basic Syntax highlighting
- [x] Code commenter
- [x] Generate run config from gutter and run it (all file)
- [x] Fix parser errors
- [ ] Better syntax highlighting. Currently just at lexer level - look into annotator for parser syntax highlighting https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html#annotator
- [ ] Tidy up and publish
- [x] Full parser of hurl grammar https://hurl.dev/docs/grammar.html#grammar
- [ ] Code folding - would be useful to fold hurl entries
- [x] Run individual requests (could use --from-entry & --to-entry options, or generate a tmp file but not ideal)
- [ ] Support for running multiple files with glob pattern
- [ ] Code completion
- [x] JSON language injection
- [x] XML language injection
- [x] Json path language injection
- [x] xpath language injection
- [ ] Vars file support
- [ ] Better run config options? currently just a field for additional args.
- [ ] Mark failed assertions as errors in the editor

![Build](https://github.com/jazzytomato/intellij-hurl-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/PLUGIN_ID.svg)](https://plugins.jetbrains.com/plugin/PLUGIN_ID)

## Template ToDo list
- [x] Create a new [IntelliJ Platform Plugin Template][template] project.
- [x] Get familiar with the [template documentation][template].
- [x] Adjust the [pluginGroup](./gradle.properties), [plugin ID](./src/main/resources/META-INF/plugin.xml) and [sources package](./src/main/kotlin).
- [x] Adjust the plugin description in `README` (see [Tips][docs:plugin-description])
- [x] Review the [Legal Agreements](https://plugins.jetbrains.com/docs/marketplace/legal-agreements.html?from=IJPluginTemplate).
- [ ] [Publish a plugin manually](https://plugins.jetbrains.com/docs/intellij/publishing-plugin.html?from=IJPluginTemplate) for the first time.
- [ ] Set the `PLUGIN_ID` in the above README badges.
- [ ] Set the [Plugin Signing](https://plugins.jetbrains.com/docs/intellij/plugin-signing.html?from=IJPluginTemplate) related [secrets](https://github.com/JetBrains/intellij-platform-plugin-template#environment-variables).
- [ ] Set the [Deployment Token](https://plugins.jetbrains.com/docs/marketplace/plugin-upload.html?from=IJPluginTemplate).
- [ ] Click the <kbd>Watch</kbd> button on the top of the [IntelliJ Platform Plugin Template][template] to be notified about releases containing new features and fixes.

<!-- Plugin description -->
Adds support for Hurl language (https://hurl.dev/).
This plugin currently provides:
- Syntax highlighting
- Parsing / error highlighting
- JSON, XML, jsonpath, xpath support / language injections.
- Automatically create run config for whole hurl file and ability to run individual requests from the gutter.
- Comment / uncomment code & blocks

[Github](https://github.com/jazzytomato/intellij-hurl-plugin) | [Issues](https://github.com/jazzytomato/intellij-hurl-plugin/issues)
<!-- Plugin description end -->

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Hurl"</kbd> >
  <kbd>Install</kbd>
  
- Manually:

  Download the [latest release](https://github.com/jazzytomato/intellij-hurl-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>


---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
