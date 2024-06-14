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

public class HurlRequestImpl extends ASTWrapperPsiElement implements HurlRequest {

  public HurlRequestImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitRequest(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlBody getBody() {
    return findChildByClass(HurlBody.class);
  }

  @Override
  @NotNull
  public List<HurlHeader> getHeaderList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlHeader.class);
  }

  @Override
  @NotNull
  public List<HurlRequestSection> getRequestSectionList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlRequestSection.class);
  }

  @Override
  @NotNull
  public HurlUrlOrTemplate getUrlOrTemplate() {
    return findNotNullChildByClass(HurlUrlOrTemplate.class);
  }

  @Override
  @NotNull
  public PsiElement getMethod() {
    return findNotNullChildByType(METHOD);
  }

}
