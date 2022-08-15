package Banco;

import Cliente.ClienteBanco;
import Cliente.Usuario;
import Cuenta.Cuenta;

public class Endeudado extends Situacion{

    @Override
    public void aumentarDepositoBanco(SuperBanco banco, float monto) {
        banco.aumentarDeposito(monto);
        if(!banco.estaEndeudado())
            banco.setSituacion(new NoEndeudado());
    }

    @Override
    public float reducirDepostioBanco(SuperBanco banco, float monto) {
        for(Banco unBanco: banco.getBancos()){
            float depositoPrestado = unBanco.getDeposito() * banco.getPorcentajeReclamable();
            unBanco.reducirDeposito(depositoPrestado);
            banco.aumentarDeposito(depositoPrestado);
        }
        return this.caluclarReduccion(banco, monto);
    }
}
