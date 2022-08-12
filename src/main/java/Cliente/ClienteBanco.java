package Cliente;

import Banco.Banco;
import Banco.Credito;
import Cuenta.Cuenta;
import Moneda.Moneda;

public class ClienteBanco {

    private Usuario usuario;
    private Banco banco;
    private Cuenta cuenta;
    private Credito credito;

    //GETTER - SETTER
    public ClienteBanco(Usuario usuario, Banco banco) {
        this.setUsuario(usuario);
        this.setBanco(banco);
        this.setCuenta(null);
        this.setBanco(null);
    }

    public Usuario getUsuario() { return usuario; }

    public void setUsuario(Usuario usuario) { this.usuario = usuario; }

    public Banco getBanco() { return banco; }

    public void setBanco(Banco banco) { this.banco = banco; }

    public Cuenta getCuenta() { return cuenta; }

    public void setCuenta(Cuenta cuenta) { this.cuenta = cuenta; }

    public Credito getCredito() { return credito; }

    public void setCredito(Credito credito) { this.credito = credito; }

    //METODOS
    public void pedirCrearCuenta(){
        Cuenta cuentaCreada = banco.crearCuenta(this);
        this.setCuenta(cuentaCreada);
    }

    public void pedirCredito(float monto){
        Credito nuevoCredito = this.banco.darCredito(this, monto);
        this.setCredito(nuevoCredito);
    }

    public void pagarCredito(float monto){
        if(monto >= this.credito.getMonto()){
            this.credito = null;
        }
        else
            this.credito.setMonto(this.credito.getMonto() - monto);
    }
    /*public void depositar(Moneda moneda, float monto){
        banco.aceptarDeposito(this, moneda, monto);
    }

    public void retirar(Moneda moneda, float monto){
        banco.aceptarRetiro(this, moneda, monto);
    }*/
}
