package de.micromata.hackingnight;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Mario on 22.06.2016.
 */

@EnableAutoConfiguration
@Configuration
@ComponentScan
public class HackingNight {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(HackingNight.class, args);
    }


}
