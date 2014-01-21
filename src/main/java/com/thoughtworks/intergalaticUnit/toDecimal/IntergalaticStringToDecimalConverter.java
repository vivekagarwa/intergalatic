package com.thoughtworks.intergalaticUnit.toDecimal;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticString;
import com.thoughtworks.intergalaticUnit.toRoman.IntergalaticStringToRomanConverter;
import com.thoughtworks.roman.RomanString;
import com.thoughtworks.roman.RomanStringToDecimalConverter;

@Singleton
public class IntergalaticStringToDecimalConverter {

  private final IntergalaticStringToRomanConverter m_romanConverter;
  private final RomanStringToDecimalConverter m_romanStringToDecimalConverter;

  @Inject
  public IntergalaticStringToDecimalConverter(
          IntergalaticStringToRomanConverter romanConverter,
          RomanStringToDecimalConverter romanStringToDecimalConverter) {
    m_romanConverter = romanConverter;
    m_romanStringToDecimalConverter = romanStringToDecimalConverter;
  }

  public int getVal(IntergalaticString intergalaticString) {
    RomanString romanString = m_romanConverter.getVal(intergalaticString);
    return m_romanStringToDecimalConverter.convert(romanString);
  }
}
