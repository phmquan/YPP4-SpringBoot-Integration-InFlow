package com.ypp.integrationframework.integrationplatform.core;

import java.util.Map;

public record ConnectorRequest(
        String tenantId,
        String correlationId,
        Map<String, Object> payload
) {
}