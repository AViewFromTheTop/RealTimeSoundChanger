package net.lunade.rtsc.config;

import net.fabricmc.loader.api.FabricLoader;

import javax.json.Json;
import javax.json.JsonObject;
import javax.json.JsonReader;
import javax.json.stream.JsonGenerator;
import java.io.*;
import java.nio.file.Files;

public class configManager {

    public static File initial = FabricLoader.getInstance().getConfigDirectory();
    public static File dir2 = new File(initial, "rtsc");
    public static File dir = new File(dir2, "config.json");
    public static boolean writing;

    public static void createConfig() {
        writing = true;
        dir2.mkdirs();
        if (!Files.exists(dir.toPath())) {
            FileWriter writer = null;
            try {
                writer = new FileWriter(dir);
            } catch (IOException e) {
                e.printStackTrace();
            }
            JsonGenerator generator = Json.createGenerator(writer);
            generator.writeStartObject();
            generator.write("enabled", true);
            generator.writeEnd();
            generator.close();
        }
        writing = false;
    }

    public static boolean isEnabled() throws FileNotFoundException {
        if (!writing) {
            InputStream input = new FileInputStream(dir);
            JsonReader read = Json.createReader(input);
            JsonObject json = read.readObject();
            read.close();
            return json.getBoolean("enabled");
        } return false;
    }

    public static void setEnabled(Boolean config) throws FileNotFoundException {
        writing = true;
        dir2.mkdirs();
        FileWriter writer = null;
        try {
            writer = new FileWriter(dir);
        } catch (IOException e) {
            e.printStackTrace();
        }
        JsonGenerator generator = Json.createGenerator(writer);
        generator.writeStartObject();
        generator.write("enabled", config);
        generator.writeEnd();
        generator.close();
        writing = false;
    }

}
