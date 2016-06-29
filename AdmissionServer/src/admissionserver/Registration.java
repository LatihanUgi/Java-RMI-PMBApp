/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionserver;

import java.rmi.*;
import java.rmi.server.UnicastRemoteObject;
import Admission.AdmissionInterface;
import config.Koneksi;
import java.sql.*;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JOptionPane;

public class Registration extends UnicastRemoteObject implements AdmissionInterface
{
    public Connection con;
    private ResultSet rs;
    private PreparedStatement stat;
    
    private String Username;
    private String Pwd;
    private String Position;
    private Float Average,Indo,Eng,Math,Theory,Practice;
    private String Sains,Social;
    
    private String IdMajor,IdStudent,NoReg,Name,Birth,Gender,Email,Phone,Address,School,Vocational,Major,Quota;
    private Float Biology,Chemistry,Physics;
    Koneksi obj_koneksi = new Koneksi();
    
    public Registration() throws RemoteException
    {
        super();
    }
    
    @Override
    public void setNoReg(String cardno) throws RemoteException
    {
        this.NoReg =  NoReg;
    }
    
    @Override
    public String getNoReg() throws RemoteException
    {
        return this.NoReg;
    }

    @Override
    public void setUsername(String Username) throws RemoteException
    {
        this.Username =  Username;
    }
    
    @Override
    public String getUsername() throws RemoteException
    {
        return this.Username;
    }
    
    @Override
    public void setPwd(String Pwd)throws RemoteException
    {
        this.Pwd =  Pwd;
    }
    
    @Override
    public String getPwd() throws RemoteException
    {
        return this.Pwd;
    }
    
    @Override
    public void setPosition(String Position)throws RemoteException
    {
        this.Position =  Position;
    }
    
    @Override
    public String getPosition() throws RemoteException
    {
        return this.Position;
    }
    
    public void setIdMajor(String IdMajor)throws RemoteException
    {
        this.IdMajor =  IdMajor;
    }
    
    public String getIdMajor() throws RemoteException
    {
        return this.IdMajor;
    }
 
    public String getIdStudent() throws RemoteException
    {
        return this.IdStudent;
    }
    
    public void setIdStudent(String IdStudent)throws RemoteException
    {
        this.IdStudent =  IdStudent;
    } 
    
    public String getName() throws RemoteException
    {
        return this.Name;
    }
    
     public void setName(String Name)throws RemoteException
    {
        this.Name =  Name;
    }
    
    public void setBirth(String Birth)throws RemoteException
    {
        this.Birth =  Birth;
    }
    
    public String getBirth() throws RemoteException
    {
        return this.Birth;
    }
    
    public void setGender(String Gender)throws RemoteException
    {
        this.Gender =  Gender;
    }
  
    public String getGender() throws RemoteException
    {
        return this.Gender;
    }
    
    public void setEmail(String Email)throws RemoteException
    {
        this.Email =  Email;
    }

    public String getEmail() throws RemoteException
    {
        return this.Email;
    }
    
    public void setPhone(String Phone)throws RemoteException
    {
        this.Phone =  Phone;
    }
    
    
    public String getPhone() throws RemoteException
    {
        return this.Phone;
    }
    
    public void setAddress(String Address)throws RemoteException
    {
        this.Address =  Address;
    }
    
    
    public String getAddress() throws RemoteException
    {
        return this.Address;
    }
    
    public void setSchool(String School)throws RemoteException
    {
        this.School =  School;
    }
 
    public String getSchool() throws RemoteException
    {
        return this.School;
    }
    
    public void setIndo(Float Indo)throws RemoteException
    {
        this.Indo =  Indo;
    }
 
    public Float getIndo() throws RemoteException
    {
        return this.Indo;
    }
    
    public void setEng(Float Eng)throws RemoteException
    {
        this.Eng =  Eng;
    }

    public Float getEng() throws RemoteException
    {
        return this.Eng;
    }
    
    public void setMath(Float Math)throws RemoteException
    {
        this.Math =  Math;
    }
    
    public Float getMath() throws RemoteException
    {
        return this.Math;
    }
    
    public void setTheory(Float Theory)throws RemoteException
    {
        this.Theory =  Theory;
    }
    
    public Float getTheory() throws RemoteException
    {
        return this.Theory;
    }
    
    public void setPractice(Float Practice)throws RemoteException
    {
        this.Practice =  Practice;
    }
 
    public Float getPractice() throws RemoteException
    {
        return this.Practice;
    }
    
    public void setAverage(Float Average)throws RemoteException
    {
        this.Average =  Average;
    }
 
    public Float getAverage() throws RemoteException
    {
        return this.Average;
    }
    
    public void setVocational(String Vocational)throws RemoteException
    {
        this.Vocational =  Vocational;
    }
 
    public String getVocational() throws RemoteException
    {
        return this.Vocational;
    }
    
    public void setMajor(String Major)throws RemoteException
    {
        this.Major =  Major;
    }
 
    public String getMajor() throws RemoteException
    {
        return this.Major;
    }
    
    public Float getPhysics()
    {
        return Physics;
    }
    
    public void setPhysics(Float Physics) 
    {
        this.Physics = Physics;
    }
    
    public Float getChemistry()
    {
        return Chemistry;
    }
    
    public void setChemistry(Float Chemistry) 
    {
        this.Chemistry = Chemistry;
    }
    
    public Float getBiology()
    {
        return Biology;
    }
    
    public void setBiology(Float Biology) 
    {
        this.Chemistry = Chemistry;
    }
    
    public String getSains() throws RemoteException
    {
        return this.Sains;
    }
    
    public void setSains(String Sains)throws RemoteException
    {
        this.Sains =  Sains;
    }
    
    public String getSocial() throws RemoteException
    {
        return this.Social;
    }
    
    public void setSocial(String Social)throws RemoteException
    {
        this.Social =  Social;
    }

    public String autoIdVocational()
    {
        try
        {
            Connection con = obj_koneksi.Open();
            
            String sql = "select top 1 ID_Vocational from Vocational order by ID_Vocational desc";
            
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            String Idstudent = null;
            String id = null;
            
            if (rs.next())
            {
                Idstudent = rs.getString("ID_Vocational");
                //System.out.println(idpegawai);
                
                String potong = Idstudent.substring(3);
                int subidstudent = Integer.parseInt(potong) + 1;
                
                if(subidstudent < 10)
                {
                    id = "SMK0000" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 100)
                {
                   id = "SMK000" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 1000)
                {
                   id = "SMK00" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 10000)
                {
                   id = "SMK0" + Integer.toString(subidstudent);
                } 
                else if(subidstudent < 100000)
                {
                   id = "SMK" + Integer.toString(subidstudent);
                }
            }
            else
            {
                id = "SMK00001";
            }
            return id;
        }
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public String autoIdStudent()
    {
        try
        {
            Connection con = obj_koneksi.Open();
            
            String sql = "select top 1 ID_NewStudents from Student order by ID_NewStudents desc";
            
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            String Idstudent = null;
            String id = null;
            
            if (rs.next())
            {
                Idstudent = rs.getString("ID_NewStudents");
                //System.out.println(idpegawai);
                
                String potong = Idstudent.substring(3);
                int subidstudent = Integer.parseInt(potong) + 1;
                
                if(subidstudent < 10)
                {
                    id = "STU0000" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 100)
                {
                   id = "STU000" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 1000)
                {
                   id = "STU00" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 10000)
                {
                   id = "STU0" + Integer.toString(subidstudent);
                } 
                else if(subidstudent < 100000)
                {
                   id = "STU" + Integer.toString(subidstudent);
                }
            }
            else
            {
                id = "STU00001";
            }
            return id;
        }
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public int doUpdate(String IdMajor) 
    {
        int i = 0;
        try
        {
            obj_koneksi.Open();
            Connection con = obj_koneksi.Open();
            String str = "update Major set Quota = Quota - 1 from Major where ID_Major = ?";
            PreparedStatement pr = con.prepareStatement(str);
            
            pr.setString(1,IdMajor);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Update Quota Major");
        return i;
    }
    
    public int doLogin()
    {
        int i = 0;
        try
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str = "SELECT COUNT (*) FROM Account WHERE UserName = ? AND Password = ? AND Position = 'Admin'";
            
            PreparedStatement pr = con.prepareStatement(str);

            pr.setString(1, Username.trim());
            pr.setString(2, Pwd.trim());
            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                i = rs.getInt(1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Sorry, Account Not Find !");   
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User do Login");
        return i;
    }
    
    public int doLoginStudent()
    {
        int i = 0;
        try
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str = "SELECT COUNT (*) FROM Account WHERE UserName = ? AND Password = ? AND Position = 'Student'";
            PreparedStatement pr = con.prepareStatement(str);

            pr.setString(1, Username.trim());
            pr.setString(2, Pwd.trim());
            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                i = rs.getInt(1);
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Sorry, Account Not Find !");   
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Login As Student");
        return i;
    }
    
    public String[] caridataAdmin()
    {
        try 
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str = "select UserName from Account where UserName = ? AND Password = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1, Username);
            pr.setString(2, Pwd);
            
            ResultSet r = pr.executeQuery();
            String[] data = new String[1];
            if(r.next())
            {
                data[0]= r.getString("UserName");
            }
            else
            {
               data[0]= "null";
            }
            return data;          
        } 
        catch (Exception e) 
        {
        }
        return null;
    }
    
    public int caridataStudent()
    {
        int i = 0;
        try
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str = "select count (*) from Account ac join Student st on ac.ID_Account = st.ID_Account";
            PreparedStatement pr = con.prepareStatement(str);

            ResultSet rs = pr.executeQuery();
            if (rs.next())
            {
                JOptionPane.showMessageDialog(null, "Sorry, This Account Already Perform The Registration");
            }
            else
            {
                i = rs.getInt(1);
            }
        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Login As Student");
        return i;
    }
    
    public String[] caridataNoReg()
    {
        try 
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str = "select ID_Account from Account where UserName = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1, Username);
            
            ResultSet r = pr.executeQuery();
            String[] dataNo = new String[1];
            if(r.next())
            {
                dataNo[0]= r.getString("ID_Account");
            }
            else
            {
               dataNo[0]= "null";
            }
            return dataNo;          
        } 
        catch (Exception e) 
        {
        }
        return null;
    }
    
    public String caridataIdSiswa(String ID_Account)
    {
        String reg = "";
        try 
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str = "select ID_NewStudents from Student where ID_Account = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1, ID_Account);
            String[] dataId = new String[1];
            
            ResultSet r = pr.executeQuery();
            if(r.next())
            {
                dataId[0]= r.getString("ID_NewStudents");
                reg = dataId[0];
            }
            else
            {
               dataId[0]= "null";
            }       
        } 
        catch (Exception e) 
        {
        }
        return reg;
    }
    
    @Override
    public String EmailValidator(String email) throws RemoteException 
    {
        String status = "";
        if ("Email Benar".equals(email)) 
        {
            String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

            Pattern pattern = Pattern.compile(EMAIL_PATTERN);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) 
            {
                status = "Email Benar";
            } 
            else 
            {
                status = "";
            }
        }
        return status;
    }
    
    public int doInsertStudent(String idstudent, String NoReg, String name, String birth, String gender, 
            String email, String phone, String address, String school, String sains, String social, 
            String vocational, String major) 
    {
        int i = 0;
        try
        {
            obj_koneksi.Open();
            Connection con = obj_koneksi.Open();
            
            String str = "INSERT INTO Student(ID_NewStudents, ID_Account, FullName, BirthDate, Gender, Email, "
                    + "PhoneNo, Address, School, ID_Sains, ID_Social, ID_Vocational, "
                    + "ID_Major) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pr =con.prepareStatement(str);

            pr.setString(1,idstudent);
            pr.setString(2,NoReg);
            pr.setString(3,name);
            pr.setString(4,birth);
            pr.setString(5,gender);
            pr.setString(6,email);
            pr.setString(7,phone);
            pr.setString(8,address);
            pr.setString(9,school);
            pr.setString(10,sains);
            pr.setString(11,social);
            pr.setString(12,vocational);
            pr.setString(13,major);
            i = pr.executeUpdate();
        }
        catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        System.out.println("User enter data registration");
        return i;
    }
    
    public int doInsertVocational(String IdVocational, float indo, float eng, float math, float teory, float practice, float average) 
    {
        int i = 0;
        try
        {
            obj_koneksi.Open();
            Connection con = obj_koneksi.Open();
            
            String str = "INSERT INTO Vocational(ID_Vocational, Indonesian, English, Mathematics, Vocational_Theory,"
                    + "Practice_Vocational, Average) VALUES(?,?,?,?,?,?,?)";
            PreparedStatement pr =con.prepareStatement(str);

            pr.setString(1,IdVocational);
            pr.setFloat(2,indo);
            pr.setFloat(3,eng);
            pr.setFloat(4,math);
            pr.setFloat(5,teory);
            pr.setFloat(6,practice);
            pr.setFloat(7,average);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        return i;
    }
    
    public Integer Average()
    {
        int i = 0;
        try
        {
            obj_koneksi.Open();
            Connection con = obj_koneksi.Open();
            String str = "select AVG(Indonesian, English ,Mathematics , Vocational_Theory ,Practice_Vocational)\n" +
            "from Vocational";
            
            PreparedStatement pr =con.prepareStatement(str);
            pr.setString(1,Vocational.trim());
            pr.setFloat(2,Indo);
            pr.setFloat(3,Eng);
            pr.setFloat(4,Math);
            pr.setFloat(5,Theory);
            pr.setFloat(6,Practice);
            pr.setFloat(7,Average);
            i = pr.executeUpdate();
        }
        catch(Exception e)
        {
            System.out.println(e.getMessage());
        }
        return i;
    }
    
   
    public String BindingAccount(String account) throws RemoteException
    {
        return account;
    }
    
    public String Admission (String nama) throws RemoteException
    {
        String admission ="";
        return admission;
    }
    
    public ArrayList displays() throws RemoteException
    {
        ArrayList akun = new ArrayList();
        try 
        {
            stat = con.prepareStatement("select * from Account");
            ResultSet rs = stat.executeQuery();

            while (rs.next()) 
            {
                this.setNoReg(rs.getString(1));
                this.setUsername(rs.getString(2));
                this.setPwd(rs.getString(3));
                this.setPosition(rs.getString(4));
                
                akun.add(this.getNoReg());
                akun.add(this.getUsername());
                akun.add(this.getPwd());
                akun.add(this.getPosition());
            }

            /*Close the connection after use (MUST)*/
            if (stat != null) 
            {
                stat.close();
            }
        } 
        catch (Exception e) 
        {
            System.out.println("Error : " + e);
        }
        return akun;
    }
}
