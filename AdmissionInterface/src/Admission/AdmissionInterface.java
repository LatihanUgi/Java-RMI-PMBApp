/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Admission;

import java.rmi.*;
import java.util.ArrayList;
import java.util.Vector;

public interface AdmissionInterface extends Remote{

    public String EmailValidator(String email) throws RemoteException;
    public String Admission (String nama) throws RemoteException;
    public int doLogin() throws RemoteException;
    public int doLoginStudent() throws RemoteException;
    public String[] caridataAdmin() throws RemoteException;
    public int caridataStudent() throws RemoteException;
    public String BindingAccount(String account) throws RemoteException;
    public ArrayList displays() throws RemoteException;
    public void setNoReg(String NoReg) throws RemoteException;
    public String getNoReg() throws RemoteException;
    public void setUsername(String Username) throws RemoteException;
    public String getUsername() throws RemoteException;
    public void setPwd(String Pwd)throws RemoteException;
    public String getPwd() throws RemoteException;
    public void setPosition(String Position)throws RemoteException;
    public String getPosition() throws RemoteException;
    public String[] caridataNoReg() throws RemoteException;
    public String caridataIdSiswa(String NoReg) throws RemoteException;
    public Integer Average() throws RemoteException;
    
    public String autoIdVocational()throws RemoteException;
    public String autoIdStudent()throws RemoteException;
    public String getName() throws RemoteException;
    public void setName(String Name) throws RemoteException;
    public String getIdStudent() throws RemoteException;
    public void setIdStudent(String IdStudent) throws RemoteException;
    public String getBirth() throws RemoteException;
    public void setBirth(String Birth) throws RemoteException;
    public String getGender() throws RemoteException;
    public void setGender(String Gender) throws RemoteException;
    public String getEmail() throws RemoteException;
    public void setEmail(String Email) throws RemoteException;
    public String getPhone() throws RemoteException;
    public void setPhone(String Phone) throws RemoteException;
    public String getSchool() throws RemoteException;
    public void setSchool(String School) throws RemoteException;
    public String getAddress() throws RemoteException;
    public void setAddress(String Address) throws RemoteException;
    public Float getIndo() throws RemoteException;
    public void setIndo(Float Indo) throws RemoteException;
    public Float getEng() throws RemoteException;
    public void setEng(Float Eng) throws RemoteException;
    public Float getMath() throws RemoteException;
    public void setMath(Float Math) throws RemoteException;
    public Float getTheory() throws RemoteException;
    public void setTheory(Float Theory) throws RemoteException;
    public Float getPractice() throws RemoteException;
    public void setPractice(Float Practice) throws RemoteException;
    public Float getAverage() throws RemoteException;
    public void setAverage(Float Average) throws RemoteException;
    public String getVocational() throws RemoteException;
    public void setVocational(String Vocational) throws RemoteException;
    public String getMajor() throws RemoteException;
    public void setMajor(String Major) throws RemoteException;
    public Float getPhysics() throws RemoteException;
    public void setPhysics(Float Physics) throws RemoteException;
    public Float getChemistry() throws RemoteException;
    public void setChemistry(Float Chemistry) throws RemoteException;
    public Float getBiology() throws RemoteException;
    public void setBiology(Float Biology) throws RemoteException;
    public String getSains() throws RemoteException;
    public void setSains(String Sains) throws RemoteException;
    public String getSocial() throws RemoteException;
    public void setSocial(String Social) throws RemoteException;
    
    public int doInsertStudent(String idstudent, String NoReg, String name, String birth, String gender, String email, String phone, String address, String school, String sains, String social, String vocational, String major) throws RemoteException;
    public int doUpdate(String IdMajor) throws RemoteException;
    public int doInsertVocational(String IdVocational, float indo, float eng, float math, float teory, float practice, float average) throws RemoteException;
}
