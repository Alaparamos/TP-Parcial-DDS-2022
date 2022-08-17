package Cliente;

import Banco.*;
import GestorDB.GestorDB;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "usuario")
public class Usuario {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String nombre;

    @OneToMany(mappedBy = "usuario", cascade = CascadeType.ALL)
    private List<ClienteBanco> bancos;

    public Usuario(){}

    public Usuario(int id, String nombre, List<ClienteBanco> bancos) {
        this.id = id;
        this.nombre = nombre;
        this.bancos = bancos;
    }

    //Getter and Setter
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public List<ClienteBanco> getBancos() { return bancos; }
    public void setBancos(ArrayList<ClienteBanco> bancos) { this.bancos = bancos; }

    //GESTION CUENTA BANCO
    public void registrarseEnBanco(Banco banco){
        banco.registrarUsuario(this);
        ClienteBanco clienteBanco = banco.buscarClientePorUsuario(this);
        this.bancos.add(clienteBanco);
    }

    public void solicitarCrearCuenta(ClienteBanco cliente){
        cliente.pedirCrearCuenta();
    }

    public void depositarEnBanco(ClienteBanco clienteBanco, float monto){
        clienteBanco.depositarEnCuenta(monto);
    }

    public void retirarDeBanco(ClienteBanco clienteBanco, float monto){
        clienteBanco.retirarDeCuenta(monto);
    }

    public void solicitarCredito(ClienteBanco clienteBanco, float monto){
        clienteBanco.pedirCredito(monto);
    }

    public void pagarCredito(ClienteBanco clienteBanco, float monto){
        clienteBanco.pagarCredito(monto);
    }

}
