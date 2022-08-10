package Banco;

import Cliente.Usuario;
import Cuenta.Cuenta;

import java.util.ArrayList;

public class SuperBanco extends Banco{

    private ArrayList<Banco> bancos;
    private Situacion situacion;

    public void aceptarDeposito(Usuario cliente, float cantidad){}
    public void aceptarRetiro(Usuario cliente, float cantidad){}
    public void darCredito(Usuario cliente, float monto){}
}
