package com.thoughtworks.commodity;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;

@Singleton
public class CommodityLiterals {

  private final Map<String, Commodity> m_map = Maps.newHashMap();

  public Commodity getCommodity(String commodityId) {
    return m_map.get(commodityId);
  }

  public boolean isAlreadyPresent(Commodity commodity) {
    return m_map.containsKey(commodity.getId());
  }
  
  boolean addCommodity(Commodity commodity) {
    Preconditions.checkNotNull(commodity);
    if(isAlreadyPresent(commodity)) {
      return false;
    }
    m_map.put(commodity.getId(), commodity);
    return true;
  }

}
