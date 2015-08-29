package com.makotojava.intro;

import java.math.BigDecimal;
import java.util.Comparator;
import java.util.logging.Logger;

public class Employee extends Person {

  private String taxpayerIdentificationNumber;
  private String employeeNumber;
  private BigDecimal salary;

  public Employee() {
    super("name", 10, 10, 10, "eue", "male");
    super.printAudit(Logger.getLogger("goo"));
  }

  public String getTaxpayerIdentificationNumber() {
    return taxpayerIdentificationNumber;
  }

  public void setTaxpayerIdentificationNumber(String taxpayerIdentificationNumber) {
    this.taxpayerIdentificationNumber = taxpayerIdentificationNumber;
  }

  public String getEmployeeNumber() {
    return employeeNumber;
  }

  public void setEmployeeNumber(String employeeNumber) {
    this.employeeNumber = employeeNumber;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }

  @Override
  public void printAudit(StringBuilder buffer) {
    // Now format this instance's values
    buffer.append(toString());
  }

  private static Logger logger;// = Logger.getLogger(Employee.class.getName());

  public static void main(String[] args) {

    try {
      Employee employee1 = new Employee();
      employee1.setName("J Smith");
      Employee employee2 = new Employee();
      employee2.setName("J Smith");
      logger.info("Q: employee1 == employee2?      A: " + (employee1 == employee2));
      logger.info("Q: employee1.equals(employee2)? A: " + employee1.equals(employee2));
    } catch (NullPointerException npe) {
      // Handle...
      System.out.println("Yuck! Outputting a message with System.out.println() " +
          "because the developer did something dumb!");
    } catch (Exception npe) {
      // Handle...
      System.out.println("Yuck! Outputting a message with System.out.println() " +
          "because the developer did something dumb!");
    }

  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = super.hashCode();
    result = prime * result
        + ((employeeNumber == null) ? 0 : employeeNumber.hashCode());
    result = prime * result + ((salary == null) ? 0 : salary.hashCode());
    result = prime
        * result
        + ((taxpayerIdentificationNumber == null) ? 0
            : taxpayerIdentificationNumber.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj)
      return true;
    if (!super.equals(obj))
      return false;
    if (getClass() != obj.getClass())
      return false;
    Employee other = (Employee) obj;
    if (employeeNumber == null) {
      if (other.employeeNumber != null)
        return false;
    } else if (!employeeNumber.equals(other.employeeNumber))
      return false;
    if (salary == null) {
      if (other.salary != null)
        return false;
    } else if (!salary.equals(other.salary))
      return false;
    if (taxpayerIdentificationNumber == null) {
      if (other.taxpayerIdentificationNumber != null)
        return false;
    } else if (!taxpayerIdentificationNumber
        .equals(other.taxpayerIdentificationNumber))
      return false;
    return true;
  }

  @Override
  public String toString() {
    return super.toString() +
        "Employee [employeeNumber=" + employeeNumber + ", salary=" + salary
        + ", taxpayerIdentificationNumber=" + taxpayerIdentificationNumber
        + "]";
  }

  public static class EmployeeComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
      // TODO Auto-generated method stub
      return 0;
    }
  }

}
