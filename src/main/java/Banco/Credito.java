package Banco;

import Cliente.ClienteBanco;

import javax.persistence.*;

@Entity
@Table(name = "CREDITOS")
public class Credito {

    @Id
    @Column(name = "ID_CREDITO")
    private String id;

    @OneToOne
    private ClienteBanco deudor;

    @Column(name = "MONTO")
    private float monto;

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
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

    public Credito(String id, ClienteBanco clienteBanco, float monto){
        this.id = id;
        this.deudor = clienteBanco;
        this.monto = monto;
    }

}
