package com.thoughtworks.intergalaticUnit.toRoman;

import java.util.Map;

import com.google.common.base.Preconditions;
import com.google.common.collect.Maps;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.IntergalaticLiteral;
import com.thoughtworks.intergalaticUnit.IntergalaticToRomanConversion;
import com.thoughtworks.roman.RomanLiteral;

@Singleton
public class IntergalaticUnitToRomanConversionRules {

  private final Map<IntergalaticLiteral, IntergalaticToRomanConversion> m_list = Maps.newHashMap();
  
  boolean addRule(IntergalaticToRomanConversion intergalaticToRomanRules) {
    Preconditions.checkNotNull(intergalaticToRomanRules);
    if(isAlreadyPresent(intergalaticToRomanRules.getIntergalatic())) {
      return false;
    }
    m_list.put(intergalaticToRomanRules.getIntergalatic(), intergalaticToRomanRules);
    return true;    
  }
  
  public boolean isAlreadyPresent(IntergalaticLiteral intergalatic) {
    return m_list.containsKey(intergalatic);
  }
  
  public RomanLiteral getRomanLiteral(IntergalaticLiteral intergalaticLiteral) {
    return m_list.get(intergalaticLiteral).getRoman();
  }
  
}
