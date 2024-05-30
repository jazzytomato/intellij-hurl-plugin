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
  @NotNull
  public List<HurlCrlf> getCrlfList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlCrlf.class);
  }

  @Override
  @NotNull
  public List<HurlWhiteSpace> getWhiteSpaceList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, HurlWhiteSpace.class);
  }

  @Override
  @NotNull
  public HurlMethod getMethod() {
    return findNotNullChildByClass(HurlMethod.class);
  }

  @Override
  @NotNull
  public HurlUrl getUrl() {
    return findNotNullChildByClass(HurlUrl.class);
  }

}
