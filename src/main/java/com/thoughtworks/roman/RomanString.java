package com.thoughtworks.roman;

import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.google.common.collect.Lists;

public class RomanString {

  private final List<CompositeRomanLiteral> m_compositeList;

  private RomanString(List<CompositeRomanLiteral> compositeList) {
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

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private List<CompositeRomanLiteral> m_compositeList_;

    private Builder() {
      m_compositeList_ = Lists.newArrayList();
    }

    public Builder addComposite(CompositeRomanLiteral composite) {
      m_compositeList_.add(composite);
      return this;
    }

    public Builder setCompositeList(List<CompositeRomanLiteral> compositeList) {
      m_compositeList_.clear();
      addAllComposite(compositeList);
      return this;
    }

    public void addAllComposite(List<CompositeRomanLiteral> compositeList) {
      compositeList.addAll(Lists.newArrayList(compositeList));
    }

    public RomanString build() {
      return new RomanString(m_compositeList_);
    }

  }

}
