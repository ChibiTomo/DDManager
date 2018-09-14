package net.chibidevteam.ddlmanager.app;

import static net.chibidevteam.ddlmanager.util.config.Config.ROOT_COMPONENTS_PACKAGE;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = { //
        ROOT_COMPONENTS_PACKAGE, //
        "net.chibidevteam.apiversioning", //
        "net.chibidevteam.securityseed.main" //
})
public class DDLManagerApplication {

    public static void main(String[] args) {
        SpringApplication.run(DDLManagerApplication.class, args);
    }
}
