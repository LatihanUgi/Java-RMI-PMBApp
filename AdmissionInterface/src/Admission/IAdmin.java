/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admission;

import java.rmi.*;
import java.util.ArrayList;

public interface IAdmin extends Remote
{
    public String autoIdStudent()throws RemoteException;
    public String getIdStudent() throws RemoteException;
    public void setIdStudent(String IdStudent) throws RemoteException;
    public String getNoReg() throws RemoteException;
    public void setNoReg(String NoReg) throws RemoteException;
    public String getName() throws RemoteException;
    public void setName(String Name) throws RemoteException;
    public String getBirth() throws RemoteException;
    public void setBirth(String Birth) throws RemoteException;
    public String getGender() throws RemoteException;
    public void setGender(String Gender) throws RemoteException;
    public String getEmail() throws RemoteException;
    public void setEmail(String Email) throws RemoteException;
    public String getPhone() throws RemoteException;
    public void setPhone(String Phone) throws RemoteException;
    public String getAddress() throws RemoteException;
    public void setAddress(String Address) throws RemoteException;
    public String getSchool() throws RemoteException;
    public void setSchool(String School) throws RemoteException;
    public String getSains() throws RemoteException;
    public void setSains(String Sains) throws RemoteException;
    public String getSocial() throws RemoteException;
    public void setSocial(String Social) throws RemoteException;
    public String getVocational() throws RemoteException;
    public void setVocational(String Vocational) throws RemoteException;
    public String getMajor() throws RemoteException;
    public void setMajor(String Major) throws RemoteException;
    public ArrayList selecteddisplay() throws RemoteException;
    
    
    public ArrayList display() throws RemoteException;
    public int doInsert() throws RemoteException;
    public ArrayList getRecord() throws RemoteException;
    public int doUpdate() throws RemoteException;
    public int doDelete() throws RemoteException;
    public String[] searchDataStudent() throws RemoteException;
    public int caridataStudent() throws RemoteException;
    public String[] caridataAdmin() throws RemoteException;
}
