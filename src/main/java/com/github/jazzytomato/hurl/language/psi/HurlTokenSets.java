package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.TokenSet;

public interface HurlTokenSets {

    TokenSet COMMENTS = TokenSet.create(HurlTypes.COMMENT);
    TokenSet NUMBERS = TokenSet.create(HurlTypes.NUMBER);
    TokenSet SECTIONS = TokenSet.create(HurlTypes.S_ASSERTS, HurlTypes.S_BASIC_AUTH, HurlTypes.S_CAPTURES, HurlTypes.S_COOKIES, HurlTypes.S_FORM_PARAMS, HurlTypes.S_HEADERS, HurlTypes.S_MULTIPART_FORM_DATA, HurlTypes.S_OPTIONS, HurlTypes.S_QUERY_STRING_PARAMS);
}
