package net.lunade.rtsc;

import com.mojang.brigadier.CommandDispatcher;
import net.fabricmc.fabric.api.client.command.v1.FabricClientCommandSource;
import net.lunade.rtsc.config.configManager;

import java.io.FileNotFoundException;

import static net.fabricmc.fabric.api.client.command.v1.ClientCommandManager.literal;


public class EnableDisableCommand {

    public static void register(CommandDispatcher<FabricClientCommandSource> dispatcher) {
        dispatcher.register(literal("rtsc")
                        .then(literal("enable")
                                .executes(context -> {
                                    try {
                                        return enable();
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    return 0;
                                }))
                        .then(literal("disable")
                                .executes(context -> {
                                    try {
                                        return disable();
                                    } catch (FileNotFoundException e) {
                                        e.printStackTrace();
                                    }
                                    return 0;
                                })));
    }

    private static int disable() throws FileNotFoundException {
        configManager.setEnabled(false);
        return 1;
    }

    private static int enable() throws FileNotFoundException {
        configManager.setEnabled(true);
        return 1;
    }

}
