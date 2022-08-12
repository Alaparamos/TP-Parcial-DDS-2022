package Cuenta;

import Moneda.Bitcoin;

public class AdaptadorCuentaVirtual extends Cuenta{

    private CuentaVirtual cuentaVirtual;

    public CuentaVirtual getCuentaVirtual() { return cuentaVirtual; }

    public void setCuentaVirtual(CuentaVirtual cuentaVirtual) { this.cuentaVirtual = cuentaVirtual; }

    @Override
    public Cuenta crearCuenta() {
        AdaptadorCuentaVirtual adaptadorCuentaVirtual = new AdaptadorCuentaVirtual();
        adaptadorCuentaVirtual.setCuentaVirtual(new CuentaVirtual());
        return adaptadorCuentaVirtual;
    }

    @Override
    public void depositar(float monto) {
        Bitcoin bitcoin = cuentaVirtual.elegirBitcoin();
        int cantidad = 0; //TODO: calcular cantidad segun precio bitcoin
        cuentaVirtual.comprarBitcoin(bitcoin, cantidad);
    }

    @Override
    public void retirar(float monto) {
        Bitcoin bitcoin = cuentaVirtual.elegirBitcoin();
        int cantidad = 0; //TODO: calcular cantidad segun precio bitcoin
        cuentaVirtual.venderBitcoin(bitcoin, cantidad);
    }

    @Override
    public float calcularSaldo() {
        return 0;
    }
}
