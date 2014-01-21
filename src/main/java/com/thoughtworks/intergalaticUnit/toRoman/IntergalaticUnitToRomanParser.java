package com.thoughtworks.intergalaticUnit.toRoman;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticLiteral;
import com.thoughtworks.intergalaticUnit.IntergalaticToRomanConversion;
import com.thoughtworks.roman.RomanLiteral;

@Singleton
public class IntergalaticUnitToRomanParser {

  private static final String IS = "is";

  public IntergalaticToRomanConversion create(String statement) {
    List<String> wordList = Lists.newArrayList(statement.split(" "));
    if (!(wordList.size() == 3 && wordList.get(1).equals(IS) && wordList.get(2).length() == 1 && RomanLiteral
            .isValidRoman(wordList.get(2).charAt(0)))) {
      return null;
    }
    RomanLiteral roman = RomanLiteral.getRomanLiteral(wordList.get(2).charAt(0));
    String intergalaticLiteralName = wordList.get(0);
    IntergalaticLiteral intergalaticLiteral = createIntergalaticLiteral(intergalaticLiteralName);
    return create(intergalaticLiteral, roman);
  }

  private IntergalaticToRomanConversion create(IntergalaticLiteral intergalaticLiteral,
          RomanLiteral roman) {
    IntergalaticToRomanConversion.Builder builder = IntergalaticToRomanConversion.newBuilder();
    builder.setIntergalatic(intergalaticLiteral);
    builder.setRoman(roman);
    return builder.build();
  }

  private IntergalaticLiteral createIntergalaticLiteral(String intergalaticLiteralName) {
    IntergalaticLiteral.Builder builder = IntergalaticLiteral.newBuilder();
    builder.setName(intergalaticLiteralName);
    return builder.build();
  }

}
