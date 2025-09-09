package com.ypp.integrationframework.chatwoot;

import com.ypp.integrationframework.integrationplatform.chatwoot.controller.AccountController;
import com.ypp.integrationframework.integrationplatform.chatwoot.dto.AccountDto;
import com.ypp.integrationframework.integrationplatform.chatwoot.service.ChatwootAccountService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class ChatwootAccountApiTest {
    @Mock
    private ChatwootAccountService accountService;

    @InjectMocks
    private AccountController accountController;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAccountDetails() {
        // Arrange
        AccountDto mockAccount = new AccountDto();
        mockAccount.setId(1L);
        mockAccount.setName("Dung Tran");
        when(accountService.getAccountDetails()).thenReturn(mockAccount);

        // Act
        AccountDto result = accountController.getAccountDetails();

        // Assert
        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("Dung Tran");
        verify(accountService, times(1)).getAccountDetails();
    }

    @Test
    void testUpdateAccount() {
        AccountDto inputAccount = new AccountDto();
        inputAccount.setName("New Name");

        AccountDto updatedAccount = new AccountDto();
        updatedAccount.setId(1L);
        updatedAccount.setName("New Name");

        when(accountService.updateAccount(inputAccount)).thenReturn(updatedAccount);

        AccountDto result = accountController.updateAccount(inputAccount);

        assertThat(result).isNotNull();
        assertThat(result.getId()).isEqualTo(1L);
        assertThat(result.getName()).isEqualTo("New Name");
        verify(accountService, times(1)).updateAccount(inputAccount);
    }
}
