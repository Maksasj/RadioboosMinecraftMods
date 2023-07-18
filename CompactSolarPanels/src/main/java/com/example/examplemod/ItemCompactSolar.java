/*******************************************************************************
 * Copyright (c) 2012 cpw.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the GNU Public License v3.0
 * which accompanies this distribution, and is available at
 * http://www.gnu.org/licenses/gpl.html
 *
 * Contributors:
 *     cpw - initial API and implementation
 ******************************************************************************/
package com.example.examplemod;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;

import java.util.List;

public class ItemCompactSolar extends ItemBlock {
    public ItemCompactSolar(net.minecraft.block.Block block) {
        super(block);
    }

    @Override
    public void addInformation(ItemStack stack, EntityPlayer player, List lines, boolean advancedTooltips) {
        lines.add("This line will appear in");
        lines.add("the tooltip of the Block");
        lines.add("when it's moused over in");
        lines.add("your inventory.");
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        return "wtfadsad";
    }
}