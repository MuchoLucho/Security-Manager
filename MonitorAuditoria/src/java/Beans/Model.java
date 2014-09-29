/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author Javier
 */
public class Model implements Serializable {//Application Level Logical Data Management.
    public static /*final*/ InfoSensibility sensData = new InfoSensibility();
    public static /*final*/ PermissionManagement permMan = new PermissionManagement(sensData);
 
    
    public void write() throws FileNotFoundException, IOException
    {
        FileOutputStream fos = new FileOutputStream("/Model.bin");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        
        out.writeObject(sensData);
        out.writeObject(permMan);
    }
    
    public void read () throws FileNotFoundException, IOException, ClassNotFoundException
    {
        FileInputStream fis = new FileInputStream("/Model.bin");
        ObjectInputStream in = new ObjectInputStream(fis);
        
        InfoSensibility aux = new InfoSensibility();
        aux = (InfoSensibility)in.readObject();
        PermissionManagement aux2 = new PermissionManagement(aux);
        aux2 = (PermissionManagement)in.readObject();
        
        sensData = aux;
        permMan = aux2;
   
    }
}
