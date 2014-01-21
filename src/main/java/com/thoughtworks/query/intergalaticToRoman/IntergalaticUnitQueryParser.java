package com.thoughtworks.query.intergalaticToRoman;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.ParserProvider;
import com.thoughtworks.ParserProvider.Parser;
import com.thoughtworks.intergalaticUnit.IntergalaticString;
import com.thoughtworks.intergalaticUnit.IntergalaticUnitQuery;

@Singleton
public class IntergalaticUnitQueryParser {

  private final ParserProvider m_parserProvider;

  @Inject
  public IntergalaticUnitQueryParser(ParserProvider intergalaticStringParser) {
    m_parserProvider = intergalaticStringParser;
  }

  public IntergalaticUnitQuery getIntergalaticUnitQuery(String statement) {
    Parser parser = m_parserProvider.createNewParser(statement);
    if (!"how".equals(parser.getNextWord())) {
      return null;
    }
    if (!"much".equals(parser.getNextWord())) {
      return null;
    }
    if (!"is".equals(parser.getNextWord())) {
      return null;
    }
    IntergalaticString intergalaticString = parser.getIntergalaticString();
    if (intergalaticString == null) {
      return null;
    }
    if (!"?".equals(parser.getNextWord())) {
      return null;
    }
    if (!parser.isCompletlyCovered()) {
      return null;
    }
    return create(intergalaticString);
  }
  
  private IntergalaticUnitQuery create(IntergalaticString intergalaticString) {
    IntergalaticUnitQuery.Builder builder = IntergalaticUnitQuery.newBuilder();
    builder.setUnits(intergalaticString);
    return builder.build();
  }

}
