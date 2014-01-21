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
    CommodityPriceResponse resp = createResponse(commodityPriceQuery);
    String intergalaticString = m_intergalaticToStringConverter.getVal(resp.getUnits());
    double totalPriceInDouble = resp.getTotalPrice();
    int totalPriceInInteger = (int) totalPriceInDouble;
    String totalPrice = totalPriceInDouble == totalPriceInInteger ? String
            .valueOf(totalPriceInInteger) : String.valueOf(totalPriceInDouble);
    return String.format("%s %s is %s Credits", intergalaticString, resp.getCommodity().getId(),
            totalPrice);
  }

  private CommodityPriceResponse createResponse(CommodityPriceQuery commodityPriceQuery) {
    double price = m_commodityPricing.getPrice(commodityPriceQuery.getCommodity());
    int units = m_intergalaticStringToDecimalConverter.getVal(commodityPriceQuery.getUnits());
    CommodityPriceResponse.Builder builder = CommodityPriceResponse.newBuilder();
    builder.setCommodity(commodityPriceQuery.getCommodity());
    builder.setUnits(commodityPriceQuery.getUnits());
    builder.setTotalPrice(price * units);
    return builder.build();
  }

}
