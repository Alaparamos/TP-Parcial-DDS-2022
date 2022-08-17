package Banco;

public abstract class Situacion {
    public abstract void aumentarDepositoBanco(SuperBanco banco, float monto);
    public abstract float reducirDepostioBanco(SuperBanco banco, float monto);

    public float caluclarReduccion(Banco banco, float monto){
        if(banco.getDeposito() >= monto){
            banco.setDeposito(banco.getDeposito() - monto);
            return monto;
        }
        else{
            float ret = banco.getDeposito();
            banco.setDeposito(0);
            return ret;
        }
    }
}
