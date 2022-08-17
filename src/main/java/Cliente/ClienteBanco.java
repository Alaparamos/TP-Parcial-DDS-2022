package Cliente;

import Banco.Banco;
import Banco.Credito;
import Cuenta.Cuenta;

import javax.persistence.*;

@Entity
@Table(name = "clienteBanco")
public class ClienteBanco {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", referencedColumnName =  "id")
    private Usuario usuario;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "banco_id", referencedColumnName = "id")
    private Banco banco;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "cuenta_id", referencedColumnName = "id")
    private Cuenta cuenta;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "credito_id", referencedColumnName = "id")
    private Credito credito;

    public ClienteBanco(int id, Usuario usuario, Banco banco) {
        this.id = id;
        this.usuario = usuario;
        this.banco = banco;
    }

    //GETTER - SETTER
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
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
