package Cuenta;

public class FactoryCuenta {

    public static Cuenta crearCuenta(String tipo){
        if(tipo.equals("AdaptadorCuentaVirtual")){
            AdaptadorCuentaVirtual adaptadorCuentaVirtual = new AdaptadorCuentaVirtual();
            adaptadorCuentaVirtual.setCuentaVirtual(new CuentaVirtual());
            return adaptadorCuentaVirtual;
        }
        else if(tipo.equals("CuentaBasica")){
            return new CuentaBasica();
        }
        else
            return null;
    }
}
