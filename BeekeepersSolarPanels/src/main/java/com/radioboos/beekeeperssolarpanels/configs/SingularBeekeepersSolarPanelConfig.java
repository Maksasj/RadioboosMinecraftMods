package com.radioboos.beekeeperssolarpanels.configs;

import com.radioboos.beekeeperssolarpanels.common.CommonSolarPanelConfig;

public class SingularBeekeepersSolarPanelConfig extends CommonSolarPanelConfig {
    public SingularBeekeepersSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 100000000;
        this.maxDrain = 6000000;
        this.dayProduction = 3000000;
        this.nightProduction = 1500000;
    }
}
