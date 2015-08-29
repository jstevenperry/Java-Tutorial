package com.makotojava.intro;

import java.util.logging.Logger;

public class HumanResourcesApplication {
  private static final Logger log = Logger.getLogger(HumanResourcesApplication.class.getName());

  public static void main(String[] args) {
    Employee e = new Employee();
    e.setName("J Smith");
    e.setEmployeeNumber("0001");
    e.setTaxpayerIdentificationNumber("123-45-6789");
    e.printAudit(log);
  }
  
  public boolean load(Person prototype) {
    return false;
  }
  
  public boolean save(Person objectToSave) {
    return false;
  }
}
