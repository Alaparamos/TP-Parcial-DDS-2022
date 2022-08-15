package Cliente;

import Banco.Banco;

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
    public ArrayList<ClienteBanco> getBancos() { return bancos; }
    public void setBancos(ArrayList<ClienteBanco> bancos) { this.bancos = bancos; }

    //GESTION CUENTA BANCO
    public void registrarseEnBanco(Banco banco){
        banco.registrarUsuario(this);
        ClienteBanco clienteBanco = banco.buscarClientePorUsuario(this);
        this.bancos.add(clienteBanco);
    }

    public void depositarEnBanco(Banco banco, float monto){
        banco.aceptarDeposito(this, monto);
    }

    public void retirarDeBanco(Banco banco, float monto){
        banco.aceptarRetiro(this, monto);
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
