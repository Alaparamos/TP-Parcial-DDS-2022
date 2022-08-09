package Banco;

import Cliente.Cliente;
import Cuenta.Cuenta;

public class NoEndeudado extends Situacion{

    @Override
    public Cuenta crearCuenta(Cliente cliente) {
        return null;
    }
}
