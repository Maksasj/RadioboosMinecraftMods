package com.radioboos.industriousbatteries.blocks;

import com.radioboos.industriousbatteries.common.CommonBlock;
import com.radioboos.industriousbatteries.common.CommonItemBlock;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockRegister {
    static public CommonBlock TEST_BLOCK = new CommonBlock("testBlock");
    static public void register() {
        GameRegistry.registerBlock(TEST_BLOCK, CommonItemBlock.class, "testBlock");
    }
}
