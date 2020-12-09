package com.adp3.controller.bridge;

import com.adp3.entity.bridge.EmployeeSalary;
import com.adp3.factory.bridge.EmployeeSalaryFactory;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.*;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

/**
 * Author: Liesl Gounden-Wentzel
 * Class: Part Time
 * Student number: 202104133
 * Controller TEST:
 */


@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeSalaryControllerTest {

    private static EmployeeSalary empSal = EmployeeSalaryFactory.buildEmployeeSalary("A1234",52.12,40.5);
    private static String SECURITY_USERNAME = "User";
    private static String SECURITY_PASSWORD = "Password";


    @Autowired
    private TestRestTemplate restTemplate;
    private String baseURl = "http://localhost:8080/employeeSalary/";


    @Test
    public void a_create() {

        String url = baseURl + "create";
        System.out.println("URL: " + url);
        System.out.println("Post Data: " + empSal);
        System.out.println("ID: "+ empSal.getEmpID());
        ResponseEntity<EmployeeSalary> postResponse = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url, empSal, EmployeeSalary.class);
        assertNotNull(postResponse);
        assertNotNull(postResponse.getBody());
        empSal = postResponse.getBody();
        System.out.println("Saved data: " + empSal);
        //assertEquals(HttpStatus.FORBIDDEN, postResponseEntity.getStatusCode());
        assertEquals(empSal.getEmpID(),postResponse.getBody().getEmpID());
    }

    @Test
    public void b_read() {
        String url = baseURl + "read" + empSal.getEmpID();
        System.out.println("URL:  " + url);
        ResponseEntity<EmployeeSalary> responseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .getForEntity(url, EmployeeSalary.class);
        assertNotNull(responseEntity);
        //assertEquals(empSal.getEmpID(), responseEntity.getBody().getEmpID());
        System.out.println("Called data using EmpID: "+ empSal.getEmpID()+"\tEmp Rate: " + empSal.getEmpRate()+"\tEmp Hours: "+empSal.getEmpHours());
    }

    @Test
    public void c_update() {


        EmployeeSalary updated = new EmployeeSalary.Builder().copy(empSal).setEmpHours(15.5).build();
        String url = baseURl + "update";
        System.out.println("URL:  " + url);
        System.out.println("Old Hours for EmpID: " + empSal.getEmpID() + "\tHours: "+empSal.getEmpHours());
        ResponseEntity<EmployeeSalary> ResponseEntity = restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .postForEntity(url,updated, EmployeeSalary.class);
        assertNotNull(ResponseEntity);
        assertNotNull(updated);
        System.out.println("New Hours for EmpID: " + empSal.getEmpID() + "\tHours: "+updated.getEmpHours());
    }

    @Test
    public void d_getall() {
        String url = baseURl + "all";
        System.out.println("URL: "+url);
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .exchange(url, HttpMethod.GET, entity, String.class);
        System.out.println(responseEntity);
        System.out.println(responseEntity.getBody());
        assertNotNull(responseEntity.getBody());
    }

    @Test
    public void e_delete() {

        String url = baseURl + "delete" + empSal.getEmpID();
        System.out.println("URL:  " + url);
        restTemplate
                .withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD)
                .delete(url);
    }
}