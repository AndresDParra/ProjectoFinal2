module com.example.projectofinal2 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires net.synedra.validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.almasb.fxgl.all;
    requires com.google.gson;
    requires com.nimbusds.jose.jwt;
    requires static lombok;
    requires io.github.cdimascio.dotenv.java;
    requires org.mongodb.driver.core;
    requires org.mongodb.driver.sync.client;
    requires org.mongodb.bson;
    requires annotations;

    opens com.example.projectofinal2 to javafx.fxml;
    opens com.example.projectofinal2.model to com.nimbusds.jose.jwt;
    opens com.example.projectofinal2.controllers to javafx.fxml;
    exports com.example.projectofinal2;
}