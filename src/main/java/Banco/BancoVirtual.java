package Banco;

import Cliente.Usuario;
import Cuenta.*;
import Moneda.Moneda;

public class BancoVirtual extends Banco{

    public Cuenta crearCuenta(Usuario cliente) {
        return (Cuenta)(new AdaptadorCuentaVirtual());
    }

    public void aceptarDeposito(Usuario cliente, float cantidad){}
    public void aceptarRetiro(Usuario cliente, float cantidad){}
    public void darCredito(Usuario cliente, float monto){}
}
