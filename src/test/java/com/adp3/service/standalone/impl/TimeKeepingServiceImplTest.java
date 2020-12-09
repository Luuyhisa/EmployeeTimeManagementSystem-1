

/*
 * Author: Lungisa Lucky Mkhasakhasa
 * Class: Part Time
 * Student number: 216060117
 * Class Description: TimekeepingServiceTest
 * */


package com.adp3.service.standalone.impl;
import com.adp3.entity.standalone.Employee;
import com.adp3.entity.standalone.Timekeeping;
import com.adp3.factory.standalone.TimekeepingFactory;
import junit.framework.TestCase;
import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
@RunWith(SpringRunner.class)
public class TimeKeepingServiceImplTest {
    @Autowired
            TimeKeepingServiceImpl serv;
    //private TimeKeepingServiceServicesImpl repository = new TimeKeepingServiceServicesImpl();
    Timekeeping timekeeping = TimekeepingFactory.buildTimekeepingService(1000,1500,"LM88");




    @Test
    public void testCreate() {
//        TimekeepingService cExpected = repository.create(timekeepingservice);
        Timekeeping emp_created = serv.create( timekeeping );
        Assert.assertEquals( timekeeping.getRecID(), emp_created.getRecID() );
        //        Assert.assertEquals(cExpected.getempID(),timekeepingservice.getempID());
        System.out.println("Created Employee: " + timekeeping );


    }
    @Test
    public void testRead() {

//        TimekeepingService rTimekeepingservice  = repository.read(timekeepingservice.getempID());
//        Assert.assertNotNull(rTimekeepingservice);
        Timekeeping reader = serv.read(timekeeping.getempID());
        System.out.println("Reader data : " + reader );

    }
    @Test
    public void testUpdate() {
        Timekeeping rTimekeepingservice = new Timekeeping.Builder()
                .setEmployee_id("LM88")
                .setTime_In(1500)
                .setTime_Out(2100)
                .copy(timekeeping)
                .build();
        rTimekeepingservice = serv.update(rTimekeepingservice);
        //Assert.assertNotNull(rTimekeepingservice.toString());
    }
    @Test
    public void testDelete() {
        serv.delete( timekeeping.getempID() );
        System.out.println("Deleted: "+ timekeeping.getempID());
        System.out.print( "Get All: " +  serv.getAll() );

      // Assert.assertNotNull(timekeeping.getempID());
    }
@Test
    public void testGetAll() {
        Set<Timekeeping> timekeepimngx = serv.getAll();
        System.out.print( "Get All: " + timekeepimngx );
        Assert.assertNotNull(timekeepimngx);

    }
}