package com.makotojava.intro;

import java.math.BigDecimal;
import java.util.logging.Logger;

import org.junit.Test;

public class SimpleListTest {

  @Test
  public void testAdd() {
    Logger log = Logger.getLogger(SimpleListTest.class.getName());
    
    SimpleList<BigDecimal> sl = new SimpleList<BigDecimal>();
    sl.add(BigDecimal.ONE);
    log.info("SimpleList size is : " + sl.size());
    sl.add(BigDecimal.ZERO);
    log.info("SimpleList size is : " + sl.size());
    sl.clear();
    log.info("SimpleList size is : " + sl.size());
  }

}
