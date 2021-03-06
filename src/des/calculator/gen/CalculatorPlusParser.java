/*******************************************************************************
 * Copyright 2011 Douglas Siemon
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 *   http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 ******************************************************************************/
/* Generated By:JavaCC: Do not edit this line. CalculatorPlusParser.java */
        package des.calculator.gen;

        import des.calculator.calculatorPlus.*;

        public class CalculatorPlusParser implements CalculatorPlusParserConstants {

                public static CalculatorPlusParser getParser(String code){
                                java.io.StringReader sr = new java.io.StringReader( code );
                                java.io.Reader r = new java.io.BufferedReader( sr );
                                return new CalculatorPlusParser( r ) ;
                }

                public void parse() throws ParseException, TokenMgrError,NumberFormatException,SyntaxError{
                                this.Start();
                }

                public String name = null;
                public int numParams = 0;
                public ExpressionNode root = null;
                public boolean isVar = false;
                public boolean isFunc = false;

  final public void Start() throws ParseException, NumberFormatException, SyntaxError {
    Statement();
    jj_consume_token(0);
  }

  final public void Statement() throws ParseException, NumberFormatException, SyntaxError {
        Token tmpToken;
    if (jj_2_1(2147483647)) {
      tmpToken = jj_consume_token(NAME);
                  this.name = tmpToken.image; tmpToken=null;
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case SET:
        jj_consume_token(SET);
                          isVar=true;
        this.root = Expression();
        break;
      case LPAREN:
        jj_consume_token(LPAREN);
                          isFunc=true;
        tmpToken = jj_consume_token(NUMBER);
                                  this.numParams = (int)Double.parseDouble( tmpToken.image ); tmpToken=null;
        jj_consume_token(RPAREN);
        jj_consume_token(SET);
        this.root = Expression();
        break;
      default:
        jj_la1[0] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    } else {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NUMBER:
      case LPAREN:
      case SYSTEM:
      case SIN:
      case COS:
      case TAN:
      case ATAN:
      case ASIN:
      case ACOS:
      case FLOOR:
      case CEILING:
      case ABS:
      case LN:
      case LOG:
      case MINUS:
      case NAME:
        this.root = Expression();
        break;
      default:
        jj_la1[1] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
  }

  final public ExpressionNode Expression() throws ParseException, NumberFormatException, SyntaxError {
        Token tmpToken;
        BinaryOperator operator;
        ExpressionNode left;
        ExpressionNode right;
    left = Term();
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
      case MINUS:
        ;
        break;
      default:
        jj_la1[2] = jj_gen;
        break label_1;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PLUS:
        tmpToken = jj_consume_token(PLUS);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Term();
                  left = new BinaryNode(left,operator,right);
        break;
      case MINUS:
        tmpToken = jj_consume_token(MINUS);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Term();
                  left = new BinaryNode(left,operator,right);
        break;
      default:
        jj_la1[3] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          {if (true) return left;}
    throw new Error("Missing return statement in function");
  }

  final public ExpressionNode Term() throws ParseException, NumberFormatException, SyntaxError {
        Token tmpToken;
        BinaryOperator operator;
        ExpressionNode left;
        ExpressionNode right;
    left = Exponent();
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLICATION:
      case DIVISION:
      case MODULUS:
        ;
        break;
      default:
        jj_la1[4] = jj_gen;
        break label_2;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case MULTIPLICATION:
        tmpToken = jj_consume_token(MULTIPLICATION);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Exponent();
                  left = new BinaryNode(left,operator,right);
        break;
      case DIVISION:
        tmpToken = jj_consume_token(DIVISION);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Exponent();
                  left = new BinaryNode(left,operator,right);
        break;
      case MODULUS:
        tmpToken = jj_consume_token(MODULUS);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Exponent();
                  left = new BinaryNode(left,operator,right);
        break;
      default:
        jj_la1[5] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          {if (true) return left;}
    throw new Error("Missing return statement in function");
  }

  final public ExpressionNode Exponent() throws ParseException, NumberFormatException, SyntaxError {
        Token tmpToken;
        BinaryOperator operator;
        ExpressionNode left;
        ExpressionNode right;
    left = Unary();
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EXPONENT:
      case ROOT:
        ;
        break;
      default:
        jj_la1[6] = jj_gen;
        break label_3;
      }
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case EXPONENT:
        tmpToken = jj_consume_token(EXPONENT);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Unary();
                  left = new BinaryNode(left,operator,right);
        break;
      case ROOT:
        tmpToken = jj_consume_token(ROOT);
                  operator = BinaryOperator.binaryFactory(tmpToken.image);  tmpToken=null;
        right = Unary();
                  left = new BinaryNode(left,operator,right);
        break;
      default:
        jj_la1[7] = jj_gen;
        jj_consume_token(-1);
        throw new ParseException();
      }
    }
          {if (true) return left;}
    throw new Error("Missing return statement in function");
  }

  final public ExpressionNode Unary() throws ParseException, NumberFormatException, SyntaxError {
        Token tmpToken;
        UnaryOperator operator;
        ExpressionNode child;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
    case LPAREN:
    case SYSTEM:
    case NAME:
      child = Primary();
      break;
    case MINUS:
      tmpToken = jj_consume_token(MINUS);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case SIN:
      tmpToken = jj_consume_token(SIN);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case COS:
      tmpToken = jj_consume_token(COS);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case TAN:
      tmpToken = jj_consume_token(TAN);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case ATAN:
      tmpToken = jj_consume_token(ATAN);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case ASIN:
      tmpToken = jj_consume_token(ASIN);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case ACOS:
      tmpToken = jj_consume_token(ACOS);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case FLOOR:
      tmpToken = jj_consume_token(FLOOR);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case CEILING:
      tmpToken = jj_consume_token(CEILING);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case ABS:
      tmpToken = jj_consume_token(ABS);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case LN:
      tmpToken = jj_consume_token(LN);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    case LOG:
      tmpToken = jj_consume_token(LOG);
                  operator = UnaryOperator.unaryFactory(tmpToken.image);  tmpToken=null;
      child = Unary();
                  child = new UnaryNode(child, operator);
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
          {if (true) return child;}
    throw new Error("Missing return statement in function");
  }

  final public ExpressionNode Primary() throws ParseException, NumberFormatException, SyntaxError {
        Token tmpToken;
        ExpressionNode child;

        FunctionNode functionNode;
        SystemFunctionNode systemFunctionNode;
        ExpressionNode param;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUMBER:
      tmpToken = jj_consume_token(NUMBER);
                  child = new LeafNode(Double.parseDouble( tmpToken.image ));  tmpToken=null;
      break;
    case LPAREN:
      jj_consume_token(LPAREN);
      child = Expression();
      jj_consume_token(RPAREN);
      break;
    default:
      jj_la1[12] = jj_gen;
      if (jj_2_2(2147483647)) {
        tmpToken = jj_consume_token(NAME);
                  child = functionNode = new FunctionNode(tmpToken.image);  tmpToken=null;
                  if(isFunc){ {if (true) throw new SyntaxError("You may not call user functions inside other functions");} }
        jj_consume_token(LPAREN);
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case RPAREN:
          jj_consume_token(RPAREN);
          break;
        case NUMBER:
        case LPAREN:
        case SYSTEM:
        case SIN:
        case COS:
        case TAN:
        case ATAN:
        case ASIN:
        case ACOS:
        case FLOOR:
        case CEILING:
        case ABS:
        case LN:
        case LOG:
        case MINUS:
        case NAME:
          param = Expression();
                                  functionNode.addParameter(param);
          label_4:
          while (true) {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case COMMA:
              ;
              break;
            default:
              jj_la1[9] = jj_gen;
              break label_4;
            }
            jj_consume_token(COMMA);
            param = Expression();
                                          functionNode.addParameter(param);
          }
          jj_consume_token(RPAREN);
          break;
        default:
          jj_la1[10] = jj_gen;
          jj_consume_token(-1);
          throw new ParseException();
        }
      } else {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case NAME:
          tmpToken = jj_consume_token(NAME);
                  child = new VariableNode(tmpToken.image);  tmpToken=null;
          break;
        default:
          jj_la1[13] = jj_gen;
          if (jj_2_3(2147483647)) {
            jj_consume_token(SYSTEM);
            tmpToken = jj_consume_token(NAME);
                  child = systemFunctionNode = new SystemFunctionNode(tmpToken.image);  tmpToken=null;
            jj_consume_token(LPAREN);
            param = Expression();
                  systemFunctionNode.addParameter(param);
            label_5:
            while (true) {
              switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
              case COMMA:
                ;
                break;
              default:
                jj_la1[11] = jj_gen;
                break label_5;
              }
              jj_consume_token(COMMA);
              param = Expression();
                          systemFunctionNode.addParameter(param);
            }
            jj_consume_token(RPAREN);
          } else {
            switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
            case SYSTEM:
              jj_consume_token(SYSTEM);
              tmpToken = jj_consume_token(NAME);
                  child = new SystemVariableNode(tmpToken.image);  tmpToken=null;
              break;
            default:
              jj_la1[14] = jj_gen;
              jj_consume_token(-1);
              throw new ParseException();
            }
          }
        }
      }
    }
          {if (true) return child;}
    throw new Error("Missing return statement in function");
  }

  private boolean jj_2_1(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_1(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(0, xla); }
  }

  private boolean jj_2_2(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_2(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(1, xla); }
  }

  private boolean jj_2_3(int xla) {
    jj_la = xla; jj_lastpos = jj_scanpos = token;
    try { return !jj_3_3(); }
    catch(LookaheadSuccess ls) { return true; }
    finally { jj_save(2, xla); }
  }

  private boolean jj_3_3() {
    if (jj_scan_token(SYSTEM)) return true;
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3R_6() {
    if (jj_scan_token(LPAREN)) return true;
    if (jj_scan_token(NUMBER)) return true;
    if (jj_scan_token(RPAREN)) return true;
    if (jj_scan_token(SET)) return true;
    return false;
  }

  private boolean jj_3_2() {
    if (jj_scan_token(NAME)) return true;
    if (jj_scan_token(LPAREN)) return true;
    return false;
  }

  private boolean jj_3_1() {
    if (jj_scan_token(NAME)) return true;
    Token xsp;
    xsp = jj_scanpos;
    if (jj_scan_token(8)) {
    jj_scanpos = xsp;
    if (jj_3R_6()) return true;
    }
    return false;
  }

  /** Generated Token Manager. */
  public CalculatorPlusParserTokenManager token_source;
  SimpleCharStream jj_input_stream;
  /** Current token. */
  public Token token;
  /** Next token. */
  public Token jj_nt;
  private int jj_ntk;
  private Token jj_scanpos, jj_lastpos;
  private int jj_la;
  private int jj_gen;
  final private int[] jj_la1 = new int[15];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x300,0x417ffa20,0x1800000,0x1800000,0xe000000,0xe000000,0x30000000,0x30000000,0x417ffa20,0x80,0x417ffe20,0x80,0x220,0x40000000,0x800,};
   }
  final private JJCalls[] jj_2_rtns = new JJCalls[3];
  private boolean jj_rescan = false;
  private int jj_gc = 0;

  /** Constructor with InputStream. */
  public CalculatorPlusParser(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public CalculatorPlusParser(java.io.InputStream stream, String encoding) {
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new CalculatorPlusParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor. */
  public CalculatorPlusParser(java.io.Reader stream) {
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new CalculatorPlusParserTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Constructor with generated Token Manager. */
  public CalculatorPlusParser(CalculatorPlusParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  /** Reinitialise. */
  public void ReInit(CalculatorPlusParserTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 15; i++) jj_la1[i] = -1;
    for (int i = 0; i < jj_2_rtns.length; i++) jj_2_rtns[i] = new JJCalls();
  }

  private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      if (++jj_gc > 100) {
        jj_gc = 0;
        for (int i = 0; i < jj_2_rtns.length; i++) {
          JJCalls c = jj_2_rtns[i];
          while (c != null) {
            if (c.gen < jj_gen) c.first = null;
            c = c.next;
          }
        }
      }
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }

  static private final class LookaheadSuccess extends java.lang.Error { }
  final private LookaheadSuccess jj_ls = new LookaheadSuccess();
  private boolean jj_scan_token(int kind) {
    if (jj_scanpos == jj_lastpos) {
      jj_la--;
      if (jj_scanpos.next == null) {
        jj_lastpos = jj_scanpos = jj_scanpos.next = token_source.getNextToken();
      } else {
        jj_lastpos = jj_scanpos = jj_scanpos.next;
      }
    } else {
      jj_scanpos = jj_scanpos.next;
    }
    if (jj_rescan) {
      int i = 0; Token tok = token;
      while (tok != null && tok != jj_scanpos) { i++; tok = tok.next; }
      if (tok != null) jj_add_error_token(kind, i);
    }
    if (jj_scanpos.kind != kind) return true;
    if (jj_la == 0 && jj_scanpos == jj_lastpos) throw jj_ls;
    return false;
  }


/** Get the next Token. */
  final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  private java.util.List jj_expentries = new java.util.ArrayList();
  private int[] jj_expentry;
  private int jj_kind = -1;
  private int[] jj_lasttokens = new int[100];
  private int jj_endpos;

  private void jj_add_error_token(int kind, int pos) {
    if (pos >= 100) return;
    if (pos == jj_endpos + 1) {
      jj_lasttokens[jj_endpos++] = kind;
    } else if (jj_endpos != 0) {
      jj_expentry = new int[jj_endpos];
      for (int i = 0; i < jj_endpos; i++) {
        jj_expentry[i] = jj_lasttokens[i];
      }
      jj_entries_loop: for (java.util.Iterator it = jj_expentries.iterator(); it.hasNext();) {
        int[] oldentry = (int[])(it.next());
        if (oldentry.length == jj_expentry.length) {
          for (int i = 0; i < jj_expentry.length; i++) {
            if (oldentry[i] != jj_expentry[i]) {
              continue jj_entries_loop;
            }
          }
          jj_expentries.add(jj_expentry);
          break jj_entries_loop;
        }
      }
      if (pos != 0) jj_lasttokens[(jj_endpos = pos) - 1] = kind;
    }
  }

  /** Generate ParseException. */
  public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[31];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 15; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 31; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    jj_endpos = 0;
    jj_rescan_token();
    jj_add_error_token(0, 0);
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = (int[])jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  final public void enable_tracing() {
  }

  /** Disable tracing. */
  final public void disable_tracing() {
  }

  private void jj_rescan_token() {
    jj_rescan = true;
    for (int i = 0; i < 3; i++) {
    try {
      JJCalls p = jj_2_rtns[i];
      do {
        if (p.gen > jj_gen) {
          jj_la = p.arg; jj_lastpos = jj_scanpos = p.first;
          switch (i) {
            case 0: jj_3_1(); break;
            case 1: jj_3_2(); break;
            case 2: jj_3_3(); break;
          }
        }
        p = p.next;
      } while (p != null);
      } catch(LookaheadSuccess ls) { }
    }
    jj_rescan = false;
  }

  private void jj_save(int index, int xla) {
    JJCalls p = jj_2_rtns[index];
    while (p.gen > jj_gen) {
      if (p.next == null) { p = p.next = new JJCalls(); break; }
      p = p.next;
    }
    p.gen = jj_gen + xla - jj_la; p.first = token; p.arg = xla;
  }

  static final class JJCalls {
    int gen;
    Token first;
    int arg;
    JJCalls next;
  }

        }
