// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.PsiElement;

public class HurlVisitor extends PsiElementVisitor {

  public void visitBody(@NotNull HurlBody o) {
    visitPsiElement(o);
  }

  public void visitJson(@NotNull HurlJson o) {
    visitPsiElement(o);
  }

  public void visitJsonArray(@NotNull HurlJsonArray o) {
    visitJson(o);
  }

  public void visitJsonName(@NotNull HurlJsonName o) {
    visitPsiElement(o);
  }

  public void visitJsonObject(@NotNull HurlJsonObject o) {
    visitJson(o);
  }

  public void visitJsonProp(@NotNull HurlJsonProp o) {
    visitPsiElement(o);
  }

  public void visitJsonValue(@NotNull HurlJsonValue o) {
    visitPsiElement(o);
  }

  public void visitRequest(@NotNull HurlRequest o) {
    visitPsiElement(o);
  }

  public void visitVarr(@NotNull HurlVarr o) {
    visitPsiElement(o);
  }

  public void visitPsiElement(@NotNull PsiElement o) {
    visitElement(o);
  }

}
