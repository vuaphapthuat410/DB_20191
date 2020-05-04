/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BestMark;

/**
 *
 * @author vuaphapthuat410
 */
import java.util.*;
import DB.connect.DBconnect;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Bestmark {
    public static void main(String[] args) {
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");
        Scanner myObj = new Scanner(System.in);
        
        System.out.println("Enter the year: ");
        String year = myObj.nextLine();
        System.out.println("Enter the semester: ");
        String sem = myObj.nextLine();
        
        try{
            String sqlcmd = "SELECT HoSV,TenSV,(SUM(Diem * SoTC)/SUM(SoTC)) AS DiemTB FROM ((SinhVienLop INNER JOIN Lop ON SinhVienLop.MaLop = Lop.MaLop) \n" +
"INNER JOIN SinhVien ON SinhVienLop.MaSV = SinhVien.MaSV) INNER JOIN MonHoc On Lop.MaMH = MonHoc.MaMH WHERE NamHoc = " + year + " AND HocKy = " + sem + "\n" +
"GROUP BY SinhVien.MaSV ORDER BY DiemTB DESC LIMIT 3";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String HoSV = rs.getString("HoSV");
                  String TenSV = rs.getString("TenSV");
                  String Score = rs.getString("DiemTB");
                  System.out.println(HoSV+" "+TenSV+"\t"+Score);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }       
}
