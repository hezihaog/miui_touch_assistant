package com.zh.touchassistant.database.util;

import java.util.UUID;

public class UUIDUtil {
    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}