package Banco;

import Cliente.ClienteBanco;

import javax.persistence.Entity;
import javax.persistence.OneToOne;

@Entity
public class Credito {

    @OneToOne(mappedBy = "credito")
    private ClienteBanco deudor;
    private float monto;

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
