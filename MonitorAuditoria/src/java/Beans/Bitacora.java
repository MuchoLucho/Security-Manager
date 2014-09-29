package Beans;

import java.util.ArrayList;
import java.util.Date;

/*
    Codificacion de los Eventos
        Crear rol: R01
        Modificar rol: R02 
        Eliminar rol: R03
       
        Crear usuario: U01
        Modificar usuario: U02
        Eliminar usuario: U03
        
        Crear sensibilidad: S01
        Modificar sensibilidad: S02 
        Eliminar sensibilidad: S03

        Activar auditoria: A01
        Desactivar auditoria: A02
        Consultar auditoria: A03
*/
public class Bitacora {
    private static final ArrayList<String> l1 = new ArrayList();
    
    public static void crearUsuario(){
        insertar("crear","usuario");
    }
    public static void crearRol(){
        insertar("crear","rol");
    }
    public static void crearSensibilidad(){
        insertar("crear","sensibilidad");
    }
    public static void crearAuditoria(){
        insertar("crear","auditoria");
    }

//    public static void crearUsuario(){
//        insertar("crear","usuario");
//    }
        
    private static void insertar(String accion, String padre)
    {
        String codif=null;
        if(padre.equals("rol"))
        {
            switch (accion)
            {
                case "crear": codif="R01";
                    break;
                case "modificar": codif="R02";
                    break;
                case "eliminar": codif="R03";
                    break;  
            }
        } else if(padre.equals("usuario"))
                {
                    switch (accion)
                    {
                        case "crear": codif="U01";
                            break;
                        case "modificar": codif="U02";
                            break;
                        case "eliminar": codif="U03";
                            break;
                    }
                } else if(padre.equals("sensibilidad"))
                        {
                            switch (accion)
                            {
                                case "crear": codif="S01";
                                    break;
                                case "modificar": codif="S02";
                                    break;
                                case "eliminar": codif="S03";
                                    break;
                            }
                        } else if(padre.equals("auditoria"))
                                {
                                    switch (accion)
                                    {
                                        case "activar": codif="A01";
                                            break;
                                        case "desactivar": codif="A02";
                                            break;
                                        case "consultar": codif="A03";
                                            break;
                                    }
                                }
        
        Date dat= new Date();
        String element = (dat.getDay()+21)+"/"+(dat.getMonth()+1)+"/"+(dat.getYear()+1900) + " " + (dat.getHours())+":"+(dat.getMinutes())+":"+(dat.getSeconds())+" "+codif;
        System.out.println(element);
        l1.add(element);
        System.out.println(l1.toString());
    }
    
    public static String getContents(){
        StringBuilder str = new StringBuilder();
        l1.stream().forEach(x->str.append(x).append("\n"));
        return str.toString();
    }
    
}
