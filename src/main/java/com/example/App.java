package com.example;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.catalina.startup.Tomcat;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.bag.HashBag;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.h2.Driver;
import org.hibernate.Version;
import org.springframework.core.SpringVersion;

import java.util.LinkedHashMap;
import java.util.Map;

public class App {
    private static final Logger LOGGER = LogManager.getLogger(App.class);

    public static void main(String[] args) throws Exception {
        LOGGER.info("Starting intentionally vulnerable Dependabot test application");

        ObjectMapper mapper = new ObjectMapper();
        Map<String, String> dependencyVersions = new LinkedHashMap<>();
        dependencyVersions.put("spring-core", SpringVersion.getVersion());
        dependencyVersions.put("hibernate-core", Version.getVersionString());
        dependencyVersions.put("h2-driver", Driver.class.getPackage().getImplementationVersion());
        dependencyVersions.put("tomcat-embed-core", Tomcat.class.getPackage().getImplementationVersion());

        Bag bag = new HashBag();
        bag.add("commons-collections");
        dependencyVersions.put("commons-collections-items", String.valueOf(bag.size()));

        Tomcat tomcat = new Tomcat();
        tomcat.setPort(0);

        LOGGER.info("Resolved dependency sample: {}", mapper.writeValueAsString(dependencyVersions));
    }
}
