package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class SulfuricBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public SulfuricBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 7000000;
        this.maxDrain = 140000;
        this.dayProduction = 70000;
        this.nightProduction = 35000;
    }
}
