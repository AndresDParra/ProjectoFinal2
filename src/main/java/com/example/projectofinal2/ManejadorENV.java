package com.example.projectofinal2;

import io.github.cdimascio.dotenv.Dotenv;

public class ManejadorENV {
    public static void main(String[] args) {

        Dotenv dotenv = Dotenv.load();
        String mongoString = dotenv.get("MONGO_STRING");
        System.out.println(mongoString);

    }
}
