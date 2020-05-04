/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Mark;

/**
 *
 * @author vuaphapthuat410
 */
import java.sql.ResultSet;
import java.util.*;
import DB.connect.DBconnect;
import java.sql.SQLException;

public class Mark {

    public static void AddMark(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        System.out.println("Enter the student's mark: ");
        String StuMark = myObj.nextLine();

        String sqlcmd = "INSERT INTO SinhVienLop VALUES (?,?,?)" ;
        String[] sqlval = {StuId, ClsId, StuMark};

        bool = db.insertData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");
    }
    
    public static void UpMark(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        System.out.println("Enter the student's mark: ");
        String StuMark = myObj.nextLine();

        String sqlcmd = "UPDATE SinhVienLop SET Diem = ? WHERE MaSV = '" + StuId +"' AND MaLop ='" + ClsId + "'" ;
        String[] sqlval = {StuMark};

        bool = db.updateData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");
    }
    
    public static void PrintMarkCls(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        
        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();
        
        try{
            String sqlcmd = "SELECT * FROM SinhVienLop WHERE MaLop = '" + ClsId + "'";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String StuId = rs.getString("MaSV");
                  String StuClsMark = rs.getString("Diem");
                  System.out.println(StuId+"\t"+ClsId+"\t"+StuClsMark);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }
    
    public static void PrintMarkStu(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        
        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();
        
        try{
            String sqlcmd = "SELECT * FROM SinhVienLop WHERE MaSV = '" + StuId + "'";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ClsId = rs.getString("MaLop");
                  String StuClsMark = rs.getString("Diem");
                  System.out.println(StuId+"\t"+ClsId+"\t"+StuClsMark);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }
    
    public static void main(String[] args) {
        int choiceMark;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: Add Mark.");
            System.out.println("2: Update Mark.");
            System.out.println("3. Print Mark in a class.");
            System.out.println("4: Print Mark of a student.");
            System.out.println("Press any other number to exit");
            choiceMark = myObj.nextInt();

            switch (choiceMark) {
                case 1:
                    AddMark(db);
                    break;
                case 2:
                    UpMark(db);
                    break;
                case 3:
                    PrintMarkCls(db);
                    break;
                case 4:
                    PrintMarkStu(db);
                    break;
            }
        } while (choiceMark == 1 || choiceMark == 2 || choiceMark == 3 || choiceMark == 4);
    }
}
