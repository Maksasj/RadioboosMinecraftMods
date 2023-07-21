package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class QuadrupleCompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public QuadrupleCompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 10000000;
        this.maxDrain = 100000;
        this.dayProduction = 10000;
        this.nightProduction = 1000;
    }
}
