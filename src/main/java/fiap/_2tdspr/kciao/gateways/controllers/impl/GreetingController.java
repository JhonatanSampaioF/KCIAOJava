package fiap._2tdspr.kciao.gateways.controllers.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Locale;

@RestController
@RequiredArgsConstructor
public class GreetingController {

    private final MessageSource messageSource;

    @GetMapping("/greeting")
    public String greet(Locale locale) {
        return messageSource.getMessage("greeting", null, locale);
    }
}

