package com.thoughtworks.roman;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CompositeRomanLiteral {

  private final RomanLiteral m_roman;
  private final RomanLiteral m_toSubtract;

  private CompositeRomanLiteral(RomanLiteral roman, RomanLiteral toSubtract) {
    m_roman = roman;
    m_toSubtract = toSubtract;
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private RomanLiteral m_roman_;
    private RomanLiteral m_toSubtract_;

    private Builder() {
    }

    public Builder setRoman(RomanLiteral roman) {
      m_roman_ = roman;
      return this;
    }

    public Builder setToSubtract(RomanLiteral toSubtract) {
      m_toSubtract_ = toSubtract;
      return this;
    }

    public CompositeRomanLiteral build() {
      return new CompositeRomanLiteral(m_roman_, m_toSubtract_);
    }

  }

}
