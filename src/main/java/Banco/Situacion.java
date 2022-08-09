package Banco;

import Cliente.Cliente;
import Cuenta.Cuenta;

public abstract class Situacion {
    public abstract Cuenta crearCuenta(Cliente cliente);
}
