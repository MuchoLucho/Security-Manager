/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Beans;

/**
 *
 * @author Javier
 */
public class Model {//Application Level Logical Data Management.
    public static final InfoSensibility sensData = new InfoSensibility();
    public static final PermissionManagement permMan = new PermissionManagement(sensData);
}
