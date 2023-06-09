package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.subclass.Date;

public abstract class Employee {
    private String employeeName;
    private String employeeId;
    private String employeePhoneNumber;
    private String employeeAddress;
    private Date employeeDateOfBirth;
    private Date employeeHireDate;

    public Employee(String employeeName, String employeeId, String employeePhoneNumber, String employeeAddress, Date employeeDateOfBirth, Date employeeHireDate) {
        this.employeeName = employeeName;
        this.employeeId = employeeId;
        this.employeePhoneNumber = employeePhoneNumber;
        this.employeeAddress = employeeAddress;
        this.employeeDateOfBirth = employeeDateOfBirth;
        this.employeeHireDate = employeeHireDate;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeePhoneNumber() {
        return employeePhoneNumber;
    }

    public void setEmployeePhoneNumber(String employeePhoneNumber) {
        this.employeePhoneNumber = employeePhoneNumber;
    }

    public String getEmployeeAddress() {
        return employeeAddress;
    }

    public void setEmployeeAddress(String employeeAddress) {
        this.employeeAddress = employeeAddress;
    }

    public Date getEmployeeDateOfBirth() {
        return employeeDateOfBirth;
    }

    public void setEmployeeDateOfBirth(Date employeeDateOfBirth) {
        this.employeeDateOfBirth = employeeDateOfBirth;
    }

    public Date getEmployeeHireDate() {
        return employeeHireDate;
    }

    public void setEmployeeHireDate(Date employeeHireDate) {
        this.employeeHireDate = employeeHireDate;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "employeeName='" + employeeName + '\'' +
                ", employeeId='" + employeeId + '\'' +
                ", employeePhoneNumber='" + employeePhoneNumber + '\'' +
                ", employeeAddress='" + employeeAddress + '\'' +
                ", employeeDateOfBirth=" + employeeDateOfBirth +
                ", employeeHireDate=" + employeeHireDate +
                '}';
    }
}
