package Cuenta;

import Moneda.Bitcoin;
import Moneda.RepoBitcoins;

import java.util.ArrayList;
import java.util.Map;

public class CuentaVirtual {

    private Map<String, Float> bitcoins;
    private MetodoSeleccion metodoSeleccion;

    public Map<String, Float> getBitcoins() { return bitcoins; }
    public void setBitcoins(Map<String, Float> bitcoins) { this.bitcoins = bitcoins; }
    public MetodoSeleccion getMetodoSeleccion() { return metodoSeleccion; }
    public void setMetodoSeleccion(MetodoSeleccion metodoSeleccion) { this.metodoSeleccion = metodoSeleccion; }

    public void comprarBitcoin(Bitcoin bitcoin, float cantidad){
        if(this.bitcoins.get(bitcoin.getId()) == null){
            this.bitcoins.put(bitcoin.getId(), cantidad);
        }
        else{
            float deposito = this.bitcoins.get(bitcoin.getId());
            this.bitcoins.replace(bitcoin.getId(), deposito + cantidad);
        }
    }

    public void venderBitcoin(Bitcoin bitcoin, float cantidad){
        float deposito = this.bitcoins.get(bitcoin.getId());
        if(deposito <= cantidad){
            this.bitcoins.remove(bitcoin.getId());
        }
        else
            this.bitcoins.replace(bitcoin.getId(), deposito - cantidad);
    }

    public ArrayList<Bitcoin> conseguirBitcoins(){
        ArrayList<Bitcoin> listaBitcoins = new ArrayList<>();
        for (Bitcoin bitcoin : RepoBitcoins.getInstance().getBitcoins()) {
            if(this.bitcoins.containsKey(bitcoin.getId()))
                listaBitcoins.add(bitcoin);
        }
        return listaBitcoins;
    }

    public float calcularCantidadBitcoins(Bitcoin bitcoin, float monto){
        return Float.parseFloat(bitcoin.getPriceUsd()) * 300;
    }
}
