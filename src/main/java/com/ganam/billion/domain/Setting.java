package com.ganam.billion.domain;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity(name="setting")
@Data
@NoArgsConstructor
public class Setting {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="setting_key")
    private String setting_key;

    @Column(nullable = false, name = "setting_value")
    private String setting_value;

    public Setting(String setting_key, String setting_value) {
        this.setting_key = setting_key;
        this.setting_value = setting_value;
    }

    public static Setting createSetting(String setting_key, String setting_value){
        return new Setting(setting_key, setting_value);
    }

    public static Setting createPassword(String password, PasswordEncoder passwordEncoder){
        return new Setting("password",passwordEncoder.encode(password));
    }


}
