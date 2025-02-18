package com.aa.crewcomp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration.class,
        org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration.class})
public class ConnectivityDemoApplication {
    public static void main(String[] args) {
        SpringApplication.run(ConnectivityDemoApplication.class, args);
    }
}
