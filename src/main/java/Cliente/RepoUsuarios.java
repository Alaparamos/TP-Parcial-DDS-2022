package Cliente;

import GestorDB.GestorDB;

import java.util.ArrayList;
import java.util.List;

public class RepoUsuarios {
    private List<Usuario> listaUsuarios;
    private static RepoUsuarios instance;

    public RepoUsuarios(List<Usuario> listaUsuarios){
        this.listaUsuarios = listaUsuarios;
    }

    public static RepoUsuarios getInstance(){
        if(instance == null){
            instance = new RepoUsuarios(new ArrayList<Usuario>());
        }
        return instance;
    }

    public List<Usuario> getListaUsuarios() { return listaUsuarios; }
    public void setListaUsuarios(List<Usuario> listaUsuarios) { this.listaUsuarios = listaUsuarios; }

    public Usuario buscarUsuario(int id){
        for(Usuario unUsuario : this.getListaUsuarios()){
            if(unUsuario.getId() == id)
                return unUsuario;
        }
        //Si no lo encuentra
        Usuario Usuario = GestorDB.getInstance().buscarUsuario(id);
        this.listaUsuarios.add(Usuario);
        return Usuario;
    }
}
