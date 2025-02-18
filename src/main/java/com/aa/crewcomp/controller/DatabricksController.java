package com.aa.crewcomp.controller;

import com.aa.crewcomp.service.DatabricksTestService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/orion")
public class DatabricksController {

    private DatabricksTestService service;

    public DatabricksController(DatabricksTestService service) {
        this.service = service;
    }

//    @GetMapping("/columns")
//    public ResponseEntity<List<String>> getColumnNames() {
//        List<String> columnNames = service.getColumnNames();
//        return ResponseEntity.ok(columnNames);
//    }
//
//    @GetMapping("/data")
//    public ResponseEntity<List<Map<String, Object>>> getData() {
//        try {
//            List<Map<String, Object>> data = service.getBoardingTimesData();
//            return ResponseEntity.ok(data);
//        } catch (Exception e) {
//            return  null; // todo - return something
//        }
//    }

    @GetMapping("/normal_board_std")
    public ResponseEntity<List<Map<String, Object>>> get_normal_board_std() {
        try {
            List<Map<String, Object>> data = service.normal_board_std();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return  null; // todo - return something
        }
    }

    @GetMapping("/FLIGHT_CREW_FLIGHT_LEG")
    public ResponseEntity<List<Map<String, Object>>> get_FLIGHT_CREW_FLIGHT_LEG() {
        try {
            List<Map<String, Object>> data = service.FLIGHT_CREW_FLIGHT_LEG();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return  null; // todo - return something
        }
    }

    @GetMapping("/board_pax_event")
    public ResponseEntity<List<Map<String, Object>>> get_board_pax_event() {
        try {
            List<Map<String, Object>> data = service.board_pax_event();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return  null; // todo - return something
        }
    }

    @GetMapping("/FLIGHT_LEG")
    public ResponseEntity<List<Map<String, Object>>> get_FLIGHT_LEG() {
        try {
            List<Map<String, Object>> data = service.FLIGHT_LEG();
            return ResponseEntity.ok(data);
        } catch (Exception e) {
            return  null; // todo - return something
        }
    }
}
