package Cuenta;

import Bitcoin.Bitcoin;
import Bitcoin.BitcoinCuenta;
import Bitcoin.RepoBitcoins;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "CUENTAS_VIRTUALES")
public class CuentaVirtual {

    @Id
    @Column(name = "ID_CUENTA_VIRTUAL")
    private String id;

    @OneToMany(mappedBy = "cuentaVirtual",cascade = CascadeType.ALL)
    private List<BitcoinCuenta> bitcoins;
    private MetodoSeleccion metodoSeleccion;

    public List<BitcoinCuenta> getBitcoins() { return bitcoins; }
    public void setBitcoins(List<BitcoinCuenta> bitcoins) { this.bitcoins = bitcoins; }
    public MetodoSeleccion getMetodoSeleccion() { return metodoSeleccion; }
    public void setMetodoSeleccion(MetodoSeleccion metodoSeleccion) { this.metodoSeleccion = metodoSeleccion; }

    public void comprarBitcoin(Bitcoin bitcoin, float cantidad){
        BitcoinCuenta aux = this.buscarBitcoin(bitcoin);
        if(aux == null){
            aux = new BitcoinCuenta(this, bitcoin.getId(), cantidad);
            this.bitcoins.add(aux);
        }
        else
            aux.setCantidad(aux.getCantidad() + cantidad);
    }

    public void venderBitcoin(Bitcoin bitcoin, float cantidad){
        BitcoinCuenta bitcoinCuenta = this.buscarBitcoin(bitcoin);
        float deposito = bitcoinCuenta.getCantidad();
        if(deposito <= cantidad){
            this.bitcoins.remove(bitcoinCuenta);
        }
        else
            bitcoinCuenta.setCantidad(deposito - cantidad);
    }

    public ArrayList<Bitcoin> conseguirBitcoins(){
        ArrayList<Bitcoin> listaBitcoins = new ArrayList<>();
        for (Bitcoin bitcoin : RepoBitcoins.getInstance().getBitcoins()) {
            if(this.buscarBitcoin(bitcoin) != null)
                listaBitcoins.add(bitcoin);
        }
        return listaBitcoins;
    }

    public BitcoinCuenta buscarBitcoin(Bitcoin bitcoin){
        for(BitcoinCuenta unaBitcoin : this.bitcoins){
            if(unaBitcoin.getIdBitcoin().equals(bitcoin.getId()))
                return unaBitcoin;
        }
        return null;
    }

    public float calcularCantidadBitcoins(Bitcoin bitcoin, float monto){
        return Float.parseFloat(bitcoin.getPriceUsd()) * 300;
    }
}
