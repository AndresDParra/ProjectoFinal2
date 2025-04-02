package com.example.projectofinal2.Clases.model;

public class GestorCuentaBanco {

    public void crearCuentaBanco(String id, String nombre, String contrasenia,double saldoInicial ) {
        CuentaBanco cuentaBanco = new CuentaBanco(id, nombre, contrasenia, saldoInicial);
        BilleteraVirtual.getCuentasBanco().add(cuentaBanco);
    }

    public void eliminarCuentaBanco(String id) {
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            if (cuentaBanco.getIdCuenta().equals(id)) {
                BilleteraVirtual.getCuentasBanco().remove(cuentaBanco);
                break;
            }
        }
    }

    public void modificarCuentaBanco(String id, String nombre, String contrasenia, double saldo) {
        for (CuentaBanco cuentaBanco : BilleteraVirtual.getCuentasBanco()) {
            if (cuentaBanco.getIdCuenta().equals(id)) {
                cuentaBanco.setNombreBanco(nombre);
                cuentaBanco.setSaldo(saldo);
                cuentaBanco.setNumeroCuenta(contrasenia);
                break;
            }
        }
    }
}
