package com.example.projectofinal2.model;

import com.example.projectofinal2.config.Environment;
import com.mongodb.MongoException;
import com.mongodb.client.*;
import javafx.scene.control.Alert;
import org.bson.Document;

import java.time.LocalDateTime;

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
        Document document = new Document("IDcuenta", cuentaBanco.getIdCuenta());
        document.append("saldo", cuentaBanco.getSaldo());
        document.append("nombreBanco", "Venequi");
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

    public static void AccessMongoDBCuentasBanco() {
        try {
            MongoCollection<Document> collection = MongoDBFacade.db.getCollection("CuentasBanco");
            FindIterable<Document> documents = collection.find();
            BilleteraVirtual.getCuentasBanco().clear();
            for (Document doc : documents) {
                Document usuarioDoc = doc.get("usuario", Document.class);
                Usuario usuario = new Usuario(
                        usuarioDoc.getString("nombre"),
                        usuarioDoc.getString("id"),
                        usuarioDoc.getString("correo"),
                        usuarioDoc.getString("telefono"));
                CuentaBanco cuentaBanco = new CuentaBanco(
                        doc.getString("IDcuenta"),
                        doc.getDouble("saldo"),
                        usuario,
                        usuario.getTelefono());
                cuentaBanco.setContrasena(doc.getString("contrasena"));

                BilleteraVirtual.getCuentasBanco().add(cuentaBanco);
            }
        } catch (MongoException e) {
            System.out.println("No se pudo conectar a la base de datos");
            showConnectionError();
        }
    }

    public static void EditarDatosMongo() {


    }

    public static void AccessMongoDBUsuario() {
        MongoCollection<Document> collection = MongoDBFacade.db.getCollection("usuario");
        FindIterable<Document> documents = collection.find();

        try {
            for (Document doc : documents) {
                Usuario usuario = new Usuario(
                        doc.getString("nombre"),
                        doc.getString("id"),
                        doc.getString("correo"),
                        doc.getString("telefono"));

                BilleteraVirtual.getUsuarios().add(usuario);
            }
        } catch (MongoException e) {

            System.out.println("No se pudo conectar a la base de datos");
            showConnectionError();
        }

    }

    public static void insertTransaccion(Transaccion transaccion) {
        MongoCollection<Document> collection = db.getCollection("transacciones");
        Document document = new Document("fecha", transaccion.fecha().toString());
        document.append("monto", transaccion.monto());
        document.append("descripcion", transaccion.descripcion());
        document.append("categoria", transaccion.categoria().toString());
        document.append("tipo", transaccion.tipo().toString());
        document.append("cuentaOrigen", transaccion.cuentaOrigen().getIdCuenta());
        if (transaccion.cuentaDestino() != null) {
            document.append("cuentaDestino", transaccion.cuentaDestino().getIdCuenta());
        }
        collection.insertOne(document);
    }

    public static void AccessMongoDBTransacciones() {
        MongoCollection<Document> collection = MongoDBFacade.db.getCollection("transacciones");
        FindIterable<Document> documents = collection.find();
        BilleteraVirtual.getTransacciones().clear();

        for (Document doc : documents) {
            Transaccion transaccion = new Transaccion(
                    LocalDateTime.parse(doc.getString("fecha")),
                    doc.getDouble("monto"),
                    doc.getString("descripcion"),
                    CategoriaTransaccion.valueOf(doc.getString("categoria")),
                    TipoTransaccion.valueOf(doc.getString("tipo")),
                    GestorCuentaBanco.getCuentaBancoById(doc.getString("cuentaOrigen")),
                    doc.containsKey("cuentaDestino") ? GestorCuentaBanco.getCuentaBancoById(doc.getString("cuentaDestino")) : null);
            BilleteraVirtual.getTransacciones().add(transaccion);


        }
    }
}