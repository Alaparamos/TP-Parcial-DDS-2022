package Cuenta;
import Cliente.ClienteBanco;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public abstract class Cuenta {

    @OneToOne(mappedBy = "cuenta")
    private ClienteBanco cliente;

    public ClienteBanco getCliente() { return cliente; }
    public void setCliente(ClienteBanco cliente) { this.cliente = cliente; }

    public abstract void depositar(float monto);
    public abstract void retirar(float monto);
    public abstract float calcularSaldo();
}
