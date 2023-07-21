package com.radioboos.compactsolarpanels.config;

import com.radioboos.compactsolarpanels.common.CommonSolarPanelConfig;

public class SeptupleCompressedSolarPanelConfig extends CommonSolarPanelConfig {
    public SeptupleCompressedSolarPanelConfig(String configLabel) {
        super(configLabel);

        this.capacity = 2147483647;
        this.maxDrain = 100000000;
        this.dayProduction = 10000000;
        this.nightProduction = 1000000;
    }
}
