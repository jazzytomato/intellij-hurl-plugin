// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi.impl;

import com.github.jazzytomato.hurl.language.psi.HurlBody;
import com.github.jazzytomato.hurl.language.psi.HurlJson;
import com.github.jazzytomato.hurl.language.psi.HurlVisitor;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.tree.LeafElement;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import static com.github.jazzytomato.hurl.language.psi.HurlTypes.STRING;

public class HurlJsonImpl extends ASTWrapperPsiElement implements HurlBody, PsiLanguageInjectionHost {

  public HurlJsonImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull HurlVisitor visitor) {
    visitor.visitBody(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof HurlVisitor) accept((HurlVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public HurlJson getJson() {
    return findChildByClass(HurlJson.class);
  }

  @Override
  @Nullable
  public PsiElement getString() {
    return findChildByType(STRING);
  }

  @Override
  public boolean isValidHost() {
    return true;
  }

  @Override
  public PsiLanguageInjectionHost updateText(@NotNull String text) {
    LeafElement newLeaf = ((LeafElement) getNode().getFirstChildNode()).replaceWithText(text);
    return (PsiLanguageInjectionHost) newLeaf.getPsi();
  }

  @NotNull
  @Override
  public LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
    return new LiteralTextEscaper<HurlJsonImpl>(this) {
      @Override
      public boolean decode(@NotNull TextRange rangeInsideHost, @NotNull StringBuilder outChars) {
        outChars.append(myHost.getText(), rangeInsideHost.getStartOffset(), rangeInsideHost.getEndOffset());
        return true;
      }

      @Override
      public int getOffsetInHost(int offsetInDecoded, @NotNull TextRange rangeInsideHost) {
        int offset = rangeInsideHost.getStartOffset() + offsetInDecoded;
        if (offset < rangeInsideHost.getStartOffset()) {
          offset = rangeInsideHost.getStartOffset();
        } else if (offset > rangeInsideHost.getEndOffset()) {
          offset = rangeInsideHost.getEndOffset();
        }
        return offset;
      }

      @Override
      public boolean isOneLine() {
        return false;
      }
    };
  }

}
