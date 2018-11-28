package com.leiwan.zl.utils;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Administrator on 2018/11/16.
 */

public class MMap {
    public static Map<String, Object> map;

    public static Map getMap(int provincecode, int citycode,String app,String android) {
        map = new HashMap<>();
        map.put("provincecode", provincecode);
        map.put("citycode", citycode);
//        map.put("sign", sign);
        map.put("product", app);
        map.put("platform", android);
        return map;
    }
}
