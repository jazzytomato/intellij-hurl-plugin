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

public class HurlPredicateValueImpl extends ASTWrapperPsiElement implements HurlPredicateValue {

  public HurlPredicateValueImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitPredicateValue(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlMultilineGraphqlString getMultilineGraphqlString() {
    return findChildByClass(HurlMultilineGraphqlString.class);
  }

  @Override
  @Nullable
  public HurlMultilineJsonString getMultilineJsonString() {
    return findChildByClass(HurlMultilineJsonString.class);
  }

  @Override
  @Nullable
  public HurlMultilineString getMultilineString() {
    return findChildByClass(HurlMultilineString.class);
  }

  @Override
  @Nullable
  public HurlMultilineXmlString getMultilineXmlString() {
    return findChildByClass(HurlMultilineXmlString.class);
  }

  @Override
  @Nullable
  public HurlOnelineBase64 getOnelineBase64() {
    return findChildByClass(HurlOnelineBase64.class);
  }

  @Override
  @Nullable
  public HurlOnelineFile getOnelineFile() {
    return findChildByClass(HurlOnelineFile.class);
  }

  @Override
  @Nullable
  public HurlOnelineHex getOnelineHex() {
    return findChildByClass(HurlOnelineHex.class);
  }

  @Override
  @Nullable
  public PsiElement getAlphanum() {
    return findChildByType(ALPHANUM);
  }

  @Override
  @Nullable
  public PsiElement getAny() {
    return findChildByType(ANY);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

  @Override
  @Nullable
  public PsiElement getJsonId() {
    return findChildByType(JSON_ID);
  }

  @Override
  @Nullable
  public PsiElement getNumber() {
    return findChildByType(NUMBER);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  @Override
  @Nullable
  public PsiElement getTemplate() {
    return findChildByType(TEMPLATE);
  }

}
