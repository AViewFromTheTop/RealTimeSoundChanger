package net.lunade.rtsc.block;

import net.minecraft.block.Block;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import java.util.ArrayList;
import java.util.List;


public class BlockSoundGroupOverwrites {

    public static void init() {

    }

    public static void addBlock(String id, BlockSoundGroup sounds) {
        ids.add(new Identifier(id));
        soundGroups.add(sounds);
    }

    public static void addBlock(String nameSpace, String id, BlockSoundGroup sounds) {
        ids.add(new Identifier(nameSpace, id));
        soundGroups.add(sounds);
    }

    public static void addBlock(Block block, BlockSoundGroup sounds) {
        ids.add(Registry.BLOCK.getId(block));
        soundGroups.add(sounds);
    }

    public static void addBlocks(Block[] blocks, BlockSoundGroup sounds) {
        for (Block block : blocks) {
            ids.add(Registry.BLOCK.getId(block));
            soundGroups.add(sounds);
        }
    }

    public static void addNamespace(String nameSpace, BlockSoundGroup sounds) {
        namespaces.add(nameSpace);
        namespaceSoundGroups.add(sounds);
    }

    public static void removeAll() {
        ids.clear();
        soundGroups.clear();
        namespaces.clear();
        namespaceSoundGroups.clear();
    }

    public static List<Identifier> ids = new ArrayList<>();
    public static List<BlockSoundGroup> soundGroups = new ArrayList<>();
    public static List<String> namespaces = new ArrayList<>();
    public static List<BlockSoundGroup> namespaceSoundGroups = new ArrayList<>();
}
