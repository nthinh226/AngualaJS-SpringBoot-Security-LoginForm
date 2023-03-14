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
public class SigningResponse {
// signer_signed
    private String action;
    private String token;
    private String signer;
    private SingerInfo signer_info;
    private String status;
    private String file;
    private String file_digest;
    private String valid_to;
    private String signature_id;

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getSigner() {
        return signer;
    }

    public void setSigner(String signer) {
        this.signer = signer;
    }

    public SingerInfo getSigner_info() {
        return signer_info;
    }

    public void setSigner_info(SingerInfo signer_info) {
        this.signer_info = signer_info;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }

    public String getFile_digest() {
        return file_digest;
    }

    public void setFile_digest(String file_digest) {
        this.file_digest = file_digest;
    }

    public String getValid_to() {
        return valid_to;
    }

    public void setValid_to(String valid_to) {
        this.valid_to = valid_to;
    }

    public String getSignature_id() {
        return signature_id;
    }

    public void setSignature_id(String signature_id) {
        this.signature_id = signature_id;
    }

}
