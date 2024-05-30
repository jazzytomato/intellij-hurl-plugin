// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.jazzytomato.hurl.language.psi.impl.*;

public interface HurlTypes {

  IElementType COMMENT = new HurlElementType("COMMENT");
  IElementType CRLF = new HurlElementType("CRLF");
  IElementType IDENTIFIER = new HurlElementType("IDENTIFIER");
  IElementType METHOD = new HurlElementType("METHOD");
  IElementType REQUEST = new HurlElementType("REQUEST");
  IElementType URL = new HurlElementType("URL");
  IElementType WHITE_SPACE = new HurlElementType("WHITE_SPACE");

  IElementType A_ZA_Z0_9___ = new HurlTokenType("a-zA-Z0-9_.-");
  IElementType COMMENT_1_0_0 = new HurlTokenType("COMMENT_1_0_0");
  IElementType DELETE_METHOD = new HurlTokenType("DELETE_METHOD");
  IElementType GET_METHOD = new HurlTokenType("GET_METHOD");
  IElementType POST_METHOD = new HurlTokenType("POST_METHOD");
  IElementType PUT_METHOD = new HurlTokenType("PUT_METHOD");
  IElementType WHITE_SPACE_0_0 = new HurlTokenType("WHITE_SPACE_0_0");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new HurlCommentImpl(node);
      }
      else if (type == CRLF) {
        return new HurlCrlfImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new HurlIdentifierImpl(node);
      }
      else if (type == METHOD) {
        return new HurlMethodImpl(node);
      }
      else if (type == REQUEST) {
        return new HurlRequestImpl(node);
      }
      else if (type == URL) {
        return new HurlUrlImpl(node);
      }
      else if (type == WHITE_SPACE) {
        return new HurlWhiteSpaceImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
