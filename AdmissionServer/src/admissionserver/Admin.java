/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionserver;

import config.Koneksi;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import Admission.IAdmin;
import java.rmi.RemoteException;

public class Admin extends UnicastRemoteObject implements IAdmin
{
    private String Username, Pwd;
    private String IdStudent,NoReg,Name,Birth,Gender,Email,Phone,Address,School,Sains,Social,Vocational,Major;
    Koneksi kon = new Koneksi();
    
    public Admin()throws Exception
    {
        super();
    }

    @Override
    public String getIdStudent() 
    {
        return IdStudent;
    }

    @Override
    public void setIdStudent(String IdStudent) 
    {
        this.IdStudent = IdStudent;
    }

    @Override
    public String getNoReg() 
    {
        return NoReg;
    }

    @Override
    public void setNoReg(String NoReg) 
    {
        this.NoReg = NoReg;
    }

    @Override
    public String getName() {
        return Name;
    }

    @Override
    public void setName(String Name) 
    {
        this.Name = Name;
    }
    
    @Override
    public String getBirth() {
        return Birth;
    }

    @Override
    public void setBirth(String Birth) 
    {
        this.Birth = Birth;
    }
    
    @Override
    public String getGender() {
        return Gender;
    }

    @Override
    public void setGender(String Gender) 
    {
        this.Gender = Gender;
    }

    @Override
    public String getEmail() 
    {
        return Email;
    }

    @Override
    public void setEmail(String Email) 
    {
        this.Email = Email;
    }
    
    @Override
    public String getPhone() 
    {
        return Phone;
    }

    @Override
    public void setPhone(String Phone) 
    {
        this.Phone = Phone;
    }
    
    @Override
    public String getAddress() 
    {
        return Address;
    }
    
    @Override
    public void setAddress(String Address) 
    {
        this.Address = Address;
    }
    
    @Override
    public String getSchool() 
    {
        return School;
    }
    
    @Override
    public void setSchool(String School) 
    {
        this.School = School;
    }
    
    @Override
    public String getSains()
    {
        return Sains;
    }
    
    @Override
    public void setSains(String Sains) 
    {
        this.Sains = Sains;
    }
    
    public String getSocial()
    {
        return Social;
    }
    
    @Override
    public void setSocial(String Social) 
    {
        this.Social = Social;
    }
    
    @Override
    public String getVocational()
    {
        return Vocational;
    }
    
    @Override
    public void setVocational (String Vocational) 
    {
        this.Vocational = Vocational;
    }
    
    @Override
    public String getMajor()
    {
        return Major;
    }
    
    @Override
    public void setMajor(String Major) 
    {
        this.Major = Major;
    }
    
    public String autoIdStudent()
    {
        try
        {
            Connection con = kon.Open();
            
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
    
    public ArrayList display() {
        ArrayList data = new ArrayList();
        
        try
        {
            kon.Open();
            Statement stmt = kon.Open().createStatement();
            String str = "SELECT * FROM Student";
            ResultSet rs = stmt.executeQuery(str);            
            while(rs.next()) 
            {
                 this.setIdStudent(rs.getString(1));
                 this.setNoReg(rs.getString(2));
                 this.setName(rs.getString(3));
                 this.setBirth(rs.getString(4));
                 this.setGender(rs.getString(5));
                 this.setEmail(rs.getString(6));
                 this.setPhone(rs.getString(7));
                 this.setAddress(rs.getString(8));
                 this.setSchool(rs.getString(9));
                 this.setSains(rs.getString(10));
                 this.setSocial(rs.getString(11));
                 this.setVocational(rs.getString(12));
                 this.setMajor(rs.getString(13));
                                  
                 data.add(this.getIdStudent());
                 data.add(this.getNoReg());
                 data.add(this.getName());
                 data.add(this.getBirth());
                 data.add(this.getGender());
                 data.add(this.getEmail());
                 data.add(this.getPhone());
                 data.add(this.getAddress());
                 data.add(this.getSchool());
                 data.add(this.getSains());
                 data.add(this.getSocial());
                 data.add(this.getVocational());
                 data.add(this.getMajor());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());            
        }
        System.out.println("User Display Data Student");
        return data;
    }
    
    public ArrayList selecteddisplay() 
    {
        ArrayList data = new ArrayList();
        
        try
        {
            kon.Open();
            Connection con = kon.Open();
            
            Statement stmt = kon.Open().createStatement();
            String str = "SELECT * FROM Student where ID_NewStudents = ? or FullName = ? ";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, IdStudent);
            ps.setString(2, Name);
            ResultSet rs = stmt.executeQuery(str);            
            while(rs.next()) 
            {
                 this.setIdStudent(rs.getString(1));
                 this.setNoReg(rs.getString(2));
                 this.setName(rs.getString(3));
                 this.setBirth(rs.getString(4));
                 this.setGender(rs.getString(5));
                 this.setEmail(rs.getString(6));
                 this.setPhone(rs.getString(7));
                 this.setAddress(rs.getString(8));
                 this.setSchool(rs.getString(9));
                 this.setSains(rs.getString(10));
                 this.setSocial(rs.getString(11));
                 this.setVocational(rs.getString(12));
                 this.setMajor(rs.getString(13));
                                  
                 data.add(this.getIdStudent());
                 data.add(this.getNoReg());
                 data.add(this.getName());
                 data.add(this.getBirth());
                 data.add(this.getGender());
                 data.add(this.getEmail());
                 data.add(this.getPhone());
                 data.add(this.getAddress());
                 data.add(this.getSchool());
                 data.add(this.getSains());
                 data.add(this.getSocial());
                 data.add(this.getVocational());
                 data.add(this.getMajor());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());            
        }
        return data;
    }
    
    public int doInsert() 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            
            String str = "INSERT INTO Student(ID_NewStudents, ID_Account, FullName, BirthDate, Gender, Email, PhoneNo, Address, School, ID_Sains, ID_Social, ID_Vocational, ID_Major) VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)";
            PreparedStatement pr =con.prepareStatement(str);

            pr.setString(1,IdStudent.trim());
            pr.setString(2,NoReg.trim());
            pr.setString(3,Name.trim());
            pr.setString(4,Birth.trim());
            pr.setString(5,Gender.trim());
            pr.setString(6,Email.trim());
            pr.setString(7,Phone.trim());
            pr.setString(8,Address.trim());
            pr.setString(9,School.trim());
            pr.setString(10,Sains.trim());
            pr.setString(11,Social.trim());
            pr.setString(12,Vocational.trim());
            pr.setString(13,Major.trim());
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Add Data Student");
        return i;
    }
    
    public ArrayList getRecord() 
    {
        ArrayList data = new ArrayList();
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "SELECT * FROM Student WHERE ID_NewStudents = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1,IdStudent);
            ResultSet rs = pr.executeQuery();            
            while(rs.next()) 
            {
                 this.setIdStudent(rs.getString(1));
                 this.setNoReg(rs.getString(2));
                 this.setName(rs.getString(3));
                 this.setBirth(rs.getString(4));
                 this.setGender(rs.getString(5));
                 this.setEmail(rs.getString(6));
                 this.setPhone(rs.getString(7));
                 this.setAddress(rs.getString(8));
                 this.setSchool(rs.getString(9));
                 this.setSains(rs.getString(10));
                 this.setSocial(rs.getString(11));
                 this.setVocational(rs.getString(12));
                 this.setMajor(rs.getString(13));
                 
                 data.add(this.getIdStudent());
                 data.add(this.getNoReg());
                 data.add(this.getName());
                 data.add(this.getBirth());
                 data.add(this.getGender());
                 data.add(this.getEmail());
                 data.add(this.getPhone());
                 data.add(this.getAddress());
                 data.add(this.getSchool());
                 data.add(this.getSains());
                 data.add(this.getSocial());
                 data.add(this.getVocational());
                 data.add(this.getMajor());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Add Data Student By Search ID Student");
        return data;
    }
    
    public int doUpdate() 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "UPDATE Student SET FullName =  ?, BirthDate = ?, Gender = ?, Email = ?, PhoneNo = ?, Address = ?, School = ?, ID_Sains = ?, ID_Social = ?, ID_Vocational = ?, ID_Major = ? WHERE ID_NewStudents = ?";
            PreparedStatement pr = con.prepareStatement(str);
            
            pr.setString(1,Name.trim());
            pr.setString(2,Birth.trim());
            pr.setString(3,Gender.trim());
            pr.setString(4,Email.trim());
            pr.setString(5,Phone.trim());
            pr.setString(6,Address.trim());
            pr.setString(7,School.trim());
            pr.setString(8,Sains.trim());
            pr.setString(9,Social.trim());
            pr.setString(10,Vocational.trim());
            pr.setString(11,Major.trim());
            pr.setString(12, IdStudent.trim());
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Update Data Student");
        return i;
    }
    
    public int doDelete() 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "DELETE Student WHERE ID_NewStudents = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1,IdStudent);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Delete Data Student");
        return i;
    }
    
    public String[] searchDataStudent() throws RemoteException
    {
        try 
        {
            Connection c = kon.Open();
            String sq = "select ID_NewStudents, ID_Account, FullName, BirthDate, Gender, Email, PhoneNo, Address, School, ID_Sains, ID_Social, ID_Vocational, ID_Major from Student where (ID_NewStudents = ? OR FullName = ?)";
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, IdStudent);
            ps.setString(2, Name);
            
            ResultSet r = ps.executeQuery();
            String[] data = new String[13];
            if(r.next())
            {
                data[0]= r.getString("ID_NewStudents");
                data[1]= r.getString("ID_Account");
                data[2]= r.getString("FullName");
                data[3]= r.getString("BirthDate");
                data[4]= r.getString("Gender");
                data[5]= r.getString("Email");
                data[6]= r.getString("PhoneNo");
                data[7]= r.getString("Address");
                data[8]= r.getString("School");
                data[9]= r.getString("ID_Sains");
                data[10]= r.getString("ID_Social");
                data[11]= r.getString("ID_Vocational");
                data[12]= r.getString("ID_Major");
            }
            else
            {
               data[0]= "";
            }
            return data;          
        } 
        catch (Exception e) 
        {
             System.out.println(e.getMessage());
        }
        System.out.println("User Search Data Student");
        return null;
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
        try 
        {
            Connection c = kon.Open();
            String sq = "select count(*) as jumlah from Student where ID_NewStudents=?";
            //pake prepare statment karena ada parameter
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, getIdStudent());
            
            ResultSet r = ps.executeQuery();
            int jumlah = 0;
            if(r.next())
            {
                jumlah = r.getInt("jumlah");
            }
            return jumlah;          
        } 
        catch (Exception e) 
        {
        }
        return 0;
    }
}
