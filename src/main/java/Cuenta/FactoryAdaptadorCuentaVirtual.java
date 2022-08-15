package Cuenta;

public class FactoryAdaptadorCuentaVirtual extends FactoryCuenta{

    @Override
    public Cuenta crearCuenta() {
        AdaptadorCuentaVirtual adaptadorCuentaVirtual = new AdaptadorCuentaVirtual();
        adaptadorCuentaVirtual.setCuentaVirtual(new CuentaVirtual());
        return adaptadorCuentaVirtual;
    }
}
