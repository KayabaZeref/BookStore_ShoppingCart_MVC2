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
public class UserDTO {
    private String userID;
    private String fullName;
    private String address;
    private String phone;
    private String password;
    private String roleID;

    public UserDTO() {
    }

    public UserDTO(String userID, String fullName, String address, String phone, String password, String roleID) {
        this.userID = userID;
        this.fullName = fullName;
        this.address = address;
        this.phone = phone;
        this.password = password;
        this.roleID = roleID;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoleID() {
        return roleID;
    }

    public void setRoleID(String roleID) {
        this.roleID = roleID;
    }

    @Override
    public String toString() {
        return "UserDTO{" + "userID=" + userID + ", fullName=" + fullName + ", address=" + address + ", phone=" + phone + ", password=" + password + ", roleID=" + roleID + '}';
    }

    

    
    
    

}
