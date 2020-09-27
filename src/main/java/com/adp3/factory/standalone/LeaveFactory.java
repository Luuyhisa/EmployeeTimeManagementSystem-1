package com.adp3.factory.standalone;

import com.adp3.entity.standalone.Leave;
import com.adp3.util.GenericHelper;

/**
 * Author: Ayanda Nongxa
 * Class: Part Time
 * Student number:204513723
 * Class Description: LeaveFactory
 */

public class LeaveFactory {

    private LeaveFactory(){
    }

    public static Leave createLeave(String leaveDesc) {
        String leaveID = GenericHelper.generateID();
        return new Leave.Builder()
                .setLeaveID(leaveID)
                .setLeaveDesc(leaveDesc)
                .build();
    }

}
