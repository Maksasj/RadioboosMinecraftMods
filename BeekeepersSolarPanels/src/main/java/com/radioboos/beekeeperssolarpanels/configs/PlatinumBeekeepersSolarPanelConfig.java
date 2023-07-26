package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class PlatinumBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public PlatinumBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 100000000;
        this.maxDrain = 3000000;
        this.dayProduction = 1400000;
        this.nightProduction = 700000;
    }
}
