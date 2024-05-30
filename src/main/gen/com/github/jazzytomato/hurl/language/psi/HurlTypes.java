// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.jazzytomato.hurl.language.psi.impl.*;

public interface HurlTypes {

  IElementType REQUEST = new HurlElementType("REQUEST");

  IElementType ANY = new HurlTokenType("ANY");
  IElementType COMMENT = new HurlTokenType("COMMENT");
  IElementType METHOD = new HurlTokenType("METHOD");
  IElementType URL = new HurlTokenType("URL");
  IElementType VAR = new HurlTokenType("VAR");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == REQUEST) {
        return new HurlRequestImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
