package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class DiamondBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public DiamondBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 50000000;
        this.maxDrain = 1600000;
        this.dayProduction = 800000;
        this.nightProduction = 400000;
    }
}
