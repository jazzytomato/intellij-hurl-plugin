// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlVariableValue extends PsiElement {

  @Nullable
  HurlKeyString getKeyString();

  @Nullable
  PsiElement getAlphanum();

  @Nullable
  PsiElement getIdentifier();

  @Nullable
  PsiElement getNumber();

}
