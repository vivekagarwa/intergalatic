package com.thoughtworks.commodity;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;

@Singleton
public class CommodityPricing {

  private final Map<Commodity, CommodityPrice> m_map = Maps.newHashMap();

  public double getPrice(Commodity commodity) {
    return m_map.get(commodity).getPrice();
  }

  public boolean isAlreadyPresent(CommodityPrice commodity) {
    return m_map.containsKey(commodity.getCommodity());
  }
  
  boolean addRule(CommodityPrice commodityPrice) {
    Preconditions.checkNotNull(commodityPrice);
    if(isAlreadyPresent(commodityPrice)) {
      return false;
    }
    m_map.put(commodityPrice.getCommodity(), commodityPrice);
    return true;
  }
  
}
