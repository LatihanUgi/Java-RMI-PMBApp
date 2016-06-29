/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admission;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

/**
 *
 * @author INTELAMD
 */
public interface IAccount extends Remote 
{
    public String[] caridataAdmin() throws RemoteException;
    public String autoNoReg()throws RemoteException;
    public String getNoReg() throws RemoteException;
    public void setNoReg(String NoReg) throws RemoteException;
    public String getUserName() throws RemoteException;
    public void setUserName(String UserName) throws RemoteException;
    public String getPassword() throws RemoteException;
    public void setPassword(String Password) throws RemoteException;
    public String getPosition() throws RemoteException;
    public void setPosition(String Position) throws RemoteException;
//    public void validatelelete(String Position) throws RemoteException;
    
    public ArrayList display() throws RemoteException;
    public ArrayList selecteddisplay() throws RemoteException;
    public int doInsert() throws RemoteException;
    public ArrayList getRecord() throws RemoteException;
    public int doUpdate() throws RemoteException;
    public int doDelete() throws RemoteException;
    public String[] searchDataAccount() throws RemoteException;
    public int caridataAccount() throws RemoteException;
}
