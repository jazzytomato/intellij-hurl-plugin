// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.github.jazzytomato.hurl.language.psi.HurlTypes.*;
import com.github.jazzytomato.hurl.language.psi.*;

public class HurlMatchPredicateImpl extends HurlPredicateImpl implements HurlMatchPredicate {

  public HurlMatchPredicateImpl(@NotNull ASTNode node) {
    super(node);
  }

  @Override
  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitMatchPredicate(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlRegex getRegex() {
    return findChildByClass(HurlRegex.class);
  }

  @Override
  @Nullable
  public HurlRegexString getRegexString() {
    return findChildByClass(HurlRegexString.class);
  }

}
