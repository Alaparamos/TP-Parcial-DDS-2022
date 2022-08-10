package Banco;

import Cliente.ClienteBanco;
import Cliente.Usuario;
import Cuenta.*;
import Moneda.Moneda;

import java.util.ArrayList;
import java.util.Optional;

public class Banco {

    private float deposito;
    private ArrayList<ClienteBanco> clientes;

    //GETTERs - SETTERs
    public float getDeposito() { return deposito; }
    public void setDeposito(float deposito) { this.deposito = deposito; }
    public ArrayList<ClienteBanco> getClientes() { return clientes; }
    public void setClientes(ArrayList<ClienteBanco> clientes) { this.clientes = clientes; }

    //METHODS
    public void registrarUsuario(Usuario usuario){
        ClienteBanco nuevoCliente = ClienteBanco.ClienteBanco(usuario, this);
        this.clientes.add(nuevoCliente);
    }

    public ClienteBanco buscarClientePorUsuario(Usuario usuario){
        Optional<ClienteBanco> cliente =
                this.clientes.stream().
                        filter(unCliente -> usuario.equals(unCliente.getUsuario())
                ).findAny();

        return cliente.get();
    }

    public Cuenta crearCuenta(ClienteBanco cliente) {
        if (cliente.getBanco().equals(this) && cliente.getCuenta().equals(null)) {
            CuentaBasica nuevaCuenta = new CuentaBasica();
            return nuevaCuenta;
        } else
            return cliente.getCuenta();
    }

    public Credito darCredito(ClienteBanco cliente, float monto){
        return Credito.Credito(cliente, monto);
    }


}
