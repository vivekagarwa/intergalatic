package com.thoughtworks.intergalaticUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IntergalaticUnitResponse {

  private final IntergalaticString m_units;
  private final int m_unitsDecimal;

  private IntergalaticUnitResponse(IntergalaticString units, int unitsDecimal) {
    m_units = units;
    m_unitsDecimal = unitsDecimal;
  }

  public IntergalaticString getUnits() {
    return m_units;
  }

  public int getUnitsDecimal() {
    return m_unitsDecimal;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_units).append(m_unitsDecimal).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof IntergalaticUnitResponse))
      return false;

    IntergalaticUnitResponse rhs = (IntergalaticUnitResponse) obj;
    return new EqualsBuilder().append(m_units, rhs.m_units)
            .append(m_unitsDecimal, rhs.m_unitsDecimal).isEquals();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private IntergalaticString m_units_;
    private int m_unitsDecimal_;

    private Builder() {
    }

    public Builder setUnits(IntergalaticString units) {
      m_units_ = units;
      return this;
    }

    public Builder setUnitsDecimal(int unitsDecimal) {
      m_unitsDecimal_ = unitsDecimal;
      return this;
    }

    public IntergalaticUnitResponse build() {
      return new IntergalaticUnitResponse(m_units_, m_unitsDecimal_);
    }

  }

}
