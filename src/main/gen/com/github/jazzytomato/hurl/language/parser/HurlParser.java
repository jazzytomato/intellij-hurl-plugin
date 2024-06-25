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
    create_token_set_(DECODE_FILTER, FILTER, FORMAT_FILTER, JSONPATH_FILTER,
      NTH_FILTER, REGEX_FILTER, REPLACE_FILTER, SPLIT_FILTER,
      TODATE_FILTER, XPATH_FILTER),
    create_token_set_(BODY_QUERY, BYTES_QUERY, CERTIFICATE_QUERY, COOKIE_QUERY,
      DURATION_QUERY, HEADER_QUERY, JSONPATH_QUERY, MD_5_QUERY,
      QUERY, REGEX_QUERY, SHA_256_QUERY, STATUS_QUERY,
      URL_QUERY, VARIABLE_QUERY, XPATH_QUERY),
    create_token_set_(BOOLEAN_PREDICATE, COLLECTION_PREDICATE, CONTAIN_PREDICATE, DATE_PREDICATE,
      END_WITH_PREDICATE, EQUAL_PREDICATE, EXIST_PREDICATE, FLOAT_PREDICATE,
      GREATER_OR_EQUAL_PREDICATE, GREATER_PREDICATE, INCLUDE_PREDICATE, INTEGER_PREDICATE,
      ISO_DATE_PREDICATE, IS_EMPTY_PREDICATE, IS_NUMBER_PREDICATE, LESS_OR_EQUAL_PREDICATE,
      LESS_PREDICATE, MATCH_PREDICATE, NOT_EQUAL_PREDICATE, PREDICATE,
      REGEX_PREDICATE, START_WITH_PREDICATE, STRING_PREDICATE),
    create_token_set_(AWS_SIGV_4_OPTION, BOOLEAN_OPTION, CA_CERTIFICATE_OPTION, CLIENT_CERTIFICATE_OPTION,
      CLIENT_KEY_OPTION, COMPRESSED_OPTION, CONNECT_TO_OPTION, DELAY_OPTION,
      FOLLOW_REDIRECT_OPTION, FOLLOW_REDIRECT_TRUSTED_OPTION, HTTP_10_OPTION, HTTP_11_OPTION,
      HTTP_2_OPTION, HTTP_3_OPTION, INSECURE_OPTION, INTEGER_OPTION,
      IPV_4_OPTION, IPV_6_OPTION, MAX_REDIRS_OPTION, NETRC_FILE_OPTION,
      NETRC_OPTION, NETRC_OPTIONAL_OPTION, OPTION, OUTPUT_OPTION,
      PATH_AS_IS_OPTION, PROXY_OPTION, RESOLVE_OPTION, RETRY_INTERVAL_OPTION,
      RETRY_OPTION, SKIP_OPTION, UNIX_SOCKET_OPTION, USER_OPTION,
      VARIABLE_OPTION, VERBOSE_OPTION, VERY_VERBOSE_OPTION),
  };

  /* ********************************************************** */
  // NEW_LINE* query filter* predicate NEW_LINE
  public static boolean assert_$(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_$")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSERT, "<assert $>");
    r = assert_0(b, l + 1);
    r = r && query(b, l + 1);
    r = r && assert_2(b, l + 1);
    r = r && predicate(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean assert_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "assert_0", c)) break;
    }
    return true;
  }

  // filter*
  private static boolean assert_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "assert_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!filter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "assert_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NEW_LINE* '[Asserts]' NEW_LINE assert*
  public static boolean asserts_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asserts_section")) return false;
    if (!nextTokenIs(b, "<asserts section>", NEW_LINE, S_ASSERTS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ASSERTS_SECTION, "<asserts section>");
    r = asserts_section_0(b, l + 1);
    r = r && consumeTokens(b, 0, S_ASSERTS, NEW_LINE);
    r = r && asserts_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean asserts_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asserts_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "asserts_section_0", c)) break;
    }
    return true;
  }

  // assert*
  private static boolean asserts_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "asserts_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!assert_$(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "asserts_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'aws-sigv4:' value-string
  public static boolean aws_sigv4_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "aws_sigv4_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, AWS_SIGV_4_OPTION, "<aws sigv 4 option>");
    r = consumeToken(b, "aws-sigv4:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* '[BasicAuth]' NEW_LINE key-value*
  public static boolean basic_auth_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_auth_section")) return false;
    if (!nextTokenIs(b, "<basic auth section>", NEW_LINE, S_BASIC_AUTH)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BASIC_AUTH_SECTION, "<basic auth section>");
    r = basic_auth_section_0(b, l + 1);
    r = r && consumeTokens(b, 0, S_BASIC_AUTH, NEW_LINE);
    r = r && basic_auth_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean basic_auth_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_auth_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "basic_auth_section_0", c)) break;
    }
    return true;
  }

  // key-value*
  private static boolean basic_auth_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "basic_auth_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "basic_auth_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // NEW_LINE* (json | xml | STRING|multiline-json-string|multiline-xml-string|multiline-graphql-string|multiline-string|oneline-string|oneline-file|oneline-base64|oneline-hex|catchall) NEW_LINE
  public static boolean body(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY, "<body>");
    r = body_0(b, l + 1);
    r = r && body_1(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean body_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "body_0", c)) break;
    }
    return true;
  }

  // json | xml | STRING|multiline-json-string|multiline-xml-string|multiline-graphql-string|multiline-string|oneline-string|oneline-file|oneline-base64|oneline-hex|catchall
  private static boolean body_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_1")) return false;
    boolean r;
    r = json(b, l + 1);
    if (!r) r = xml(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = multiline_json_string(b, l + 1);
    if (!r) r = multiline_xml_string(b, l + 1);
    if (!r) r = multiline_graphql_string(b, l + 1);
    if (!r) r = multiline_string(b, l + 1);
    if (!r) r = oneline_string(b, l + 1);
    if (!r) r = oneline_file(b, l + 1);
    if (!r) r = oneline_base64(b, l + 1);
    if (!r) r = oneline_hex(b, l + 1);
    if (!r) r = catchall(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'body'
  public static boolean body_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "body_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BODY_QUERY, "<body query>");
    r = consumeToken(b, "body");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ('true'|'false') | TEMPLATE
  public static boolean boolean_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_OPTION, "<boolean option>");
    r = boolean_option_0(b, l + 1);
    if (!r) r = consumeToken(b, TEMPLATE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'true'|'false'
  private static boolean boolean_option_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_option_0")) return false;
    boolean r;
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    return r;
  }

  /* ********************************************************** */
  // 'isBoolean'
  public static boolean boolean_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "boolean_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BOOLEAN_PREDICATE, "<boolean predicate>");
    r = consumeToken(b, "isBoolean");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'bytes'
  public static boolean bytes_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "bytes_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BYTES_QUERY, "<bytes query>");
    r = consumeToken(b, "bytes");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'cacert:' filename
  public static boolean ca_certificate_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ca_certificate_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CA_CERTIFICATE_OPTION, "<ca certificate option>");
    r = consumeToken(b, "cacert:");
    r = r && filename(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* key-string ':' query filter* NEW_LINE
  public static boolean capture(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CAPTURE, "<capture>");
    r = capture_0(b, l + 1);
    r = r && key_string(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && query(b, l + 1);
    r = r && capture_4(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean capture_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "capture_0", c)) break;
    }
    return true;
  }

  // filter*
  private static boolean capture_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!filter(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "capture_4", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '[Captures]' NEW_LINE capture*
  public static boolean capture_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_section")) return false;
    if (!nextTokenIs(b, S_CAPTURES)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, S_CAPTURES, NEW_LINE);
    r = r && capture_section_2(b, l + 1);
    exit_section_(b, m, CAPTURE_SECTION, r);
    return r;
  }

  // capture*
  private static boolean capture_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "capture_section_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!capture(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "capture_section_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '/' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '<' | '<=' | '>=' | '`' | '~' | '^' | '|' | '+' | NULL| ALPHANUM |IDENTIFIER|NUMBER | JSON_ID | STRING | ANY
  static boolean catchall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "catchall")) return false;
    boolean r;
    r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LPAR);
    if (!r) r = consumeToken(b, RPAR);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, LESS_OR_EQUAL);
    if (!r) r = consumeToken(b, GREATER_OR_EQUAL);
    if (!r) r = consumeToken(b, BACKQUOTE);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, JSON_ID);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, ANY);
    return r;
  }

  /* ********************************************************** */
  // 'certificate' ('Subject'|'Issuer'|'Start-Date'|'Expire-Date'|'Serial-Number')
  public static boolean certificate_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "certificate_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CERTIFICATE_QUERY, "<certificate query>");
    r = consumeToken(b, "certificate");
    r = r && certificate_query_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'Subject'|'Issuer'|'Start-Date'|'Expire-Date'|'Serial-Number'
  private static boolean certificate_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "certificate_query_1")) return false;
    boolean r;
    r = consumeToken(b, "Subject");
    if (!r) r = consumeToken(b, "Issuer");
    if (!r) r = consumeToken(b, "Start-Date");
    if (!r) r = consumeToken(b, "Expire-Date");
    if (!r) r = consumeToken(b, "Serial-Number");
    return r;
  }

  /* ********************************************************** */
  // 'cert:' filename
  public static boolean client_certificate_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "client_certificate_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLIENT_CERTIFICATE_OPTION, "<client certificate option>");
    r = consumeToken(b, "cert:");
    r = r && filename(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'key:' value-string
  public static boolean client_key_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "client_key_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CLIENT_KEY_OPTION, "<client key option>");
    r = consumeToken(b, "key:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isCollection'
  public static boolean collection_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "collection_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COLLECTION_PREDICATE, "<collection predicate>");
    r = consumeToken(b, "isCollection");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'compressed:' boolean-option
  public static boolean compressed_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "compressed_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COMPRESSED_OPTION, "<compressed option>");
    r = consumeToken(b, "compressed:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'connect-to:' value-string
  public static boolean connect_to_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "connect_to_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONNECT_TO_OPTION, "<connect to option>");
    r = consumeToken(b, "connect-to:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'contains' (STRING|oneline-hex|oneline-base64)
  public static boolean contain_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contain_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CONTAIN_PREDICATE, "<contain predicate>");
    r = consumeToken(b, "contains");
    r = r && contain_predicate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING|oneline-hex|oneline-base64
  private static boolean contain_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "contain_predicate_1")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = oneline_hex(b, l + 1);
    if (!r) r = oneline_base64(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'cookie' STRING
  public static boolean cookie_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookie_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COOKIE_QUERY, "<cookie query>");
    r = consumeToken(b, "cookie");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* '[Cookies]' NEW_LINE key-value*
  public static boolean cookies_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookies_section")) return false;
    if (!nextTokenIs(b, "<cookies section>", NEW_LINE, S_COOKIES)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, COOKIES_SECTION, "<cookies section>");
    r = cookies_section_0(b, l + 1);
    r = r && consumeTokens(b, 0, S_COOKIES, NEW_LINE);
    r = r && cookies_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean cookies_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookies_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "cookies_section_0", c)) break;
    }
    return true;
  }

  // key-value*
  private static boolean cookies_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "cookies_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "cookies_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'isDate'
  public static boolean date_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "date_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DATE_PREDICATE, "<date predicate>");
    r = consumeToken(b, "isDate");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'decode' STRING
  public static boolean decode_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "decode_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DECODE_FILTER, "<decode filter>");
    r = consumeToken(b, "decode");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'delay:' integer-option
  public static boolean delay_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "delay_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DELAY_OPTION, "<delay option>");
    r = consumeToken(b, "delay:");
    r = r && integer_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'duration'
  public static boolean duration_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "duration_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, DURATION_QUERY, "<duration query>");
    r = consumeToken(b, "duration");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'endsWith' (STRING|oneline-hex|oneline-base64)
  public static boolean end_with_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_with_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, END_WITH_PREDICATE, "<end with predicate>");
    r = consumeToken(b, "endsWith");
    r = r && end_with_predicate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING|oneline-hex|oneline-base64
  private static boolean end_with_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "end_with_predicate_1")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = oneline_hex(b, l + 1);
    if (!r) r = oneline_base64(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // request response?
  public static boolean entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ENTRY, "<entry>");
    r = request(b, l + 1);
    r = r && entry_1(b, l + 1);
    exit_section_(b, l, m, r, false, HurlParser::recover_entry);
    return r;
  }

  // response?
  private static boolean entry_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "entry_1")) return false;
    response(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '==' predicate-value
  public static boolean equal_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "equal_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EQUAL_PREDICATE, "<equal predicate>");
    r = consumeToken(b, "==");
    r = r && predicate_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'exists'
  public static boolean exist_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exist_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXIST_PREDICATE, "<exist predicate>");
    r = consumeToken(b, "exists");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ALPHANUM | IDENTIFIER | '/' | '-' | '+')+
  public static boolean file_contenttype(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_contenttype")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILE_CONTENTTYPE, "<file contenttype>");
    r = file_contenttype_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!file_contenttype_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "file_contenttype", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ALPHANUM | IDENTIFIER | '/' | '-' | '+'
  private static boolean file_contenttype_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_contenttype_0")) return false;
    boolean r;
    r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, PLUS);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* key-string ':' file-value NEW_LINE
  public static boolean file_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILE_PARAM, "<file param>");
    r = file_param_0(b, l + 1);
    r = r && key_string(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && file_value(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean file_param_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_param_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "file_param_0", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'file,' filename ';' file-contenttype?
  public static boolean file_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILE_VALUE, "<file value>");
    r = consumeToken(b, "file,");
    r = r && filename(b, l + 1);
    r = r && consumeToken(b, SEMI);
    r = r && file_value_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // file-contenttype?
  private static boolean file_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "file_value_3")) return false;
    file_contenttype(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (TEMPLATE|ANY|ALPHANUM|IDENTIFIER|STRING|NULL|NUMBER|'.'|'_'|'/'|'\'|',')+
  public static boolean filename(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FILENAME, "<filename>");
    r = filename_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!filename_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "filename", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // TEMPLATE|ANY|ALPHANUM|IDENTIFIER|STRING|NULL|NUMBER|'.'|'_'|'/'|'\'|','
  private static boolean filename_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filename_0")) return false;
    boolean r;
    r = consumeToken(b, TEMPLATE);
    if (!r) r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, COMMA);
    return r;
  }

  /* ********************************************************** */
  // 'count' | 'daysAfterNow' | 'daysBeforeNow' | 'htmlEscape' | 'htmlUnescape' | 'toInt' | 'urlDecode' | 'urlEncode' | decode-filter | jsonpath-filter | nth-filter | regex-filter | replace-filter | split-filter | xpath-filter | format-filter | todate-filter
  public static boolean filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, FILTER, "<filter>");
    r = consumeToken(b, "count");
    if (!r) r = consumeToken(b, "daysAfterNow");
    if (!r) r = consumeToken(b, "daysBeforeNow");
    if (!r) r = consumeToken(b, "htmlEscape");
    if (!r) r = consumeToken(b, "htmlUnescape");
    if (!r) r = consumeToken(b, "toInt");
    if (!r) r = consumeToken(b, "urlDecode");
    if (!r) r = consumeToken(b, "urlEncode");
    if (!r) r = decode_filter(b, l + 1);
    if (!r) r = jsonpath_filter(b, l + 1);
    if (!r) r = nth_filter(b, l + 1);
    if (!r) r = regex_filter(b, l + 1);
    if (!r) r = replace_filter(b, l + 1);
    if (!r) r = split_filter(b, l + 1);
    if (!r) r = xpath_filter(b, l + 1);
    if (!r) r = format_filter(b, l + 1);
    if (!r) r = todate_filter(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isFloat'
  public static boolean float_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "float_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FLOAT_PREDICATE, "<float predicate>");
    r = consumeToken(b, "isFloat");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'location:' boolean-option
  public static boolean follow_redirect_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "follow_redirect_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOLLOW_REDIRECT_OPTION, "<follow redirect option>");
    r = consumeToken(b, "location:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'location-trusted:' boolean-option
  public static boolean follow_redirect_trusted_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "follow_redirect_trusted_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FOLLOW_REDIRECT_TRUSTED_OPTION, "<follow redirect trusted option>");
    r = consumeToken(b, "location-trusted:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* '[FormParams]' NEW_LINE key-value*
  public static boolean form_params_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_params_section")) return false;
    if (!nextTokenIs(b, "<form params section>", NEW_LINE, S_FORM_PARAMS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FORM_PARAMS_SECTION, "<form params section>");
    r = form_params_section_0(b, l + 1);
    r = r && consumeTokens(b, 0, S_FORM_PARAMS, NEW_LINE);
    r = r && form_params_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean form_params_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_params_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "form_params_section_0", c)) break;
    }
    return true;
  }

  // key-value*
  private static boolean form_params_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "form_params_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "form_params_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'format' STRING
  public static boolean format_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "format_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FORMAT_FILTER, "<format filter>");
    r = consumeToken(b, "format");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '>=' predicate-value
  public static boolean greater_or_equal_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "greater_or_equal_predicate")) return false;
    if (!nextTokenIs(b, GREATER_OR_EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GREATER_OR_EQUAL);
    r = r && predicate_value(b, l + 1);
    exit_section_(b, m, GREATER_OR_EQUAL_PREDICATE, r);
    return r;
  }

  /* ********************************************************** */
  // '>' predicate-value
  public static boolean greater_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "greater_predicate")) return false;
    if (!nextTokenIs(b, GREATER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, GREATER);
    r = r && predicate_value(b, l + 1);
    exit_section_(b, m, GREATER_PREDICATE, r);
    return r;
  }

  /* ********************************************************** */
  // key-value
  public static boolean header(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER, "<header>");
    r = key_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'header' STRING
  public static boolean header_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "header_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HEADER_QUERY, "<header query>");
    r = consumeToken(b, "header");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | '*'
  public static boolean http_status(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http_status")) return false;
    if (!nextTokenIs(b, "<http status>", NUMBER, STAR)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTTP_STATUS, "<http status>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STAR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'http1.0:' boolean-option
  public static boolean http10_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http10_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTTP_10_OPTION, "<http 10 option>");
    r = consumeToken(b, "http1.0:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'http1.1:' boolean-option
  public static boolean http11_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http11_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTTP_11_OPTION, "<http 11 option>");
    r = consumeToken(b, "http1.1:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'http2:' boolean-option
  public static boolean http2_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http2_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTTP_2_OPTION, "<http 2 option>");
    r = consumeToken(b, "http2:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'http3:' boolean-option
  public static boolean http3_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "http3_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, HTTP_3_OPTION, "<http 3 option>");
    r = consumeToken(b, "http3:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !<<eof>> entry* NEW_LINE*
  static boolean hurlFile(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = hurlFile_0(b, l + 1);
    r = r && hurlFile_1(b, l + 1);
    r = r && hurlFile_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // !<<eof>>
  private static boolean hurlFile_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile_0")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !eof(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // entry*
  private static boolean hurlFile_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!entry(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "hurlFile_1", c)) break;
    }
    return true;
  }

  // NEW_LINE*
  private static boolean hurlFile_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "hurlFile_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "hurlFile_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'includes' predicate-value
  public static boolean include_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "include_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INCLUDE_PREDICATE, "<include predicate>");
    r = consumeToken(b, "includes");
    r = r && predicate_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'insecure:' boolean-option
  public static boolean insecure_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "insecure_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INSECURE_OPTION, "<insecure option>");
    r = consumeToken(b, "insecure:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NUMBER | TEMPLATE
  public static boolean integer_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_option")) return false;
    if (!nextTokenIs(b, "<integer option>", NUMBER, TEMPLATE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_OPTION, "<integer option>");
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, TEMPLATE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isInteger'
  public static boolean integer_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "integer_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, INTEGER_PREDICATE, "<integer predicate>");
    r = consumeToken(b, "isInteger");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'ipv4:' boolean-option
  public static boolean ipv4_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ipv4_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IPV_4_OPTION, "<ipv 4 option>");
    r = consumeToken(b, "ipv4:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'ipv6:' boolean-option
  public static boolean ipv6_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "ipv6_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IPV_6_OPTION, "<ipv 6 option>");
    r = consumeToken(b, "ipv6:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isEmpty'
  public static boolean is_empty_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "is_empty_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IS_EMPTY_PREDICATE, "<is empty predicate>");
    r = consumeToken(b, "isEmpty");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isNumber'
  public static boolean is_number_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "is_number_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, IS_NUMBER_PREDICATE, "<is number predicate>");
    r = consumeToken(b, "isNumber");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isIsoDate'
  public static boolean iso_date_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "iso_date_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ISO_DATE_PREDICATE, "<iso date predicate>");
    r = consumeToken(b, "isIsoDate");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // json_array | json_object
  public static boolean json(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json")) return false;
    if (!nextTokenIs(b, "<json>", LBRACE, LBRACKET)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON, "<json>");
    r = json_array(b, l + 1);
    if (!r) r = json_object(b, l + 1);
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
    exit_section_(b, l, m, r, false, HurlParser::recover_json);
    return r;
  }

  /* ********************************************************** */
  // JSON_ID | STRING ':'
  public static boolean json_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_name")) return false;
    if (!nextTokenIs(b, "<json_name>", JSON_ID, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_NAME, "<json_name>");
    r = consumeToken(b, JSON_ID);
    if (!r) r = parseTokens(b, 0, STRING, COLON);
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
  // [] json_name json_value  NEW_LINE*
  public static boolean json_prop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_prop")) return false;
    boolean r, p;
    Marker m = enter_section_(b, l, _NONE_, JSON_PROP, "<json prop>");
    r = json_prop_0(b, l + 1);
    p = r; // pin = 1
    r = r && report_error_(b, json_name(b, l + 1));
    r = p && report_error_(b, json_value(b, l + 1)) && r;
    r = p && json_prop_3(b, l + 1) && r;
    exit_section_(b, l, m, r, p, HurlParser::recover_json);
    return r || p;
  }

  // []
  private static boolean json_prop_0(PsiBuilder b, int l) {
    return true;
  }

  // NEW_LINE*
  private static boolean json_prop_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_prop_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "json_prop_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING | TEMPLATE | NUMBER | ('true'|'false') | NULL | json
  public static boolean json_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSON_VALUE, "<json value>");
    r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, TEMPLATE);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = json_value_3(b, l + 1);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = json(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'true'|'false'
  private static boolean json_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "json_value_3")) return false;
    boolean r;
    r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean jsonpath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsonpath")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, JSONPATH, r);
    return r;
  }

  /* ********************************************************** */
  // 'jsonpath' jsonpath
  public static boolean jsonpath_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsonpath_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSONPATH_FILTER, "<jsonpath filter>");
    r = consumeToken(b, "jsonpath");
    r = r && jsonpath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'jsonpath' jsonpath
  public static boolean jsonpath_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "jsonpath_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, JSONPATH_QUERY, "<jsonpath query>");
    r = consumeToken(b, "jsonpath");
    r = r && jsonpath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (ALPHANUM|IDENTIFIER|NUMBER|NULL|'_'|'-'|'.'|'['|']'|'@'|'$'|'\'|'{'|'}'|TEMPLATE)+
  public static boolean key_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_STRING, "<key>");
    r = key_string_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!key_string_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "key_string", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ALPHANUM|IDENTIFIER|NUMBER|NULL|'_'|'-'|'.'|'['|']'|'@'|'$'|'\'|'{'|'}'|TEMPLATE
  private static boolean key_string_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_string_0")) return false;
    boolean r;
    r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, TEMPLATE);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* key-string ':' value-string? NEW_LINE
  public static boolean key_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, KEY_VALUE, "<key value>");
    r = key_value_0(b, l + 1);
    r = r && key_string(b, l + 1);
    r = r && consumeToken(b, COLON);
    r = r && key_value_3(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean key_value_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "key_value_0", c)) break;
    }
    return true;
  }

  // value-string?
  private static boolean key_value_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "key_value_3")) return false;
    value_string(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '<=' predicate-value
  public static boolean less_or_equal_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "less_or_equal_predicate")) return false;
    if (!nextTokenIs(b, LESS_OR_EQUAL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS_OR_EQUAL);
    r = r && predicate_value(b, l + 1);
    exit_section_(b, m, LESS_OR_EQUAL_PREDICATE, r);
    return r;
  }

  /* ********************************************************** */
  // '<' predicate-value
  public static boolean less_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "less_predicate")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && predicate_value(b, l + 1);
    exit_section_(b, m, LESS_PREDICATE, r);
    return r;
  }

  /* ********************************************************** */
  // 'matches' (regex-string | regex)
  public static boolean match_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MATCH_PREDICATE, "<match predicate>");
    r = consumeToken(b, "matches");
    r = r && match_predicate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // regex-string | regex
  private static boolean match_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "match_predicate_1")) return false;
    boolean r;
    r = regex_string(b, l + 1);
    if (!r) r = regex(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'max-redirs:' integer-option
  public static boolean max_redirs_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "max_redirs_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MAX_REDIRS_OPTION, "<max redirs option>");
    r = consumeToken(b, "max-redirs:");
    r = r && integer_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'md5'
  public static boolean md5_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "md5_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MD_5_QUERY, "<md 5 query>");
    r = consumeToken(b, "md5");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '```graphql' (TEMPLATE|catchall|NEW_LINE)* '```'
  public static boolean multiline_graphql_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_graphql_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTILINE_GRAPHQL_STRING, "<multiline graphql string>");
    r = consumeToken(b, "```graphql");
    r = r && multiline_graphql_string_1(b, l + 1);
    r = r && consumeToken(b, BACKQUOTE_3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (TEMPLATE|catchall|NEW_LINE)*
  private static boolean multiline_graphql_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_graphql_string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiline_graphql_string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiline_graphql_string_1", c)) break;
    }
    return true;
  }

  // TEMPLATE|catchall|NEW_LINE
  private static boolean multiline_graphql_string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_graphql_string_1_0")) return false;
    boolean r;
    r = consumeToken(b, TEMPLATE);
    if (!r) r = catchall(b, l + 1);
    if (!r) r = consumeToken(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // '```json' NEW_LINE* json NEW_LINE* '```'
  public static boolean multiline_json_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_json_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTILINE_JSON_STRING, "<multiline json string>");
    r = consumeToken(b, "```json");
    r = r && multiline_json_string_1(b, l + 1);
    r = r && json(b, l + 1);
    r = r && multiline_json_string_3(b, l + 1);
    r = r && consumeToken(b, BACKQUOTE_3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean multiline_json_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_json_string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "multiline_json_string_1", c)) break;
    }
    return true;
  }

  // NEW_LINE*
  private static boolean multiline_json_string_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_json_string_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "multiline_json_string_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '```' (TEMPLATE|catchall|NEW_LINE)* '```'
  public static boolean multiline_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_string")) return false;
    if (!nextTokenIs(b, BACKQUOTE_3)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BACKQUOTE_3);
    r = r && multiline_string_1(b, l + 1);
    r = r && consumeToken(b, BACKQUOTE_3);
    exit_section_(b, m, MULTILINE_STRING, r);
    return r;
  }

  // (TEMPLATE|catchall|NEW_LINE)*
  private static boolean multiline_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multiline_string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multiline_string_1", c)) break;
    }
    return true;
  }

  // TEMPLATE|catchall|NEW_LINE
  private static boolean multiline_string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_string_1_0")) return false;
    boolean r;
    r = consumeToken(b, TEMPLATE);
    if (!r) r = catchall(b, l + 1);
    if (!r) r = consumeToken(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // '```xml' NEW_LINE* xml NEW_LINE* '```'
  public static boolean multiline_xml_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_xml_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTILINE_XML_STRING, "<multiline xml string>");
    r = consumeToken(b, "```xml");
    r = r && multiline_xml_string_1(b, l + 1);
    r = r && xml(b, l + 1);
    r = r && multiline_xml_string_3(b, l + 1);
    r = r && consumeToken(b, BACKQUOTE_3);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean multiline_xml_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_xml_string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "multiline_xml_string_1", c)) break;
    }
    return true;
  }

  // NEW_LINE*
  private static boolean multiline_xml_string_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multiline_xml_string_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "multiline_xml_string_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // key-value | file-param
  public static boolean multipart_form_data_param(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_param")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPART_FORM_DATA_PARAM, "<multipart form data param>");
    r = key_value(b, l + 1);
    if (!r) r = file_param(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* '[MultipartFormData]' NEW_LINE+ multipart-form-data-param*
  public static boolean multipart_form_data_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section")) return false;
    if (!nextTokenIs(b, "<multipart form data section>", NEW_LINE, S_MULTIPART_FORM_DATA)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, MULTIPART_FORM_DATA_SECTION, "<multipart form data section>");
    r = multipart_form_data_section_0(b, l + 1);
    r = r && consumeToken(b, S_MULTIPART_FORM_DATA);
    r = r && multipart_form_data_section_2(b, l + 1);
    r = r && multipart_form_data_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean multipart_form_data_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "multipart_form_data_section_0", c)) break;
    }
    return true;
  }

  // NEW_LINE+
  private static boolean multipart_form_data_section_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NEW_LINE);
    while (r) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "multipart_form_data_section_2", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // multipart-form-data-param*
  private static boolean multipart_form_data_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "multipart_form_data_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!multipart_form_data_param(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "multipart_form_data_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'netrc-file:' value-string
  public static boolean netrc_file_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "netrc_file_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NETRC_FILE_OPTION, "<netrc file option>");
    r = consumeToken(b, "netrc-file:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'netrc:' boolean-option
  public static boolean netrc_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "netrc_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NETRC_OPTION, "<netrc option>");
    r = consumeToken(b, "netrc:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'netrc-optional:' boolean-option
  public static boolean netrc_optional_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "netrc_optional_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NETRC_OPTIONAL_OPTION, "<netrc optional option>");
    r = consumeToken(b, "netrc-optional:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '!=' predicate-value
  public static boolean not_equal_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "not_equal_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NOT_EQUAL_PREDICATE, "<not equal predicate>");
    r = consumeToken(b, "!=");
    r = r && predicate_value(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'nth' NUMBER
  public static boolean nth_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nth_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NTH_FILTER, "<nth filter>");
    r = consumeToken(b, "nth");
    r = r && consumeToken(b, NUMBER);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'base64,' (ALPHANUM|IDENTIFIER|'+'|'-'|'='|'==')* ';'
  public static boolean oneline_base64(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_base64")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ONELINE_BASE_64, "<oneline base 64>");
    r = consumeToken(b, "base64,");
    r = r && oneline_base64_1(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ALPHANUM|IDENTIFIER|'+'|'-'|'='|'==')*
  private static boolean oneline_base64_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_base64_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!oneline_base64_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "oneline_base64_1", c)) break;
    }
    return true;
  }

  // ALPHANUM|IDENTIFIER|'+'|'-'|'='|'=='
  private static boolean oneline_base64_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_base64_1_0")) return false;
    boolean r;
    r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, "==");
    return r;
  }

  /* ********************************************************** */
  // 'file,' filename ';'
  public static boolean oneline_file(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_file")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ONELINE_FILE, "<oneline file>");
    r = consumeToken(b, "file,");
    r = r && filename(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'hex,' (NUMBER|ALPHANUM)* ';'
  public static boolean oneline_hex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_hex")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ONELINE_HEX, "<oneline hex>");
    r = consumeToken(b, "hex,");
    r = r && oneline_hex_1(b, l + 1);
    r = r && consumeToken(b, SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (NUMBER|ALPHANUM)*
  private static boolean oneline_hex_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_hex_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!oneline_hex_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "oneline_hex_1", c)) break;
    }
    return true;
  }

  // NUMBER|ALPHANUM
  private static boolean oneline_hex_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_hex_1_0")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ALPHANUM);
    return r;
  }

  /* ********************************************************** */
  // '`' (xml | '[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '/' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '<' | '\`' | '~' | '^' | '|' | '+' | NULL | ALPHANUM |NUMBER | TEMPLATE | METHOD | ANY)* '`'
  public static boolean oneline_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_string")) return false;
    if (!nextTokenIs(b, BACKQUOTE)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, BACKQUOTE);
    r = r && oneline_string_1(b, l + 1);
    r = r && consumeToken(b, BACKQUOTE);
    exit_section_(b, m, ONELINE_STRING, r);
    return r;
  }

  // (xml | '[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '/' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '<' | '\`' | '~' | '^' | '|' | '+' | NULL | ALPHANUM |NUMBER | TEMPLATE | METHOD | ANY)*
  private static boolean oneline_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_string_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!oneline_string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "oneline_string_1", c)) break;
    }
    return true;
  }

  // xml | '[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '/' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '<' | '\`' | '~' | '^' | '|' | '+' | NULL | ALPHANUM |NUMBER | TEMPLATE | METHOD | ANY
  private static boolean oneline_string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "oneline_string_1_0")) return false;
    boolean r;
    r = xml(b, l + 1);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LPAR);
    if (!r) r = consumeToken(b, RPAR);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, "\\`");
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, TEMPLATE);
    if (!r) r = consumeToken(b, METHOD);
    if (!r) r = consumeToken(b, ANY);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* (aws-sigv4-option|ca-certificate-option|client-certificate-option|client-key-option|compressed-option|connect-to-option|delay-option|follow-redirect-option|follow-redirect-trusted-option|http10-option|http11-option|http2-option|http3-option|insecure-option|ipv4-option|ipv6-option|max-redirs-option|netrc-option|netrc-file-option|netrc-optional-option|output-option|path-as-is-option|proxy-option|resolve-option|retry-option|retry-interval-option|skip-option|unix-socket-option|user-option|variable-option|verbose-option|very-verbose-option)
  public static boolean option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, OPTION, "<option>");
    r = option_0(b, l + 1);
    r = r && option_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean option_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "option_0", c)) break;
    }
    return true;
  }

  // aws-sigv4-option|ca-certificate-option|client-certificate-option|client-key-option|compressed-option|connect-to-option|delay-option|follow-redirect-option|follow-redirect-trusted-option|http10-option|http11-option|http2-option|http3-option|insecure-option|ipv4-option|ipv6-option|max-redirs-option|netrc-option|netrc-file-option|netrc-optional-option|output-option|path-as-is-option|proxy-option|resolve-option|retry-option|retry-interval-option|skip-option|unix-socket-option|user-option|variable-option|verbose-option|very-verbose-option
  private static boolean option_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "option_1")) return false;
    boolean r;
    r = aws_sigv4_option(b, l + 1);
    if (!r) r = ca_certificate_option(b, l + 1);
    if (!r) r = client_certificate_option(b, l + 1);
    if (!r) r = client_key_option(b, l + 1);
    if (!r) r = compressed_option(b, l + 1);
    if (!r) r = connect_to_option(b, l + 1);
    if (!r) r = delay_option(b, l + 1);
    if (!r) r = follow_redirect_option(b, l + 1);
    if (!r) r = follow_redirect_trusted_option(b, l + 1);
    if (!r) r = http10_option(b, l + 1);
    if (!r) r = http11_option(b, l + 1);
    if (!r) r = http2_option(b, l + 1);
    if (!r) r = http3_option(b, l + 1);
    if (!r) r = insecure_option(b, l + 1);
    if (!r) r = ipv4_option(b, l + 1);
    if (!r) r = ipv6_option(b, l + 1);
    if (!r) r = max_redirs_option(b, l + 1);
    if (!r) r = netrc_option(b, l + 1);
    if (!r) r = netrc_file_option(b, l + 1);
    if (!r) r = netrc_optional_option(b, l + 1);
    if (!r) r = output_option(b, l + 1);
    if (!r) r = path_as_is_option(b, l + 1);
    if (!r) r = proxy_option(b, l + 1);
    if (!r) r = resolve_option(b, l + 1);
    if (!r) r = retry_option(b, l + 1);
    if (!r) r = retry_interval_option(b, l + 1);
    if (!r) r = skip_option(b, l + 1);
    if (!r) r = unix_socket_option(b, l + 1);
    if (!r) r = user_option(b, l + 1);
    if (!r) r = variable_option(b, l + 1);
    if (!r) r = verbose_option(b, l + 1);
    if (!r) r = very_verbose_option(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* '[Options]' NEW_LINE option*
  public static boolean options_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "options_section")) return false;
    if (!nextTokenIs(b, "<options section>", NEW_LINE, S_OPTIONS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OPTIONS_SECTION, "<options section>");
    r = options_section_0(b, l + 1);
    r = r && consumeTokens(b, 0, S_OPTIONS, NEW_LINE);
    r = r && options_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean options_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "options_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "options_section_0", c)) break;
    }
    return true;
  }

  // option*
  private static boolean options_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "options_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!option(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "options_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // 'output:' value-string
  public static boolean output_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "output_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, OUTPUT_OPTION, "<output option>");
    r = consumeToken(b, "output:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'path-as-is:' boolean-option
  public static boolean path_as_is_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "path_as_is_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PATH_AS_IS_OPTION, "<path as is option>");
    r = consumeToken(b, "path-as-is:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'not'? (equal-predicate|not-equal-predicate|greater-predicate|greater-or-equal-predicate|less-predicate|less-or-equal-predicate|start-with-predicate|end-with-predicate|contain-predicate|match-predicate|regex-predicate|exist-predicate|is-empty-predicate|include-predicate|integer-predicate|float-predicate|boolean-predicate|string-predicate|collection-predicate|date-predicate|iso-date-predicate|is-number-predicate)
  public static boolean predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, PREDICATE, "<predicate>");
    r = predicate_0(b, l + 1);
    r = r && predicate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'not'?
  private static boolean predicate_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_0")) return false;
    consumeToken(b, "not");
    return true;
  }

  // equal-predicate|not-equal-predicate|greater-predicate|greater-or-equal-predicate|less-predicate|less-or-equal-predicate|start-with-predicate|end-with-predicate|contain-predicate|match-predicate|regex-predicate|exist-predicate|is-empty-predicate|include-predicate|integer-predicate|float-predicate|boolean-predicate|string-predicate|collection-predicate|date-predicate|iso-date-predicate|is-number-predicate
  private static boolean predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_1")) return false;
    boolean r;
    r = equal_predicate(b, l + 1);
    if (!r) r = not_equal_predicate(b, l + 1);
    if (!r) r = greater_predicate(b, l + 1);
    if (!r) r = greater_or_equal_predicate(b, l + 1);
    if (!r) r = less_predicate(b, l + 1);
    if (!r) r = less_or_equal_predicate(b, l + 1);
    if (!r) r = start_with_predicate(b, l + 1);
    if (!r) r = end_with_predicate(b, l + 1);
    if (!r) r = contain_predicate(b, l + 1);
    if (!r) r = match_predicate(b, l + 1);
    if (!r) r = regex_predicate(b, l + 1);
    if (!r) r = exist_predicate(b, l + 1);
    if (!r) r = is_empty_predicate(b, l + 1);
    if (!r) r = include_predicate(b, l + 1);
    if (!r) r = integer_predicate(b, l + 1);
    if (!r) r = float_predicate(b, l + 1);
    if (!r) r = boolean_predicate(b, l + 1);
    if (!r) r = string_predicate(b, l + 1);
    if (!r) r = collection_predicate(b, l + 1);
    if (!r) r = date_predicate(b, l + 1);
    if (!r) r = iso_date_predicate(b, l + 1);
    if (!r) r = is_number_predicate(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // oneline-base64|oneline-file|oneline-hex|TEMPLATE|multiline-json-string|multiline-xml-string|multiline-graphql-string|multiline-string|catchall
  public static boolean predicate_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "predicate_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREDICATE_VALUE, "<predicate value>");
    r = oneline_base64(b, l + 1);
    if (!r) r = oneline_file(b, l + 1);
    if (!r) r = oneline_hex(b, l + 1);
    if (!r) r = consumeToken(b, TEMPLATE);
    if (!r) r = multiline_json_string(b, l + 1);
    if (!r) r = multiline_xml_string(b, l + 1);
    if (!r) r = multiline_graphql_string(b, l + 1);
    if (!r) r = multiline_string(b, l + 1);
    if (!r) r = catchall(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'proxy:' value-string
  public static boolean proxy_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "proxy_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PROXY_OPTION, "<proxy option>");
    r = consumeToken(b, "proxy:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // status-query | url-query | header-query | certificate-query | cookie-query | body-query | xpath-query | jsonpath-query | regex-query | variable-query | duration-query | bytes-query | sha256-query | md5-query
  public static boolean query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, QUERY, "<query>");
    r = status_query(b, l + 1);
    if (!r) r = url_query(b, l + 1);
    if (!r) r = header_query(b, l + 1);
    if (!r) r = certificate_query(b, l + 1);
    if (!r) r = cookie_query(b, l + 1);
    if (!r) r = body_query(b, l + 1);
    if (!r) r = xpath_query(b, l + 1);
    if (!r) r = jsonpath_query(b, l + 1);
    if (!r) r = regex_query(b, l + 1);
    if (!r) r = variable_query(b, l + 1);
    if (!r) r = duration_query(b, l + 1);
    if (!r) r = bytes_query(b, l + 1);
    if (!r) r = sha256_query(b, l + 1);
    if (!r) r = md5_query(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* '[QueryStringParams]' NEW_LINE key-value*
  public static boolean query_string_params_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_string_params_section")) return false;
    if (!nextTokenIs(b, "<query string params section>", NEW_LINE, S_QUERY_STRING_PARAMS)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, QUERY_STRING_PARAMS_SECTION, "<query string params section>");
    r = query_string_params_section_0(b, l + 1);
    r = r && consumeTokens(b, 0, S_QUERY_STRING_PARAMS, NEW_LINE);
    r = r && query_string_params_section_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean query_string_params_section_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_string_params_section_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "query_string_params_section_0", c)) break;
    }
    return true;
  }

  // key-value*
  private static boolean query_string_params_section_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "query_string_params_section_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!key_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "query_string_params_section_3", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // !request
  static boolean recover_entry(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_entry")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !request(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // !(',' | ']' | '}' | '[' | '{')
  static boolean recover_json(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_json")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NOT_);
    r = !recover_json_0(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ',' | ']' | '}' | '[' | '{'
  private static boolean recover_json_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "recover_json_0")) return false;
    boolean r;
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    return r;
  }

  /* ********************************************************** */
  // '/' regex-content '/'
  public static boolean regex(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex")) return false;
    if (!nextTokenIs(b, SLASH)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, SLASH);
    r = r && regex_content(b, l + 1);
    r = r && consumeToken(b, SLASH);
    exit_section_(b, m, REGEX, r);
    return r;
  }

  /* ********************************************************** */
  // ('[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '<' | '`' | '~' | '^' | '|' | '+' | ALPHANUM | IDENTIFIER | NUMBER | JSON_ID | ANY | '\/' )+
  public static boolean regex_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_content")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REGEX_CONTENT, "<regex content>");
    r = regex_content_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!regex_content_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "regex_content", c)) break;
    }
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '<' | '`' | '~' | '^' | '|' | '+' | ALPHANUM | IDENTIFIER | NUMBER | JSON_ID | ANY | '\/'
  private static boolean regex_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_content_0")) return false;
    boolean r;
    r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LPAR);
    if (!r) r = consumeToken(b, RPAR);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, LESS);
    if (!r) r = consumeToken(b, BACKQUOTE);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, JSON_ID);
    if (!r) r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, "\\/");
    return r;
  }

  /* ********************************************************** */
  // 'regex' (regex-string | regex)
  public static boolean regex_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REGEX_FILTER, "<regex filter>");
    r = consumeToken(b, "regex");
    r = r && regex_filter_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // regex-string | regex
  private static boolean regex_filter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_filter_1")) return false;
    boolean r;
    r = regex_string(b, l + 1);
    if (!r) r = regex(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'regex' (regex-string | regex)
  public static boolean regex_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REGEX_PREDICATE, "<regex predicate>");
    r = consumeToken(b, "regex");
    r = r && regex_predicate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // regex-string | regex
  private static boolean regex_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_predicate_1")) return false;
    boolean r;
    r = regex_string(b, l + 1);
    if (!r) r = regex(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'regex' (regex-string |regex)
  public static boolean regex_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REGEX_QUERY, "<regex query>");
    r = consumeToken(b, "regex");
    r = r && regex_query_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // regex-string |regex
  private static boolean regex_query_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_query_1")) return false;
    boolean r;
    r = regex_string(b, l + 1);
    if (!r) r = regex(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // STRING
  public static boolean regex_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "regex_string")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, REGEX_STRING, r);
    return r;
  }

  /* ********************************************************** */
  // 'replace' (regex-string | regex) STRING
  public static boolean replace_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replace_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REPLACE_FILTER, "<replace filter>");
    r = consumeToken(b, "replace");
    r = r && replace_filter_1(b, l + 1);
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // regex-string | regex
  private static boolean replace_filter_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "replace_filter_1")) return false;
    boolean r;
    r = regex_string(b, l + 1);
    if (!r) r = regex(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* METHOD url_or_template NEW_LINE* header* request-section* body?
  public static boolean request(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request")) return false;
    if (!nextTokenIs(b, "<request>", METHOD, NEW_LINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REQUEST, "<request>");
    r = request_0(b, l + 1);
    r = r && consumeToken(b, METHOD);
    r = r && url_or_template(b, l + 1);
    r = r && request_3(b, l + 1);
    r = r && request_4(b, l + 1);
    r = r && request_5(b, l + 1);
    r = r && request_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean request_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "request_0", c)) break;
    }
    return true;
  }

  // NEW_LINE*
  private static boolean request_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_3")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "request_3", c)) break;
    }
    return true;
  }

  // header*
  private static boolean request_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!header(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_4", c)) break;
    }
    return true;
  }

  // request-section*
  private static boolean request_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!request_section(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "request_5", c)) break;
    }
    return true;
  }

  // body?
  private static boolean request_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_6")) return false;
    body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // basic-auth-section | query-string-params-section | form-params-section | multipart-form-data-section | cookies-section | options-section
  public static boolean request_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "request_section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, REQUEST_SECTION, "<request section>");
    r = basic_auth_section(b, l + 1);
    if (!r) r = query_string_params_section(b, l + 1);
    if (!r) r = form_params_section(b, l + 1);
    if (!r) r = multipart_form_data_section(b, l + 1);
    if (!r) r = cookies_section(b, l + 1);
    if (!r) r = options_section(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'resolve:' value-string
  public static boolean resolve_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "resolve_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESOLVE_OPTION, "<resolve option>");
    r = consumeToken(b, "resolve:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NEW_LINE* HTTP_VERSION http-status NEW_LINE header* response-section* body?
  public static boolean response(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response")) return false;
    if (!nextTokenIs(b, "<response>", HTTP_VERSION, NEW_LINE)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESPONSE, "<response>");
    r = response_0(b, l + 1);
    r = r && consumeToken(b, HTTP_VERSION);
    r = r && http_status(b, l + 1);
    r = r && consumeToken(b, NEW_LINE);
    r = r && response_4(b, l + 1);
    r = r && response_5(b, l + 1);
    r = r && response_6(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // NEW_LINE*
  private static boolean response_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, NEW_LINE)) break;
      if (!empty_element_parsed_guard_(b, "response_0", c)) break;
    }
    return true;
  }

  // header*
  private static boolean response_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!header(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "response_4", c)) break;
    }
    return true;
  }

  // response-section*
  private static boolean response_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_5")) return false;
    while (true) {
      int c = current_position_(b);
      if (!response_section(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "response_5", c)) break;
    }
    return true;
  }

  // body?
  private static boolean response_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_6")) return false;
    body(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // capture-section | asserts-section
  public static boolean response_section(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "response_section")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RESPONSE_SECTION, "<response section>");
    r = capture_section(b, l + 1);
    if (!r) r = asserts_section(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'retry-interval:' integer-option
  public static boolean retry_interval_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "retry_interval_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETRY_INTERVAL_OPTION, "<retry interval option>");
    r = consumeToken(b, "retry-interval:");
    r = r && integer_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'retry:' integer-option
  public static boolean retry_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "retry_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, RETRY_OPTION, "<retry option>");
    r = consumeToken(b, "retry:");
    r = r && integer_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'sha256'
  public static boolean sha256_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "sha256_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SHA_256_QUERY, "<sha 256 query>");
    r = consumeToken(b, "sha256");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'skip:' boolean-option
  public static boolean skip_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "skip_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SKIP_OPTION, "<skip option>");
    r = consumeToken(b, "skip:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'split' STRING
  public static boolean split_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "split_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, SPLIT_FILTER, "<split filter>");
    r = consumeToken(b, "split");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'startsWith' (STRING|oneline-hex|oneline-base64)
  public static boolean start_with_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_with_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, START_WITH_PREDICATE, "<start with predicate>");
    r = consumeToken(b, "startsWith");
    r = r && start_with_predicate_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // STRING|oneline-hex|oneline-base64
  private static boolean start_with_predicate_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "start_with_predicate_1")) return false;
    boolean r;
    r = consumeToken(b, STRING);
    if (!r) r = oneline_hex(b, l + 1);
    if (!r) r = oneline_base64(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'status'
  public static boolean status_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "status_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STATUS_QUERY, "<status query>");
    r = consumeToken(b, "status");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'isString'
  public static boolean string_predicate(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "string_predicate")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STRING_PREDICATE, "<string predicate>");
    r = consumeToken(b, "isString");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'toDate' STRING
  public static boolean todate_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "todate_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, TODATE_FILTER, "<todate filter>");
    r = consumeToken(b, "toDate");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'unix-socket:' value-string
  public static boolean unix_socket_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unix_socket_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNIX_SOCKET_OPTION, "<unix socket option>");
    r = consumeToken(b, "unix-socket:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'url'
  public static boolean url_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL_QUERY, "<url query>");
    r = consumeToken(b, "url");
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (URL | template) (NUMBER|ALPHANUM|IDENTIFIER|'-'|','|'/'|'\'|'&'|'='|'?'|'%'|'$'|key-string|':'|template)*
  public static boolean url_or_template(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_or_template")) return false;
    if (!nextTokenIs(b, "<url or template>", TEMPLATE, URL)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, URL_OR_TEMPLATE, "<url or template>");
    r = url_or_template_0(b, l + 1);
    r = r && url_or_template_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // URL | template
  private static boolean url_or_template_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_or_template_0")) return false;
    boolean r;
    r = consumeToken(b, URL);
    if (!r) r = consumeToken(b, TEMPLATE);
    return r;
  }

  // (NUMBER|ALPHANUM|IDENTIFIER|'-'|','|'/'|'\'|'&'|'='|'?'|'%'|'$'|key-string|':'|template)*
  private static boolean url_or_template_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_or_template_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!url_or_template_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "url_or_template_1", c)) break;
    }
    return true;
  }

  // NUMBER|ALPHANUM|IDENTIFIER|'-'|','|'/'|'\'|'&'|'='|'?'|'%'|'$'|key-string|':'|template
  private static boolean url_or_template_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "url_or_template_1_0")) return false;
    boolean r;
    r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = key_string(b, l + 1);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, TEMPLATE);
    return r;
  }

  /* ********************************************************** */
  // 'user:' value-string
  public static boolean user_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "user_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, USER_OPTION, "<user option>");
    r = consumeToken(b, "user:");
    r = r && value_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // STRING | ( value-string-content | TEMPLATE)+
  public static boolean value_string(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_string")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VALUE_STRING, "<value string>");
    r = consumeToken(b, STRING);
    if (!r) r = value_string_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // ( value-string-content | TEMPLATE)+
  private static boolean value_string_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_string_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_string_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!value_string_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "value_string_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // value-string-content | TEMPLATE
  private static boolean value_string_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_string_1_0")) return false;
    boolean r;
    r = value_string_content(b, l + 1);
    if (!r) r = consumeToken(b, TEMPLATE);
    return r;
  }

  /* ********************************************************** */
  // (URL|catchall)+
  static boolean value_string_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_string_content")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = value_string_content_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!value_string_content_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "value_string_content", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // URL|catchall
  private static boolean value_string_content_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "value_string_content_0")) return false;
    boolean r;
    r = consumeToken(b, URL);
    if (!r) r = catchall(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // 'variable:' (ALPHANUM|IDENTIFIER)+ '=' variable-value+
  public static boolean variable_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_OPTION, "<variable option>");
    r = consumeToken(b, "variable:");
    r = r && variable_option_1(b, l + 1);
    r = r && consumeToken(b, EQ);
    r = r && variable_option_3(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (ALPHANUM|IDENTIFIER)+
  private static boolean variable_option_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_option_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_option_1_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!variable_option_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_option_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ALPHANUM|IDENTIFIER
  private static boolean variable_option_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_option_1_0")) return false;
    boolean r;
    r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    return r;
  }

  // variable-value+
  private static boolean variable_option_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_option_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = variable_value(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!variable_value(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "variable_option_3", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'variable' STRING
  public static boolean variable_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_QUERY, "<variable query>");
    r = consumeToken(b, "variable");
    r = r && consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // NULL | 'true' | 'false' | '=' | NUMBER | ALPHANUM | IDENTIFIER | key-string
  public static boolean variable_value(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "variable_value")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARIABLE_VALUE, "<variable value>");
    r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, "true");
    if (!r) r = consumeToken(b, "false");
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = key_string(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'verbose:' boolean-option
  public static boolean verbose_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "verbose_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VERBOSE_OPTION, "<verbose option>");
    r = consumeToken(b, "verbose:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'very-verbose:' boolean-option
  public static boolean very_verbose_option(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "very_verbose_option")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VERY_VERBOSE_OPTION, "<very verbose option>");
    r = consumeToken(b, "very-verbose:");
    r = r && boolean_option(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // (xml_version_tag | xml_comment | NEW_LINE)* xml_element
  public static boolean xml(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XML, "<xml>");
    r = xml_0(b, l + 1);
    r = r && xml_element(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (xml_version_tag | xml_comment | NEW_LINE)*
  private static boolean xml_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xml_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_0", c)) break;
    }
    return true;
  }

  // xml_version_tag | xml_comment | NEW_LINE
  private static boolean xml_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_0_0")) return false;
    boolean r;
    r = xml_version_tag(b, l + 1);
    if (!r) r = xml_comment(b, l + 1);
    if (!r) r = consumeToken(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // (ALPHANUM|NUMBER|'_'|'-')+ '=' STRING
  static boolean xml_attribute(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_attribute")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xml_attribute_0(b, l + 1);
    r = r && consumeTokens(b, 0, EQ, STRING);
    exit_section_(b, m, null, r);
    return r;
  }

  // (ALPHANUM|NUMBER|'_'|'-')+
  private static boolean xml_attribute_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_attribute_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xml_attribute_0_0(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!xml_attribute_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_attribute_0", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  // ALPHANUM|NUMBER|'_'|'-'
  private static boolean xml_attribute_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_attribute_0_0")) return false;
    boolean r;
    r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, DASH);
    return r;
  }

  /* ********************************************************** */
  // '<' '/' xml_tag_name '>'
  static boolean xml_close_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_close_tag")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LESS, SLASH);
    r = r && xml_tag_name(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '<!--' (catchall | NEW_LINE)* '-->'
  static boolean xml_comment(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_comment")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<!--");
    r = r && xml_comment_1(b, l + 1);
    r = r && consumeToken(b, "-->");
    exit_section_(b, m, null, r);
    return r;
  }

  // (catchall | NEW_LINE)*
  private static boolean xml_comment_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_comment_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xml_comment_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_comment_1", c)) break;
    }
    return true;
  }

  // catchall | NEW_LINE
  private static boolean xml_comment_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_comment_1_0")) return false;
    boolean r;
    r = catchall(b, l + 1);
    if (!r) r = consumeToken(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // xml_element | xml_text
  static boolean xml_content(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_content")) return false;
    boolean r;
    r = xml_element(b, l + 1);
    if (!r) r = xml_text(b, l + 1);
    return r;
  }

  /* ********************************************************** */
  // xml_open_tag xml_content* xml_close_tag | xml_self_closing_tag | xml_comment
  static boolean xml_element(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_element")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xml_element_0(b, l + 1);
    if (!r) r = xml_self_closing_tag(b, l + 1);
    if (!r) r = xml_comment(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // xml_open_tag xml_content* xml_close_tag
  private static boolean xml_element_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_element_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = xml_open_tag(b, l + 1);
    r = r && xml_element_0_1(b, l + 1);
    r = r && xml_close_tag(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // xml_content*
  private static boolean xml_element_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_element_0_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xml_content(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_element_0_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '<' xml_tag_name xml_attribute* '>'
  static boolean xml_open_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_open_tag")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && xml_tag_name(b, l + 1);
    r = r && xml_open_tag_2(b, l + 1);
    r = r && consumeToken(b, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // xml_attribute*
  private static boolean xml_open_tag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_open_tag_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xml_attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_open_tag_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // '<' xml_tag_name xml_attribute* '/' '>'
  static boolean xml_self_closing_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_self_closing_tag")) return false;
    if (!nextTokenIs(b, LESS)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LESS);
    r = r && xml_tag_name(b, l + 1);
    r = r && xml_self_closing_tag_2(b, l + 1);
    r = r && consumeTokens(b, 0, SLASH, GREATER);
    exit_section_(b, m, null, r);
    return r;
  }

  // xml_attribute*
  private static boolean xml_self_closing_tag_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_self_closing_tag_2")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xml_attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_self_closing_tag_2", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER | ALPHANUM
  static boolean xml_tag_name(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_tag_name")) return false;
    if (!nextTokenIs(b, "", ALPHANUM, IDENTIFIER)) return false;
    boolean r;
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, ALPHANUM);
    return r;
  }

  /* ********************************************************** */
  // '[' | ']' | '{' | '}' | '(' | ')' | "_" | '-' | '.' | '@' | '!' | '\' | '/' | '$' | '?' | '=' | '&' | '%' | "," | ":" | ";" | "+" | '*' | '>' | '`' | '~' | '^' | '|' | '+' | NULL| ALPHANUM | IDENTIFIER| NUMBER | JSON_ID | STRING | ANY | TEMPLATE | NEW_LINE
  static boolean xml_text(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_text")) return false;
    boolean r;
    r = consumeToken(b, LBRACKET);
    if (!r) r = consumeToken(b, RBRACKET);
    if (!r) r = consumeToken(b, LBRACE);
    if (!r) r = consumeToken(b, RBRACE);
    if (!r) r = consumeToken(b, LPAR);
    if (!r) r = consumeToken(b, RPAR);
    if (!r) r = consumeToken(b, UNDERSCORE);
    if (!r) r = consumeToken(b, DASH);
    if (!r) r = consumeToken(b, DOT);
    if (!r) r = consumeToken(b, AT);
    if (!r) r = consumeToken(b, BANG);
    if (!r) r = consumeToken(b, BACKSLASH);
    if (!r) r = consumeToken(b, SLASH);
    if (!r) r = consumeToken(b, DOLLAR);
    if (!r) r = consumeToken(b, QMARK);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, AMPERSAND);
    if (!r) r = consumeToken(b, PERCENT);
    if (!r) r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, COLON);
    if (!r) r = consumeToken(b, SEMI);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, STAR);
    if (!r) r = consumeToken(b, GREATER);
    if (!r) r = consumeToken(b, BACKQUOTE);
    if (!r) r = consumeToken(b, TILDE);
    if (!r) r = consumeToken(b, CARET);
    if (!r) r = consumeToken(b, PIPE);
    if (!r) r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, NULL);
    if (!r) r = consumeToken(b, ALPHANUM);
    if (!r) r = consumeToken(b, IDENTIFIER);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, JSON_ID);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, ANY);
    if (!r) r = consumeToken(b, TEMPLATE);
    if (!r) r = consumeToken(b, NEW_LINE);
    return r;
  }

  /* ********************************************************** */
  // '<?xml' xml_attribute* '?>'
  static boolean xml_version_tag(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_version_tag")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, "<?xml");
    r = r && xml_version_tag_1(b, l + 1);
    r = r && consumeToken(b, "?>");
    exit_section_(b, m, null, r);
    return r;
  }

  // xml_attribute*
  private static boolean xml_version_tag_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xml_version_tag_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!xml_attribute(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "xml_version_tag_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // STRING
  public static boolean xpath(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpath")) return false;
    if (!nextTokenIs(b, STRING)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, STRING);
    exit_section_(b, m, XPATH, r);
    return r;
  }

  /* ********************************************************** */
  // 'xpath' xpath
  public static boolean xpath_filter(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpath_filter")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XPATH_FILTER, "<xpath filter>");
    r = consumeToken(b, "xpath");
    r = r && xpath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // 'xpath' xpath
  public static boolean xpath_query(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "xpath_query")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, XPATH_QUERY, "<xpath query>");
    r = consumeToken(b, "xpath");
    r = r && xpath(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

}
