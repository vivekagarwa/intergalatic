package com.thoughtworks.roman;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.base.Strings;
import com.google.common.collect.Lists;

public class RomanParserAndValidator {

  public RomanString parseAndValidate(String romanNumeral) {
    Preconditions.checkState(!Strings.isNullOrEmpty(romanNumeral));
    List<RomanLiteral> list = Lists.newArrayList();
    for (int i = 0; i < romanNumeral.length(); i++) {
      list.add(RomanLiteral.getRomanLiteral(romanNumeral.charAt(i)));
    }
    return parseAndValidate(list);
  }

  public RomanString parseAndValidate(List<RomanLiteral> romanLiteralList) {
    Preconditions.checkNotNull(romanLiteralList);
    Preconditions.checkState(romanLiteralList.size() > 0);
    List<CompositeRomanLiteral> list = Lists.newArrayList();
    RomanLiteral prevRoman = romanLiteralList.get(0);
    int consequtive = 0;
    for (RomanLiteral roman : romanLiteralList) {
      if (roman.equals(RomanLiteral.O)) {
        return null;
      }
      int order = roman.compareTo(prevRoman);
      if (order == 0) {
        // succession
        ++consequtive;
        RulesConfig rule = RulesConfig.getApplicableRule(roman);
        Preconditions.checkState(consequtive <= rule.getConsequtive());
        list.add(new CompositeRomanLiteral(roman));
      } else if (order < 0) {
        // normal order
        consequtive = 1;
        prevRoman = roman;
        list.add(new CompositeRomanLiteral(roman));
      } else {
        // subtract
        RulesConfig rule = RulesConfig.getApplicableRule(prevRoman);
        Preconditions.checkState(consequtive == 1);
        Preconditions.checkState(rule.getAllowedSubtractFrom().contains(roman));
        list.remove(list.size() - 1);
        list.add(new CompositeRomanLiteral(roman, prevRoman));
        prevRoman = RomanLiteral.getSmaller(prevRoman);
        consequtive = 0;
      }
    }
    return new RomanString(list);
  }

}
