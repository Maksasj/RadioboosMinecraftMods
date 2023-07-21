package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class DoubleCompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public DoubleCompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 100000;
        this.maxDrain = 1000;
        this.dayProduction = 100;
        this.nightProduction = 10;
    }
}
