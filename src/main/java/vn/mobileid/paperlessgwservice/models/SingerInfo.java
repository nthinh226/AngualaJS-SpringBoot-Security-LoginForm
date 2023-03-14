/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vn.mobileid.paperlessgwservice.models;

/**
 *
 * @author MSI-NT
 */
public class SingerInfo {

    private String code;
    private String phone;
    private Certificate certificate;
    private String signing_time;
    private String signing_option;
    private String type;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Certificate getCertificate() {
        return certificate;
    }

    public void setCertificate(Certificate certificate) {
        this.certificate = certificate;
    }

    public String getSigning_time() {
        return signing_time;
    }

    public void setSigning_time(String signing_time) {
        this.signing_time = signing_time;
    }

    public String getSigning_option() {
        return signing_option;
    }

    public void setSigning_option(String signing_option) {
        this.signing_option = signing_option;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
    
    
}
