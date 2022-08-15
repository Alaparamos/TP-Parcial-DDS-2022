package Banco;

import Cliente.ClienteBanco;
import Cliente.Usuario;
import Cuenta.*;

import java.util.ArrayList;
import java.util.Optional;

public class Banco {

    private float deposito;
    private final float porcentajeDepositoMinimo = 2;
    private ArrayList<ClienteBanco> clientes;
    private final float porcentajeIntereses = 2;

    //GETTERs - SETTERs
    public float getDeposito() { return deposito; }
    public void setDeposito(float deposito) { this.deposito = deposito; }
    public ArrayList<ClienteBanco> getClientes() { return clientes; }
    public void setClientes(ArrayList<ClienteBanco> clientes) { this.clientes = clientes; }

    //METHODS
    public void registrarUsuario(Usuario usuario){
        ClienteBanco nuevoCliente = new ClienteBanco(usuario, this);
        this.clientes.add(nuevoCliente);
    }

    public ClienteBanco buscarClientePorUsuario(Usuario usuario){
        Optional<ClienteBanco> cliente =
                this.clientes.stream().
                        filter(unCliente -> usuario.equals(unCliente.getUsuario())
                ).findAny();

        return cliente.get();
    }

    public void aumentarDeposito(float monto){
        this.deposito += monto;
    }

    public float reducirDeposito(float monto){
        //Si no se retira el total del monto entonces se retira lo que queda del deposito
        float montoRetirado = Float.min(deposito, monto);

        //El deposito no puede ser negativo
        this.deposito = Float.min(deposito - monto, 0);
        return montoRetirado;
    }

    public boolean estaEndeudado(){
        float saldoCuentas = 0;
        for(ClienteBanco cliente: this.getClientes()){
            saldoCuentas += cliente.getCuenta().calcularSaldo();
        }
        return deposito < saldoCuentas * this.porcentajeDepositoMinimo;
    }

    public Cuenta crearCuenta(ClienteBanco cliente) {
        if  (cliente.getBanco().equals(this) && cliente.getCuenta() == null) {
            FactoryCuentaBasica fCB = new FactoryCuentaBasica();
            return fCB.crearCuenta();
        } else
            return cliente.getCuenta();
    }

    public Credito darCredito(ClienteBanco cliente, float monto){
        if(cliente.getCredito() == null && !this.estaEndeudado()){
            float montoPrestado = this.reducirDeposito(monto);
            return new Credito(cliente, montoPrestado * this.porcentajeIntereses);
        }
        else
            return null;
    }

    public void aceptarDeposito(Usuario usuario, float monto){
        ClienteBanco cliente = this.buscarClientePorUsuario(usuario);
        cliente.getCuenta().depositar(monto);
        this.aumentarDeposito(monto);
    }
    public void aceptarRetiro(Usuario usuario, float monto){
        ClienteBanco cliente = this.buscarClientePorUsuario(usuario);
        float montoRetirado = this.reducirDeposito(monto);
        cliente.getCuenta().retirar(montoRetirado);
    }
}
