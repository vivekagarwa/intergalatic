package com.thoughtworks.query.intergalaticCommodity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.thoughtworks.commodity.Commodity;
import com.thoughtworks.intergalaticUnit.IntergalaticString;

public class CommodityPriceResponse {

  private final Commodity m_commodity;
  private final IntergalaticString m_units;
  private final double m_totalPrice;

  private CommodityPriceResponse(Commodity commodity, IntergalaticString units, double m_totalPrice) {
    m_commodity = commodity;
    m_units = units;
    this.m_totalPrice = m_totalPrice;
  }

  public Commodity getCommodity() {
    return m_commodity;
  }

  public IntergalaticString getUnits() {
    return m_units;
  }

  public double getTotalPrice() {
    return m_totalPrice;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_commodity).append(m_units).append(m_totalPrice)
            .toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof CommodityPriceResponse))
      return false;

    CommodityPriceResponse rhs = (CommodityPriceResponse) obj;
    return new EqualsBuilder().append(m_commodity, rhs.m_commodity).append(m_units, rhs.m_units)
            .append(m_totalPrice, rhs.m_totalPrice).isEquals();
  }

  public static Builder newBuilder() {
    return new Builder();
  }

  public static class Builder {

    private Commodity m_commodity_;
    private IntergalaticString m_units_;
    private double m_totalPrice_;

    private Builder() {
    }

    public Builder setCommodity(Commodity commodity) {
      m_commodity_ = commodity;
      return this;
    }

    public Builder setUnits(IntergalaticString units) {
      m_units_ = units;
      return this;
    }

    public Builder setTotalPrice(double totalPrice) {
      m_totalPrice_ = totalPrice;
      return this;
    }

    public CommodityPriceResponse build() {
      return new CommodityPriceResponse(m_commodity_, m_units_, m_totalPrice_);
    }

  }

}
