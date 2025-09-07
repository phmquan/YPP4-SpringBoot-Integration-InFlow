package com.ypp.integrationframework.salesforce;

import com.ypp.integrationframework.integrationplatform.salesforce.controller.SalesforceConnectionController;
import com.ypp.integrationframework.integrationplatform.salesforce.service.SalesforceConnectionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(SalesforceConnectionController.class)
@AutoConfigureMockMvc(addFilters = false)
class SalesforceConnectionControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private SalesforceConnectionService salesforceConnectionService;

    @Test
    void shouldReturnAccessToken() throws Exception {
        // Arrange
        when(salesforceConnectionService.getAccessToken())
                .thenReturn(ResponseEntity.ok("mock-access-token"));

        // Act + Assert
        mockMvc.perform(get("/api/v1/integration/salesforce/connect"))
                .andExpect(status().isOk())
                .andExpect(content().string("mock-access-token"));
    }
}
