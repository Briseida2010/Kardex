package pkgEntidad;

/**
 * @author GatunoMaestro
 */
public class clsEnArticulo 
{
    private int _idprod;
    private String _nomprod;
    private int _stock;
    private float _precio;

    public int getIdprod() {
        return _idprod;
    }

    public void setIdprod(int _idprod) {
        this._idprod = _idprod;
    }

    public String getNomprod() {
        return _nomprod;
    }

    public void setNomprod(String _nomprod) {
        this._nomprod = _nomprod;
    }

    public int getStock() {
        return _stock;
    }

    public void setStock(int _stock) {
        this._stock = _stock;
    }

    public float getPrecio() {
        return _precio;
    }

    public void setPrecio(float _precio) {
        this._precio = _precio;
    }
    
}