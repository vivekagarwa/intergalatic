package com.thoughtworks.roman;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CompositeRomanLiteral {

  private final RomanLiteral m_roman;
  private final RomanLiteral m_toSubtract;

  public CompositeRomanLiteral(RomanLiteral roman, RomanLiteral toSubtract) {
    m_roman = roman;
    m_toSubtract = toSubtract;
  }
  
  public CompositeRomanLiteral(RomanLiteral roman) {
    m_roman = roman;
    m_toSubtract = RomanLiteral.O;
  }

  public RomanLiteral getRoman() {
    return m_roman;
  }

  public RomanLiteral getToSubtract() {
    return m_toSubtract;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_roman).append(m_toSubtract).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof CompositeRomanLiteral))
      return false;

    CompositeRomanLiteral rhs = (CompositeRomanLiteral) obj;
    return new EqualsBuilder().append(m_roman, rhs.m_roman).append(m_toSubtract, rhs.m_toSubtract)
            .isEquals();
  }

}
