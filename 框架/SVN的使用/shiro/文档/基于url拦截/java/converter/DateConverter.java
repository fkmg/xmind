package com.sxt.converter;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.springframework.core.convert.converter.Converter;

import java.util.Date;

/**
 * 通用型日期转换器
 */
public class DateConverter implements Converter<String, Date> {
    @Override
    public Date convert(String s) {
        // s!=null && !"".equals(s)
        if (StringUtils.isNotEmpty(s)) {
            String[] pattern = new String[]{"yyyy-MM", "yyyyMMddHHmmss", "yyyyMMdd", "yyyyMM", "yyyy/MM", "yyyy-MM-dd HH:mm:ss", "yyyy-MM-dd'T'HH:mm", "yyyy-MM-dd'T'HH:mm:ss", "yyyy/MM/dd HH:mm:ss",
                    "yyyy-MM-dd", "yyyy/MM/dd", "yyyy年MM月dd日 HH时mm分ss秒", "yyyy年MM月dd日"};
            try {
                Date d = DateUtils.parseDate(s, pattern);
                return d;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
