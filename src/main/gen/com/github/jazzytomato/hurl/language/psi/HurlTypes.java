// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.jazzytomato.hurl.language.psi.impl.*;

public interface HurlTypes {

  IElementType COMMENT = new HurlElementType("COMMENT");
  IElementType CRLF = new HurlElementType("CRLF");
  IElementType DELETE_METHOD = new HurlElementType("DELETE_METHOD");
  IElementType GET_METHOD = new HurlElementType("GET_METHOD");
  IElementType IDENTIFIER = new HurlElementType("IDENTIFIER");
  IElementType METHOD = new HurlElementType("METHOD");
  IElementType POST_METHOD = new HurlElementType("POST_METHOD");
  IElementType PUT_METHOD = new HurlElementType("PUT_METHOD");
  IElementType REQUEST = new HurlElementType("REQUEST");
  IElementType URL = new HurlElementType("URL");
  IElementType WHITE_SPACE = new HurlElementType("WHITE_SPACE");

  IElementType A_ZA_Z0_9___ = new HurlTokenType("a-zA-Z0-9_.-");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == COMMENT) {
        return new HurlCommentImpl(node);
      }
      else if (type == CRLF) {
        return new HurlCrlfImpl(node);
      }
      else if (type == DELETE_METHOD) {
        return new HurlDeleteMethodImpl(node);
      }
      else if (type == GET_METHOD) {
        return new HurlGetMethodImpl(node);
      }
      else if (type == IDENTIFIER) {
        return new HurlIdentifierImpl(node);
      }
      else if (type == METHOD) {
        return new HurlMethodImpl(node);
      }
      else if (type == POST_METHOD) {
        return new HurlPostMethodImpl(node);
      }
      else if (type == PUT_METHOD) {
        return new HurlPutMethodImpl(node);
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
