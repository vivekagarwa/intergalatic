package com.thoughtworks.intergalaticUnit.toRoman;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticLiterals;
import com.thoughtworks.intergalaticUnit.IntergalaticToRomanConversion;

@Singleton
public class IntergalaticUnitToRomanHandler {

  private final IntergalaticLiterals m_literals;
  private final IntergalaticUnitToRomanConversionRules m_conversionRules;

  @Inject
  public IntergalaticUnitToRomanHandler(IntergalaticLiterals literals,
          IntergalaticUnitToRomanConversionRules conversionRules) {
    m_literals = literals;
    m_conversionRules = conversionRules;
  }

  public String handle(IntergalaticToRomanConversion conversionRule) {
    if (!m_literals.addIntergalaticLiteral(conversionRule.getIntergalatic())) {
      return conversionRule.getIntergalatic().getName() + " is already is defined";
    }
    if (!m_conversionRules.addRule(conversionRule)) {
      return conversionRule.getIntergalatic().getName() + " is already is defined";
    }
    return "";
  }
}