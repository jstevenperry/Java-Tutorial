package com.makotojava.intro;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.math.BigDecimal;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class HumanResourcesApplicationTest {
  
  private HumanResourcesApplication classUnderTest;
  
  private List<Employee> testData;
  
  @Before
  public void setUp() {
    classUnderTest = new HumanResourcesApplication();
    testData = HumanResourcesApplication.createEmployees();
  }
  
  @After
  public void tearDown() {
    classUnderTest = null;
    testData.clear();
    testData = null;
  }

  @Test
  public void testSerializeToDisk() {
    String filename = "employees-Junit-" + System.currentTimeMillis() + ".ser";
    boolean status = classUnderTest.serializeToDisk(filename, testData);
    assertTrue(status);
  }

  @Test
  public void testSaveToDisk() {
    String filename = "employees-Junit-" + System.currentTimeMillis() + ".txt";
    boolean status = classUnderTest.saveToDisk(filename, testData);
    assertTrue(status);
  }

  @Test
  public void testReadFromDisk() {
    String filename = "employees-Junit-" + System.currentTimeMillis() + ".txt";
    int expectedNumberOfObjects = testData.size();
    classUnderTest.saveToDisk(filename, testData);
    List<Employee> employees = classUnderTest.readFromDisk(filename);
    assertEquals(expectedNumberOfObjects, employees.size());
  }

  @Test
  public void testReadFromDiskBuffered() {
    String filename = "employees-Junit-" + System.currentTimeMillis() + ".txt";
    int expectedNumberOfObjects = testData.size();
    classUnderTest.saveToDisk(filename, testData);
    List<Employee> employees = classUnderTest.readFromDiskBuffered(filename);
    assertEquals(expectedNumberOfObjects, employees.size());
  }

  @Test
  public void testDeserializeFromDisk() {
    String filename = "employees-Junit-" + System.currentTimeMillis() + ".ser";
    int expectedNumberOfObjects = testData.size();
    classUnderTest.serializeToDisk(filename, testData);
    List<Employee> employees = classUnderTest.deserializeFromDisk(filename);
    assertEquals(expectedNumberOfObjects, employees.size());
  }
  
  @Test
  public void testHandleStockOptions() {
    List<Person> people = HumanResourcesApplication.createPeople();
    StockOptionProcessingCallback callback = new StockOptionProcessingCallback() {
      @Override
      public void process(StockOptionEligible stockOptionEligible) {
        BigDecimal reallyCheapPrice = BigDecimal.valueOf(0.01);
        int numberOfOptions = 10000;
        stockOptionEligible.awardStockOptions(numberOfOptions, reallyCheapPrice);
      }
    };
    for (Person person : people) {
      classUnderTest.handleStockOptions(person, callback);
    }
  }

}
