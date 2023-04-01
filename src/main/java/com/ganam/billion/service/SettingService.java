package com.ganam.billion.service;

import com.ganam.billion.domain.Setting;
import com.ganam.billion.repository.SettingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class SettingService {
    private final SettingRepository repository;

    @Autowired
    public SettingService(SettingRepository repository) {
        this.repository = repository;
    }

    public Optional<Setting> findSettingValue(String setting_key){
        return repository.findSettingValue(setting_key);
    }
}