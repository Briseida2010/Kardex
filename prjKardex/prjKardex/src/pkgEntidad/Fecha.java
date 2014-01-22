package pkgEntidad;

/**
 * @author GatunoMaestro
 */
public class Fecha 
{
    private int _dia;
    private int _mes;
    private int _año;
    private int _hor;
    private int _min;
    public boolean setdia(int dia)
    {
        if(dia>0&&dia<32)
        {
            _dia=dia;
            return true;
        }
        else
            return false;
    }
    public int getdia()
    {
        return _dia;
    }
    public boolean setmes(int mes)
    {
        if(mes<13&&mes>0)
        {
            _mes=mes;
            return true;
        }
        else
            return false;
    }
    public int getmes()
    {
        return _mes;
    }
    public boolean setaño(int año)
    {
        if(año>0&&año<100)
        {
            año=año+2000;
            _año=año;
            return true;
        }
        else
        {
            _año=año;
            return true;
        }
    }
    public int getaño()
    {
        return _año;
    }
    public boolean sethor(int hora)
    {
        if(hora>0&&hora<24)
        {
            _hor=hora;
            return true;
        }
        else
            return false;
    }
    public int gethora()
    {
        return _hor;
    }
    public boolean setmin(int min)
    {
        if(min>0&&min<60)
        {
            _min=min;
            return true;
        }
        else
            return false;
    }
    public int getmin()
    {
        return _min;
    }
    public String getFecha()
    {
        return String.valueOf(_dia)+" "+String.valueOf(_mes)+" "+String.valueOf(_año)+" "+String.valueOf(_hor)+" "+String.valueOf(_min);
    }
    public String getFechaCorta()
    {
        return String.valueOf(_dia)+" "+String.valueOf(_mes)+" "+String.valueOf(_año);
    }
}