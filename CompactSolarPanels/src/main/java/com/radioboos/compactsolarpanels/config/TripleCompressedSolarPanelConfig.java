package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class TripleCompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public TripleCompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 1000000;
        this.maxDrain = 10000;
        this.dayProduction = 1000;
        this.nightProduction = 100;
    }
}
