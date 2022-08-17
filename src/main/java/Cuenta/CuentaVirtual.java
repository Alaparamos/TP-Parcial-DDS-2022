package Cuenta;

import Bitcoin.Bitcoin;
import Bitcoin.BitcoinCuenta;
import Bitcoin.RepoBitcoins;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Entity
@Table(name = "cuentaVirtual")
public class CuentaVirtual {

    @Id
    @GeneratedValue
    private int id;
    @OneToMany(mappedBy = "cuentaVirtual", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<BitcoinCuenta> bitcoins;

    @Transient
    private MetodoSeleccion metodoSeleccion;

    @Transient
    private HashMap<Bitcoin, Float> saldo;

    public List<BitcoinCuenta> getBitcoins() {
        return bitcoins;
    }

    public void setBitcoins(List<BitcoinCuenta> bitcoins) {
        this.bitcoins = bitcoins;
    }

    public MetodoSeleccion getMetodoSeleccion() {
        return metodoSeleccion;
    }

    public void setMetodoSeleccion(MetodoSeleccion metodoSeleccion) {
        this.metodoSeleccion = metodoSeleccion;
    }

    public void comprarBitcoin(Bitcoin bitcoin, float cantidad) {
        BitcoinCuenta aux = this.buscarBitcoin(bitcoin);
        if (aux == null) {
            aux = new BitcoinCuenta(this, bitcoin.getId(), cantidad);
            this.bitcoins.add(aux);
        } else
            aux.setCantidad(aux.getCantidad() + cantidad);
    }

    public void venderBitcoin(Bitcoin bitcoin, float cantidad) {
        BitcoinCuenta bitcoinCuenta = this.buscarBitcoin(bitcoin);
        float deposito = bitcoinCuenta.getCantidad();
        if (deposito <= cantidad) {
            this.bitcoins.remove(bitcoinCuenta);
        } else
            bitcoinCuenta.setCantidad(deposito - cantidad);
    }

    public ArrayList<Bitcoin> conseguirBitcoins() {
        ArrayList<Bitcoin> listaBitcoins = new ArrayList<>();
        for (Bitcoin bitcoin : RepoBitcoins.getInstance().getBitcoins()) {
            if (this.buscarBitcoin(bitcoin) != null)
                listaBitcoins.add(bitcoin);
        }
        return listaBitcoins;
    }

    public BitcoinCuenta buscarBitcoin(Bitcoin bitcoin) {
        for (BitcoinCuenta unaBitcoin : this.bitcoins) {
            if (unaBitcoin.getIdBitcoin().equals(bitcoin.getId()))
                return unaBitcoin;
        }
        return null;
    }

    public float calcularCantidadBitcoins(Bitcoin bitcoin, float monto) {
        return Float.parseFloat(bitcoin.getPriceUsd()) * 300;
    }
}
/*
   @Override
    public void depositar(float monto, Bitcoin moneda) {
        BitcoinCuenta bitcoin = buscarBitcoin(moneda);
        if (bitcoin == null) throw new RuntimeException();
        this.saldo.put(moneda, monto);
    }

    @Override
    public void retirar(float monto, Bitcoin moneda) {
        BitcoinCuenta bitcoin = buscarBitcoin(moneda);
        if (bitcoin == null) throw new RuntimeException();
        this.saldo.replace(moneda, monto - this.saldo.get(moneda));
    }

    @Override
    public float calcularSaldo() {
        return conseguirBitcoins().stream()
                .map(unaBitcoin -> unaBitcoin.getPriceUsd())
                .map(unaBitcoin -> Float.parseFloat(unaBitcoin))
                .map(unaBitcoin -> unaBitcoin * )
                .reduce(Float::sum)
                .get();
    }
 */