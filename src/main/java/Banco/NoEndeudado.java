package Banco;

import Cliente.Usuario;
import Cuenta.Cuenta;

public class NoEndeudado extends Situacion{

    @Override
    public void cobrarCredito(Usuario cliente){}

    @Override
    public void darCredito(Usuario cliente){}
}
