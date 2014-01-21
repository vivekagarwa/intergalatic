package com.thoughtworks.query.intergalaticCommodity;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.commodity.CommodityPricing;
import com.thoughtworks.intergalaticUnit.toDecimal.IntergalaticStringToDecimalConverter;
import com.thoughtworks.intergalaticUnit.toString.IntergalaticStringToStringConverter;

@Singleton
public class CommodityPriceQueryHandler {

  private final CommodityPricing m_commodityPricing;
  private final IntergalaticStringToDecimalConverter m_intergalaticStringToDecimalConverter;
  private final IntergalaticStringToStringConverter m_intergalaticToStringConverter;

  @Inject
  public CommodityPriceQueryHandler(CommodityPricing commodityPricing,
          IntergalaticStringToStringConverter intergalaticToStringConverter,
          IntergalaticStringToDecimalConverter intergalaticStringToDecimalConverter) {
    m_commodityPricing = commodityPricing;
    m_intergalaticToStringConverter = intergalaticToStringConverter;
    m_intergalaticStringToDecimalConverter = intergalaticStringToDecimalConverter;
  }

  public String handle(CommodityPriceQuery commodityPriceQuery) {
    String totalPrice = getTotalPrice(commodityPriceQuery);
    String intergalaticString = m_intergalaticToStringConverter.getVal(commodityPriceQuery
            .getUnits());
    return String.format("%s %s is %s Credits", intergalaticString, commodityPriceQuery
            .getCommodity().getId(), totalPrice);
  }

  private String getTotalPrice(CommodityPriceQuery commodityPriceQuery) {
    double price = m_commodityPricing.getPrice(commodityPriceQuery.getCommodity());
    int units = m_intergalaticStringToDecimalConverter.getVal(commodityPriceQuery.getUnits());
    double totalPriceInDouble = price * units;
    int totalPriceInInteger = (int) totalPriceInDouble;
    String totalPrice = totalPriceInDouble == totalPriceInInteger ? String
            .valueOf(totalPriceInInteger) : String.valueOf(totalPriceInDouble);
    return totalPrice;
  }
}
