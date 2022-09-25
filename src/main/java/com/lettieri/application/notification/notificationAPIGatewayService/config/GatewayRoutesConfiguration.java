package com.lettieri.application.notification.notificationAPIGatewayService.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayRoutesConfiguration {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("r1", r -> r.path("/api/notifications")
                        .uri("http://localhost:8084/api/notifications"))
                .route("r2", r -> r.path("/api/notifications/preferences")
                        .uri("http://localhost:8081/api/notifications/preferences"))
                .route("r3", r -> r.path("/api/notifications/templates")
                        .uri("http://localhost:8082/api/notifications/templates"))
                .route("r4", r -> r.path("/api/notifications/send")
                        .uri("http://localhost:8083/api/notifications/send"))
                .build();
    }
}
