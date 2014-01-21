package com.thoughtworks.intergalaticUnit;

import com.google.inject.Inject;
import com.google.inject.Singleton;
import com.thoughtworks.intergalaticUnit.toRoman.IntergalaticStringToRomanConverter;

@Singleton
public class IntergalaticStringVerifier {

  private final IntergalaticStringToRomanConverter m_romanConverter;

  @Inject
  public IntergalaticStringVerifier(IntergalaticStringToRomanConverter romanConverter) {
    m_romanConverter = romanConverter;
  }

  public boolean isVerified(IntergalaticString intergalaticString) {
    try {
      m_romanConverter.getVal(intergalaticString);
      return true;
    } catch (IllegalArgumentException e) {
      return false;
    } catch (IllegalStateException e) {
      return false;
    }
  }

}
