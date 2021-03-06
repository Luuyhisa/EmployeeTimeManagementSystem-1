


package com.adp3.controller.reports;

import com.adp3.entity.reports.StoreReports;
import com.adp3.factory.reports.StoreReportFactory;
import com.adp3.service.reports.impl.StoreReportsServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Set;

@RestController
@RequestMapping("/StoreReports")
public class StoreReportsController {

    @Autowired
    private StoreReportsServiceImpl storeReportsService;

    @PutMapping("/create")
    public StoreReports create(StoreReports storeReports){
         return storeReportsService.create(StoreReportFactory.createStoreReports(storeReports.getEmpID(),storeReports.getStoreID(),storeReports.getTimeServiceID()));
    }

    @GetMapping("/read/{storeReportsId}")
    public  StoreReports read(@PathVariable String storeReportsId){
        return storeReportsService.read(storeReportsId);
    }

    @PutMapping("/update/{storeReportsId}")
    public StoreReports update(@RequestBody StoreReports storeReports){
        return storeReportsService.update(storeReports);
    }
    /*

     */
    @DeleteMapping("/deleted/{storeReportsId}")
    public void delete(@PathVariable String storeReportsId){
        storeReportsService.delete(storeReportsId);
    }

    @GetMapping("/all")
    public Set<StoreReports> getAll(){
        return storeReportsService.getAll();
    }
}
