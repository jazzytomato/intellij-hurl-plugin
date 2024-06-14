// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlRequestSection extends PsiElement {

  @Nullable
  HurlBasicAuthSection getBasicAuthSection();

  @Nullable
  HurlCookiesSection getCookiesSection();

  @Nullable
  HurlFormParamsSection getFormParamsSection();

  @Nullable
  HurlMultipartFormDataSection getMultipartFormDataSection();

  @Nullable
  HurlOptionsSection getOptionsSection();

  @Nullable
  HurlQueryStringParamsSection getQueryStringParamsSection();

}
