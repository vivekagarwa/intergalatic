package com.thoughtworks.intergalaticUnit;

import java.util.List;

import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.Pair;

@Singleton
public class IntergalaticStringParser {

  private final IntergalaticLiterals m_intergalaticLiterals;
  private final IntergalaticStringVerifier m_intergalaticStringVerifier;

  @Inject
  public IntergalaticStringParser(IntergalaticLiterals intergalaticLiterals,
          IntergalaticStringVerifier intergalaticStringVerifier) {
    m_intergalaticLiterals = intergalaticLiterals;
    m_intergalaticStringVerifier = intergalaticStringVerifier;
  }

  public Pair<IntergalaticString, Integer> parseIntergalaticString(List<String> wordList) {
    int i = 0;
    List<IntergalaticLiteral> m_intergalaticLiteralList = Lists.newArrayList();
    for (i = 0; i < wordList.size(); i++) {
      String word = wordList.get(i);
      IntergalaticLiteral intergalaticUnit = m_intergalaticLiterals.getIntergalaticLiteral(word);
      if (intergalaticUnit == null) {
        break;
      }
      m_intergalaticLiteralList.add(intergalaticUnit);
    }
    IntergalaticString intergalaticString = create(m_intergalaticLiteralList);
    if (intergalaticString == null) {
      return null;
    }
    return new Pair<IntergalaticString, Integer>(intergalaticString, i-1);
  }

  private IntergalaticString create(List<IntergalaticLiteral> intergalaticLiteralList) {
    IntergalaticString.Builder builder = IntergalaticString.newBuilder();
    builder.addAllLiteral(intergalaticLiteralList);
    IntergalaticString intergalaticString = builder.build();
    if (m_intergalaticStringVerifier.isVerified(intergalaticString)) {
      return intergalaticString;
    } 
    return null;
  }
}
