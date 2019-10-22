package com.company;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

public class FileUtils {
    public static void writeObject(String filename, Object object, StandardOpenOption...options) {
        Path path = Paths.get(filename);
        try (ObjectOutputStream out = new ObjectOutputStream(Files.newOutputStream(path, options))){
            out.writeObject(object);
        } catch (Exception e) {
            View.getInstance().showErrorMessage(String.format("Failed to save to %s.", filename));
        }
    }
    public static Object readObject(String filename) {
        Path path = Paths.get(filename);
        try (ObjectInputStream in = new ObjectInputStream(Files.newInputStream(path))){
            return in.readObject();
        } catch (Exception e) {
            View.getInstance().showErrorMessage(String.format("Failed to load from %s.", filename));
        }
        return null;
    }
}
