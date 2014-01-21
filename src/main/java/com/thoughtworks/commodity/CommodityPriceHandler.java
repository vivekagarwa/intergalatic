package com.thoughtworks.commodity;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class CommodityPriceHandler {

  private final CommodityLiterals m_literals;
  private final CommodityPricing m_commodityPricing;

  @Inject
  public CommodityPriceHandler(CommodityLiterals literals, CommodityPricing commodityPricing) {
    m_literals = literals;
    m_commodityPricing = commodityPricing;
  }

  public String handle(CommodityPrice commodityPrice) {
    if (!m_literals.addCommodity(commodityPrice.getCommodity())) {
      return commodityPrice.getCommodity().getId() + " commodity has already been defined";
    }
    if (!m_commodityPricing.addRule(commodityPrice)) {
      return commodityPrice.getCommodity().getId() + " commodity has already been priced";
    }
    return "";
  }
}