package com.radioboos.industriousbatteries.common;

import net.minecraft.world.World;

import java.time.temporal.ValueRange;
import java.util.Random;

public class Utils {
    public static final Random random = new Random();

    public static boolean isDaytime(World world) {
        long time = world.getWorldTime() % 24000;
        return time >= 0 && time < 12000;
    }

    public static String euEnergyToString(double energy) {
        double energyAbs = Math.abs(energy);

        if(inRange(energyAbs, 0.0, 1000.0)) {
            return String.format("%.1f", energy);
        } else if (inRange(energyAbs, 1000.0, 1000000.0)) {
            return String.format("%.1fk", energy / 1000.0);
        } else if (inRange(energyAbs, 1000000.0, 1000000000.0)) {
            return String.format("%.1fM", energy / 1000000.0);
        }

        return String.format("%.1fG", energy / 1000000000.0);
    }

    public static boolean inRange(double value, double min, double max) {
        return (value >= min) && (value < max);
    }
}

