package Banco;

import Cliente.ClienteBanco;
import Cliente.Usuario;
import Cuenta.Cuenta;

public class NoEndeudado extends Situacion{

    @Override
    public void aumentarDepositoBanco(SuperBanco banco, float monto) {
        //Busca un banco de su lista que este endeudado para darle el monto cobrado
        for(Banco unBanco: banco.getBancos()){
            if(banco.estaEndeudado()){
                banco.aumentarDeposito(monto);
                return;
            }
        }
        //Si ninguno de sus bancos esta endeudado el SuperBanco cobra el monto
        banco.aumentarDeposito(monto);
    }

    @Override
    public float reducirDepostioBanco(SuperBanco banco, float monto) {

        if(banco.estaEndeudado()){
            banco.setSituacion(new Endeudado());
        }

        return this.caluclarReduccion(banco, monto);
    }
}
