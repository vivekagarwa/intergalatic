package com.thoughtworks.intergalaticUnit;

import com.thoughtworks.roman.RomanLiteral;

public class IntergalaticToRomanConversion {

  private final IntergalaticLiteral m_intergalatic;
  private final RomanLiteral m_roman;

  public IntergalaticToRomanConversion(IntergalaticLiteral intergalatic, RomanLiteral roman) {
    m_intergalatic = intergalatic;
    m_roman = roman;
  }

  public IntergalaticLiteral getIntergalatic() {
    return m_intergalatic;
  }

  public RomanLiteral getRoman() {
    return m_roman;
  }

}