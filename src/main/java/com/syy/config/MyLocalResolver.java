package com.syy.config;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MyLocalResolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
//        国际化：获取请求中的语言参数
        String language=httpServletRequest.getParameter("l");

        System.out.println(language);
        Locale locale=Locale.getDefault();
        if (!StringUtils.isEmpty(language)){
            String[] split=language.split("_");
            locale=new Locale(split[0],split[1]);

        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
