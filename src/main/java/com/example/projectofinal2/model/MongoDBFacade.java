package com.example.projectofinal2.model;

import com.example.projectofinal2.config.Environment;
import com.mongodb.client.*;
import javafx.scene.control.Alert;
import org.bson.Document;

public class MongoDBFacade {

    public static final MongoDatabase db = Environment.INSTANCE.env_value();

    public static void insertUsuario(Usuario usuario) {
        MongoCollection<Document> collection = db.getCollection("usuario");
        Document document = new Document("nombre", usuario.getNombre());
        document.append("correo", usuario.getCorreo());
        document.append("telefono", usuario.getTelefono());
        document.append("id", usuario.getId());
        collection.insertOne(document);
        System.out.println("Usuario insertado correctamente");
    }

    public static void insertCuentaBanco(CuentaBanco cuentaBanco) {
        MongoCollection<Document> collection = db.getCollection("CuentasBanco");
        Document document = new Document("IDcuenta", cuentaBanco.getIdCuenta() );
        document.append("saldo", cuentaBanco.getSaldo());
        Usuario usuario = cuentaBanco.getUsuario();
        Document usuarioDoc = new Document("nombre", usuario.getNombre())
                .append("correo", usuario.getCorreo())
                .append("telefono", usuario.getTelefono())
                .append("id", usuario.getId());
        document.append("usuario", usuarioDoc);
        document.append("contrasena", cuentaBanco.getContrasena());
        document.append("transacciones", CuentaBanco.getTransacciones());
        document.append("DTOtransacciones", CuentaBanco.getDTOtransacciones());
        collection.insertOne(document);
        System.out.println("Usuario insertado correctamente");
    }

    // This is an instance initializer block that should be removed or moved
    // to a method if needed
    private static void showConnectionError() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error de conexión");
        alert.setContentText("No se pudo conectar a la base de datos");
        alert.showAndWait();
    }

    public static void AccessMongoDB() {
        MongoCollection<Document> collection = MongoDBFacade.db.getCollection("CuentasBanco");
        FindIterable<Document> documents = collection.find();

        for (Document doc : documents) {
            CuentaBanco cuentaBanco = new CuentaBanco(
                    doc.getString("idCuenta"),
                    doc.getDouble("saldo"),
                    doc.get("usuario", Usuario.class),
                    doc.getString("telefono"));

            //BilleteraVirtual.getCuentasBanco().add()
        }

        // This might be needed only on error, consider moving to a catch block
        showConnectionError();
    }

    public static void EditarDatosMongo() {
        // Implementation needed here
    }
}