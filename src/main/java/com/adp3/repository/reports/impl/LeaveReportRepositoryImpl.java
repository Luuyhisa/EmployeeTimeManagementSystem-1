/*
package com.adp3.repository.reports.impl;

import com.adp3.entity.reports.LeaveReport;
import com.adp3.repository.reports.LeaveReportRepository;

import java.util.HashSet;
import java.util.Set;

*/
/**
 * Author: Megan Jacobs
 * Class: Part Time
 * Student number: 211137162
 * Description: LeaveReportRepositoryImpl - implementation of LeaveReportRepository as a concrete class
 *//*


public class LeaveReportRepositoryImpl implements LeaveReportRepository{
    private static LeaveReportRepository repository = null;
    private Set<LeaveReport> leaveReportDB;
    public LeaveReportRepositoryImpl() {
        this.leaveReportDB = new HashSet<>();
    }

    public static LeaveReportRepository getRepository(){
        if (repository == null) repository = new LeaveReportRepositoryImpl();
        return repository;

    }
    */
/*method used to create a new LeaveReport
     * @param: leaveReportDesc - eg. Annual Leave, Sick Leave etc
     * @return: LeaveReport
     * *//*

    @Override
    public LeaveReport create(LeaveReport leaveReport) {
        this.leaveReportDB.add(leaveReport);
        return leaveReport;
    }

    */
/*method used to read a LeaveReport
     * @param: leaveReportID - eg. record 001, record 231 etc
     * @return: LeaveReport
     * *//*

    @Override
    public LeaveReport read(String leaveReportID) {
        LeaveReport leaveReport =null;
        for(LeaveReport l: this.leaveReportDB) {
            if (l.getLeaveReportID().equalsIgnoreCase(leaveReportID)) {
                leaveReport = l;
                break;
            }
        }
        return leaveReport;
    }

    */
/*method used to update a LeaveReport
     * @param: leaveReport
     * @return: LeaveReport
     * *//*

    @Override
    public LeaveReport update(LeaveReport leaveReport) {
        //update the object
        LeaveReport existingLeaveReport = read(leaveReport.getLeaveReportID());
        if(leaveReport != null) {
            this.leaveReportDB.remove(existingLeaveReport);
            this.leaveReportDB.add(leaveReport);
        }

        return leaveReport;
    }

    */
/*method used to delete a LeaveReport
     * @param: leaveReportID - eg. record 001, record 231 etc
     * @return: void
     * *//*

    @Override
    public void delete (String leaveReportID) {
        LeaveReport existingLeaveReport = read(leaveReportID);
        if (existingLeaveReport != null)
            this.leaveReportDB.remove(existingLeaveReport);

    }

    */
/*method used to retrieve Collection of LeaveReport
     * @param: void
     * @return: Set
     * *//*

    @Override
    public Set<LeaveReport> getAll() {
        return this.leaveReportDB;
    }
}
*/
