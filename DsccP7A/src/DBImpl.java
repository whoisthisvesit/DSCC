/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author NARENDER KESWANI
 */
import java.rmi.*;
import java.rmi.server.*;
import java.sql.*;

public class DBImpl extends UnicastRemoteObject implements IDB {

    String str, str1;

    public DBImpl() throws RemoteException {
    }

    public String getData() {
        String URL = "jdbc:mysql://localhost:3308/p6";
        String UName = "root";
        String Pass = "Narend-10";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, UName, Pass);
            Statement s = con.createStatement();
            ResultSet rs = s.executeQuery("select * from books");
            ResultSetMetaData rsmd = rs.getMetaData();
            str = "";
            str1 = "";
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                str1 = str1 + rsmd.getColumnName(i) + "\t";
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    str = str + rs.getString(i) + "\t";
                }
                str = str + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (str1 + "\n" + str);
    }

    @Override
    public String getData(int id) throws RemoteException {
                String URL = "jdbc:mysql://localhost:3308/p6";
        String UName = "root";
        String Pass = "Narend-10";
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(URL, UName, Pass);            
            PreparedStatement ps = con.prepareStatement("select * from books where books_id=?");
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            ResultSetMetaData rsmd = rs.getMetaData();
            str = "";
            str1 = "";
            for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                str1 = str1 + rsmd.getColumnName(i) + "\t";
            }
            System.out.println();
            while (rs.next()) {
                for (int i = 1; i <= rsmd.getColumnCount(); i++) {
                    str = str + rs.getString(i) + "\t";
                }
                str = str + "\n";
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return (str1 + "\n" + str);
    }
}
