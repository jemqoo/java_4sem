package com.example.demo;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;


@SpringBootApplication
public class FileHasher {

    private File inputFile;
    private File hashedFile;

    public FileHasher(File inputFile, File hashedFile) {
        this.inputFile = inputFile;
        this.hashedFile = hashedFile;
    }

    @PostConstruct
    public void hashFile() throws IOException, NoSuchAlgorithmException {
        byte[] inputBytes = Files.readAllBytes(inputFile.toPath());
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hashedBytes = digest.digest(inputBytes);
        String hashedString = new String(hashedBytes, StandardCharsets.UTF_8);
        FileWriter writer = new FileWriter(hashedFile);
        writer.write(hashedString);
        writer.close();
        inputFile.delete();
    }

    @PreDestroy
    public void cleanup() {
        hashedFile.delete();
    }

    public static void main(String[] args) throws IOException, NoSuchAlgorithmException {
        String currDir = "C:\\Users\\at0m\\IdeaProjects\\javaPract_semestr4\\p12\\src\\main\\java\\com\\example\\demo\\";
        File inputFile = new File(currDir + args[0] + ".txt");
        File hashedFile = new File(currDir + args[1] + ".txt");

        System.out.println("input: " + inputFile);
        System.out.println("output: " + hashedFile);

        if (!inputFile.exists()) {
            System.out.println("worked here");
            hashedFile.createNewFile();
            FileWriter writer = new FileWriter(hashedFile);
            writer.write("null");
            writer.close();
            return;
        }

        System.out.println("worked");

        FileHasher fileHasher = new FileHasher(inputFile, hashedFile);
        fileHasher.hashFile();
    }
}