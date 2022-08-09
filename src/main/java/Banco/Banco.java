package Banco;

import Cliente.Cliente;
import Cuenta.Cuenta;
import Moneda.Moneda;

import java.util.ArrayList;

public abstract  class Banco {
    private float deposito;
    private ArrayList<Cuenta> cuentas;
    private ArrayList<Credito> creditosPrestados;

    public abstract Cuenta crearCuenta(Cliente cliente);
    public abstract void aceptarDeposito(Cliente cliente, Moneda moneda, float cantidad);
    public abstract void aceptarRetiro(Cliente cliente, Moneda moneda, float cantidad);
    public abstract void darCredito(Cliente cliente, float monto);
}
