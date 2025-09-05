package com.ypp.integrationframework.integrationplatform.connectors;

import com.ypp.integrationframework.integrationplatform.core.ConnectorRequest;
import com.ypp.integrationframework.integrationplatform.core.ConnectorResult;
import com.ypp.integrationframework.integrationplatform.core.EventType;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.HashMap;
import java.util.Map;

public class ChatwootConnector implements Connector {

    private final WebClient webClient;

    public ChatwootConnector() {
        this.webClient = WebClient.builder()
                .baseUrl("https://your-chatwoot-instance/api/v1")
                .defaultHeader("api_access_token", "uL1LNzZffdUPEw3TDGEycsQB") // hardcode
                .build();
    }



    @Override
    public String getName() {
        return "chatwoot";
    }

    @Override
    public boolean getSupportEvents(EventType type) {
        return type == EventType.CREATE || type == EventType.UPDATE;
    }

    @Override
    public ConnectorResult push(ConnectorRequest request) {
        try {
            Map<String, Object> payload = request.payload();

            Map<String, Object> body = new HashMap<>();
            body.put("source_id", payload.get("sourceId"));
            body.put("content", payload.get("message"));

            Map<String, Object> response = webClient.post()
                    .uri("/accounts/{accountId}/conversations", payload.get("accountId"))
                    .bodyValue(body)
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return new ConnectorResult(true, "ok", Map.of("response", response));

        } catch (Exception e) {
            return new ConnectorResult(false, e.getMessage(), Map.of());
        }
    }

    @Override
    public ConnectorResult pull(ConnectorRequest request) {
        try {
            Map<String, Object> payload = request.payload();

            Map<String, Object> response = webClient.get()
                    .uri("/accounts/{accountId}/conversations", payload.get("accountId"))
                    .retrieve()
                    .bodyToMono(Map.class)
                    .block();

            return new ConnectorResult(true, "ok", Map.of("response", response));
        } catch (Exception e) {
            return new ConnectorResult(false, e.getMessage(), Map.of());
        }
    }
}
