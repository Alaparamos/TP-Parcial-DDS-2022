package Cuenta;

import Bitcoin.Bitcoin;
import Bitcoin.RepoBitcoins;

public class AdaptadorCuentaVirtual extends Cuenta{

    private CuentaVirtual cuentaVirtual;

    public CuentaVirtual getCuentaVirtual() { return cuentaVirtual; }

    public void setCuentaVirtual(CuentaVirtual cuentaVirtual) { this.cuentaVirtual = cuentaVirtual; }

    @Override
    public void depositar(float monto) {
        Bitcoin bitcoin = cuentaVirtual.getMetodoSeleccion().buscarBitcoin(RepoBitcoins.getInstance().getBitcoins());
        float cantidad = cuentaVirtual.calcularCantidadBitcoins(bitcoin, monto);
        cuentaVirtual.comprarBitcoin(bitcoin, cantidad);
    }

    @Override
    public void retirar(float monto) {
        Bitcoin bitcoin = cuentaVirtual.getMetodoSeleccion().buscarBitcoin(this.getCuentaVirtual().conseguirBitcoins());
        float cantidad = cuentaVirtual.calcularCantidadBitcoins(bitcoin, monto);
        cuentaVirtual.venderBitcoin(bitcoin, cantidad);
    }

    @Override
    public float calcularSaldo() {
        return 0;
    }
}
