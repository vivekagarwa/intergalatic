package com.thoughtworks.intergalaticUnit;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class IntergalaticLiteral {

  private final String m_name;

  private IntergalaticLiteral(String name) {
    m_name = name;
  }

  public String getName() {
    return m_name;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_name).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof IntergalaticLiteral))
      return false;

    IntergalaticLiteral rhs = (IntergalaticLiteral) obj;
    return new EqualsBuilder().append(m_name, rhs.m_name).isEquals();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String m_name_;

    private Builder() {
    }

    public Builder setName(String name) {
      m_name_ = name;
      return this;
    }

    public IntergalaticLiteral build() {
      return new IntergalaticLiteral(m_name_);
    }

  }

}
