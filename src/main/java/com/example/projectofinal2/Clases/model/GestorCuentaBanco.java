package com.example.projectofinal2.Clases.model;

public class GestorCuentaBanco {

    public static void crearCuentaBanco(String id,double saldoInicial, String contrasenia, String nombre, String idUsuario, String correo, String telefono) {
        Usuario usuario = new Usuario(nombre, idUsuario, correo, telefono);
        CuentaBanco cuentaBanco = new CuentaBanco(id, saldoInicial, usuario, contrasenia);
        BilleteraVirtual.getCuentasBanco().add(cuentaBanco);
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
}
