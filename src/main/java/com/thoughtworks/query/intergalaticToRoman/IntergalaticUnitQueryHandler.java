package com.thoughtworks.query.intergalaticToRoman;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticUnitQuery;
import com.thoughtworks.intergalaticUnit.IntergalaticUnitResponse;
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

  private IntergalaticUnitResponse createResponse(IntergalaticUnitQuery intergalaticUnitQuery) {
    IntergalaticUnitResponse.Builder builder = IntergalaticUnitResponse.newBuilder();
    builder.setUnits(intergalaticUnitQuery.getUnits());
    builder.setUnitsDecimal(m_intergalaticStringToDecimalConverter.getVal(intergalaticUnitQuery
            .getUnits()));
    return builder.build();
  }

  public String handle(IntergalaticUnitQuery intergalaticUnitQuery) {
    IntergalaticUnitResponse resp = createResponse(intergalaticUnitQuery);
    String intergalaticString = m_intergalaticToStringConverter.getVal(resp.getUnits());
    return String.format("%s is %s", intergalaticString, resp.getUnitsDecimal());
  }
}
