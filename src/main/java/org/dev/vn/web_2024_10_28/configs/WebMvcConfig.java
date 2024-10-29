package org.dev.vn.web_2024_10_28.configs;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;

import java.util.Locale;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Bean(name = "localeResolver")
    public LocaleResolver getLocaleResolver() {
        CookieLocaleResolver resolver = new CookieLocaleResolver();
        resolver.setDefaultLocale(Locale.forLanguageTag("vi-VN")); // Đặt ngôn ngữ mặc định là tiếng Việt
        resolver.setCookieMaxAge(3600); // Cookie tồn tại trong 1 giờ
        return resolver;
    }

    @Bean(name = "messageSource")
    public MessageSource getMessageResource() {
        ReloadableResourceBundleMessageSource messageResource = new ReloadableResourceBundleMessageSource();
        messageResource.setBasename("classpath:i18n/messages"); // Đường dẫn tới các tệp message
        messageResource.setDefaultEncoding("UTF-8"); // Đảm bảo UTF-8 để hiển thị tiếng Việt
        messageResource.setCacheSeconds(3600); // Thời gian cache 1 giờ
        return messageResource;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        LocaleChangeInterceptor localeInterceptor = new LocaleChangeInterceptor();
        localeInterceptor.setParamName("language"); // Tham số URL để thay đổi ngôn ngữ
        registry.addInterceptor(localeInterceptor).addPathPatterns("/**");
    }
}