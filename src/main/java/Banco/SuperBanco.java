package Banco;

import Cliente.ClienteBanco;

import java.util.ArrayList;

public class SuperBanco extends Banco{

    private ArrayList<Banco> bancos;
    private Situacion situacion = new NoEndeudado();
    private float porcentajeReclamable;

    public SuperBanco(String id, float deposito, ArrayList<ClienteBanco> clientes) {
        super(id, deposito, clientes);
    }

    public float getPorcentajeReclamable() { return porcentajeReclamable; }
    public void setPorcentajeReclamable(float porcentajeReclamable) { this.porcentajeReclamable = porcentajeReclamable; }
    public ArrayList<Banco> getBancos() { return bancos; }
    public void setBancos(ArrayList<Banco> bancos) { this.bancos = bancos; }
    public Situacion getSituacion() { return situacion; }
    public void setSituacion(Situacion situacion) { this.situacion = situacion; }


    public void aumentarDeposito(float monto){
        this.situacion.aumentarDepositoBanco(this, monto);
    }

    public float reducirDeposito(float monto){
        return this.situacion.reducirDepostioBanco(this, monto);
    }
}
