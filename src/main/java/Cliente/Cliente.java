package Cliente;

import Banco.Banco;
import Cuenta.Cuenta;
import Mediator.Mediator;
import Moneda.Moneda;

import javax.print.attribute.standard.Media;

public class Cliente {
    private String nombre;
    private String id;

    //Getter and Setter
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    //GESTION CUENTA BANCO
    public void crearCuenta(Banco banco){
        Mediator.getInstance().pedidoCrearCuenta(this, banco);
    }

    public void depositar(Banco banco, Moneda moneda, float cantidad){
        Mediator.getInstance().depositar(this, banco, moneda, cantidad);
    }

    public void retirar(Banco banco, Moneda moneda, float cantidad){
        Mediator.getInstance().retirar(this, banco, moneda, cantidad);
    }
}
