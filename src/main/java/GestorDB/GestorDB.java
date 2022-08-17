package GestorDB;


import Banco.Banco;
import Cliente.ClienteBanco;
import Cliente.Usuario;
import Banco.Credito;
import Cuenta.Cuenta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

public class GestorDB {

    private EntityManager entityManager;
    private static GestorDB instance;

    public static GestorDB getInstance(){
        if(instance == null){
            instance = new GestorDB();
        }
        return instance;
    }

    public EntityManager getEntityManager() { return entityManager; }
    public void setEntityManager(EntityManager entityManager) { this.entityManager = entityManager; }

    public void iniciarConexionDB(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("TP-DDS-Parcial");
        this.entityManager = emf.createEntityManager();

        this.entityManager.getTransaction().begin();
    }

    public void terminarConexionDB(){
        this.entityManager.getTransaction().commit();
        this.entityManager.close();
    }

    public void guardarObjeto(Object o){
        entityManager.persist(o);
    }

    public Banco buscarBanco(String id){
        String sql = "FROM Banco WHERE id=" + '\'' + id + '\'';
        List<Banco> resultado = entityManager.createQuery(sql).getResultList();
        entityManager.persist(resultado.get(0));
        return resultado.get(0);
    }

    public Usuario buscarUsuario(String id){
        String sql = "FROM Usuario WHERE id=" + '\'' + id + '\'';
        List<Usuario> resultado = entityManager.createQuery(sql).getResultList();
        entityManager.persist(resultado.get(0));
        return resultado.get(0);
    }

    public ClienteBanco buscarClienteBanco(String id){
        String sql = "FROM ClienteBanco WHERE id=" + '\'' + id + '\'';
        List<ClienteBanco> resultado = entityManager.createQuery(sql).getResultList();
        entityManager.persist(resultado.get(0));
        return resultado.get(0);
    }

    public Credito buscarCredito(String id){
        String sql = "FROM Credito WHERE id=" + '\'' + id + '\'';
        List<Credito> resultado = entityManager.createQuery(sql).getResultList();
        entityManager.persist(resultado.get(0));
        return resultado.get(0);
    }

    public Cuenta buscarCuenta(String id){
        String sql = "FROM Cuenta WHERE id=" + '\'' + id + '\'';
        List<Cuenta> resultado = entityManager.createQuery(sql).getResultList();
        entityManager.persist(resultado.get(0));
        return resultado.get(0);
    }
}
