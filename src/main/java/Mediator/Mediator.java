package Mediator;

import Banco.Banco;
import Cliente.Usuario;
import Moneda.Moneda;

public class Mediator {

    private static Mediator instance;

    public static Mediator getInstance(){
        if(instance == null){
            instance = new Mediator();
        }
        return instance;
    }


    public void pedidoCrearCuenta(Usuario cliente, Banco banco){

    }

    public void depositar(Usuario cliente, Banco banco, Moneda moneda, float cantidad){

    }

    public void retirar(Usuario cliente, Banco banco, Moneda moneda, float cantidad){

    }

    public void hacerPedidoCredito(Usuario cliente, float monto){

    }
}
