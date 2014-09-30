package Beans;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;


public class Model implements Serializable {//Application Level Logical Data Management.

    public static InfoSensibility sensData = new InfoSensibility();
    public static PermissionManagement permMan = new PermissionManagement(sensData);

    public static void write() throws FileNotFoundException, IOException {
        FileOutputStream fos = new FileOutputStream("Model.bin");
        ObjectOutputStream out = new ObjectOutputStream(fos);
        out.writeObject(sensData);
        out.writeObject(permMan);
    }

    public static void read() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("Model.bin");
        ObjectInputStream in = new ObjectInputStream(fis);
        InfoSensibility aux = (InfoSensibility) in.readObject();
        PermissionManagement aux2 = (PermissionManagement) in.readObject();
        sensData = aux;
        permMan = aux2;
    }
}
