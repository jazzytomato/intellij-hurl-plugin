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

public class HurlCaptureImpl extends ASTWrapperPsiElement implements HurlCapture {

  public HurlCaptureImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitCapture(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<HurlFilter> getFilterList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlFilter.class);
  }

  @Override
  @NotNull
  public HurlKeyString getKeyString() {
    return findNotNullChildByClass(HurlKeyString.class);
  }

  @Override
  @NotNull
  public HurlQuery getQuery() {
    return findNotNullChildByClass(HurlQuery.class);
  }

}
