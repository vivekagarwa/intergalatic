package com.thoughtworks.commodity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Commodity {

  private final String m_id;

  private Commodity(String id) {
    m_id = id;
  }

  public String getId() {
    return m_id;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_id).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof Commodity))
      return false;

    Commodity rhs = (Commodity) obj;
    return new EqualsBuilder().append(m_id, rhs.m_id).isEquals();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private String m_id_;

    private Builder() {
    }

    public Builder setId(String id) {
      m_id_ = id;
      return this;
    }

    public Commodity build() {
      return new Commodity(m_id_);
    }

  }

}
