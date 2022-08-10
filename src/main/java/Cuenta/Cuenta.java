package Cuenta;
import Cliente.Usuario;

public abstract class Cuenta {
    private Usuario cliente;

    public abstract Cuenta crearCuenta();
    public abstract void depositar(float monto);
    public abstract void retirar(float monto);
    public abstract float calcularSaldo();
}
