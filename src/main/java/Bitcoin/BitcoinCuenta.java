package Bitcoin;

import Cuenta.CuentaVirtual;

import javax.persistence.*;

@Entity
@Table(name = "bitcoinCuenta")
public class BitcoinCuenta {

    @Id
    @GeneratedValue
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "cuentaVirtual_id", referencedColumnName = "id")
    private CuentaVirtual cuentaVirtual;

    @Column
    private String idBitcoin;

    @Column
    private float cantidad;

    public BitcoinCuenta(CuentaVirtual cuentaVirtual, String idBitcoin, float cantidad) {
        this.cuentaVirtual = cuentaVirtual;
        this.idBitcoin = idBitcoin;
        this.cantidad = cantidad;
    }

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }
    public CuentaVirtual getCuentaVirtual() { return cuentaVirtual; }
    public void setCuentaVirtual(CuentaVirtual cuentaVirtual) { this.cuentaVirtual = cuentaVirtual; }
    public String getIdBitcoin() { return idBitcoin; }
    public void setIdBitcoin(String idBitcoin) { this.idBitcoin = idBitcoin; }
    public float getCantidad() { return cantidad; }
    public void setCantidad(float cantidad) { this.cantidad = cantidad; }
}
