package Banco;

import GestorDB.GestorDB;

import java.util.ArrayList;
import java.util.List;

public class RepoBancos {

    private List<Banco> listaBancos;
    private static RepoBancos instance;

    public RepoBancos(List<Banco> listaBancos){
        this.listaBancos = listaBancos;
    }

    public static RepoBancos getInstance(){
        if(instance == null){
            instance = new RepoBancos(new ArrayList<Banco>());
        }
        return instance;
    }

    public List<Banco> getListaBancos() { return listaBancos; }
    public void setListaBancos(List<Banco> listaBancos) { this.listaBancos = listaBancos; }

    public Banco buscarBanco(String id){
        for(Banco unBanco : this.getListaBancos()){
            if(unBanco.getId().equals(id))
                return unBanco;
        }
        //Si no lo encuentra
        Banco banco = GestorDB.getInstance().buscarBanco(id);
        this.listaBancos.add(banco);
        return banco;
    }
}
