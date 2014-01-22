package pkgNegocios;
import pkgEntidad.*;
import java.io.*;
/**
 * @author GatunoMaestro
 */
public class clsArticulo 
{
    String holaCharlie="Hola Briseida como estas";
    String dataInput="";
    clsEnArticulo[] arreglo;
    public void leerArchivoOrigen()
    {
        try
        {
            FileInputStream file=new FileInputStream("articulos.txt");
            int c;
            while((c=file.read())!=-1)
            {
                dataInput=dataInput+String.valueOf((char)c);
            }
            file.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Se creara un nuevo registro debido a que el anterior no existe o esta ilegible.");
            crearArchivoOrigen();
        }
        catch(IOException e)
        {
            System.out.println("El archivo es ilegible, se procedera a crear uno nuevo.");
            crearArchivoOrigen();
        }
    }
    public void crearArchivoOrigen()
    {
        try
        {
            PrintWriter file=new PrintWriter("articulos.txt");
            file.println("__Articulos_~");
            file.close();
        }
        catch(IOException e)
        {
            System.out.println("No se pudo crear el archivo de articulos, saliendo");
            System.exit(0);
        }
    }
    public void guardarArchivoOrigen()
    {
        byte c[];
        try
        {
            FileOutputStream file=new FileOutputStream("articulos.txt");
            String n="~";
            c=n.getBytes();
            file.write(c);
            for(int i=0;i<arreglo.length;i++)
            {
                String cadena="prod:"+arreglo[i].getIdprod()+"*nomb:"+arreglo[i].getNomprod()+"*stoc:"+arreglo[i].getStock()+"*prec:"+arreglo[i].getPrecio()+"*~";
                c=cadena.getBytes();
                file.write(c);
            }
            file.close();
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Se creara un nuevo registro debido a que el anterior no existe o esta ilegible.");
            crearArchivoOrigen();
        }
        catch(IOException e)
        {
            System.out.println("No se pudo crear el archivo de articulos, saliendo");
            System.exit(0);
        }
    }
    public void crearArreglos()
    {
        int setter=0;
        int getter=0;
        int rezzer=0;
        for(int i=0;i<dataInput.length();i++)
        {
            if(dataInput.charAt(i)==(char)'_')
            {
                if(dataInput.charAt(i+1)==(char)'_')
                {
                    int j=0;
                    setter=i+2;
                    while(j==0)
                    {
                        if(dataInput.charAt(setter)!='_')
                        {
                            setter=setter+1;
                        }
                        else
                        {
                            j=1;
                            setter=j;
                        }
                    }
                    break;
                }
            }
        }
        for(int line=setter;line<dataInput.length();line++)
        {
            if(dataInput.charAt(line)==Character.valueOf('~'))
            {
                getter++;
            }
        }
        arreglo=new clsEnArticulo[getter];
        for(int i=0;i<getter;i++)
        {
            arreglo[i]=new clsEnArticulo();
        }
        for(int line=setter;line<dataInput.length();line++)
        {
            int j;
            if(dataInput.charAt(line)==Character.valueOf('~'))
            {
                for(j=line;j<dataInput.length();j++)
                {
                    if(dataInput.charAt(j)==Character.valueOf('~'))
                    {
                        break;
                    }
                }
                for(int palabra=line;palabra<j;palabra++)
                {
                    int tmp=1;
                    String tmpstr="";
                    String pala[]={"prod:","nomb:","stoc:","prec:"};
                    if(dataInput.charAt(palabra)==pala[tmp].charAt(0)&&dataInput.charAt(palabra+1)==pala[tmp].charAt(1)
                            &&dataInput.charAt(palabra+2)==pala[tmp].charAt(2)&&dataInput.charAt(palabra+3)==pala[tmp].charAt(3)
                            &&dataInput.charAt(palabra+4)==pala[tmp].charAt(4))
                    {
                        int hl=palabra;
                        tmpstr="";
                        while(dataInput.charAt(hl)!=(char)'*')
                        {
                            if(dataInput.charAt(hl)!=(char)'*')
                                tmpstr=tmpstr+dataInput.charAt(hl);
                            hl++;
                        }
                        palabra=hl;
                        switch(tmp)
                        {
                            case 1: arreglo[rezzer].setIdprod(Integer.parseInt(tmpstr));
                                break;
                            case 2: arreglo[rezzer].setNomprod(tmpstr);
                                break;
                            case 3: arreglo[rezzer].setStock(Integer.parseInt(tmpstr));
                                break;
                            case 4: arreglo[rezzer].setPrecio(Float.parseFloat(tmpstr));
                                rezzer++;
                                tmp=0;
                                break;
                        }
                        tmp++;
                    }
                }
            }
        }
    }
    public void agregarArticulo(clsEnArticulo art)
    {
        clsEnArticulo tmp[]=new clsEnArticulo[arreglo.length+1];
        int i;
        for(i=0;i<arreglo.length;i++)
        {
            tmp[i]=new clsEnArticulo();
            tmp[i].setIdprod(arreglo[i].getIdprod());
            tmp[i].setNomprod(arreglo[i].getNomprod());
            tmp[i].setPrecio(arreglo[i].getPrecio());
            tmp[i].setStock(arreglo[i].getStock());
        }
        tmp[i]=new clsEnArticulo();
        tmp[i]=art;
        arreglo=tmp;
        guardarArchivoOrigen();
    }
    public void modificarArticulo(clsEnArticulo art)
    {
        int _index=buscarIndex(art.getNomprod());
        if(_index!=-1)
            arreglo[_index]=art;
        guardarArchivoOrigen();
    }
    public int buscarIndex(String nombre)
    {
        int res=-1;
        for(int i=0;i<arreglo.length;i++)
        {
            if(arreglo[i].getNomprod().equals(nombre))
            {
                res=i;
                break;
            }
        }
        return res;
    }
    public void eliminarArticulo(String nombre)
    {
        int _index=buscarIndex(nombre);
        if(_index!=-1)
        {
            for(int i=_index;i<arreglo.length;i++)
            {
                arreglo[i]=arreglo[i+1];
            }
            clsEnArticulo tmp[]=new clsEnArticulo[arreglo.length-1];
            for(int i=0;i<arreglo.length-1;i++)
            {
                tmp[i]=new clsEnArticulo();
                tmp[i]=arreglo[i];
            }
            arreglo=tmp;
            guardarArchivoOrigen();
        }
    }
    public clsEnArticulo buscarArticulo(String nombre)
    {
        int _index=buscarIndex(nombre);
        if(_index!=-1)
        {
            return arreglo[_index];
        }
        else
        {
            return null;
        }
    }
    public clsEnArticulo[] listarArticulo()
    {
        return arreglo;
    }
}