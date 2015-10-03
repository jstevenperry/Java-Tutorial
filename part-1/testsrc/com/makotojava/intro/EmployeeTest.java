package com.makotojava.intro;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Logger;

import org.junit.Test;

public class EmployeeTest {

  @Test
  public void test() {
    int int1 = 1;
    int int2 = 1;
    Logger l = Logger.getLogger(EmployeeTest.class.getName());
    
    l.info("Q: int1 == int2?           A: " + (int1 == int2));
    Integer integer1 = Integer.valueOf(int1);
    Integer integer2 = Integer.valueOf(int2);
    l.info("Q: Integer1 == Integer2?   A: " + (integer1 == integer2));
    integer1 = new Integer(int1);
    integer2 = new Integer(int2);
    l.info("Q: Integer1 == Integer2?   A: " + (integer1 == integer2));
    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
    l.info("Q: Employee1 == Employee2? A: " + (employee1 == employee2));
  }
  
  @Test
  public void anotherTest() {
    Logger l = Logger.getLogger(Employee.class.getName());
    Integer integer1 = Integer.valueOf(1);
    Integer integer2 = Integer.valueOf(1);
    l.info("Q: integer1 == integer2 ? A: " + (integer1 == integer2));
    l.info("Q: integer1.equals(integer2) ? A: " + integer1.equals(integer2));
    integer1 = new Integer(integer1);
    integer2 = new Integer(integer2);
    l.info("Q: integer1 == integer2 ? A: " + (integer1 == integer2));
    l.info("Q: integer1.equals(integer2) ? A: " + integer1.equals(integer2));
    Employee employee1 = new Employee();
    Employee employee2 = new Employee();
    l.info("Q: employee1 == employee2 ? A: " + (employee1 == employee2));
    l.info("Q: employee1.equals(employee2) ? A : " + employee1.equals(employee2));
  }
  
  @Test
  public void yetAnotherTest() {
    Logger l = Logger.getLogger(Employee.class.getName());
    Employee employee1 = new Employee();
    try {
      // Uncomment for tutorial NPE example
//      Employee employee1 = null;
      employee1.setName("J Smith");
      Employee employee2 = new Employee();
      employee2.setName("J Smith");
      l.info("Q: employee1 == employee2?      A: " + (employee1 == employee2));
      l.info("Q: employee1.equals(employee2)? A: " + employee1.equals(employee2));
    } catch (Exception e) {
      l.severe("Caught exception: " + e.getMessage());
    } finally {
      // Always executes
    }
  }
  
  @Test
  public void exceptionTest() {
    Logger l = Logger.getLogger(Employee.class.getName());
    File file = new File("file.txt");
    BufferedReader bufferedReader = null;
    try {
      bufferedReader = new BufferedReader(new FileReader(file));
      String line = bufferedReader.readLine();
      while (line != null) {
        // Read the file
      }
    } catch (FileNotFoundException e) {
      l.severe(e.getMessage());
    } catch (IOException e) {
      l.severe(e.getMessage());
    } catch (Exception e) {
      l.severe(e.getMessage());
    } finally {
      // Close the reader
    }
  }
  
  @Test
  public void exceptionTestTryWithResources() {
    Logger l = Logger.getLogger(Employee.class.getName());
    File file = new File("file.txt");
      try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file))) {
        String line = bufferedReader.readLine();
        while (line != null) {
          // Read the file
        }
      } catch (Exception e) {
        l.severe(e.getMessage());
      }
  }
  
}
