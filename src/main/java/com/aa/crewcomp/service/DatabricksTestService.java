package com.aa.crewcomp.service;

import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class DatabricksTestService {

    private final Environment environment;
    private final JdbcTemplate jdbcTemplate;

    public DatabricksTestService(Environment environment, JdbcTemplate jdbcTemplate) {
        this.environment = environment;
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Map<String, Object>> getDatabricksData() {
        return jdbcTemplate.queryForList("SELECT * FROM databricks_table");
    }

    public List<Map<String, Object>> normal_board_std() {

        String query = "";
        if(environment.getProperty("config.orion-env").equals("prod")) {
            query = String.format("SELECT * from fltcorepkg_prod_ref.normal_board_std LIMIT %d", 5);
        } else {
            query = String.format("SELECT * from fltcorepkg_stage_ref.normal_board_std LIMIT %d", 5);
        }
        List<Map<String, Object>> data = jdbcTemplate.queryForList(query);
        return data;
    }

    public List<Map<String, Object>> FLIGHT_CREW_FLIGHT_LEG() {
        String query = "";
        if(environment.getProperty("config.orion-env").equals("prod")) {
            query = String.format("SELECT * FROM crewcomp_prod_pkg_pii.FLIGHT_CREW_FLIGHT_LEG LIMIT %d",10);
        } else {
            query = String.format("SELECT * FROM crewcomp_nonprod_pkg_pii.FLIGHT_CREW_FLIGHT_LEG LIMIT %d", 10);
        }
        List<Map<String, Object>> data = jdbcTemplate.queryForList(query);
        return data;
    }

    public List<Map<String, Object>> board_pax_event() {
        String query = "";
        if(environment.getProperty("config.orion-env").equals("prod")) {
            query = String.format("SELECT * FROM crewcomp_prod_pkg_pii.board_pax_event LIMIT %d",10);
        } else {
            query = String.format("SELECT * FROM crewcomp_nonprod_pkg_pii.board_pax_event LIMIT %d",10);
        }
        List<Map<String, Object>> data = jdbcTemplate.queryForList(query);
        return data;
    }

    public List<Map<String, Object>> FLIGHT_LEG() {
        String query = "";

        if(environment.getProperty("config.orion-env").equals("prod")) {
            //query = String.format("SELECT * FROM fltcorepkg_prod_pkg.flight_leg LIMIT %d", 10);
            query = String.format("SELECT * FROM crewcomp_prod_pkg_pii.flight_leg LIMIT %d", 10);
        } else {
//            query = String.format("SELECT * FROM crewcomp_nonprod_pkg_pii.FLIGHT_LEG LIMIT %d",10);

            query = String.format("select * from crewcomp_nonprod_bi_vw.RO_EMP_CONTRCT_MONTH");
        }
        List<Map<String, Object>> data = jdbcTemplate.queryForList(query);
        return data;
    }

//    public List<Map<String, Object>> getROData() {
//        String query = String.format(" select * from crewcomp_nonprod_bi_vw.RO_EMP_CONTRCT_MONTH");
//        List<Map<String, Object>> data = jdbcTemplate.queryForList(query);
//        String jsonString = gson.toJson(data);
//        return data;
//    }
}
