package net.lunade.rtsc;

import net.fabricmc.api.ClientModInitializer;

import java.io.FileNotFoundException;

public class RTSCClient implements ClientModInitializer {

    @Override
    public void onInitializeClient() {
        BlockSoundGroupOverwrites.init();
        try {
            realTimeSoundWriter.writeSoundsJSON();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }
}