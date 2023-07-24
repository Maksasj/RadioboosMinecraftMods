package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class ShimmeringBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public ShimmeringBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 1000000;
        this.maxDrain = 16000;
        this.dayProduction = 8000;
        this.nightProduction = 4000;
    }
}
