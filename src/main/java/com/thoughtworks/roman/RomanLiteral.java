package com.thoughtworks.roman;

import com.google.common.base.Preconditions;

public enum RomanLiteral {
  O('O', 0),
  I('I', 1),
  V('V', 5),
  X('X', 10),
  L('L', 50),
  C('C', 100),
  D('D', 500),
  M('M', 1000), ;

  private final int m_dec;
  private final Character m_roman;

  private RomanLiteral(Character roman, int dec) {
    m_roman = roman;
    m_dec = dec;
  }

  public Character getCharacter() {
    return m_roman;
  }

  public int getDec() {
    return m_dec;
  }

  public static RomanLiteral getRomanLiteral(Character romanChar) {
    RomanLiteral roman = getRomanLiteralInternal(romanChar);
    Preconditions.checkState(roman != null, romanChar);
    return roman;
  }

  public static RomanLiteral getSmaller(RomanLiteral roman) {
    Preconditions.checkNotNull(roman);
    Preconditions.checkArgument(!roman.equals(RomanLiteral.O));
    return RomanLiteral.values()[roman.ordinal() - 1];
  }

//  public static RomanLiteral getRomanLiteral(RomanLiteral romanLiteral) {
//    Preconditions.checkNotNull(romanLiteral);
//    for (RomanLiteral roman : RomanLiteral.values()) {
//      if (romanLiteral.equals(roman.getRomanLiteral())) {
//        return roman;
//      }
//    }
//    Preconditions.checkState(false, romanLiteral);
//    return null;
//  }

  public static boolean isValidRoman(Character charAt) {
    return getRomanLiteralInternal(charAt) != null;
  }

  private static RomanLiteral getRomanLiteralInternal(Character romanChar) {
    Preconditions.checkNotNull(romanChar);
    for (RomanLiteral roman : RomanLiteral.values()) {
      if (romanChar.equals(roman.getCharacter())) {
        return roman;
      }
    }
    return null;
  }

}
