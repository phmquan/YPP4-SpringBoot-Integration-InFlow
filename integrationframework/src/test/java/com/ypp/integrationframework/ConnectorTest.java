package com.ypp.integrationframework;

import com.ypp.integrationframework.integrationplatform.connectors.Connector;
import com.ypp.integrationframework.integrationplatform.core.ConnectorRequest;
import com.ypp.integrationframework.integrationplatform.core.ConnectorResult;
import com.ypp.integrationframework.integrationplatform.core.EventType;
import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ConnectorTest {

    @Test
    void push_shouldReturnSuccess() {
        Connector connector = new DummyConnector();
        ConnectorRequest request = new ConnectorRequest(
                "correlation1", Map.of("key", "value")
        );

        ConnectorResult result = connector.push(request);

        assertTrue(result.success());
        assertEquals("ok", result.message());
    }

    @Test
    void pull_shouldReturnSuccess() {
        Connector connector = new DummyConnector();
        ConnectorRequest request = new ConnectorRequest("correlation2", Map.of("key", "value"));

        ConnectorResult result = connector.pull(request);

        assertTrue(result.success());
        assertEquals("pulled", result.message());
        assertEquals("dummy-data", result.metadata().get("data"));
    }

    static class DummyConnector implements Connector {
        @Override
        public String getName() {
            return "dummy";
        }

        @Override
        public boolean getSupportEvents(EventType type) {
            return true;
        }

        @Override
        public ConnectorResult push(ConnectorRequest request) {
            return new ConnectorResult(true, "ok", Map.of());
        }

        @Override
        public ConnectorResult pull(ConnectorRequest request) {
            return new ConnectorResult(true, "pulled", Map.of("data", "dummy-data"));
        }
    }
}
