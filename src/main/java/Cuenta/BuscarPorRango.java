package Cuenta;

import Moneda.Bitcoin;
import Moneda.RepoBitcoins;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;


public class BuscarPorRango extends MetodoSeleccion{

    @Override
    public Bitcoin buscarBitcoin(ArrayList<Bitcoin> listaBitcoins) {
        Optional<Bitcoin> info = listaBitcoins.stream().max(
                Comparator.comparing(Bitcoin::getRank)
        );

        return info.get();
    }
}
