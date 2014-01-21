package com.thoughtworks.roman;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.thoughtworks.InputTypeParser;

public class SampleTestCase {

  private static InputTypeParser m_inputTypeParser;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Injector injector = Guice.createInjector();
    m_inputTypeParser = injector.getInstance(InputTypeParser.class);
  }

  @AfterClass
  public static void tearDownAfterClass() throws Exception {
  }

  @Before
  public void setUp() throws Exception {
  }

  @After
  public void tearDown() throws Exception {
  }

  @Test
  public final void testParseAndHandleStatement() {
    String resp = "";
    resp = m_inputTypeParser.parseAndHandleStatement("glob is I");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("prok is V");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("pish is X");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("tegj is L");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("glob glob Silver is 34 Credits");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("glob prok Gold is 57800 Credits");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("pish pish Iron is 3910 Credits");
    assertEquals("", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("how much is pish tegj glob glob ?");
    assertEquals("pish tegj glob glob is 42", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("how many Credits is glob prok Silver ?");
    assertEquals("glob prok Silver is 68 Credits", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("how many Credits is glob prok Gold ?");
    assertEquals("glob prok Gold is 57800 Credits", resp);
    resp = m_inputTypeParser.parseAndHandleStatement("how many Credits is glob prok Iron ?");
    assertEquals("glob prok Iron is 782 Credits", resp);
    resp = m_inputTypeParser
            .parseAndHandleStatement("how much wood could a woodchuck chuck if a woodchuck could chuck wood ?");
    assertEquals("I have no idea what you are talking about", resp);
  }

}
