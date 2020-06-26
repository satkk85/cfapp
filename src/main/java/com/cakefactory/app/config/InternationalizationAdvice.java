package com.cakefactory.app.config;

import com.samskivert.mustache.Mustache;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.Locale;

// TODO: Need to investigate https://stackoverflow.com/questions/54225243/why-doesnt-my-spring-boot-application-render-messages-properties-in-mustache-te

@ControllerAdvice
public class InternationalizationAdvice {

    private final MessageSource message;

    public InternationalizationAdvice(@Qualifier("messageSource") MessageSource message) {
        this.message = message;
    }

    @ModelAttribute("i18n")
    public Mustache.Lambda i18n(Locale locale){
        return (frag, out) -> {
            String body = frag.execute();
            String message = this.message.getMessage(body, null, locale);
            out.write(message);
        };
    }
}
