package Cuenta;

import Bitcoin.Bitcoin;
import Bitcoin.RepoBitcoins;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("virtual")
public class AdaptadorCuentaVirtual extends Cuenta{

    @OneToOne
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
