# intellij-hurl-plugin

![Build](https://github.com/jazzytomato/intellij-hurl-plugin/workflows/Build/badge.svg)
[![Version](https://img.shields.io/jetbrains/plugin/v/com.github.jazzytomato.hurl.svg)](https://plugins.jetbrains.com/plugin/24735-hurl)
[![Downloads](https://img.shields.io/jetbrains/plugin/d/com.github.jazzytomato.hurl.svg)](https://plugins.jetbrains.com/plugin/24735-hurl)

<!-- Plugin description -->
Adds support for Hurl language (https://hurl.dev/).
This plugin currently provides:
- Syntax highlighting
- Parsing / error highlighting
- JSON, XML, jsonpath, xpath support (language injections).
- Create run configurations for hurl files and run individual requests inline.
- Comment / uncomment code and blocks

[Github](https://github.com/jazzytomato/intellij-hurl-plugin) | [Issues](https://github.com/jazzytomato/intellij-hurl-plugin/issues) | [Hurl language](https://hurl.dev/)
<!-- Plugin description end -->

## Disclaimer
I am not affiliated with the Hurl project.
This is an early release and there are likely to be bugs and missing features. Please report any issues on the Issues page. Contributions are welcome.

## Installation

- Using the IDE built-in plugin system:
  
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>Marketplace</kbd> > <kbd>Search for "Hurl"</kbd> >
  <kbd>Install</kbd>
  
- Manually:

  Download the [latest release](https://github.com/jazzytomato/intellij-hurl-plugin/releases/latest) and install it manually using
  <kbd>Settings/Preferences</kbd> > <kbd>Plugins</kbd> > <kbd>⚙️</kbd> > <kbd>Install plugin from disk...</kbd>

## ToDo list
- [x] File type registration and icon
- [x] Basic parser
- [x] Basic Syntax highlighting
- [x] Code commenter
- [x] Generate run config from gutter and run it (all file)
- [x] Fix parser errors
- [x] Tidy up and publish
- [x] Full parser of hurl grammar https://hurl.dev/docs/grammar.html#grammar
- [x] Run individual requests (could use --from-entry & --to-entry options, or generate a tmp file but not ideal)
- [x] JSON language injection
- [x] XML language injection
- [x] Json path language injection
- [x] xpath language injection
- [ ] Better regex parsing. Currently some issues with escaped characters
- [ ] Better XML parsing.
- [ ] Better syntax highlighting. Currently just at lexer level - look into annotator for parser syntax highlighting https://plugins.jetbrains.com/docs/intellij/syntax-highlighting-and-error-highlighting.html#annotator
- [ ] Code folding - would be useful to fold hurl entries
- [ ] Support for running multiple files with glob pattern
- [ ] Code completion
- [ ] GraphQL language injection
- [ ] Make language injection dependencies optional
- [ ] Vars file support
- [ ] Better run config options? currently just a field for additional args.
- [ ] Mark failed assertions as errors in the editor?

---
Plugin based on the [IntelliJ Platform Plugin Template][template].

[template]: https://github.com/JetBrains/intellij-platform-plugin-template
[docs:plugin-description]: https://plugins.jetbrains.com/docs/intellij/plugin-user-experience.html#plugin-description-and-presentation
