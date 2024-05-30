// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.jazzytomato.hurl.language.psi.impl.*;

public interface HurlTypes {

  IElementType PROPERTY = new HurlElementType("PROPERTY");

  IElementType COMMENT = new HurlTokenType("COMMENT");
  IElementType CRLF = new HurlTokenType("CRLF");
  IElementType KEY = new HurlTokenType("KEY");
  IElementType SEPARATOR = new HurlTokenType("SEPARATOR");
  IElementType VALUE = new HurlTokenType("VALUE");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == PROPERTY) {
        return new HurlPropertyImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
