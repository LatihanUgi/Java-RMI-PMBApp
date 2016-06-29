/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package config;

import java.sql.Connection;
import java.sql.DriverManager;

public class Koneksi {
    Connection con;
    public Connection Open()
    {
        try
        {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String url = "jdbc:sqlserver://localhost:1433;databaseName=NewStudent";
            con = DriverManager.getConnection(url, "Juwitaa", "123456");
            return con;
        }
        catch(Exception e)
        {
            System.err.println(e);
            return null;
        }
    }
}
