package com.example.projectofinal2.model;

public class GestorPresupuesto {

    public static void crearPresupuesto(CuentaBanco cuentaBanco, double presupuesto) {

        Presupuesto presupuesto1 = new Presupuesto(presupuesto, cuentaBanco);
        BilleteraVirtual.getPresupuestos().add(presupuesto1);

    }

    public static void eliminarPresupuesto(Presupuesto presupuesto) {
        BilleteraVirtual.getPresupuestos().remove(presupuesto);

    }

    public static void actualizarPresupuesto(CuentaBanco cuentaBanco, double presupuesto) {

        for (Presupuesto p : BilleteraVirtual.getPresupuestos()) {
            if (p.getCuentaBanco().equals(cuentaBanco)) {
                p.setPresupuesto(presupuesto);
                break;
            }
        }


    }
}
