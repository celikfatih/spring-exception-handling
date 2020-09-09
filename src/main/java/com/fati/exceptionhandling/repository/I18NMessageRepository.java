package com.fati.exceptionhandling.repository;

import com.fati.exceptionhandling.model.I18NMessage;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * author @ fati
 * created @ 7.09.2020
 */

public interface I18NMessageRepository extends JpaRepository<I18NMessage, Long> {
    I18NMessage findByCodeAndLocale(String code, String locale);
}
