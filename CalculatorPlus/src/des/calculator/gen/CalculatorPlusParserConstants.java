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
/* Generated By:JavaCC: Do not edit this line. CalculatorPlusParserConstants.java */
package des.calculator.gen;


/**
 * Token literal values and constants.
 * Generated by org.javacc.parser.OtherFilesGen#start()
 */
public interface CalculatorPlusParserConstants {

  /** End of File. */
  int EOF = 0;
  /** RegularExpression Id. */
  int NUMBER = 5;
  /** RegularExpression Id. */
  int DIGITS = 6;
  /** RegularExpression Id. */
  int COMMA = 7;
  /** RegularExpression Id. */
  int SET = 8;
  /** RegularExpression Id. */
  int LPAREN = 9;
  /** RegularExpression Id. */
  int RPAREN = 10;
  /** RegularExpression Id. */
  int SYSTEM = 11;
  /** RegularExpression Id. */
  int SIN = 12;
  /** RegularExpression Id. */
  int COS = 13;
  /** RegularExpression Id. */
  int TAN = 14;
  /** RegularExpression Id. */
  int ATAN = 15;
  /** RegularExpression Id. */
  int ASIN = 16;
  /** RegularExpression Id. */
  int ACOS = 17;
  /** RegularExpression Id. */
  int FLOOR = 18;
  /** RegularExpression Id. */
  int CEILING = 19;
  /** RegularExpression Id. */
  int ABS = 20;
  /** RegularExpression Id. */
  int LN = 21;
  /** RegularExpression Id. */
  int LOG = 22;
  /** RegularExpression Id. */
  int PLUS = 23;
  /** RegularExpression Id. */
  int MINUS = 24;
  /** RegularExpression Id. */
  int MULTIPLICATION = 25;
  /** RegularExpression Id. */
  int DIVISION = 26;
  /** RegularExpression Id. */
  int MODULUS = 27;
  /** RegularExpression Id. */
  int EXPONENT = 28;
  /** RegularExpression Id. */
  int ROOT = 29;
  /** RegularExpression Id. */
  int NAME = 30;

  /** Lexical state. */
  int DEFAULT = 0;

  /** Literal token values. */
  String[] tokenImage = {
    "<EOF>",
    "\" \"",
    "\"\\t\"",
    "\"\\r\"",
    "\"\\n\"",
    "<NUMBER>",
    "<DIGITS>",
    "\",\"",
    "\"=\"",
    "\"(\"",
    "\")\"",
    "\"$\"",
    "\"sin\"",
    "\"cos\"",
    "\"tan\"",
    "\"atan\"",
    "\"asin\"",
    "\"acos\"",
    "\"flr\"",
    "\"cl\"",
    "\"abs\"",
    "\"ln\"",
    "\"log\"",
    "\"+\"",
    "\"-\"",
    "\"*\"",
    "\"/\"",
    "\"%\"",
    "\"^\"",
    "\"\\u221a\"",
    "<NAME>",
  };

}
