/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Student;

/**
 *
 * @author vuaphapthuat410
 */
import java.sql.ResultSet;
import java.util.*;
import DB.connect.DBconnect;
import java.sql.SQLException;

public class Student {

    public static void AddStu(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();

        System.out.println("Enter the student first name: ");
        String StuFName = myObj.nextLine();

        System.out.println("Enter the student rest name: ");
        String StuRName = myObj.nextLine();

        System.out.println("Enter the date of birth: ");
        String StuDate= myObj.nextLine();
        
        System.out.println("Enter the place where he/she was born: ");
        String StuPlace = myObj.nextLine();

        String sqlcmd = "INSERT INTO SinhVien values (?,?,?,?,?)";
        String[] sqlval = {StuId, StuFName, StuRName, StuDate, StuPlace};

        bool = db.insertData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");

    }

    public static void UpdateStu(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool = 0;

        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();

        System.out.println("Enter the one you want to change 'HoGV'(1) or 'TenGv'(2) or 'DonVi'(3) or 'NoiSinh'(4): ");
        int StuField = Integer.parseInt(myObj.nextLine());

        System.out.println("Enter the value you want to change:  ");
        String StuVal = myObj.nextLine();
        
        if (StuField == 1) {
            String sqlcmd = "UPDATE SinhVien SET HoSV = ? WHERE MaSV = '" + StuId +"'";
            String[] sqlval = {StuVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (StuField == 2) {
            String sqlcmd = "UPDATE SinhVien SET TenSV = ? WHERE MaSV = '" + StuId +"'";
            String[] sqlval = {StuVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (StuField == 3) {
            String sqlcmd = "UPDATE SinhVien SET NgaySinh = ? WHERE MaSV = '" + StuId +"'";
            String[] sqlval = {StuVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (StuField == 4) {
            String sqlcmd = "UPDATE SinhVien SET NoiSinh = ? WHERE MaSV = '" + StuId +"'";
            String[] sqlval = {StuVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        
        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing changed");
    }

    public static void PrintStu(DBconnect db) {
        try{
            String sqlcmd = "SELECT * FROM SinhVien";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ID = rs.getString("MaSV");
                  String FName = rs.getString("HoSV");
                  String RName = rs.getString("TenSV");
                  String Date = rs.getString("NgaySinh");
                  String Place = rs.getString("NoiSinh");
                  System.out.println(ID+"\t"+FName+" "+RName+"\t"+Date+"\t"+Place);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }
    
    public static void SearchStu(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        
        try{
            System.out.println("Search by Student's ID. Please enter the id: ");
            String StuId = myObj.nextLine();
            
            String sqlcmd = "SELECT * FROM SinhVien WHERE MaSV = '" + StuId + "'";
            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ID = rs.getString("MaSV");
                  String FName = rs.getString("HoSV");
                  String RName = rs.getString("TenSV");
                  String Date = rs.getString("NgaySinh");
                  String Place = rs.getString("NoiSinh");
                  System.out.println(ID+"\t"+FName+" "+RName+"\t"+Date+"\t"+Place);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }

    public static void main(String[] args) {
        int choiceStu;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: Add Student.");
            System.out.println("2: Update Student.");
            System.out.println("3. Search Student.");
            choiceStu = myObj.nextInt();

            switch (choiceStu) {
                case 1:
                    AddStu(db);
                    break;
                case 2:
                    UpdateStu(db);
                    break;
                case 3:
                    SearchStu(db);
                    break;
            }
        } while (choiceStu == 1 || choiceStu == 2 || choiceStu == 3);
    }
}
