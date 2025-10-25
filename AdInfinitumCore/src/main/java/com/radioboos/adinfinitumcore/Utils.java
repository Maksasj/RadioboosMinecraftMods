package com.radioboos.adinfinitumcore;

import net.minecraft.world.World;

public class Utils {
    public static boolean isDaytime(World world) {
        long time = world.getWorldTime() % 24000;
        return time >= 0 && time < 12000;
    }

    public static String euEnergyToString(double energy) {
        if (energy == 0)
            return "0.0";

        final String[] units = new String[]{ "", "k", "M", "G", "T", "P", "E" };
        final int base = 1000;

        int unitIndex = (int) (Math.floor(Math.log10(Math.abs(energy)) / 3));
        unitIndex = Math.min(unitIndex, units.length - 1);

        double divisor = Math.pow(base, unitIndex);

        return String.format("%.1f%s", energy / divisor, units[unitIndex]);
    }

    public static boolean inRange(double value, double min, double max) {
        return (value >= min) && (value < max);
    }
}

