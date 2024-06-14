// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.jazzytomato.hurl.language.psi.HurlTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.github.jazzytomato.hurl.language.psi.*;

public class HurlRequestSectionImpl extends ASTWrapperPsiElement implements HurlRequestSection {

  public HurlRequestSectionImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitRequestSection(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlBasicAuthSection getBasicAuthSection() {
    return findChildByClass(HurlBasicAuthSection.class);
  }

  @Override
  @Nullable
  public HurlCookiesSection getCookiesSection() {
    return findChildByClass(HurlCookiesSection.class);
  }

  @Override
  @Nullable
  public HurlFormParamsSection getFormParamsSection() {
    return findChildByClass(HurlFormParamsSection.class);
  }

  @Override
  @Nullable
  public HurlMultipartFormDataSection getMultipartFormDataSection() {
    return findChildByClass(HurlMultipartFormDataSection.class);
  }

  @Override
  @Nullable
  public HurlOptionsSection getOptionsSection() {
    return findChildByClass(HurlOptionsSection.class);
  }

  @Override
  @Nullable
  public HurlQueryStringParamsSection getQueryStringParamsSection() {
    return findChildByClass(HurlQueryStringParamsSection.class);
  }

}
