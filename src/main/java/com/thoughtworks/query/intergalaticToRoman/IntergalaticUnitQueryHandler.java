package com.thoughtworks.query.intergalaticToRoman;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticUnitQuery;
import com.thoughtworks.intergalaticUnit.toDecimal.IntergalaticStringToDecimalConverter;
import com.thoughtworks.intergalaticUnit.toString.IntergalaticStringToStringConverter;

@Singleton
public class IntergalaticUnitQueryHandler {

  private final IntergalaticStringToDecimalConverter m_intergalaticStringToDecimalConverter;
  private final IntergalaticStringToStringConverter m_intergalaticToStringConverter;

  @Inject
  public IntergalaticUnitQueryHandler(
          IntergalaticStringToStringConverter intergalaticToStringConverter,
          IntergalaticStringToDecimalConverter intergalaticStringToDecimalConverter) {
    m_intergalaticToStringConverter = intergalaticToStringConverter;
    m_intergalaticStringToDecimalConverter = intergalaticStringToDecimalConverter;
  }

  public String handle(IntergalaticUnitQuery intergalaticUnitQuery) {
    String intergalaticString = m_intergalaticToStringConverter.getVal(intergalaticUnitQuery
            .getUnits());
    int unitsDecimal = m_intergalaticStringToDecimalConverter.getVal(intergalaticUnitQuery
            .getUnits());
    return String.format("%s is %s", intergalaticString, unitsDecimal);
  }
}
