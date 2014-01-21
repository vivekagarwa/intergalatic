package com.thoughtworks.intergalaticUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IntergalaticUnitQuery {

  private final IntergalaticString m_units;
  
  private IntergalaticUnitQuery(IntergalaticString units) {
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
  
  public static Builder newBuilder() {
    return new Builder();
  }
  
  public static class Builder {
    
    private IntergalaticString m_units_;
    
    private Builder() {
    }
    
    public Builder setUnits(IntergalaticString units) {
      m_units_ = units;
      return this;
    }
    
    public IntergalaticUnitQuery build() {
      return new IntergalaticUnitQuery(m_units_);
    }
    
  }
  
}
