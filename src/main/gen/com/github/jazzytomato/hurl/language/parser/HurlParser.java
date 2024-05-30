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
  // request*
  static boolean hurlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hurlFile", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !<<eof>> METHOD (URL|VAR) (ANY|VAR)*
  public static boolean request(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REQUEST, "<request>");
    r = request_0(b, l + 1);
    r = r && consumeToken(b, METHOD);
    r = r && request_2(b, l + 1);
    p = r; // pin = 3
    r = r && request_3(b, l + 1);
    exit_section_(b, l, m, r, p, HurlParser::request_recover);
    return r || p;
  }

  // !<<eof>>
  private static boolean request_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // URL|VAR
  private static boolean request_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_2")) return false;
    boolean r;
    r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, VAR);
    return r;
  }

  // (ANY|VAR)*
  private static boolean request_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_3", c)) break;
    }
    return true;
  }

  // ANY|VAR
  private static boolean request_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_3_0")) return false;
    boolean r;
    r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, VAR);
    return r;
  }

  /* ********************************************************** */
  // !METHOD !URL
  static boolean request_recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_recover")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = request_recover_0(b, l + 1);
    r = r && request_recover_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !METHOD
  private static boolean request_recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_recover_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, METHOD);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !URL
  private static boolean request_recover_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_recover_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, URL);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
