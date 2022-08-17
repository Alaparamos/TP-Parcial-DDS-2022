package Cuenta;
import GestorDB.Cliente.ClienteBanco;

import javax.persistence.*;

@MappedSuperclass
public abstract class Cuenta {

    @Id
    @Column(name = "ID_CUENTA")
    private String id;

    @OneToOne
    private ClienteBanco cliente;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public ClienteBanco getCliente() { return cliente; }
    public void setCliente(ClienteBanco cliente) { this.cliente = cliente; }

    public abstract void depositar(float monto);
    public abstract void retirar(float monto);
    public abstract float calcularSaldo();
}
