/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admissionserver;

import Admission.IMajor;
import config.Koneksi;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

/**
 *
 * @author INTELAMD
 */
public class Major extends UnicastRemoteObject implements IMajor
{
    private String IdMajor,Department,Program,Description,Username,Pwd,IdStudent,noreg,name,Birth,email,phone,address,school,gender,Quota,Cost;;
    private Float indo, eng, math, theory, practice, average;
    
    Koneksi kon = new Koneksi();
    
    public Major()throws Exception
    {
        super();
    }
    public String getIdMajor() 
    {
        return IdMajor;
    }
    public void setIdMajor(String IdMajor) 
    {
        this.IdMajor = IdMajor;
    }
    public String getDepartment() 
    {
        return Department;
    }
    public void setDepartment(String Department) 
    {
        this.Department = Department;
    }
    public String getProgram() 
    {
        return Program;
    }
    public void setProgram(String Program) 
    {
        this.Program = Program;
    }
    public String getDescription() 
    {
        return Description;
    }
    public void setDescription(String Description) 
    {
        this.Description = Description;
    }
    public String getQuota() 
    {
        return Quota;
    }
    public void setQuota(String Quota) 
    {
        this.Quota = Quota;
    }
    public String getCost() 
    {
        return Cost;
    }
    public void setCost(String Cost) 
    {
        this.Cost = Cost;
    }
    public String getIdStudent() 
    {
        return IdStudent;
    }
    public void setIdStudent(String IdStudent) 
    {
        this.IdStudent = IdStudent;
    }
    public String getnoreg() 
    {
        return noreg;
    }
    public void setnoreg(String noreg) 
    {
        this.noreg = noreg;
    }
    public String getname() 
    {
        return name;
    }
    public void setname(String name) 
    {
        this.name = name;
    }
    public String getBirth() 
    {
        return Birth;
    }
    public void setBirth(String Birth) 
    {
        this.Birth = Birth;
    }
    public String getemail() 
    {
        return email;
    }
    public void setemail(String email) 
    {
        this.email = email;
    }
    public String getphone() 
    {
        return phone;
    }
    public void setphone(String phone) 
    {
        this.phone = phone;
    }
    public String getaddress() 
    {
        return address;
    }
    public void setaddress(String address) 
    {
        this.address = address;
    }
    public String getschool() 
    {
        return school;
    }
    public void setschool(String school) 
    {
        this.school = school;
    }
    public String getgender() 
    {
        return gender;
    }
    public void setgender(String gender) 
    {
        this.gender = gender;
    }
    public Float getindo() 
    {
        return indo;
    }
    public void setindo(Float indo) 
    {
        this.indo = indo;
    }
    public Float geteng() 
    {
        return eng;
    }
    public void seteng(Float eng) 
    {
        this.eng = eng;
    }
    public Float getmath() 
    {
        return math;
    }
    public void setmath(Float math) 
    {
        this.math = math;
    }
    public Float gettheory() 
    {
        return theory;
    }
    public void settheory(Float theory) 
    {
        this.theory = theory;
    }
    public Float getpractice() 
    {
        return practice;
    }
    public void setpractice(Float practice) 
    {
        this.practice = practice;
    }
    public Float getaverage() 
    {
        return average;
    }
    public void setaverage(Float average) 
    {
        this.average = average;
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
    
    public String autoId()
    {
        try
        {
            Connection con = kon.Open();
            
            String sql = "select top 1 ID_Major from Major order by ID_Major desc";
            
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            String Idmajor = null;
            String id = null;
            
            if (rs.next())
            {
                Idmajor = rs.getString("ID_Major");
                
                String potong = Idmajor.substring(5);
                int subidmajor = Integer.parseInt(potong) + 1;
                
                if(subidmajor < 10)
                {
                    id = "MAJOR00" + Integer.toString(subidmajor);
                }
                else if(subidmajor < 100)
                {
                   id = "MAJOR0" + Integer.toString(subidmajor);
                }
                else if(subidmajor < 1000)
                {
                   id = "MAJOR" + Integer.toString(subidmajor);
                }
            }
            else
            {
                id = "MAJOR001";
            }
            return id;
        }
        
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public ArrayList display() throws RemoteException
    {
        ArrayList data = new ArrayList();
        try
        {
            Koneksi kon = new Koneksi();
            Connection con = kon.Open();
            String str ="select ID_NewStudents, ID_Account, FullName, BirthDate, Gender, Email, PhoneNo, Address, School, ID_Major, Indonesian, English, Mathematics, Vocational_Theory, Practice_Vocational, Average from Student st  join Vocational vc on st.ID_Vocational = vc.ID_Vocational where ID_Account = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1, noreg);

            ResultSet rs = pr.executeQuery();
            
            
            while(rs.next()) 
            {
                 this.setIdStudent(rs.getString(1));
                 this.setnoreg(rs.getString(2));
                 this.setname(rs.getString(3));
                 this.setBirth(rs.getString(4));
                 this.setgender(rs.getString(5));
                 this.setemail(rs.getString(6));
                 this.setphone(rs.getString(7));
                 this.setaddress(rs.getString(8));
                 this.setschool(rs.getString(9));
                 this.setIdMajor(rs.getString(10));
                 this.setindo(Float.parseFloat(rs.getString(11)));
                 this.seteng(Float.parseFloat(rs.getString(12)));
                 this.setmath(Float.parseFloat(rs.getString(13)));
                 this.settheory(Float.parseFloat(rs.getString(14)));
                 this.setpractice(Float.parseFloat(rs.getString(15)));
                 this.setaverage(Float.parseFloat(rs.getString(16)));
                 
                 data.add(this.getIdStudent());
                 data.add(this.getnoreg());
                 data.add(this.getname());
                 data.add(this.getBirth());
                 data.add(this.getgender());
                 data.add(this.getemail());
                 data.add(this.getphone());
                 data.add(this.getaddress());
                 data.add(this.getschool());
                 data.add(this.getIdMajor());
                 data.add(this.getindo());
                 data.add(this.geteng());
                 data.add(this.getmath());
                 data.add(this.gettheory());
                 data.add(this.getpractice());
                 data.add(this.getaverage());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());            
        }
        System.out.println("User Display Data Major");
        return data;
    }
    
    public ArrayList displayMajor()
    {
        ArrayList data = new ArrayList();
        try 
        {
            kon.Open();
            Statement stmt = kon.Open().createStatement();
            String str = "SELECT * FROM Major";
            ResultSet rs = stmt.executeQuery(str);
            while (rs.next()) 
            {
                this.setIdMajor(rs.getString(1));
                this.setDepartment(rs.getString(2));
                this.setProgram(rs.getString(3));
                this.setDescription(rs.getString(4));
                this.setQuota(rs.getString(5));
                this.setCost(rs.getString(6));

                data.add(this.getIdMajor());
                data.add(this.getDepartment());
                data.add(this.getProgram());
                data.add(this.getDescription());
                data.add(this.getQuota());
                data.add(this.getCost());
            }
        } 
        catch (SQLException ex) 
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Display Data Major");
        return data;
    }
    
    public int doInsert(String ID_Major, String Department, String Program, String Description, String Quota, String Cost) 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            
            String str = "INSERT INTO Student(ID_Major, Department, Program, Description, Quota, Cost) VALUES(?,?,?,?,?,?)";
            PreparedStatement pr =con.prepareStatement(str);

            pr.setString(1,ID_Major);
            pr.setString(2,Department);
            pr.setString(3,Program);
            pr.setString(4,Description);
            pr.setString(5,Quota);
            pr.setString(6,Cost);
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
            String str = "SELECT * FROM Major WHERE ID_Major = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1,IdMajor);
            ResultSet rs = pr.executeQuery();            
            while(rs.next()) 
            {
                 this.setIdMajor(rs.getString(1));
                 this.setDepartment(rs.getString(2));
                 this.setProgram(rs.getString(3));
                 this.setDescription(rs.getString(4));
                 this.setQuota(rs.getString(5));
                 this.setCost(rs.getString(6));
                 
                 data.add(this.getIdMajor());
                 data.add(this.getDepartment());
                 data.add(this.getProgram());
                 data.add(this.getDescription());
                 data.add(this.getQuota());
                 data.add(this.getCost());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Display Data Major");
        return data;
    }
    
    public int doUpdate(String ID_Major, String Department, String Program, String Description, String Quota, String Cost) 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "UPDATE Student SET Department =  ?, Program = ?, Description = ?, Quota = ?, Cost = ? WHERE ID_Major = ?";
            PreparedStatement pr = con.prepareStatement(str);
            
            pr.setString(1,Department);
            pr.setString(2,Program);
            pr.setString(3,Description);
            pr.setString(4,Quota);
            pr.setString(5,Cost);
            pr.setString(6,ID_Major);
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
            String str = "DELETE Major WHERE ID_Major = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1,IdMajor);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Delete Data Major");
        return i;
    }
    
    public String[] searchDataMajor() throws RemoteException
    {
        try 
        {
            Connection c = kon.Open();
            String sq = "select ID_Major, Department, Program, Description, Qouta, Cost from Major where (ID_Major = ? OR Department = ?)";
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, IdMajor);
            ps.setString(2, Department);
            
            ResultSet r = ps.executeQuery();
            String[] data = new String[6];
            if(r.next())
            {
                data[0]= r.getString("ID_Major");
                data[1]= r.getString("Department");
                data[2]= r.getString("Program");
                data[3]= r.getString("Description");
                data[4]= r.getString("Quota");
                data[5]= r.getString("Cost");
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
        System.out.println("User Search Data Major");
        return null;
    }
    public int caridataMajor()
    {
        try 
        {
            Connection c = kon.Open();
            String sq = "select count(*) as jumlah from Major where ID_Major = ?";
            //pake prepare statment karena ada parameter
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, getIdMajor());
            
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
        System.out.println("User Search Data Major");
        return 0;
    }
}
