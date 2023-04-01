package com.ganam.billion.repository;

import com.ganam.billion.domain.Setting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface SettingRepository extends JpaRepository<Setting,String> {

    @Query(value="SELECT s FROM setting s WHERE setting_key = :setting_key")
    Optional<Setting> findSettingValue(@Param("setting_key") String setting_key);

}
