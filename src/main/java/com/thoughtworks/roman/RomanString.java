package com.thoughtworks.roman;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.Lists;

public class RomanString {

  private final List<CompositeRomanLiteral> m_compositeList;

  public RomanString(List<CompositeRomanLiteral> compositeList) {
    m_compositeList = compositeList;
  }

  public List<CompositeRomanLiteral> getCompositeList() {
    return Lists.newArrayList(m_compositeList);
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_compositeList).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof RomanString))
      return false;

    RomanString rhs = (RomanString) obj;
    return new EqualsBuilder().append(m_compositeList, rhs.m_compositeList).isEquals();
  }

}
