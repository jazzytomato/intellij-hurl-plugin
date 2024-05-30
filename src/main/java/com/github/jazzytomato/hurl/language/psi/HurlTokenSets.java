package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface HurlTokenSets {

    TokenSet IDENTIFIERS = TokenSet.create(HurlTypes.KEY);

    TokenSet COMMENTS = TokenSet.create(HurlTypes.COMMENT);

}