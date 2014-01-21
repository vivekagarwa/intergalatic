package com.thoughtworks.intergalaticUnit;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.Lists;

public class IntergalaticString {

  private final List<IntergalaticLiteral> m_literalList;

  IntergalaticString(List<IntergalaticLiteral> literalList) {
    m_literalList = literalList;
  }

  public List<IntergalaticLiteral> getLiteralList() {
    return Lists.newArrayList(m_literalList);
  }

  public int getLiteralCount() {
    return m_literalList.size();
  }

  public IntergalaticLiteral getLiteral(int index) {
    return m_literalList.get(index);
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_literalList).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof IntergalaticString))
      return false;

    IntergalaticString rhs = (IntergalaticString) obj;
    return new EqualsBuilder().append(m_literalList, rhs.m_literalList).isEquals();
  }
}
