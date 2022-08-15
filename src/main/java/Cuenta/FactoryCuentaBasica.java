package Cuenta;

public class FactoryCuentaBasica extends FactoryCuenta{

    @Override
    public Cuenta crearCuenta() {
        return new CuentaBasica();
    }
}
