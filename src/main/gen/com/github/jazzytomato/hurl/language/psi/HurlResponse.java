// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlResponse extends PsiElement {

  @Nullable
  HurlBody getBody();

  @NotNull
  List<HurlHeader> getHeaderList();

  @NotNull
  HurlHttpStatus getHttpStatus();

  @NotNull
  List<HurlResponseSection> getResponseSectionList();

  @NotNull
  PsiElement getHttpVersion();

}
