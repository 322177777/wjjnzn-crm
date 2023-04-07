package com.neusoftwjj;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@MapperScan(basePackages = {"com.neusoftwjj.crm.settings.mapper","com.neusoftwjj.crm.workbench.activity.mapper","com.neusoftwjj.crm.workbench.clue.mapper",
                            "com.neusoftwjj.crm.workbench.contacts.mapper","com.neusoftwjj.crm.workbench.customer.mapper","com.neusoftwjj.crm.workbench.transaction.mapper"})
@SpringBootApplication
public class SpringbootProjectApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootProjectApplication.class, args);
    }

}
