package oop;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DepartmentEmployeeTest {
    @Test
    public void givenValidIDAndName_whenGetIdAndName_thenExpectedValuesReturned() {
        String bioDept = "Biology";
        String chemistryDept = "Chemistry";
        Department department = new Department(01, bioDept);
        Department department1 = new Department(02, chemistryDept);
        Department department2 = new Department(01, bioDept);
        assertEquals(bioDept, department.name());
        assertEquals(chemistryDept, department1.name());
        assertTrue(department.equals(department2)); //returns true if the supplied object is of the same type and the values of all of its fields match
        assertEquals(department.hashCode(), department2.hashCode()); //returns the same value for two Person objects if all of the field values for both objects match
    }
}