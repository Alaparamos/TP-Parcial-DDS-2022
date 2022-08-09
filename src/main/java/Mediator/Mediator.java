package Mediator;

import Banco.Banco;
import Cliente.Cliente;
import Moneda.Moneda;

public class Mediator {

    private static Mediator instance;

    public static Mediator getInstance(){
        if(instance == null){
            instance = new Mediator();
        }
        return instance;
    }


    public void pedidoCrearCuenta(Cliente cliente, Banco banco){
        banco.crearCuenta(cliente);
    }

    public void depositar(Cliente cliente, Banco banco, Moneda moneda, float cantidad){

    }

    public void retirar(Cliente cliente, Banco banco, Moneda moneda, float cantidad){

    }

    public void hacerPedidoCredito(Cliente cliente, float monto){

    }
}
