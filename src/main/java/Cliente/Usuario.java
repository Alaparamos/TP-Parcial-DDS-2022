package Cliente;

import Banco.Banco;
import Mediator.Mediator;
import Moneda.Moneda;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Table(name = "USUARIOS")
public class Usuario {

    @Id
    @Column(name = "ID_USUARIO")
    private String id;

    @Column(name = "NOMBRE")
    private String nombre;

    private ArrayList<ClienteBanco> bancos;

    public Usuario(){}

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

/*    public static void main(String arg[]){
        Usuario usuario = new Usuario();
        usuario.setId("123");
        usuario.setNombre("Alfredo");

        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP-DDS-Parcial");
        EntityManager entityManager = emf.createEntityManager();

        entityManager.getTransaction().begin();
        entityManager.persist(usuario);
        entityManager.getTransaction().commit();
        entityManager.close();
    }*/
}
