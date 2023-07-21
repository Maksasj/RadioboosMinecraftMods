package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class SextupleCompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public SextupleCompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 1000000000;
        this.maxDrain = 10000000;
        this.dayProduction = 1000000;
        this.nightProduction = 100000;
    }
}
