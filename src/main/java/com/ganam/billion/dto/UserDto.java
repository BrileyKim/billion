package com.ganam.billion.dto;

public class UserDto {

    private String nickname;
    private String phone;

    private String password;

    public String getNickname() {return nickname;}
    public void setNickname(String nickname) {this.nickname = nickname;}

    public String getPhone() {return phone;}

    public void setPhone(String phone) {this.phone = phone;}

    public String getPassword() {return password;}

    public void setPassword(String password) {this.password = password;}

    private UserDto(String nickname,String phone, String password){
        this.nickname = nickname;
        this.phone = phone;
        this.password = password;
    }

}
