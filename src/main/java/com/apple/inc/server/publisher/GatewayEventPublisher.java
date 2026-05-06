package com.apple.inc.server.publisher;

import com.apple.inc.platform.common.events.GatewayConfigRefreshEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class GatewayEventPublisher {

    @Value("${spring.cloud.bus.id}")
    private String busId;

    private final ApplicationEventPublisher publisher;

    public void publish(String msg) {
        publisher.publishEvent(new GatewayConfigRefreshEvent(this, busId, "*", msg));
    }
}
