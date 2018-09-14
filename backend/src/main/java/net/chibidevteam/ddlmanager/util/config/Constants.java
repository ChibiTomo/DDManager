package net.chibidevteam.ddlmanager.util.config;

import java.util.Comparator;

public class Constants {

    public static final int                 PRIME_NBR          = 31;

    public static final Comparator<Integer> INTEGER_COMPARATOR = Comparator.nullsFirst(Integer::compareTo);

    private Constants() {
    }
}
