package Banco;

import Cliente.Cliente;
import Cuenta.Cuenta;
import Moneda.Moneda;

public class BancoNormal extends Banco{
    public Cuenta crearCuenta(){return null;}

    @Override
    public Cuenta crearCuenta(Cliente cliente) {
        return null;
    }

    public void aceptarDeposito(Cliente cliente, Moneda moneda, float cantidad){}
    public void aceptarRetiro(Cliente cliente, Moneda moneda, float cantidad){}
    public void darCredito(Cliente cliente, float monto){}
}
