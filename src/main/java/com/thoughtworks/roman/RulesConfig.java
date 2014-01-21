package com.thoughtworks.roman;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;

public enum RulesConfig {
  I(RomanLiteral.I, 3, RomanLiteral.V, RomanLiteral.X),
  V(RomanLiteral.V, 1),
  X(RomanLiteral.X, 3, RomanLiteral.L, RomanLiteral.C),
  L(RomanLiteral.L, 1),
  C(RomanLiteral.C, 3, RomanLiteral.D, RomanLiteral.M),
  D(RomanLiteral.D, 1),
  M(RomanLiteral.M, 3),
  ;

  private final RomanLiteral m_primitiveRoman;
  private final int m_consequtive;
  private final List<RomanLiteral> m_allowedSubtractFrom;

  private RulesConfig(RomanLiteral primitiveRoman, int consequtive,
          RomanLiteral... allowedSubtractFrom) {
    Preconditions.checkArgument(primitiveRoman.name().equals(this.name()),
            "primitiveRoman(%s) should match rule name(%s)", primitiveRoman.name(), this.name());
    m_primitiveRoman = primitiveRoman;
    m_consequtive = consequtive;
    m_allowedSubtractFrom = Lists.newArrayList(allowedSubtractFrom);
  }

  public static RulesConfig getApplicableRule(RomanLiteral primitiveRomanEnum) {
    Preconditions.checkNotNull(primitiveRomanEnum);
    for (RulesConfig rule : RulesConfig.values()) {
      if (primitiveRomanEnum.equals(rule.getRomanLiteral())) {
        return rule;
      }
    }
    Preconditions.checkState(false, primitiveRomanEnum);
    return null;
  }

  public RomanLiteral getRomanLiteral() {
    return m_primitiveRoman;
  }

  public int getConsequtive() {
    return m_consequtive;
  }

  public List<RomanLiteral> getAllowedSubtractFrom() {
    return m_allowedSubtractFrom;
  }

}
