package com.dantorrey.shoppinglist.util;

import org.hashids.Hashids;

public class IdObfuscator {


    private static final int MIN_LENGTH = 10;
    private static String salt = "AVeryGoodHashO1234";


    public static String enc(Long id) {

        Hashids hashIds = new Hashids(salt, MIN_LENGTH);
        return hashIds.encode(id);
    }

    public static Long dec(String obfuscatedId) {

        Hashids hashIds = new Hashids(salt, MIN_LENGTH);
        long[] ids = hashIds.decode(obfuscatedId);

        if (ids.length > 0) {
            return obfuscatedId == null ? null : ids[0];
        }

        return null;
    }
}
