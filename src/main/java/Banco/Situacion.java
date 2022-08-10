package Banco;

import Cliente.Usuario;
import Cuenta.Cuenta;

public abstract class Situacion {

    public abstract void cobrarCredito(Usuario cliente);
    public abstract void darCredito(Usuario cliente);

}
