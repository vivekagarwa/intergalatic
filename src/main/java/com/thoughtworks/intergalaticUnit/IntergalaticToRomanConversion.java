package com.thoughtworks.intergalaticUnit;

import com.thoughtworks.roman.RomanLiteral;

public class IntergalaticToRomanConversion {

  private final IntergalaticLiteral m_intergalatic;
  private final RomanLiteral m_roman;

  private IntergalaticToRomanConversion(IntergalaticLiteral intergalatic, RomanLiteral roman) {
    m_intergalatic = intergalatic;
    m_roman = roman;
  }

  public IntergalaticLiteral getIntergalatic() {
    return m_intergalatic;
  }

  public RomanLiteral getRoman() {
    return m_roman;
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private IntergalaticLiteral m_intergalatic_;
    private RomanLiteral m_roman_;

    private Builder() {
    }

    public Builder setIntergalatic(IntergalaticLiteral intergalatic) {
      m_intergalatic_ = intergalatic;
      return this;
    }

    public Builder setRoman(RomanLiteral roman) {
      m_roman_ = roman;
      return this;
    }

    public IntergalaticToRomanConversion build() {
      return new IntergalaticToRomanConversion(m_intergalatic_, m_roman_);
    }

  }

}
