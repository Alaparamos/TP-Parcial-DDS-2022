package Cuenta;
import Cliente.ClienteBanco;

import javax.persistence.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class Cuenta {
    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "cuenta", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private ClienteBanco cliente;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public ClienteBanco getCliente() { return cliente; }
    public void setCliente(ClienteBanco cliente) { this.cliente = cliente; }

    public abstract void depositar(float monto);
    public abstract void retirar(float monto);
    public abstract float calcularSaldo();
}
