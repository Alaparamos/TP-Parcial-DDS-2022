package Cuenta;

import GestorDB.GestorDB;

import java.util.ArrayList;
import java.util.List;

public class RepoCuentas {
    private List<Cuenta> listaCuentas;
    private static RepoCuentas instance;

    public RepoCuentas(List<Cuenta> listaCuentas){
        this.listaCuentas = listaCuentas;
    }

    public static RepoCuentas getInstance(){
        if(instance == null){
            instance = new RepoCuentas(new ArrayList<Cuenta>());
        }
        return instance;
    }

    public List<Cuenta> getListaCuentas() { return listaCuentas; }
    public void setListaCuentas(List<Cuenta> listaCuentas) { this.listaCuentas = listaCuentas; }

    public Cuenta buscarCuenta(int id) {
        for (Cuenta unCuenta : this.getListaCuentas()) {
            if (unCuenta.getId() == id)
                return unCuenta;
        }
        //Si no lo encuentra
        Cuenta Cuenta = GestorDB.getInstance().buscarCuenta(id);
        this.listaCuentas.add(Cuenta);
        return Cuenta;
    }
}
