package Banco;

import Cliente.ClienteBanco;
import Cuenta.*;

import java.util.ArrayList;

public class BancoVirtual extends Banco{

    public BancoVirtual(int id, float deposito, ArrayList<ClienteBanco> clientes) {
        super(id, deposito, clientes);
    }

    public Cuenta crearCuenta(ClienteBanco cliente) {
        FactoryAdaptadorCuentaVirtual fACV = new FactoryAdaptadorCuentaVirtual();
        return fACV.crearCuenta();
    }
}
