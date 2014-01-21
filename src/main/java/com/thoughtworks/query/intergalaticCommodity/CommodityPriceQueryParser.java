package com.thoughtworks.query.intergalaticCommodity;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.ParserProvider;
import com.thoughtworks.ParserProvider.Parser;
import com.thoughtworks.commodity.Commodity;
import com.thoughtworks.commodity.CommodityLiterals;
import com.thoughtworks.intergalaticUnit.IntergalaticString;

@Singleton
public class CommodityPriceQueryParser {

  private final ParserProvider m_parserProvider;
  private final CommodityLiterals m_commodityLiteral;

  @Inject
  public CommodityPriceQueryParser(ParserProvider parserProvider,
          CommodityLiterals commodityLiteral) {
    m_parserProvider = parserProvider;
    m_commodityLiteral = commodityLiteral;
  }
  
  public CommodityPriceQuery getCommodityPriceQuery(String statement) {
    Parser parser = m_parserProvider.createNewParser(statement);
    if (!"how".equals(parser.getNextWord())) {
      return null;
    }
    if (!"many".equals(parser.getNextWord())) {
      return null;
    }
    if (!"Credits".equals(parser.getNextWord())) {
      return null;
    }
    if (!"is".equals(parser.getNextWord())) {
      return null;
    }
    IntergalaticString intergalaticString = parser.getIntergalaticString();
    if (intergalaticString == null) {
      return null;
    }
    String probableCommodityName = parser.getNextWord();
    Commodity commodity = m_commodityLiteral.getCommodity(probableCommodityName);
    if (commodity == null) {
      return null;
    }
    if (!"?".equals(parser.getNextWord())) {
      return null;
    }
    if (!parser.isCompletlyCovered()) {
      return null;
    }
    return createCommodityPriceQuery(intergalaticString, commodity);
  }
  
  private CommodityPriceQuery createCommodityPriceQuery(IntergalaticString intergalaticString,
          Commodity commodity) {
    CommodityPriceQuery.Builder builder = CommodityPriceQuery.newBuilder();
    builder.setCommodity(commodity);
    builder.setUnits(intergalaticString);
    return builder.build();
  }

}
