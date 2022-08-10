package Banco;

import Cliente.ClienteBanco;
import Cliente.Usuario;

public class Credito {
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

    public static Credito Credito(ClienteBanco clienteBanco, float monto){
        Credito nuevoCredito = new Credito();
        nuevoCredito.setDeudor(clienteBanco);
        nuevoCredito.setMonto(monto);
        return nuevoCredito;
    }

}
