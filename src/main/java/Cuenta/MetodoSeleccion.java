package Cuenta;

import Moneda.Bitcoin;

import java.util.ArrayList;

public abstract class MetodoSeleccion {
    public abstract Bitcoin buscarBitcoin(ArrayList<Bitcoin> listaBitcoins);
}
