package com.thoughtworks.intergalaticUnit.toString;

import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticLiteral;
import com.thoughtworks.intergalaticUnit.IntergalaticString;

@Singleton
public class IntergalaticStringToStringConverter {

  public String getVal(IntergalaticString intergalaticString) {
    StringBuilder builder = new StringBuilder();
    int literalCount = intergalaticString.getLiteralCount();
    for (int i = 0; i < literalCount; i++) {
      IntergalaticLiteral literal = intergalaticString.getLiteral(i);
      builder.append(literal.getName());
      if (i < literalCount - 1) {
        builder.append(" ");
      }
    }
    return builder.toString();
  }
}
