package com.orgsync.api.v2.models;

import java.util.List;

/**
 * A simple POJO that matches the expected JSON request
 */
public class AccountCreateRequest {
    private String username;
    private boolean sendWelcome;
    private String welcomeMessage;
    private AccountAttributes accountAttributes;
    private List<Integer> portals;
    private List<Integer> groups;
    private List<String> identificationCardNumbers;

    public AccountCreateRequest(String username, boolean sendWelcome, String welcomeMessage,
                                 AccountAttributes accountAttributes, List<Integer> portals,
                                 List<Integer> groups, List<String> identificationCardNumbers) {
        this.username = username;
        this.sendWelcome = sendWelcome;
        this.welcomeMessage = welcomeMessage;
        this.accountAttributes = accountAttributes;
        this.portals = portals;
        this.groups = groups;
        this.identificationCardNumbers = identificationCardNumbers;
    }

    public String getUsername() {
        return username;
    }

    public boolean isSendWelcome() {
        return sendWelcome;
    }

    public String getWelcomeMessage() {
        return welcomeMessage;
    }

    public AccountAttributes getAccountAttributes() {
        return accountAttributes;
    }

    public List<Integer> getPortals() {
        return portals;
    }

    public List<Integer> getGroups() {
        return groups;
    }

    public List<String> getIdentificationCardNumbers() {
        return identificationCardNumbers;
    }
}