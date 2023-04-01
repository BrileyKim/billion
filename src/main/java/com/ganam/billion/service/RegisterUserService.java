package com.ganam.billion.service;

import com.ganam.billion.domain.Setting;
import com.ganam.billion.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class RegisterUserService {

    private final PasswordEncoder passwordEncoder;
    private final SettingRepository settingRepository;

    @Autowired
    public RegisterUserService(PasswordEncoder passwordEncoder, SettingRepository settingRepository) {
        this.passwordEncoder = passwordEncoder;
        this.settingRepository = settingRepository;
    }

    public void join(String phone, String password){

        Setting s1 = Setting.createSetting("phone",phone);
        Setting s2 = Setting.createPassword(password, passwordEncoder);

        settingRepository.save(s1);
        settingRepository.save(s2);
    }



}


