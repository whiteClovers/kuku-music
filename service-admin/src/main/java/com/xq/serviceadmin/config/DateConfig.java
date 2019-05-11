package com.xq.serviceadmin.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.convert.converter.Converter;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @program: kukuMusic
 * @description:
 * @author: Mr.Fu
 * @create: 2019-05-08 15:28
 **/

@Configuration
public class DateConfig{
    @Bean
    public Converter<String, Date> addNewConvert() {
        return new Converter<String, Date>() {
            @Override
            public Date convert(String source) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                Date date = null;
                try {
                    date = sdf.parse((String) source);
                } catch (ParseException e) {
                    SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                    try {
                        date = sdf2.parse(source);
                    } catch (ParseException e1) {
                        SimpleDateFormat sdf3 = new SimpleDateFormat("yyyy-MM-dd");
                        try {
                            date = sdf3.parse(source);
                        } catch (ParseException e2) {
//                            LOG.error("日期格式转换出错 ", e);
                            System.out.println("日期格式转换出错 ");
                        }
                    }
                }
                return date;
            }
        };
    }
}
