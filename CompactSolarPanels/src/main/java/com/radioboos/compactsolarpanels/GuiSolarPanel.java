package com.radioboos.compactsolarpanels;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;

    public class GuiSolarPanel extends GuiScreen {
        public static final int GUI_ID = 20;

        public GuiSolarPanel() {
            System.out.print("gui constructor.\n");

        }

        @Override
        public void initGui() {
            buttonList.clear();
            buttonList.add(new GuiButton(0, 100, 100, 60, 60, "Button"));
        }

        @Override
        public boolean doesGuiPauseGame() {
            return false;
        }

        @Override
        public void drawScreen(int i, int j, float f) {
            drawDefaultBackground();
            super.drawScreen(i, j, f);
            System.out.print("drawing gui.\n");
        }

        @Override
        public void actionPerformed(GuiButton button) {
            System.out.print("button clicked.\n");

        }
    }