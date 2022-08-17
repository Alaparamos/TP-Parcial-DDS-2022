package test;

import Cliente.Usuario;
import GestorDB.EntityManagerHelper;
import org.junit.Assert;
import org.junit.Test;

public class EmTest {
    
    @Test
    public void persistirUsuario(){
        Usuario joaco = new Usuario();
        joaco.setNombre("Joaquin");

        // Inicio de la Transacción para la BD
        EntityManagerHelper.beginTransaction();

        EntityManagerHelper.getEntityManager().persist(joaco); // Prepara el INSERT

        EntityManagerHelper.commit(); // Se ejecutan todas las sentencias
        // Fin de la Transacción
    }

    @Test
    public void recuperarAlUsuario(){
        Usuario joaco = (Usuario) EntityManagerHelper.createQuery("FROM Usuario WHERE nombre = 'Joaquin'").getSingleResult();
        Assert.assertEquals("Joaquin", joaco.getNombre());
    }

}
