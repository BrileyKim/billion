package com.ganam.billion.service;

import com.ganam.billion.domain.Setting;
import com.ganam.billion.dto.UserDto;
import com.ganam.billion.repository.SettingRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class RegisterUserService {

    private final PasswordEncoder passwordEncoder;
    private final SettingRepository settingRepository;

    @Autowired
    public RegisterUserService(PasswordEncoder passwordEncoder, SettingRepository settingRepository) {
        this.passwordEncoder = passwordEncoder;
        this.settingRepository = settingRepository;
    }

    public void join(UserDto dto){

        Setting s1 = Setting.createSetting("phone",dto.getPhone());
        Setting s2 = Setting.createPassword(dto.getPassword(), passwordEncoder);
        Setting s3 = Setting.createSetting("nickname",dto.getNickname());

        settingRepository.save(s1);
        settingRepository.save(s2);
        settingRepository.save(s3);
    }



}


