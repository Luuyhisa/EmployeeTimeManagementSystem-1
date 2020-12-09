/*
package com.adp3.repository.reports.impl;

import com.adp3.entity.reports.LeaveReport;
import com.adp3.factory.reports.LeaveReportFactory;
import com.adp3.repository.reports.LeaveReportRepository;
import com.adp3.util.GenericHelper;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static org.junit.Assert.*;
*
 * Author: Megan Jacobs
 * Class: Part Time
 * Student number: 211137162
 * Description: Test methods of LeaveReportRepository (IRepository) implemented in its concrete class



//Annotation of executing tests in alphabetical order
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LeaveReportRepositoryImplTest {

    private static LeaveReportRepository repository = new LeaveReportRepositoryImpl();
    private static LeaveReport leaveReport = LeaveReportFactory.buildLeaveReport("Family Responsibility");

    @Test
    public void a_create() {
        LeaveReport created = repository.create(leaveReport);
        assertEquals(leaveReport.getLeaveReportID(), created.getLeaveReportID());
        System.out.println("Created : " + created);
    }

    @Test
    public void b_read() {
        LeaveReport read = repository.read(leaveReport.getLeaveReportID());
        System.out.println("Read : " + read);

    }

    @Test
    public void c_update() {
        LeaveReport updated = new LeaveReport.Builder().copy(leaveReport).setLeaveReportDesc("Sick Leave").build();
        updated = repository.update(updated);
        System.out.println("Updated : " + updated);
    }

    @Test
    public void e_delete() {
        repository.delete(leaveReport.getLeaveReportID());
        System.out.println("Deleted :" + repository.getAll());
    }

    @Test
    public void d_getAll() {
        System.out.println("GetAll : " + repository.getAll());
    }
}
*/
