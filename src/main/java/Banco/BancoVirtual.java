package Banco;

import Cliente.ClienteBanco;
import Cliente.Usuario;
import Cuenta.*;
import Moneda.Moneda;

public class BancoVirtual extends Banco{

    public Cuenta crearCuenta(ClienteBanco cliente) {
        return FactoryCuenta.crearCuenta("AdaptadorCuentaVirtual");
    }
}
