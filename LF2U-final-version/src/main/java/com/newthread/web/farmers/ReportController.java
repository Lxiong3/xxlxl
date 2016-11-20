package com.newthread.web.farmers;

import com.newthread.model.ReportPart;
import com.newthread.util.MessageMaker;
import com.newthread.Data;
import com.newthread.service.ReportService;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;


@RestController
public class ReportController {

    private final Logger logger = Logger.getLogger(this.getClass());
    @Resource
    private ReportService reportService;

    @RequestMapping(value = "/farmers/{fid}/reports", method = RequestMethod.GET)
    public Object getReports(@PathVariable String fid) {

        ReportPart reportPart = reportService.getReport(fid);

        if (reportPart == null) {
            return MessageMaker.make("E02", "N0 this farmer or No reports !", "");
        }

        return reportPart;
    }

    // fid -> farm.faid      frid ---> farmer.fid
    @RequestMapping(value = "/farmers/{fid}/reports/{frid}", method = RequestMethod.GET)
    public Object getReportsByDate(@PathVariable String fid, @PathVariable String frid, @RequestParam(required = false) Integer start_date, @RequestParam(required = false) Integer end_date) {

        // TODO: 2016/11/19  to com.newthread.test

        if (start_date == null || end_date == null || start_date.intValue() == 0 || end_date.intValue() == 0) {

            ReportPart reportPart = reportService.getReport(frid);

            if (reportPart == null) {
                return MessageMaker.make("E02", "N0 this farmer or No reports !", "");
            }

            return reportPart;
        }

        return null;
    }

    @RequestMapping(value = "/farmers/{fid}/delivery_charge", method = RequestMethod.GET)
    public Object delivery_charge(@PathVariable String fid) {
        return "{\"delivery_charge\": " + Data.delivery_charge + "}";
    }

    @RequestMapping(value = "/farmers/{fid}/delivery_charge", method = RequestMethod.POST)
    public Object updateDelivery_charge(@PathVariable String fid, @RequestBody Map<String, Double> map) {

        Double delivery_charge = map.get("delivery_charge");

        if (delivery_charge == null) {
            return MessageMaker.make("E02", "Please Enter the new Charge !", "");
        }

        Data.delivery_charge = delivery_charge;

        return "{\"delivery_charge\": " + Data.delivery_charge + "}";
    }

}
