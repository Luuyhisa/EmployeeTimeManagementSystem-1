//package com.adp3.repository.bridge.impl;
//
//import com.adp3.entity.bridge.EmployeeLeave;
//import com.adp3.factory.bridge.EmployeeLeaveFactory;
//import com.adp3.repository.bridge.EmployeeLeaveRepository;
//import com.adp3.repository.bridge.impl.EmployeeLeaveRepositoryImpl;
//import com.adp3.util.GenericHelper;
//import org.junit.Assert;
//import org.junit.FixMethodOrder;
//import org.junit.Test;
//import org.junit.runners.MethodSorters;
//
//import java.util.Date;
//
//
////Annotation of executing tests in alphabetical order
//@FixMethodOrder(MethodSorters.NAME_ASCENDING)
//public class EmployeeLeaveRepositoryImplTest {
//
//    private static EmployeeLeaveRepository repo = new EmployeeLeaveRepositoryImpl();
//    private static String empID = GenericHelper.generateID();
//    private static EmployeeLeave empLeave = EmployeeLeaveFactory.calcEmployeeLeave(empID,"3",new Date(2020,5,28), new Date(2020,6,02));
//
//    @Test
//    public void a_create() {
//        EmployeeLeave created = repo.create(empLeave);
//        Assert.assertEquals(empLeave.getEmpID(), created.getEmpID());
//        System.out.println("CREATED: "+ created);
//    }
//
//    @Test
//    public void b_read() {
//        EmployeeLeave read = repo.read(empLeave.getEmpID());
//        System.out.println("READ: " + read);
//    }
//
//    @Test
//    public void c_update() {
//        EmployeeLeave updated = new EmployeeLeave.Builder().copy(empLeave).setLeaveID("1").setStartDate(new Date(2020,5,28))
//                .setEndDate(new Date(2020,6,02)).build();
//        updated = repo.update(updated);
//        System.out.println("UPDATED: "+ updated);
//    }
//
//    @Test
//    public void e_delete() {
//        repo.delete(empLeave.getEmpID());
//    }
//
//    @Test
//    public void d_getAll() {
//
//        System.out.println("GET ALL: "+repo.getAll());
//    }
//}