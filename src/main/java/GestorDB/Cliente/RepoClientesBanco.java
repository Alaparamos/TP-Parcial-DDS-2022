package GestorDB.Cliente;

import GestorDB.GestorDB;

import java.util.ArrayList;
import java.util.List;

public class RepoClientesBanco {
    private List<ClienteBanco> listaClienteBancos;
    private static RepoClientesBanco instance;

    public RepoClientesBanco(List<ClienteBanco> listaClienteBancos){
        this.listaClienteBancos = listaClienteBancos;
    }

    public static RepoClientesBanco getInstance(){
        if(instance == null){
            instance = new RepoClientesBanco(new ArrayList<ClienteBanco>());
        }
        return instance;
    }

    public List<ClienteBanco> getListaClienteBancos() { return listaClienteBancos; }
    public void setListaClienteBancos(List<ClienteBanco> listaClienteBancos) { this.listaClienteBancos = listaClienteBancos; }

    public ClienteBanco buscarClienteBanco(String id){
        for(ClienteBanco unClienteBanco : this.getListaClienteBancos()){
            if(unClienteBanco.getId().equals(id))
                return unClienteBanco;
        }
        //Si no lo encuentra
        ClienteBanco ClienteBanco = GestorDB.getInstance().buscarClienteBanco(id);
        this.listaClienteBancos.add(ClienteBanco);
        return ClienteBanco;
    }
}
