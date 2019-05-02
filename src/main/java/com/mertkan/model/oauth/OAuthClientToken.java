package com.mertkan.model.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_client_token")
public class OAuthClientToken {

    @Id
    @Column(name = "authentication_id")
    private String authenticationId;
    @Column(name = "token_id")
    private String tokenId;
    @Column(name = "token")
    private byte[] token;
    @Column(name = "user_name")
    private String username;
    @Column(name = "client_id")
    private String clientId;

    public OAuthClientToken() {
    }

    public String getAuthenticationId() {
        return authenticationId;
    }

    public void setAuthenticationId(String authenticationId) {
        this.authenticationId = authenticationId;
    }

    public String getTokenId() {
        return tokenId;
    }

    public void setTokenId(String tokenId) {
        this.tokenId = tokenId;
    }

    public byte[] getToken() {
        return token;
    }

    public void setToken(byte[] token) {
        this.token = token;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }
}
