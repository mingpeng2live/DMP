package com.admaster.dmp.util;

import java.util.UUID;

/**
 * uuid util
 *
 * @author pengming
 * @Date  2015年11月13日 下午7:35:01
 */
public abstract class GuidGenerator {


    /**
     * private constructor
     */
    private GuidGenerator() {
    }

    public static String generate() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }
}