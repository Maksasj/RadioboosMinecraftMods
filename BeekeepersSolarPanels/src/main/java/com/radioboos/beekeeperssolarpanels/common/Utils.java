package com.radioboos.beekeeperssolarpanels.common;

import net.minecraft.world.World;

import java.util.Random;

public class Utils {
    public static final Random random = new Random();

    public static boolean isDaytime(World world) {
        long time = world.getWorldTime() % 24000;
        return time >= 0 && time < 12000;
    }
}

