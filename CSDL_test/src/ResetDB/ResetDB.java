/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ResetDB;

/**
 *
 * 
 * @author vuaphapthuat410
 */
import java.sql.ResultSet;
import java.util.*;
import DB.connect.DBconnect;
import java.sql.SQLException;
import java.io.IOException;

public class ResetDB {
    public static void main(String[] args)
    {
        DBconnect db = new DBconnect();
        boolean boolDB = db.initialize("vuaphapthuat410", "manhto99");
        int bool;
        
        String sqlcmd1 = "DELETE FROM SinhVienLop";
        String sqlcmd2 = "DELETE FROM Lop";
        String sqlcmd3 = "DELETE FROM SinhVien";
        String sqlcmd4 = "DELETE FROM GiaoVien";
        String sqlcmd5 = "DELETE FROM MonHoc";
        String[] sqlval = {};
        
        bool = db.deleteData(sqlcmd1, sqlval);
        bool = db.deleteData(sqlcmd2, sqlval);
        bool = db.deleteData(sqlcmd3, sqlval);
        bool = db.deleteData(sqlcmd4, sqlval);
        bool = db.deleteData(sqlcmd5, sqlval); 
        
        System.out.println("Success");
    }
}
