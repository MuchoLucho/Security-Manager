package Beans;

public class Model {//Application Level Logical Data Management.
    public static final InfoSensibility sensData = new InfoSensibility();
    public static final PermissionManagement permMan = new PermissionManagement(sensData);
    
}
