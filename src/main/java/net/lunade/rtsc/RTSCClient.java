package net.lunade.rtsc;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.command.v1.ClientCommandManager;
import net.lunade.rtsc.block.BlockSoundGroupOverwrites;

import java.io.FileNotFoundException;

public class RTSCClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        try {
            RealTimeSoundWriter.writeSoundsJSON();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        BlockSoundGroupOverwrites.init();
        EnableDisableCommand.register((ClientCommandManager.DISPATCHER));
    }



}