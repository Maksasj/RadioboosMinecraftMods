package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class ShimmeringBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public ShimmeringBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 10000000;
        this.maxDrain = 280000;
        this.dayProduction = 140000;
        this.nightProduction = 70000;
    }
}
