package Banco;

import Cliente.ClienteBanco;
import Cuenta.*;

public class BancoVirtual extends Banco{

    public Cuenta crearCuenta(ClienteBanco cliente) {
        FactoryAdaptadorCuentaVirtual fACV = new FactoryAdaptadorCuentaVirtual();
        return fACV.crearCuenta();
    }
}
