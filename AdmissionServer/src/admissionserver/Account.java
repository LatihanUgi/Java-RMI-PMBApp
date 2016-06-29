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
import Admission.IAccount;
import java.rmi.RemoteException;
import javax.swing.JOptionPane;

public class Account extends UnicastRemoteObject implements IAccount
{
    private String NoReg,UserName,Password,Position;
    private String Username, Pwd;
    Koneksi kon = new Koneksi();

    public Account()throws Exception
    {
        super();
    }
    public String getNoReg() 
    {
        return NoReg;
    }
    public void setNoReg(String NoReg) 
    {
        this.NoReg = NoReg;
    }
    public String getUserName() 
    {
        return UserName;
    }
    public void setUserName(String UserName) 
    {
        this.UserName = UserName;
    }
    public String getPassword() 
    {
        return Password;
    }
    public void setPassword(String Password) 
    {
        this.Password = Password;
    }
    public String getPosition() 
    {
        return Position;
    }
    public void setPosition(String Position) 
    {
        this.Position = Position;
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
    
    public String autoNoReg()
    {
        try
        {
            Connection con = kon.Open();
            
            String sql = "select top 1 ID_Account from Account order by ID_Account desc";
            
            Statement state = con.createStatement();
            ResultSet rs = state.executeQuery(sql);
            
            String noreg = null;
            String id = null;
            
            if (rs.next())
            {
                noreg = rs.getString("ID_Account");
                //System.out.println(idpegawai);
                
                String potong = noreg.substring(3);
                int subidstudent = Integer.parseInt(potong) + 1;
                
                if(subidstudent < 10)
                {
                    id = "REG0000" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 100)
                {
                   id = "REG000" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 1000)
                {
                   id = "REG00" + Integer.toString(subidstudent);
                }
                else if(subidstudent < 10000)
                {
                   id = "REG0" + Integer.toString(subidstudent);
                } 
                else if(subidstudent < 100000)
                {
                   id = "REG" + Integer.toString(subidstudent);
                }
            }
            else
            {
                id = "REG00001";
            }
            return id;
        }
        
        catch (Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
    
    public ArrayList display() 
    {
        ArrayList data = new ArrayList();
        
        try
        {
            kon.Open();
            Statement stmt = kon.Open().createStatement();
            String str = "SELECT * FROM Account";
            ResultSet rs = stmt.executeQuery(str);            
            while(rs.next()) 
            {
                 this.setNoReg(rs.getString(1));
                 this.setUserName(rs.getString(2));
                 this.setPassword(rs.getString(3));
                 this.setPosition(rs.getString(4));
                                  
                 data.add(this.getNoReg());
                 data.add(this.getUserName());
                 data.add(this.getPassword());
                 data.add(this.getPosition());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());            
        }
        System.out.println("User Display Data Account");
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
            String str = "SELECT * FROM Account where ID_Account = ? or UserName = ? ";
            PreparedStatement ps = con.prepareStatement(str);
            ps.setString(1, NoReg);
            ps.setString(2, UserName);
            ResultSet rs = stmt.executeQuery(str);            
            while(rs.next()) 
            {
                 this.setNoReg(rs.getString(1));
                 this.setUserName(rs.getString(2));
                 this.setPassword(rs.getString(3));
                 this.setPosition(rs.getString(4));
                                  
                 data.add(this.getNoReg());
                 data.add(this.getUserName());
                 data.add(this.getPassword());
                 data.add(this.getPosition());
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
            
            String str = "INSERT INTO Account(ID_Account, UserName, Password, Position) VALUES(?,?,?,?)";
            PreparedStatement pr =con.prepareStatement(str);

            pr.setString(1,NoReg.trim());
            pr.setString(2,UserName.trim());
            pr.setString(3,Password.trim());
            pr.setString(4,Position.trim());
            
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Add Data Account");
        return i;
    }
    
    public ArrayList getRecord() 
    {
        ArrayList data = new ArrayList();
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "SELECT * FROM Account WHERE ID_Account = ?";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1,NoReg);
            ResultSet rs = pr.executeQuery();            
            while(rs.next()) 
            {
                 this.setNoReg(rs.getString(1));
                 this.setUserName(rs.getString(2));
                 this.setPassword(rs.getString(3));
                 this.setPosition(rs.getString(4));
                                  
                 data.add(this.getNoReg());
                 data.add(this.getUserName());
                 data.add(this.getPassword());
                 data.add(this.getPosition());
            }
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Search Data Account By No Reg");
        return data;
    }
    
    public int doUpdate() 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "UPDATE Account SET UserName =  ?, Password = ?, Position = ? WHERE ID_Account = ?";
            PreparedStatement pr = con.prepareStatement(str);
            
            pr.setString(1,UserName.trim());
            pr.setString(2,Password.trim());
            pr.setString(3,Position.trim());
            pr.setString(4,NoReg.trim());
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            System.out.println(ex.getMessage());
        }
        System.out.println("User Update Data Account");
        return i;
    }
    
    public int doDelete() 
    {
        int i = 0;
        try
        {
            kon.Open();
            Connection con = kon.Open();
            String str = "DELETE Account WHERE ID_Account = ? and Position = 'Student'";
            PreparedStatement pr = con.prepareStatement(str);
            pr.setString(1,NoReg);
            i = pr.executeUpdate();
        }
        catch(SQLException ex)
        {
            JOptionPane.showMessageDialog(null, "Sorry, Admin Can Not Deleted");
        }
        System.out.println("User Delete Data Account");
        return i;
    }
    
    public String[] searchDataAccount() throws RemoteException
    {
        try 
        {
            Connection c = kon.Open();
            String sq = "select ID_Account, UserName, Password, Position from Account where (ID_Account = ? OR UserName = ?)";
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, NoReg);
            ps.setString(2, UserName);
            
            ResultSet r = ps.executeQuery();
            String[] data = new String[4];
            if(r.next())
            {
                data[0]= r.getString("ID_Account");
                data[1]= r.getString("UserName");
                data[2]= r.getString("Password");
                data[3]= r.getString("Position");
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
        System.out.println("User Search Data Account By No Reg Or Username");
        return null;
    }
    
//    public void validatelelete(String Position)
//    {
//        int i = 0;
//        try
//        {
//            Koneksi kon = new Koneksi();
//            Connection con = kon.Open();
//            String str = "SELECT COUNT (*) FROM Account WHERE NoReg = ? AND Username = ? AND Position = 'Admin'";
//            
//            PreparedStatement pr = con.prepareStatement(str);
//
//            pr.setString(1, Username.trim());
//            pr.setString(2, NoReg.trim());
//            ResultSet rs = pr.executeQuery();
//            if (rs.next())
//            {
//                JOptionPane.showMessageDialog(null, "Sorry, Data Admin Can not to delete !");   
//                i = rs.getInt(1);
//            }
//            else
//            {
//                
//            }
//        }
//        catch(Exception e)
//        {
//            System.out.println(e.getMessage());
//        }
//        return i;
//    }
    
    public int caridataAccount()
    {
        try 
        {
            Connection c = kon.Open();
            String sq = "select count(*) as jumlah from Account where ID_Account = ?";
            //pake prepare statment karena ada parameter
            PreparedStatement ps = c.prepareStatement(sq);
            ps.setString(1, getNoReg());
            
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