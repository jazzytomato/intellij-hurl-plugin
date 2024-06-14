// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi.impl;

import com.github.jazzytomato.hurl.language.psi.HurlBody;
import com.github.jazzytomato.hurl.language.psi.HurlJson;
import com.github.jazzytomato.hurl.language.psi.HurlMultilineGraphqlString;
import com.github.jazzytomato.hurl.language.psi.HurlMultilineJsonString;
import com.github.jazzytomato.hurl.language.psi.HurlMultilineString;
import com.github.jazzytomato.hurl.language.psi.HurlMultilineXmlString;
import com.github.jazzytomato.hurl.language.psi.HurlOnelineBase64;
import com.github.jazzytomato.hurl.language.psi.HurlOnelineFile;
import com.github.jazzytomato.hurl.language.psi.HurlOnelineHex;
import com.github.jazzytomato.hurl.language.psi.HurlOnelineString;
import com.github.jazzytomato.hurl.language.psi.HurlVisitor;
import com.github.jazzytomato.hurl.language.psi.HurlXml;
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
  public @Nullable HurlMultilineGraphqlString getMultilineGraphqlString() {
    return findChildByClass(HurlMultilineGraphqlString.class);
  }

  @Override
  public @Nullable HurlMultilineJsonString getMultilineJsonString() {
    return findChildByClass(HurlMultilineJsonString.class);
  }

  @Override
  public @Nullable HurlMultilineString getMultilineString() {
    return findChildByClass(HurlMultilineString.class);
  }

  @Override
  public @Nullable HurlMultilineXmlString getMultilineXmlString() {
    return findChildByClass(HurlMultilineXmlString.class);
  }

  @Override
  public @Nullable HurlOnelineBase64 getOnelineBase64() {
    return findChildByClass(HurlOnelineBase64.class);
  }

  @Override
  public @Nullable HurlOnelineFile getOnelineFile() {
    return findChildByClass(HurlOnelineFile.class);
  }

  @Override
  public @Nullable HurlOnelineHex getOnelineHex() {
    return findChildByClass(HurlOnelineHex.class);
  }

  @Override
  public @Nullable HurlOnelineString getOnelineString() {
    return findChildByClass(HurlOnelineString.class);
  }

  @Override
  public @Nullable HurlXml getXml() {
    return null;
  }

  @Override
  public @Nullable PsiElement getAlphanum() {
    return null;
  }

  @Override
  public @Nullable PsiElement getAny() {
    return null;
  }

  @Override
  public @Nullable PsiElement getIdentifier() {
    return null;
  }

  @Override
  public @Nullable PsiElement getJsonId() {
    return null;
  }

  @Override
  public @Nullable PsiElement getNumber() {
    return null;
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
