package com.fati.exceptionhandling.configuration;

import com.fati.exceptionhandling.model.I18NMessage;
import com.fati.exceptionhandling.repository.I18NMessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.context.support.AbstractMessageSource;
import org.springframework.stereotype.Component;

import java.text.MessageFormat;
import java.util.Locale;

/**
 * author @ fati
 * created @ 7.09.2020
 */

@Component
@RequiredArgsConstructor
public class CustomDBMessageSource extends AbstractMessageSource {

    public static final String DEFAULT_LOCALE = "tr";

    private final I18NMessageRepository i18NMessageRepository;

    @Override
    protected MessageFormat resolveCode(String s, Locale locale) {
        I18NMessage message = i18NMessageRepository.findByCodeAndLocale(s, locale.getLanguage());
        if (message == null) {
            message = i18NMessageRepository.findByCodeAndLocale(s, DEFAULT_LOCALE);
        }
        return new MessageFormat(message.getMessage(), locale);
    }
}
