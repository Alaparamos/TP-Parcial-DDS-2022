package Cuenta;

import javax.persistence.*;

@Entity
@DiscriminatorValue("basica")
public class CuentaBasica extends Cuenta {

    @Column
    private float saldo;

    //GETTER - SETTER
    public float getSaldo() { return saldo; }
    public void setSaldo(float saldo) { this.saldo = saldo; }

    //METHODS
    @Override
    public void depositar(float monto) {
        this.saldo += monto;
    }

    @Override
    public void retirar(float monto) {
        this.saldo = Float.min(this.saldo - monto, 0);
    }

    @Override
    public float calcularSaldo() {
        return this.saldo;
    }
}
