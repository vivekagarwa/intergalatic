package com.thoughtworks.commodity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class CommodityPrice {

  private final Commodity m_commodity;
  private final double m_price;

  private CommodityPrice(Commodity commodity, double price) {
    m_commodity = commodity;
    m_price = price;
  }

  public Commodity getCommodity() {
    return m_commodity;
  }

  public double getPrice() {
    return m_price;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_commodity).append(m_price).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof CommodityPrice))
      return false;

    CommodityPrice rhs = (CommodityPrice) obj;
    return new EqualsBuilder().append(m_commodity, rhs.m_commodity).append(m_price, rhs.m_price)
            .isEquals();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private Commodity m_commodity_;
    private double m_price_;

    private Builder() {
    }

    public Builder setCommodity(Commodity commodity) {
      m_commodity_ = commodity;
      return this;
    }

    public Builder setPrice(double price) {
      m_price_ = price;
      return this;
    }

    public CommodityPrice build() {
      return new CommodityPrice(m_commodity_, m_price_);
    }

  }

}
