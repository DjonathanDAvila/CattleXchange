package com.cattle.xchange.infra.startupApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.awt.*;
import java.net.URI;

@Component
public class AppStartupRunner implements ApplicationRunner {

    @Override
    public void run(ApplicationArguments args) throws Exception {

        String swaggerUrl = "http://localhost:8080/swagger-ui/index.html";

        if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
            Desktop.getDesktop().browse(new URI(swaggerUrl));
        }
    }
}