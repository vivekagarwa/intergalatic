package com.thoughtworks;

public class Pair<F, S> {

  private final F m_first;
  private final S m_second;

  public Pair(F first, S second) {
    m_first = first;
    m_second = second;
  }

  public F getFirst() {
    return m_first;
  }

  public S getSecond() {
    return m_second;
  }
  
}
