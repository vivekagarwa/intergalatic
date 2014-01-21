package com.thoughtworks.intergalaticUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IntergalaticUnitQuery {

  private final IntergalaticString m_units;
  
  public IntergalaticUnitQuery(IntergalaticString units) {
    m_units = units; 
  }
  
  public IntergalaticString getUnits() {
    return m_units;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_units).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof IntergalaticUnitQuery))
      return false;

    IntergalaticUnitQuery rhs = (IntergalaticUnitQuery) obj;
    return new EqualsBuilder().append(m_units, rhs.m_units).isEquals();
  }
  
}
