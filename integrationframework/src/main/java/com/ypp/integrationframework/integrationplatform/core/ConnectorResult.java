package com.ypp.integrationframework.integrationplatform.core;

import java.util.Map;

public record ConnectorResult(
        boolean success,
        String message,
        Map<String, Object> metadata
) {
}