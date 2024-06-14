// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlBody extends PsiElement {

  @Nullable
  HurlJson getJson();

  @Nullable
  HurlMultilineGraphqlString getMultilineGraphqlString();

  @Nullable
  HurlMultilineJsonString getMultilineJsonString();

  @Nullable
  HurlMultilineString getMultilineString();

  @Nullable
  HurlMultilineXmlString getMultilineXmlString();

  @Nullable
  HurlOnelineBase64 getOnelineBase64();

  @Nullable
  HurlOnelineFile getOnelineFile();

  @Nullable
  HurlOnelineHex getOnelineHex();

  @Nullable
  HurlOnelineString getOnelineString();

  @Nullable
  HurlXml getXml();

  @Nullable
  PsiElement getAlphanum();

  @Nullable
  PsiElement getAny();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getJsonId();

  @Nullable
  PsiElement getNumber();

  @Nullable
  PsiElement getString();

}
