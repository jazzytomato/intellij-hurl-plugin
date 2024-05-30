package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface HurlTokenSets {

    TokenSet COMMENTS = TokenSet.create(HurlTypes.COMMENT);
    TokenSet METHODS = TokenSet.create(HurlTypes.METHOD);
    TokenSet URLS = TokenSet.create(HurlTypes.URL);

}
