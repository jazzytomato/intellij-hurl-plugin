// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface HurlResponseSection extends PsiElement {

  @Nullable
  HurlAssertsSection getAssertsSection();

  @Nullable
  HurlCaptureSection getCaptureSection();

}
