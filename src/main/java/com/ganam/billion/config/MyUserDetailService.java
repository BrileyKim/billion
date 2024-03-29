package com.ganam.billion.config;

import com.ganam.billion.domain.Setting;
import com.ganam.billion.service.SettingService;
import com.mysql.cj.exceptions.PasswordExpiredException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class MyUserDetailService implements UserDetailsService {

    private final SettingService settingService;

    @Autowired
    public MyUserDetailService(SettingService settingService){this.settingService = settingService;}

    @Override
    public UserDetails loadUserByUsername(String insertedPhone) throws UsernameNotFoundException {

        Optional<Setting> phone= settingService.findSettingValue("phone");
        Setting phoneSetting = phone.orElseThrow(() -> new UsernameNotFoundException("전화번호를 다시 입력해주세요."));

        Optional<Setting> nickname = settingService.findSettingValue("nickname");
        Setting nameSetting = nickname.orElseThrow(() -> new UsernameNotFoundException("부적절한 닉네임입니다."));

        Optional<Setting> password = settingService.findSettingValue("password");
        Setting passwordSetting = password.orElseThrow(() -> new PasswordExpiredException("비밀번호를 다시 입력해주세요."));

        return User.builder()
                .username(nameSetting.getSetting_value())
                .password(passwordSetting.getSetting_value())
                .roles("관리자")
                .build();
    }

}
