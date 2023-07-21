package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class CompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public CompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 10000;
        this.maxDrain = 100;
        this.dayProduction = 10;
        this.nightProduction = 1;
    }
}
