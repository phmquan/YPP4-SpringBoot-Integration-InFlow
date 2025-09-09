package com.ypp.integrationframework.integrationplatform.chatwoot.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class AccountDto {
    private Long id;
    private String name;
    private String locale;
    private String domain;

    @JsonProperty("support_email")
    private String supportEmail;

    @JsonProperty("auto_resolve_after")
    private Integer autoResolveAfter;

    @JsonProperty("auto_resolve_message")
    private String autoResolveMessage;

    @JsonProperty("auto_resolve_ignore_waiting")
    private Boolean autoResolveIgnoreWaiting;

    private String industry;

    @JsonProperty("company_size")
    private String companySize;

    private String timezone;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocale() {
        return locale;
    }

    public void setLocale(String locale) {
        this.locale = locale;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }

    public String getSupportEmail() {
        return supportEmail;
    }

    public void setSupportEmail(String supportEmail) {
        this.supportEmail = supportEmail;
    }

    public Integer getAutoResolveAfter() {
        return autoResolveAfter;
    }

    public void setAutoResolveAfter(Integer autoResolveAfter) {
        this.autoResolveAfter = autoResolveAfter;
    }

    public String getAutoResolveMessage() {
        return autoResolveMessage;
    }

    public void setAutoResolveMessage(String autoResolveMessage) {
        this.autoResolveMessage = autoResolveMessage;
    }

    public Boolean getAutoResolveIgnoreWaiting() {
        return autoResolveIgnoreWaiting;
    }

    public void setAutoResolveIgnoreWaiting(Boolean autoResolveIgnoreWaiting) {
        this.autoResolveIgnoreWaiting = autoResolveIgnoreWaiting;
    }

    public String getIndustry() {
        return industry;
    }

    public void setIndustry(String industry) {
        this.industry = industry;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }
}
