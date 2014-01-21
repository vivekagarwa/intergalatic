package com.thoughtworks;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.commodity.CommodityPrice;
import com.thoughtworks.commodity.CommodityPriceHandler;
import com.thoughtworks.commodity.CommodityPriceParser;
import com.thoughtworks.intergalaticUnit.IntergalaticToRomanConversion;
import com.thoughtworks.intergalaticUnit.IntergalaticUnitQuery;
import com.thoughtworks.intergalaticUnit.toRoman.IntergalaticUnitToRomanHandler;
import com.thoughtworks.intergalaticUnit.toRoman.IntergalaticUnitToRomanParser;
import com.thoughtworks.query.intergalaticCommodity.CommodityPriceQuery;
import com.thoughtworks.query.intergalaticCommodity.CommodityPriceQueryHandler;
import com.thoughtworks.query.intergalaticCommodity.CommodityPriceQueryParser;
import com.thoughtworks.query.intergalaticToRoman.IntergalaticUnitQueryHandler;
import com.thoughtworks.query.intergalaticToRoman.IntergalaticUnitQueryParser;

@Singleton
public class InputTypeParser {

  private final IntergalaticUnitToRomanParser m_intergalaticUnitToRomanParser;
  private final IntergalaticUnitToRomanHandler m_intergalaticUnitToRomanHandler;

  private final CommodityPriceParser m_commodityPriceParser;
  private final CommodityPriceHandler m_commodityPriceHandler;

  private final IntergalaticUnitQueryParser m_intergalaticUnitQueryParser;
  private final IntergalaticUnitQueryHandler m_intergalaticUnitQueryHandler;

  private final CommodityPriceQueryParser m_commodityPriceQueryParser;
  private final CommodityPriceQueryHandler m_commodityPriceQueryHandler;

  @Inject
  public InputTypeParser(IntergalaticUnitToRomanParser intergalaticUnitToRomanParser,
          IntergalaticUnitToRomanHandler intergalaticUnitToRomanHandler,
          CommodityPriceParser commodityPriceParser,
          CommodityPriceHandler commodityPriceHandler,
          IntergalaticUnitQueryParser intergalaticUnitQueryParser,
          IntergalaticUnitQueryHandler intergalaticUnitQueryHandler,
          CommodityPriceQueryParser commodityPriceQueryParser,
          CommodityPriceQueryHandler commodityPriceQueryHandler) {
    m_intergalaticUnitToRomanParser = intergalaticUnitToRomanParser;
    m_intergalaticUnitToRomanHandler = intergalaticUnitToRomanHandler;
    m_commodityPriceParser = commodityPriceParser;
    m_commodityPriceHandler = commodityPriceHandler;
    m_intergalaticUnitQueryParser = intergalaticUnitQueryParser;
    m_intergalaticUnitQueryHandler = intergalaticUnitQueryHandler;
    m_commodityPriceQueryParser = commodityPriceQueryParser;
    m_commodityPriceQueryHandler = commodityPriceQueryHandler;
  }

  public String parseAndHandleStatement(String statement) {
    IntergalaticToRomanConversion intergalaticToRomanConversion = m_intergalaticUnitToRomanParser
            .create(statement);
    if (intergalaticToRomanConversion != null) {
      return m_intergalaticUnitToRomanHandler.handle(intergalaticToRomanConversion);
    }

    CommodityPrice commodityPrice = m_commodityPriceParser.parse(statement);
    if (commodityPrice != null) {
      return m_commodityPriceHandler.handle(commodityPrice);
    }

    IntergalaticUnitQuery intergalaticUnitQuery = m_intergalaticUnitQueryParser
            .getIntergalaticUnitQuery(statement);
    if (intergalaticUnitQuery != null) {
      return m_intergalaticUnitQueryHandler.handle(intergalaticUnitQuery);
    }

    CommodityPriceQuery commodityPriceQuery = m_commodityPriceQueryParser
            .getCommodityPriceQuery(statement);
    if (commodityPriceQuery != null) {
      return m_commodityPriceQueryHandler.handle(commodityPriceQuery);
    }

    return "I have no idea what you are talking about";
  }
}
