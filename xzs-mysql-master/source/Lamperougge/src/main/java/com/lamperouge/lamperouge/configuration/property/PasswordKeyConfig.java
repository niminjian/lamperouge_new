package com.lamperouge.lamperouge.configuration.property;

/**
 * @author nmj
 * @create 2022-01-11 15:24
 */
public class PasswordKeyConfig {

    private String publicKey;

    private String privateKey;

    public String getPublicKey() {
        return publicKey;
    }

    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }

    public String getPrivateKey() {
        return privateKey;
    }

    public void setPrivateKey(String privateKey) {
        this.privateKey = privateKey;
    }
}
