package com.newthread.framework.web.farmers;

import com.newthread.framework.db.FarmerDB;
import com.newthread.framework.entity.Report;
import com.newthread.framework.model.ReportPart;
import com.newthread.framework.service.ReportService;
import com.newthread.framework.util.MessageMaker;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;


@RestController
public class ReportController {

    private final Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ReportService reportService;

    @RequestMapping(value = "/farmers/{fid}/reports",method = RequestMethod.GET)
    public Object getReports(@PathVariable String fid){

        List<ReportPart> list = reportService.getReport(fid);

        if(list == null || list.size() == 0){
            return MessageMaker.make("E02","N0 this farmer or No reports !","");
        }

        return list;
    }

    @RequestMapping(value = "/farmers/{fid}/reports/{frid}[?start_date=YYYYMMDD&end_date=YYYYMMDD]",method = RequestMethod.GET)
    public Object getReportsByDate(@PathVariable String fid,@PathVariable String frid){

        // TODO: 2016/11/15  
        
        List<ReportPart> list = reportService.getReport(fid);

        if(list == null || list.size() == 0){
            return MessageMaker.make("E02","N0 this farmer or No reports !","");
        }

        return list;
    }

    @RequestMapping(value = "/farmers/{fid}/delivery_charge",method = RequestMethod.GET)
    public Object delivery_charge(@PathVariable String fid){
        return "{\"delivery_charge\": "+ reportService.getPrice(fid) +"}";
    }

    @RequestMapping(value = "/farmers/{fid}/delivery_charge",method = RequestMethod.POST)
    public Object updateDelivery_charge(@PathVariable String fid, @RequestBody Map<String,Double> map){

        Double delivery_charge = map.get("delivery_charge");

        if(delivery_charge == null){
            return MessageMaker.make("E02","Please Enter the new Charge !","");
        }

        int x = reportService.updateCharge(fid,delivery_charge);

        if(x == 0){
            return MessageMaker.make("E02","Update fail !","");
        }

        return x;
    }

}
