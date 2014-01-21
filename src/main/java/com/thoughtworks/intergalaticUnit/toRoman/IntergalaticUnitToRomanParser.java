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
    if (!(isValidConversion(wordList))) {
      return null;
    }
    RomanLiteral roman = RomanLiteral.getRomanLiteral(wordList.get(2).charAt(0));
    String intergalaticLiteralName = wordList.get(0);
    IntergalaticLiteral intergalaticLiteral = new IntergalaticLiteral(intergalaticLiteralName);
    return new IntergalaticToRomanConversion(intergalaticLiteral, roman);
  }

  private boolean isValidConversion(List<String> tokens) {
    return tokens.size() == 3 && tokens.get(1).equals(IS) && isAValidRomanString(tokens.get(2));
  }

  private boolean isAValidRomanString(String romanValue) {
    return romanValue.length() == 1 && RomanLiteral.isValidRoman(romanValue.charAt(0));
  }

}
