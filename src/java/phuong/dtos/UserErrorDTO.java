/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package phuong.dtos;

/**
 *
 * @author ACER
 */
public class UserErrorDTO {
    private String userIDError;
    private String fullNameError;
    private String addressError;
    private String phoneError;
    private String passwordError;
    private String confirmError;
    private String roleIDError;

    public UserErrorDTO() {
    }

    public UserErrorDTO(String userIDError, String fullNameError, String addressError, String phoneError, String passwordError, String confirmError, String roleIDError) {
        this.userIDError = userIDError;
        this.fullNameError = fullNameError;
        this.addressError = addressError;
        this.phoneError = phoneError;
        this.passwordError = passwordError;
        this.confirmError = confirmError;
        this.roleIDError = roleIDError;
    }

    public String getUserIDError() {
        return userIDError;
    }

    public void setUserIDError(String userIDError) {
        this.userIDError = userIDError;
    }

    public String getFullNameError() {
        return fullNameError;
    }

    public void setFullNameError(String fullNameError) {
        this.fullNameError = fullNameError;
    }

    public String getAddressError() {
        return addressError;
    }

    public void setAddressError(String addressError) {
        this.addressError = addressError;
    }

    public String getPhoneError() {
        return phoneError;
    }

    public void setPhoneError(String phoneError) {
        this.phoneError = phoneError;
    }

    public String getPasswordError() {
        return passwordError;
    }

    public void setPasswordError(String passwordError) {
        this.passwordError = passwordError;
    }

    public String getConfirmError() {
        return confirmError;
    }

    public void setConfirmError(String confirmError) {
        this.confirmError = confirmError;
    }

    public String getRoleIDError() {
        return roleIDError;
    }

    public void setRoleIDError(String roleIDError) {
        this.roleIDError = roleIDError;
    }

    
    
    
}
