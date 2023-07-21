package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class QuintupleCompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public QuintupleCompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 100000000;
        this.maxDrain = 1000000;
        this.dayProduction = 100000;
        this.nightProduction = 10000;
    }
}
