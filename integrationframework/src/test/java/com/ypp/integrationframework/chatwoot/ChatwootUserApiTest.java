package com.ypp.integrationframework.chatwoot;

import com.ypp.integrationframework.integrationplatform.chatwoot.dto.UserDto;
import com.ypp.integrationframework.integrationplatform.chatwoot.controller.UserController;
import com.ypp.integrationframework.integrationplatform.chatwoot.service.ChatwootUserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserController.class)
@AutoConfigureMockMvc(addFilters = false)
class ChatwootUserApiTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ChatwootUserService chatwootUserService;

    @Test
    void shouldReturnUserProfile() throws Exception {
        UserDto mockUser = new UserDto();
        mockUser.setId(139431L);
        mockUser.setName("Dung Tran");
        mockUser.setEmail("2054052013dung@ou.edu.vn");

        when(chatwootUserService.getUserProfile())
                .thenReturn(mockUser);

        mockMvc.perform(get("/api/v1/integration/chatwoot/profile"))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":139431,\"name\":\"Dung Tran\",\"email\":\"2054052013dung@ou.edu.vn\"}"));
    }
}
