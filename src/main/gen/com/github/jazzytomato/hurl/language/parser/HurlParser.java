// This is a generated file. Not intended for manual editing.
package com.github.jazzytomato.hurl.language.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.github.jazzytomato.hurl.language.psi.HurlTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class HurlParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return hurlFile(b, l + 1);
  }

  /* ********************************************************** */
  // "#" [^\r\n]*
  public static boolean COMMENT(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMMENT")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMMENT, "<comment>");
    r = consumeToken(b, "#");
    r = r && COMMENT_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // [^\r\n]
  private static boolean COMMENT_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "COMMENT_1")) return false;
    consumeToken(b, COMMENT_1_0_0);
    return true;
  }

  /* ********************************************************** */
  // "\n"
  public static boolean CRLF(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "CRLF")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CRLF, "<crlf>");
    r = consumeToken(b, "\n");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [a-zA-Z0-9_.-]+
  public static boolean IDENTIFIER(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "IDENTIFIER")) return false;
    Marker m = enter_section_(b, l, _NONE_, IDENTIFIER, "<identifier>");
    consumeToken(b, A_ZA_Z0_9___);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // [ \t\f]+
  public static boolean WHITE_SPACE(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "WHITE_SPACE")) return false;
    Marker m = enter_section_(b, l, _NONE_, WHITE_SPACE, "<white space>");
    consumeToken(b, WHITE_SPACE_0_0);
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // request* (COMMENT | CRLF)*
  static boolean hurlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = hurlFile_0(b, l + 1);
    r = r && hurlFile_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // request*
  private static boolean hurlFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hurlFile_0", c)) break;
    }
    return true;
  }

  // (COMMENT | CRLF)*
  private static boolean hurlFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!hurlFile_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hurlFile_1", c)) break;
    }
    return true;
  }

  // COMMENT | CRLF
  private static boolean hurlFile_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile_1_0")) return false;
    boolean r;
    r = COMMENT(b, l + 1);
    if (!r) r = CRLF(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // GET_METHOD | POST_METHOD | PUT_METHOD | DELETE_METHOD
  public static boolean method(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "method")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, METHOD, "<method>");
    r = consumeToken(b, GET_METHOD);
    if (!r) r = consumeToken(b, POST_METHOD);
    if (!r) r = consumeToken(b, PUT_METHOD);
    if (!r) r = consumeToken(b, DELETE_METHOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // method url (CRLF | WHITE_SPACE)*
  public static boolean request(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REQUEST, "<request>");
    r = method(b, l + 1);
    r = r && url(b, l + 1);
    r = r && request_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (CRLF | WHITE_SPACE)*
  private static boolean request_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_2", c)) break;
    }
    return true;
  }

  // CRLF | WHITE_SPACE
  private static boolean request_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_2_0")) return false;
    boolean r;
    r = CRLF(b, l + 1);
    if (!r) r = WHITE_SPACE(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // ( "http://" | "https://" ) IDENTIFIER ("/" IDENTIFIER)*
  public static boolean url(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL, "<url>");
    r = url_0(b, l + 1);
    r = r && IDENTIFIER(b, l + 1);
    r = r && url_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // "http://" | "https://"
  private static boolean url_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_0")) return false;
    boolean r;
    r = consumeToken(b, "http://");
    if (!r) r = consumeToken(b, "https://");
    return r;
  }

  // ("/" IDENTIFIER)*
  private static boolean url_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!url_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "url_2", c)) break;
    }
    return true;
  }

  // "/" IDENTIFIER
  private static boolean url_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "/");
    r = r && IDENTIFIER(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

}
