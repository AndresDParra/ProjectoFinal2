package com.example.projectofinal2.model;

public class GestorCuentaBanco {

    public static CuentaBanco crearCuentaBanco(String id,double saldoInicial, String contrasenia, String nombre, String idUsuario, String correo, String telefono) {
        String connectionString = System.getenv("MONGO_STRING");
        if (connectionString == null) {
            throw new RuntimeException("MONGO_STRING environment variable is not set");
        }else {
            Usuario usuario = new Usuario(nombre, idUsuario, correo, telefono);
            CuentaBanco cuentaBanco = new CuentaBanco(id, saldoInicial, usuario, contrasenia);
            BilleteraVirtual.getCuentasBanco().add(cuentaBanco);
            BilleteraVirtual.getUsuarios().add(usuario);
            MongoDBFacade.insertUsuario(usuario);
            MongoDBFacade.insertCuentaBanco(cuentaBanco);
            return cuentaBanco;
        }
    }

    public static void eliminarCuentaBanco(String id) {
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            if (cuentaBanco.getIdCuenta().equals(id)) {
                BilleteraVirtual.getCuentasBanco().remove(cuentaBanco);
                break;
            }
        }
    }

    public static void modificarCuentaBanco(String id, String nombre, String contrasenia, double saldo) {
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            if (cuentaBanco.getIdCuenta().equals(id)) {
                cuentaBanco.setNombreBanco(nombre);
                cuentaBanco.setSaldo(saldo);
                break;
            }
        }
    }
    public static CuentaBanco getCuentaBancoById(String id) {
        for (CuentaBanco cuenta : BilleteraVirtual.getCuentasBanco()) {
            if (cuenta.getIdCuenta().equals(id)) {
                return cuenta;
            }
        }
        return null;
    }
}
