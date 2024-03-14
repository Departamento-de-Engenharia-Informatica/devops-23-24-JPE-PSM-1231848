package com.greglturnquist.payroll;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
class EmployeeTest {

    @Test
    void testCreateEmployee() throws InstantiationException {
        Employee employee = new Employee("John", "Wick", "Accountant", 5);
        assertNotNull(employee);
        assertEquals("John", employee.getFirstName());
        assertEquals("Wick", employee.getLastName());
        assertEquals("Accountant", employee.getDescription());
        assertEquals(5, employee.getJobYears());
    }

    @Test
    void constructor_throwsExceptionIfFirstNameEmpty() {
        //Arrange
        String firstName = " ";
        String lastName = "Wick";
        String description = "Accountant";
        int jobYears = 5;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    @Test
    void constructor_throwsExceptionIfFirstNameNull() {
        //Arrange
        String firstName = null;
        String lastName = "Wick";
        String description = "Accountant";
        int jobYears = 5;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    @Test
    void constructor_throwsExceptionIfLastNameEmpty() {
        //Arrange
        String firstName = "John ";
        String lastName = " ";
        String description = "Accountant";
        int jobYears = 5;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }

    @Test
    void constructor_throwsExceptionIfLastNameNull() {
        //Arrange
        String firstName = "John ";
        String lastName = null;
        String description = "Accountant";
        int jobYears = 5;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    @Test
    void constructor_throwsExceptionIfDescriptionisEmpty() {
        //Arrange
        String firstName = "John ";
        String lastName = "Wick";
        String description = " ";
        int jobYears = 5;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    @Test
    void constructor_throwsExceptionIfDescriptionisNull() {
        //Arrange
        String firstName = "John ";
        String lastName = "Wick";
        String description = null;
        int jobYears = 5;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
    @Test
    void constructor_throwsExceptionIfJobYearsLessThanZero() {
        //Arrange
        String firstName = "John ";
        String lastName = "Wick";
        String description = "Accountant";
        int jobYears = -1;
        String expectedMessage = "Invalid parameter.";
        //Act
        Exception exception = assertThrows(InstantiationException.class, () -> {
            new Employee(firstName, lastName, description, jobYears);
        });
        String result = exception.getMessage();
        //Assert
        assertEquals(expectedMessage, result);
    }
}