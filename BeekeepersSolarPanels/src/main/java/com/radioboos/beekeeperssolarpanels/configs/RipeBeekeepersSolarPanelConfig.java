package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class RipeBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public RipeBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 100000;
        this.maxDrain = 1000;
        this.dayProduction = 100;
        this.nightProduction = 10;
    }
}
