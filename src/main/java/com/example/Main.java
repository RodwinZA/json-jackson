package com.example;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {

        Employee employee = getEmployee();
        ObjectMapper mapper = new ObjectMapper().enable(SerializationFeature.INDENT_OUTPUT);

        try {
            mapper.writeValue(
                    new File("/home/wtc/IdeaProjects/myjsontut/src/main/resources/employee.json"),
                    employee);

            String empJson = mapper.writeValueAsString(employee);
            System.out.println("The employee object in json format:" + empJson);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    private static Employee getEmployee() {
        Employee emp = new Employee();
        emp.setId("E010890");
        emp.setName("James");
        emp.setDeptName("DBMS");
        emp.setRating(5);
        emp.setSalary(1000000.00);

        return emp;
    }
}
