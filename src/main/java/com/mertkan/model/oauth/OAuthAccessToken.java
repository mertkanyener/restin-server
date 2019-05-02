package com.mertkan.model.oauth;



import javax.persistence.*;

@Entity
@Table(name = "oauth_access_token")
public class OAuthAccessToken {

    @Id
    @Column(name = "authentication_id")
    private String authenticationId;
    @Column(name = "token_id")
    private String tokenId;
    @Column(name = "token")
    @Lob
    private byte[] token;
    @Column(name = "user_name")
    private String username;
    @Column(name = "client_id")
    private String clientId;
    @Column(name = "authentication")
    @Lob
    private byte[] authentication;
    @Column(name = "refresh_token")
    private String refreshToken;

    public OAuthAccessToken() {
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

    public byte[] getAuthentication() {
        return authentication;
    }

    public void setAuthentication(byte[] authentication) {
        this.authentication = authentication;
    }

    public String getRefreshToken() {
        return refreshToken;
    }

    public void setRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }
}
