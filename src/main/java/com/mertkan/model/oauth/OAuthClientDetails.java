package com.mertkan.model.oauth;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "oauth_client_details")
public class OAuthClientDetails {

    @Id
    @Column(name = "client_id", nullable = false)
    private String clientId;
    @Column(name = "resource_ids")
    private String resourceIds;
    @Column(name = "client_secret")
    private String clientSecret;
    @Column(name = "scope")
    private String scope;
    @Column(name = "authorized_grant_types")
    private String grantTypes;
    @Column(name = "web_server_redirect_uri")
    private String redirectURI;
    @Column(name = "authorities")
    private String authorities;
    @Column(name = "access_token_validity")
    private int access_token_validity;
    @Column(name = "refresh_token_validity")
    private int refresh_token_validity;
    @Column(name = "additional_information")
    private String info;
    @Column(name = "autoapprove")
    private String autoapprove;


    public OAuthClientDetails() {
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds;
    }

    public String getClientSecret() {
        return clientSecret;
    }

    public void setClientSecret(String clientSecret) {
        this.clientSecret = clientSecret;
    }

    public String getScope() {
        return scope;
    }

    public void setScope(String scope) {
        this.scope = scope;
    }

    public String getGrantTypes() {
        return grantTypes;
    }

    public void setGrantTypes(String grantTypes) {
        this.grantTypes = grantTypes;
    }

    public String getRedirectURI() {
        return redirectURI;
    }

    public void setRedirectURI(String redirectURI) {
        this.redirectURI = redirectURI;
    }

    public String getAuthorities() {
        return authorities;
    }

    public void setAuthorities(String authorities) {
        this.authorities = authorities;
    }

    public int getAccess_token_validity() {
        return access_token_validity;
    }

    public void setAccess_token_validity(int access_token_validity) {
        this.access_token_validity = access_token_validity;
    }

    public int getRefresh_token_validity() {
        return refresh_token_validity;
    }

    public void setRefresh_token_validity(int refresh_token_validity) {
        this.refresh_token_validity = refresh_token_validity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getAutoapprove() {
        return autoapprove;
    }

    public void setAutoapprove(String autoapprove) {
        this.autoapprove = autoapprove;
    }
}
