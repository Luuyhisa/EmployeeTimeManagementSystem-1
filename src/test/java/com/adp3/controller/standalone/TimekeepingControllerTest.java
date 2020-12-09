package com.adp3.controller.standalone;
import com.adp3.entity.standalone.Timekeeping;
import com.adp3.factory.standalone.TimekeepingFactory;
import junit.framework.TestCase;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@RunWith(SpringRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TimekeepingControllerTest {

    private Timekeeping timekeeping =
            TimekeepingFactory.buildTimekeepingService(1800,1000,"LM1234567890");

    @Autowired//http://localhost:8080/employee_time_management/Timekeeping/
    private TestRestTemplate restTemplate;
    private  String timekeepingUrl = "http://localhost:8080/employee_time_management/Timekeeping";
    private  static String SECURITY_USERNAME ="Super";
    private  static String SECURITY_PASSWORD ="Password.ADP3";

@Test
    public void testGetAll() {
        String urlGet = timekeepingUrl + "getAll " ;
        HttpHeaders headers = new HttpHeaders();
        HttpEntity<String> entity = new HttpEntity<>(null, headers);
        ResponseEntity<String> responseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_USERNAME)
                .exchange(urlGet, HttpMethod.GET, entity, String.class);
        assertNotNull(responseEntity);
    }
@Test
    public void testCreate() {
        String urlCreate = timekeepingUrl + "/create";
        ResponseEntity<Timekeeping> storeResponseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(urlCreate, timekeeping, Timekeeping.class);
        timekeeping = storeResponseEntity.getBody();
        assertEquals(timekeeping.toString(), storeResponseEntity.getBody().toString());
    }
@Test
    public void testRead() {
        String url = timekeepingUrl + "read" + timekeeping.getempID();
        ResponseEntity<Timekeeping> leaveResponseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).getForEntity(url, Timekeeping.class);
        assertNotNull(leaveResponseEntity);
        assertNotNull(leaveResponseEntity.getBody());
            }
@Test
    public void testUpdate() {
        Timekeeping updated  = new Timekeeping.Builder().copy(timekeeping).setEmployee_id("12hugh23").setTime_In(1800).setTime_Out(1000).build();
        String url = timekeepingUrl + " updated ";
        ResponseEntity<Timekeeping> ResponseEntity = restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).postForEntity(url,updated, Timekeeping.class);
        assertNotNull(ResponseEntity);
        assertNotNull(updated);
    }
@Test
    public void testDelete() {
        String urlDel = timekeepingUrl + " Delete " + timekeeping.getempID();
        restTemplate.withBasicAuth(SECURITY_USERNAME,SECURITY_PASSWORD).delete(urlDel);
        System.out.println("Timesheet data deleted ");
    }
}