package com.thoughtworks.commodity;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.ParserProvider;
import com.thoughtworks.ParserProvider.Parser;
import com.thoughtworks.intergalaticUnit.IntergalaticString;
import com.thoughtworks.intergalaticUnit.toDecimal.IntergalaticStringToDecimalConverter;

@Singleton
public class CommodityPriceParser {

  private final IntergalaticStringToDecimalConverter m_intergalaticStringToDecimalConverter;
  private final ParserProvider m_parserProvider;

  @Inject
  public CommodityPriceParser(
          IntergalaticStringToDecimalConverter intergalaticStringToDecimalConverter,
          ParserProvider parserProvider) {
    m_intergalaticStringToDecimalConverter = intergalaticStringToDecimalConverter;
    m_parserProvider = parserProvider;
  }

  public CommodityPrice parse(String statement) {
    Parser parser = m_parserProvider.createNewParser(statement);
    IntergalaticString intergalaticString = parser.getIntergalaticString();
    if (intergalaticString == null) {
      return null;
    }
    String commodityName = parser.getNextWord();
    if (commodityName == null) {
      return null;
    }
    if (!"is".equals(parser.getNextWord())) {
      return null;
    }
    Double price = convertToDouble(parser.getNextWord());
    if (price == null) {
      return null;
    }
    if (!"Credits".equals(parser.getNextWord())) {
      return null;
    }
    if (!parser.isCompletlyCovered()) {
      return null;
    }
    int unit = m_intergalaticStringToDecimalConverter.getVal(intergalaticString);
    double pricePerUnit = price / unit;
    Commodity commodity = new Commodity(commodityName);
    return new CommodityPrice(commodity, pricePerUnit);
  }

  private Double convertToDouble(String priceString) {
    if (priceString == null) {
      return null;
    }
    try {
      return Double.parseDouble(priceString);
    } catch (NumberFormatException e) {
      return null;
    }
  }
}
