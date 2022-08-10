package Cliente;

import Banco.Banco;
import Mediator.Mediator;
import Moneda.Moneda;

import java.util.ArrayList;

public class Usuario {
    private String nombre;
    private String id;
    private ArrayList<ClienteBanco> bancos;

    //Getter and Setter
    public String getNombre() { return nombre; }

    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getId() { return id; }

    public void setId(String id) { this.id = id; }

    //GESTION CUENTA BANCO
    public void registrarseEnBanco(Banco banco){
        banco.registrarUsuario(this);
        ClienteBanco clienteBanco = banco.buscarClientePorUsuario(this);
        this.bancos.add(clienteBanco);
    }
}
