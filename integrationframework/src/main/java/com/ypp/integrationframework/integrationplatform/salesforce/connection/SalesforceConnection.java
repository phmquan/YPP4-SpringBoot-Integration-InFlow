package com.ypp.integrationframework.integrationplatform.salesforce.connection;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Component
public class SalesforceConnection implements IntegrationConnection {
    @Value("${salesforce.consumerKey}")
    private String clientId;

    @Value("${salesforce.consumerSecret}")
    private String clientSecret;

    @Value("${salesforce.authUrl}")
    private String authUrl;

    private String accessToken;
    private String instanceUrl;



    @Override
    public boolean connect() {
        try {
            RestTemplate restTemplate = new RestTemplate();

            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_FORM_URLENCODED);

            String body = "grant_type=client_credentials" +
                    "&client_id=" + clientId +
                    "&client_secret=" + clientSecret;

            HttpEntity<String> request = new HttpEntity<>(body, headers);

            ResponseEntity<Map> response = restTemplate.exchange(
                    authUrl,
                    HttpMethod.POST,
                    request,
                    Map.class
            );

            if (response.getStatusCode().is2xxSuccessful() && response.getBody() != null) {
                Map<String, Object> tokenResponse = response.getBody();
                this.accessToken = (String) tokenResponse.get("access_token");
                this.instanceUrl = (String) tokenResponse.get("instance_url");
                return true;
            }
            return false;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean validate() {
        return accessToken != null && !accessToken.isEmpty();
    }

    @Override
    public String getAccessToken() {
        return accessToken;
    }

    public String getInstanceUrl() {
        return instanceUrl;
    }
}
