package com.makotojava.intro;

import java.math.BigDecimal;
import java.util.logging.Logger;

public class Manager extends Employee implements StockOptionEligible {

  private static final Logger log = Logger.getLogger(Manager.class.getName());

  public static void main(String[] args) {
    StockOptionEligible soe = new Manager();
    calculateAndAwardStockOptions(soe);
  }

  public static void calculateAndAwardStockOptions(StockOptionEligible soe) {
    BigDecimal reallyCheapPrice = BigDecimal.valueOf(0.01);
    log.info("Strike price is $" + reallyCheapPrice.toPlainString());
    int numberOfOptions = 10000;
    soe.awardStockOptions(numberOfOptions, reallyCheapPrice);
  }

  @Override
  public void awardStockOptions(int number, BigDecimal price) {
    log.info("I can't believe I got " + number + " options at $" + price.toPlainString() + "!");
  }

}
