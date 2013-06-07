package cn.sqat.util;
 
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

 
public class ConnectionManager
{
    static Connection conn;
 
    public static Connection getConnection()
    {
        try
        {

            Class.forName(Provider.DRIVER);
            try
            {
                conn = DriverManager.getConnection(Provider.CONNECTION_URL,
                		Provider.USERNAME,Provider.PASSWORD);
            }
            catch (SQLException ex)
            {
                ex.printStackTrace();
            }
        }
        catch(ClassNotFoundException e)
        {
            System.out.println(e);
        }
        return conn;
    }
 
}