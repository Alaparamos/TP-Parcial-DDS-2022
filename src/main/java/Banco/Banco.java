package Banco;

import GestorDB.Cliente.ClienteBanco;
import GestorDB.Cliente.Usuario;
import Cuenta.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Entity
@Table(name = "BANCOS")
public class Banco {

    @Id
    @Column(name = "ID_BANCO")
    private String id;

    @Column
    private float deposito;
    private final float porcentajeDepositoMinimo = 2;

    @OneToMany(mappedBy = "banco")
    private List<ClienteBanco> clientes;

    private final float porcentajeIntereses = 2;

    //CONSTRUCTOR
    public Banco(){}

    public Banco(String id, float deposito, ArrayList<ClienteBanco> clientes) {
        this.id = id;
        this.deposito = deposito;
        this.clientes = clientes;
    }

    //GETTERs - SETTERs
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public float getDeposito() { return deposito; }
    public void setDeposito(float deposito) { this.deposito = deposito; }
    public List<ClienteBanco> getClientes() { return clientes; }
    public void setClientes(ArrayList<ClienteBanco> clientes) { this.clientes = clientes; }

    //METHODS
    public void registrarUsuario(Usuario usuario){
        ClienteBanco nuevoCliente = new ClienteBanco(usuario.getId(), usuario, this);
        this.clientes.add(nuevoCliente);
    }

    public ClienteBanco buscarClientePorUsuario(Usuario usuario){
        Optional<ClienteBanco> cliente =
                this.clientes.stream().
                        filter(unCliente -> unCliente.getUsuario().equals(usuario)
                ).findFirst();

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
            Cuenta nuevaCuenta = fCB.crearCuenta();
            nuevaCuenta.setId(cliente.getId() + "_cuenta");
            nuevaCuenta.setCliente(cliente);
            return nuevaCuenta;
        } else
            return cliente.getCuenta();
    }

    public Credito darCredito(ClienteBanco cliente, float monto){
        if(cliente.getCredito() == null && !this.estaEndeudado()){
            float montoPrestado = this.reducirDeposito(monto);
            return new Credito(cliente.getId() + "_credito",cliente, montoPrestado * this.porcentajeIntereses);
        }
        else
            return null;
    }

    public void cobrarCredito(ClienteBanco cliente, float monto){
        if(monto >= cliente.getCredito().getMonto()){
            cliente.setCredito(null);
            this.aumentarDeposito(cliente.getCredito().getMonto());
        }
        else{
            cliente.getCredito().setMonto(cliente.getCredito().getMonto() - monto);
            this.aumentarDeposito(monto);
        }
    }

    public void aceptarDeposito(ClienteBanco cliente, float monto){
        cliente.getCuenta().depositar(monto);
        this.aumentarDeposito(monto);
    }

    public void aceptarRetiro(ClienteBanco cliente, float monto){
        float montoRetirado = this.reducirDeposito(monto);
        cliente.getCuenta().retirar(montoRetirado);
    }
}
