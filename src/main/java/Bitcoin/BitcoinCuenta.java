package Bitcoin;

import Cuenta.CuentaVirtual;

import javax.persistence.*;

@Entity
@Table(name = "BITCOINS_CUENTA")
public class BitcoinCuenta {

    @Id
    @GeneratedValue
    @Column(name = "ID_BITCOIN_CUENTA")
    private String id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "CUENTA_ID")
    private CuentaVirtual cuentaVirtual;

    @Column(name = "ID_BITCOIN")
    private String idBitcoin;

    @Column(name = "CANTIDAD")
    private float cantidad;

    public BitcoinCuenta(CuentaVirtual cuentaVirtual, String idBitcoin, float cantidad) {
        this.cuentaVirtual = cuentaVirtual;
        this.idBitcoin = idBitcoin;
        this.cantidad = cantidad;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public CuentaVirtual getCuentaVirtual() { return cuentaVirtual; }
    public void setCuentaVirtual(CuentaVirtual cuentaVirtual) { this.cuentaVirtual = cuentaVirtual; }
    public String getIdBitcoin() { return idBitcoin; }
    public void setIdBitcoin(String idBitcoin) { this.idBitcoin = idBitcoin; }
    public float getCantidad() { return cantidad; }
    public void setCantidad(float cantidad) { this.cantidad = cantidad; }
}
