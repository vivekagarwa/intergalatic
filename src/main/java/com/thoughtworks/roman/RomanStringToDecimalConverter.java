package com.thoughtworks.roman;

import com.google.inject.Singleton;

@Singleton
public class RomanStringToDecimalConverter {

  public int convert(RomanString unit) {
    int val = 0;
    for (CompositeRomanLiteral compositeRomanNumeral : unit.getCompositeList()) {
      val += getVal(compositeRomanNumeral);
    }
    return val;
  }

  private int getVal(CompositeRomanLiteral compositeRomanNumeral) {
    return compositeRomanNumeral.getRoman().getDec()
            - compositeRomanNumeral.getToSubtract().getDec();
  }
}
