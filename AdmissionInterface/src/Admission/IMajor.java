/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admission;

import java.rmi.*;
import java.util.ArrayList;

public interface IMajor extends Remote
{
    public String[] caridataAdmin() throws RemoteException;
    public String autoId()throws RemoteException;
    public String getIdMajor() throws RemoteException;
    public void setIdMajor(String IdMajor) throws RemoteException;
    public String getDepartment() throws RemoteException;
    public void setDepartment(String Department) throws RemoteException;
    public String getProgram() throws RemoteException;
    public void setProgram(String Program) throws RemoteException;
    public String getDescription() throws RemoteException;
    public void setDescription(String Description) throws RemoteException;
    public String getQuota() throws RemoteException;
    public void setQuota(String Quota) throws RemoteException;
    public String getCost() throws RemoteException;
    public void setCost(String Cost) throws RemoteException;
    public String getIdStudent() throws RemoteException;
    public void setIdStudent(String IdStudent) throws RemoteException;
    public String getnoreg() throws RemoteException;
    public void setnoreg(String noreg) throws RemoteException;
    public String getname() throws RemoteException;
    public void setname(String name) throws RemoteException;
    public String getBirth() throws RemoteException;
    public void setBirth(String Birth) throws RemoteException;
    public String getgender() throws RemoteException;
    public void setgender(String gender) throws RemoteException;
    public String getemail() throws RemoteException;
    public void setemail(String email) throws RemoteException;
    public String getphone() throws RemoteException;
    public void setphone(String phone) throws RemoteException;
    public String getaddress() throws RemoteException;
    public void setaddress(String address) throws RemoteException;
    public String getschool() throws RemoteException;
    public void setschool(String school) throws RemoteException;
    public Float getindo() throws RemoteException;
    public void setindo(Float indo) throws RemoteException;
    public Float geteng() throws RemoteException;
    public void seteng(Float eng) throws RemoteException;
    public Float getmath() throws RemoteException;
    public void setmath(Float math) throws RemoteException;
    public Float gettheory() throws RemoteException;
    public void settheory(Float theory) throws RemoteException;
    public Float getpractice() throws RemoteException;
    public void setpractice(Float practice) throws RemoteException;
    
    public ArrayList displayMajor() throws RemoteException;
    public ArrayList display() throws RemoteException;
    public int doInsert(String ID_Major, String Department, String Program, String Description, String Quota, String Cost) throws RemoteException;
    public ArrayList getRecord() throws RemoteException;
    public int doUpdate(String ID_Major, String Department, String Program, String Description, String Quota, String Cost) throws RemoteException;
    public int doDelete() throws RemoteException;
    public String[] searchDataMajor() throws RemoteException;
    public int caridataMajor() throws RemoteException;
}