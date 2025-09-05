package com.ypp.integrationframework;

import com.ypp.integrationframework.integrationplatform.connectors.ChatwootConnector;
import com.ypp.integrationframework.integrationplatform.connectors.Connector;
import com.ypp.integrationframework.integrationplatform.core.ConnectorRequest;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Map;

@SpringBootApplication
public class IntegrationframeworkApplication {

    public static void main(String[] args) {
        ConnectorRequest request = new ConnectorRequest(
                "correlation-test",
                Map.of(
                        "accountId", 133949
                )
        );

        SpringApplication.run(IntegrationframeworkApplication.class, args);
        Connector chatwootConnector = new ChatwootConnector();
        var data = chatwootConnector.pull(request);
        System.out.println(data);
    }
}
