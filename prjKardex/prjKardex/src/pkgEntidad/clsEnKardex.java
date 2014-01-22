package pkgEntidad;

/**
 * @author GatunoMaestro
 */
public class clsEnKardex 
{
    private int _intidkard;
    private int _intidpord;
    private Fecha _fecha;
    private int _saldoantentrada;
    private int _saldoantsalida;

    public int getIntidkard() {
        return _intidkard;
    }

    public void setIntidkard(int _intidkard) {
        this._intidkard = _intidkard;
    }

    public int getIntidpord() {
        return _intidpord;
    }

    public void setIntidpord(int _intidpord) {
        this._intidpord = _intidpord;
    }

    public int getSaldoantentrada() {
        return _saldoantentrada;
    }

    public void setSaldoantentrada(int _saldoantentrada) {
        this._saldoantentrada = _saldoantentrada;
    }

    public int getSaldoantsalida() {
        return _saldoantsalida;
    }

    public void setSaldoantsalida(int _saldoantsalida) {
        this._saldoantsalida = _saldoantsalida;
    }

    public String getFecha() {
        return _fecha.getFecha();
    }

    public void setFecha(Fecha _fecha) {
        this._fecha = _fecha;
    }
    public String getFechaCorta() {
        return _fecha.getFechaCorta();
    }
    
}