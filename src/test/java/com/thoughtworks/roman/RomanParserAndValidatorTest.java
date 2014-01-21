package com.thoughtworks.roman;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class RomanParserAndValidatorTest {

  private static RomanParserAndValidator m_romanParserAndValidator;
  private static RomanStringToDecimalConverter m_romanStringToDecimalConverter;

  @BeforeClass
  public static void setUpBeforeClass() throws Exception {
    Injector injector = Guice.createInjector();
    m_romanParserAndValidator = injector.getInstance(RomanParserAndValidator.class);
    m_romanStringToDecimalConverter = injector.getInstance(RomanStringToDecimalConverter.class);
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
  public final void testParseAndValidateString() {
    String romanNumeral = "MDXLIII";
    RomanString romanString = m_romanParserAndValidator.parseAndValidate(romanNumeral);
    assertEquals("MDXLIII should be 1543", 1543,
            m_romanStringToDecimalConverter.convert(romanString));
  }

  @Test(expected = IllegalStateException.class)
  public final void testParseAndValidateSuccessionException() {
    String romanNumeral = "IIII";
    m_romanParserAndValidator.parseAndValidate(romanNumeral);
  }

  @Test(expected = IllegalStateException.class)
  public final void testParseAndValidateOrderException() {
    String romanNumeral = "IVX";
    m_romanParserAndValidator.parseAndValidate(romanNumeral);
  }

  @Test(expected = IllegalStateException.class)
  public final void testParseAndValidateAllowedSubtractException() {
    String romanNumeral = "ID";
    m_romanParserAndValidator.parseAndValidate(romanNumeral);
  }

  @Test(expected = IllegalStateException.class)
  public final void testParseAndValidateConsequtiveSubtractException() {
    String romanNumeral = "IIV";
    m_romanParserAndValidator.parseAndValidate(romanNumeral);
  }
}
