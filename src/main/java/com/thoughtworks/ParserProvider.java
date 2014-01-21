package com.thoughtworks;

import java.util.List;

import com.google.common.base.Preconditions;
import com.google.common.collect.Lists;
import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticString;
import com.thoughtworks.intergalaticUnit.IntergalaticStringParser;

@Singleton
public class ParserProvider {

  private final IntergalaticStringParser m_intergalaticStringParser;

  @Inject
  public ParserProvider(IntergalaticStringParser intergalaticStringParser) {
    m_intergalaticStringParser = intergalaticStringParser;
  }

  public class Parser {

    private final List<String> m_wordList;
    private int index = -1;

    public Parser(String statement) {
      Preconditions.checkNotNull(statement);
      m_wordList = Lists.newArrayList(statement.split(" "));
      m_wordList.removeAll(Lists.newArrayList(""));
    }

    public String getNextWord() {
      ++index;
      if (index >= m_wordList.size()) {
        return null;
      }
      return m_wordList.get(index);
    }
    
    public boolean isCompletlyCovered() {
      return index + 1 == m_wordList.size();
    }

    public IntergalaticString getIntergalaticString() {
      ++index;
      List<String> list = m_wordList.subList(index, m_wordList.size());
      Pair<IntergalaticString, Integer> pair = m_intergalaticStringParser
              .parseIntergalaticString(list);
      if (pair == null) {
        --index;
        return null;
      }
      index += pair.getSecond();
      return pair.getFirst();
    }
  }

  public Parser createNewParser(String statement) {
    return new Parser(statement);
  }

}