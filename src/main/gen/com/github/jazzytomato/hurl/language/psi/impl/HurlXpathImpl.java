// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi.impl;

import com.github.jazzytomato.hurl.language.psi.HurlVisitor;
import com.github.jazzytomato.hurl.language.psi.HurlXpath;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import org.jetbrains.annotations.NotNull;

import static com.github.jazzytomato.hurl.language.psi.HurlTypes.STRING;

public class HurlXpathImpl extends ASTWrapperPsiElement implements HurlXpath {

  public HurlXpathImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitXpath(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public PsiElement getString() {
    return findNotNullChildByType(STRING);
  }

}
