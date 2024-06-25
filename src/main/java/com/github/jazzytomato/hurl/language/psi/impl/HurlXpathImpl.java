// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi.impl;

import com.github.jazzytomato.hurl.language.psi.HurlVisitor;
import com.github.jazzytomato.hurl.language.psi.HurlXpath;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.intellij.lang.ASTNode;
import com.intellij.openapi.util.TextRange;
import com.intellij.psi.LiteralTextEscaper;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiLanguageInjectionHost;
import com.intellij.psi.impl.source.tree.LeafElement;
import org.jetbrains.annotations.NotNull;

import static com.github.jazzytomato.hurl.language.psi.HurlTypes.STRING;

public class HurlXpathImpl extends ASTWrapperPsiElement implements HurlXpath, PsiLanguageInjectionHost {
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

  @Override
  public boolean isValidHost() {
    return true;
  }

  @Override
  public PsiLanguageInjectionHost updateText(@NotNull String text) {
    LeafElement newLeaf = ((LeafElement) getNode().getFirstChildNode()).replaceWithText(text);
    return (PsiLanguageInjectionHost) newLeaf.getPsi();
  }

  @Override
  public @NotNull LiteralTextEscaper<? extends PsiLanguageInjectionHost> createLiteralTextEscaper() {
    return new LiteralTextEscaper<HurlXpathImpl>(this) {
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

      @NotNull
      public TextRange getRelevantTextRange() {
        return TextRange.from(1, myHost.getTextLength() - 2);
      }

      @Override
      public boolean isOneLine() {
        return true;
      }
    };
  }
}
