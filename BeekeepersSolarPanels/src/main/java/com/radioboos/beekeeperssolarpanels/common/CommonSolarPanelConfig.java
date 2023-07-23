package com.radioboos.beekeeperssolarpanels.common;

import net.minecraftforge.common.config.Configuration;

public class CommonSolarPanelConfig {
    private final String configLabel;
    protected double capacity;
    protected double maxDrain;
    protected double dayProduction;
    protected double nightProduction;

    public CommonSolarPanelConfig(String configLabel) {
        this.configLabel = configLabel;

        this.capacity = 0;
        this.maxDrain = 0;
        this.dayProduction = 0;
        this.nightProduction = 0;
    }

    public void loadConfig(Configuration configuration) {
        capacity = configuration.get(configLabel, "capacity", capacity).getDouble();
        maxDrain = configuration.get(configLabel, "maxDrain", maxDrain).getDouble();
        dayProduction = configuration.get(configLabel, "dayProduction", dayProduction).getDouble();
        nightProduction = configuration.get(configLabel, "nightProduction", nightProduction).getDouble();
    }

    public double getCapacity() {
        return capacity;
    }

    public double getMaxDrain() {
        return maxDrain;
    }

    public double getDayProduction() {
        return dayProduction;
    }

    public double getNightProduction() {
        return nightProduction;
    }
}
