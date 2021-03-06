/*
 * Author: Lungisa Lucky Mkhasakhasa
 * Class: Part Time
 * Student number: 216060117
 * Class Description: TimekeepingServiceTest
 * */
package com.adp3.service.standalone.impl;
import com.adp3.entity.standalone.Timekeeping;
import com.adp3.factory.standalone.TimekeepingFactory;
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
    Timekeeping timekeeping = TimekeepingFactory.buildTimekeepingService(1000,1500,"LM888");
    @Test
    public void testCreate() {

        Assert.assertNotNull( "Created successful",timekeeping);
        System.out.println("Created Employee: " + timekeeping );

    }
    @Test
    public void testRead() {
       // Timekeeping reader = serv.read(timekeeping.getRecID());
        Assert.assertNull(serv.read(timekeeping.getRecID()));
        System.out.println(" Able to read data : " );
    }
    @Test
    public void testUpdate() {
//Update
        if (serv.read(timekeeping.getempID())!=null){
            serv.update(timekeeping);
            System.out.println("Record Exists:  " + timekeeping.getRecID());
            System.out.println("Updated : " + timekeeping);
        }
        else System.out.println("leaveReport does not exist in database:  ");
        Assert.assertNotNull(timekeeping);
    }
    @Test
    public void testDelete() {
//  Deleting Data
        if (serv.read(timekeeping.getRecID())!=null){
            serv.delete(timekeeping.getRecID());
            System.out.println("Record Deleted:  " + timekeeping.getRecID());
            System.out.println("Deleted : " + timekeeping);
        }else{
            System.out.println("Record does not  Exists: ");
        }
    }
    @Test
    public void testGetAll() {
        //Getting All
        Set<Timekeeping> timekeepimngx = serv.getAll();
        System.out.print( "Get All: " + timekeepimngx );
        Assert.assertNotNull(timekeepimngx);

    }
}