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
    b = adapt_builder_(t, b, this, EXTENDS_SETS_);
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

  public static final TokenSet[] EXTENDS_SETS_ = new TokenSet[] {
    create_token_set_(JSON, JSON_ARRAY, JSON_OBJECT),
  };

  /* ********************************************************** */
  // json | STRING
  public static boolean body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    r = json(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
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
  // json_array | json_object
  public static boolean json(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json")) return false;
    if (!nextTokenIs(b, "<json>", LBRACE, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, JSON, "<json>");
    r = json_array(b, l + 1);
    if (!r) r = json_object(b, l + 1);
    register_hook_(b, WS_BINDERS, null, null);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '[' [!']' json_item (!']' ',' json_item) *] ']'
  public static boolean json_array(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array")) return false;
    if (!nextTokenIs(b, LBRACKET)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, JSON_ARRAY, null);
    r = consumeToken(b, LBRACKET);
    p = r; // pin = 1
    r = r && report_error_(b, json_array_1(b, l + 1));
    r = p && consumeToken(b, RBRACKET) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [!']' json_item (!']' ',' json_item) *]
  private static boolean json_array_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1")) return false;
    json_array_1_0(b, l + 1);
    return true;
  }

  // !']' json_item (!']' ',' json_item) *
  private static boolean json_array_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = json_array_1_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, json_item(b, l + 1));
    r = p && json_array_1_0_2(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !']'
  private static boolean json_array_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!']' ',' json_item) *
  private static boolean json_array_1_0_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!json_array_1_0_2_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "json_array_1_0_2", c)) break;
    }
    return true;
  }

  // !']' ',' json_item
  private static boolean json_array_1_0_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_2_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = json_array_1_0_2_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COMMA));
    r = p && json_item(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !']'
  private static boolean json_array_1_0_2_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_array_1_0_2_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACKET);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // json_value
  static boolean json_item(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_item")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_);
    r = json_value(b, l + 1);
    exit_section_(b, l, m, r, false, HurlParser::recover);
    return r;
  }

  /* ********************************************************** */
  // JSON_ID | STRING
  public static boolean json_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_name")) return false;
    if (!nextTokenIs(b, "<json_name>", JSON_ID, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_NAME, "<json_name>");
    r = consumeToken(b, JSON_ID);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '{' [!'}' !'{' json_prop (!'}' ',' json_prop) *] '}'
  public static boolean json_object(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, JSON_OBJECT, null);
    r = consumeToken(b, LBRACE);
    p = r; // pin = 1
    r = r && report_error_(b, json_object_1(b, l + 1));
    r = p && consumeToken(b, RBRACE) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // [!'}' !'{' json_prop (!'}' ',' json_prop) *]
  private static boolean json_object_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1")) return false;
    json_object_1_0(b, l + 1);
    return true;
  }

  // !'}' !'{' json_prop (!'}' ',' json_prop) *
  private static boolean json_object_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = json_object_1_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, json_object_1_0_1(b, l + 1));
    r = p && report_error_(b, json_prop(b, l + 1)) && r;
    r = p && json_object_1_0_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !'}'
  private static boolean json_object_1_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // !'{'
  private static boolean json_object_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, LBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (!'}' ',' json_prop) *
  private static boolean json_object_1_0_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!json_object_1_0_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "json_object_1_0_3", c)) break;
    }
    return true;
  }

  // !'}' ',' json_prop
  private static boolean json_object_1_0_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_3_0")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_);
    r = json_object_1_0_3_0_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, consumeToken(b, COMMA));
    r = p && json_prop(b, l + 1) && r;
    exit_section_(b, l, m, r, p, null);
    return r || p;
  }

  // !'}'
  private static boolean json_object_1_0_3_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_object_1_0_3_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !consumeToken(b, RBRACE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // [] json_name ':' json_value
  public static boolean json_prop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_prop")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, JSON_PROP, "<json prop>");
    r = json_prop_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, json_name(b, l + 1));
    r = p && report_error_(b, consumeToken(b, COLON)) && r;
    r = p && json_value(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::recover);
    return r || p;
  }

  // []
  private static boolean json_prop_0(PsiBuilder b, int l) {
    return true;
  }

  /* ********************************************************** */
  // STRING | NUMBER | BOOLEAN | NULL | json
  public static boolean json_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_VALUE, "<json_value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, BOOLEAN);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = json(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(',' | ']' | '}' | '[' | '{')
  static boolean recover(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ',' | ']' | '}' | '[' | '{'
  private static boolean recover_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> METHOD (URL|varr) (varr|STRING|IDENTIFIER|COLON|NUMBER)* body? (varr|STRING|IDENTIFIER|COLON|NUMBER)*
  public static boolean request(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, REQUEST, "<request>");
    r = request_0(b, l + 1);
    r = r && consumeToken(b, METHOD);
    r = r && request_2(b, l + 1);
    p = r; // pin = 3
    r = r && report_error_(b, request_3(b, l + 1));
    r = p && report_error_(b, request_4(b, l + 1)) && r;
    r = p && request_5(b, l + 1) && r;
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

  // URL|varr
  private static boolean request_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_2")) return false;
    boolean r;
    r = consumeToken(b, URL);
    if (!r) r = varr(b, l + 1);
    return r;
  }

  // (varr|STRING|IDENTIFIER|COLON|NUMBER)*
  private static boolean request_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request_3_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_3", c)) break;
    }
    return true;
  }

  // varr|STRING|IDENTIFIER|COLON|NUMBER
  private static boolean request_3_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_3_0")) return false;
    boolean r;
    r = varr(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, NUMBER);
    return r;
  }

  // body?
  private static boolean request_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_4")) return false;
    body(b, l + 1);
    return true;
  }

  // (varr|STRING|IDENTIFIER|COLON|NUMBER)*
  private static boolean request_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request_5_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_5", c)) break;
    }
    return true;
  }

  // varr|STRING|IDENTIFIER|COLON|NUMBER
  private static boolean request_5_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_5_0")) return false;
    boolean r;
    r = varr(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, NUMBER);
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

  /* ********************************************************** */
  // LBRACE LBRACE IDENTIFIER RBRACE RBRACE
  public static boolean varr(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varr")) return false;
    if (!nextTokenIs(b, LBRACE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LBRACE, LBRACE, IDENTIFIER, RBRACE, RBRACE);
    exit_section_(b, m, VARR, r);
    return r;
  }

}
