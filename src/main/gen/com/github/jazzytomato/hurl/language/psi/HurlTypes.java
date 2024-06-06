// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.github.jazzytomato.hurl.language.psi.impl.*;

public interface HurlTypes {

  IElementType BODY = new HurlElementType("BODY");
  IElementType JSON = new HurlElementType("JSON");
  IElementType JSON_ARRAY = new HurlElementType("JSON_ARRAY");
  IElementType JSON_NAME = new HurlElementType("JSON_NAME");
  IElementType JSON_OBJECT = new HurlElementType("JSON_OBJECT");
  IElementType JSON_PROP = new HurlElementType("JSON_PROP");
  IElementType JSON_VALUE = new HurlElementType("JSON_VALUE");
  IElementType REQUEST = new HurlElementType("REQUEST");
  IElementType VARR = new HurlElementType("VARR");

  IElementType BOOLEAN = new HurlTokenType("true|false");
  IElementType COLON = new HurlTokenType(":");
  IElementType COMMA = new HurlTokenType(",");
  IElementType COMMENT = new HurlTokenType("COMMENT");
  IElementType IDENTIFIER = new HurlTokenType("IDENTIFIER");
  IElementType JSON_ID = new HurlTokenType("JSON_ID");
  IElementType LBRACE = new HurlTokenType("{");
  IElementType LBRACKET = new HurlTokenType("[");
  IElementType METHOD = new HurlTokenType("METHOD");
  IElementType NULL = new HurlTokenType("null");
  IElementType NUMBER = new HurlTokenType("NUMBER");
  IElementType RBRACE = new HurlTokenType("}");
  IElementType RBRACKET = new HurlTokenType("]");
  IElementType STRING = new HurlTokenType("STRING");
  IElementType URL = new HurlTokenType("URL");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == BODY) {
        return new HurlBodyImpl(node);
      }
      else if (type == JSON) {
        return new HurlJsonImpl(node);
      }
      else if (type == JSON_ARRAY) {
        return new HurlJsonArrayImpl(node);
      }
      else if (type == JSON_NAME) {
        return new HurlJsonNameImpl(node);
      }
      else if (type == JSON_OBJECT) {
        return new HurlJsonObjectImpl(node);
      }
      else if (type == JSON_PROP) {
        return new HurlJsonPropImpl(node);
      }
      else if (type == JSON_VALUE) {
        return new HurlJsonValueImpl(node);
      }
      else if (type == REQUEST) {
        return new HurlRequestImpl(node);
      }
      else if (type == VARR) {
        return new HurlVarrImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
