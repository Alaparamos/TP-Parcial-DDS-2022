package Banco;

import GestorDB.GestorDB;

import java.util.ArrayList;
import java.util.List;

public class RepoCreditos {

    private List<Credito> listaCreditos;
    private static RepoCreditos instance;

    public RepoCreditos(List<Credito> listaCreditos){
        this.listaCreditos = listaCreditos;
    }

    public static RepoCreditos getInstance(){
        if(instance == null){
            instance = new RepoCreditos(new ArrayList<Credito>());
        }
        return instance;
    }

    public List<Credito> getListaCreditos() { return listaCreditos; }
    public void setListaCreditos(List<Credito> listaCreditos) { this.listaCreditos = listaCreditos; }

    public Credito buscarCredito(String id){
        for(Credito unCredito : this.getListaCreditos()){
            if(unCredito.getId().equals(id))
                return unCredito;
        }
        //Si no lo encuentra
        Credito credito = GestorDB.getInstance().buscarCredito(id);
        this.listaCreditos.add(credito);
        return credito;
    }
}
