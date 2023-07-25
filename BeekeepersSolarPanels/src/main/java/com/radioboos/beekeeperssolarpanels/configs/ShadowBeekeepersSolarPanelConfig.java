package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class ShadowBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public ShadowBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 5000000;
        this.maxDrain = 50000;
        this.dayProduction = 25000;
        this.nightProduction = 12500;
    }
}
