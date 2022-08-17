package GestorDB.Cliente;

import Banco.Banco;
import Banco.Credito;
import Cuenta.Cuenta;

import javax.persistence.*;

@Entity
@Table(name = "CLIENTE_BANCO")
public class ClienteBanco {

    @Id
    @Column(name = "ID")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "USUARIO_ID")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "BANCO_ID")
    private Banco banco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CUENTA_ID")
    private Cuenta cuenta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "CREDITO_ID")
    private Credito credito;

    public ClienteBanco(String id, Usuario usuario, Banco banco) {
        this.id = id;
        this.usuario = usuario;
        this.banco = banco;
    }

    //GETTER - SETTER
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
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
        this.banco.cobrarCredito(this, monto);
    }

    public void depositarEnCuenta(float monto){
        this.banco.aceptarDeposito(this, monto);
    }

    public void retirarDeCuenta(float monto){
        this.banco.aceptarRetiro(this, monto);
    }
}
