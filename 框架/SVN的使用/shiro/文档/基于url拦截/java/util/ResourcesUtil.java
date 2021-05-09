package com.sxt.util;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lenovo on 2019/5/6.
 */
public class ResourcesUtil {
    private static List<String> anyone = new ArrayList<String>();
    private static List<String> admin = new ArrayList<String>();
    static{
        anyone.add("login");
        anyone.add("register");
        anyone.add("toLogin");
        admin.add("main");
        admin.add("edit");
    }

    public static List<String> getValue(String key) throws Exception{
        if(StringUtils.isNotEmpty(key)){
            if("anyone".equals(key)){
                return anyone;
            }else if("admin".equals(key)){
                return admin;
            }
        }
        return null;
    }

}
