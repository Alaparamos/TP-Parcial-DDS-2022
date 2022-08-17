package Banco;

import Cliente.ClienteBanco;

import javax.persistence.*;

@Entity
@Table(name = "credito")
public class Credito {

    @Id
    @GeneratedValue
    private int id;

    @OneToOne(mappedBy = "credito")
    private ClienteBanco deudor;

    @Column
    private float monto;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public ClienteBanco getDeudor() {
        return deudor;
    }
    public void setDeudor(ClienteBanco deudor) {
        this.deudor = deudor;
    }
    public float getMonto() {
        return monto;
    }
    public void setMonto(float monto) {
        this.monto = monto;
    }

    public Credito(ClienteBanco clienteBanco, float monto){
        this.deudor = clienteBanco;
        this.monto = monto;
    }

}
