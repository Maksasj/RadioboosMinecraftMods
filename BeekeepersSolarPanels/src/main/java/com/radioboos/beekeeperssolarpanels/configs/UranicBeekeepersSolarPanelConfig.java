package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class UranicBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public UranicBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 2000000;
        this.maxDrain = 650000;
        this.dayProduction = 325000;
        this.nightProduction = 162500;
    }
}
