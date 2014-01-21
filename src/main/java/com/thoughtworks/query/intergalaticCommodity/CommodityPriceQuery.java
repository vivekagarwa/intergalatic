package com.thoughtworks.query.intergalaticCommodity;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import com.thoughtworks.commodity.Commodity;
import com.thoughtworks.intergalaticUnit.IntergalaticString;

public class CommodityPriceQuery {

  private final Commodity m_commodity;
  private final IntergalaticString m_units;

  public CommodityPriceQuery(Commodity commodity, IntergalaticString units) {
    m_commodity = commodity;
    m_units = units;
  }

  public Commodity getCommodity() {
    return m_commodity;
  }

  public IntergalaticString getUnits() {
    return m_units;
  }

  public int hashCode() {
    return new HashCodeBuilder(17, 31).append(m_commodity).append(m_units).toHashCode();
  }

  public boolean equals(Object obj) {
    if (obj == null)
      return false;
    if (obj == this)
      return true;
    if (!(obj instanceof CommodityPriceQuery))
      return false;

    CommodityPriceQuery rhs = (CommodityPriceQuery) obj;
    return new EqualsBuilder().append(m_commodity, rhs.m_commodity).append(m_units, rhs.m_units)
            .isEquals();
  }

}
