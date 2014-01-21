package com.thoughtworks.intergalaticUnit;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;

@Singleton
public class IntergalaticLiterals {

  private final Map<String, IntergalaticLiteral> m_map = Maps.newHashMap();

  public IntergalaticLiteral getIntergalaticLiteral(String intergalaticLiteral) {
    return m_map.get(intergalaticLiteral);
  }

  public boolean isAlreadyPresent(IntergalaticLiteral intergalatic) {
    return m_map.containsKey(intergalatic.getName());
  }
  
  public boolean addIntergalaticLiteral(IntergalaticLiteral intergalatic) {
    Preconditions.checkNotNull(intergalatic);
    if(isAlreadyPresent(intergalatic)) {
      return false;
    }
    m_map.put(intergalatic.getName(), intergalatic);
    return true;
  }
}
