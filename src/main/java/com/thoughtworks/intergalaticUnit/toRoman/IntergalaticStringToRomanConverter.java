package com.thoughtworks.intergalaticUnit.toRoman;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticLiteral;
import com.thoughtworks.intergalaticUnit.IntergalaticString;
import com.thoughtworks.roman.RomanLiteral;
import com.thoughtworks.roman.RomanParserAndValidator;
import com.thoughtworks.roman.RomanString;

@Singleton
public class IntergalaticStringToRomanConverter {

  private final IntergalaticUnitToRomanConversionRules m_intergalaticUnitToRomanConversionRules;
  private final RomanParserAndValidator m_romanParserAndValidator;

  @Inject
  public IntergalaticStringToRomanConverter(
          IntergalaticUnitToRomanConversionRules intergalaticUnitToRomanConversionRules,
          RomanParserAndValidator romanParserAndValidator) {
    m_intergalaticUnitToRomanConversionRules = intergalaticUnitToRomanConversionRules;
    m_romanParserAndValidator = romanParserAndValidator;
  }

  public RomanString getVal(IntergalaticString intergalaticString) {
    List<RomanLiteral> list = Lists.newArrayList();
    for (IntergalaticLiteral intergalaticLiteral : intergalaticString.getLiteralList()) {
      RomanLiteral romanLiteral = m_intergalaticUnitToRomanConversionRules
              .getRomanLiteral(intergalaticLiteral);
      list.add(romanLiteral);
    }
    return m_romanParserAndValidator.parseAndValidate(list);
  }

}
