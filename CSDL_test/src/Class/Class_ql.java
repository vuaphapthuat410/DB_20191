/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Class;

/**
 *
 * @author vuaphapthuat410
 */
import java.sql.ResultSet;
import java.util.*;
import DB.connect.DBconnect;
import java.sql.SQLException;

public class Class_ql {

    public static void AddCls(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        System.out.println("Enter the subject id: ");
        String SubjId = myObj.nextLine();

        System.out.println("Enter the year (semester): ");
        String ClsYear = myObj.nextLine();

        System.out.println("Enter the semester numer: ");
        String ClsSem= myObj.nextLine();
        
        System.out.println("Enter the teacher id: ");
        String TchId = myObj.nextLine();

        String sqlcmd = "INSERT INTO Lop values (?,?,?,?,?)";
        String[] sqlval = {ClsId, SubjId, ClsYear, ClsSem, TchId};

        bool = db.insertData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");

    }

    public static void UpdateCls(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool = 0;

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        System.out.println("Enter the one you want to change 'NamHoc'(1) or 'HocKy'(2) or 'MaGV'(3): ");
        int ClsField = Integer.parseInt(myObj.nextLine());

        System.out.println("Enter the value you want to change:  ");
        String ClsVal = myObj.nextLine();
        
        if (ClsField == 1) {
            String sqlcmd = "UPDATE Lop SET NamHoc = ? WHERE MaLop = '" + ClsId +"'";
            String[] sqlval = {ClsVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (ClsField == 2) {
            String sqlcmd = "UPDATE Lop SET HocKy = ? WHERE MaLop = '" + ClsId +"'";
            String[] sqlval = {ClsVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (ClsField == 3) {
            String sqlcmd = "UPDATE Lop SET MaGV = ? WHERE MaLop = '" + ClsId +"'";
            String[] sqlval = {ClsVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        
        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing changed");
    }

    public static void PrintCls(DBconnect db) {
        try{
            String sqlcmd = "SELECT * FROM Lop";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ClsId = rs.getString("MaLop");
                  String SubjId = rs.getString("MaMH");
                  String ClsYear = rs.getString("NamHoc");
                  String ClsSem = rs.getString("HocKy");
                  String TchId = rs.getString("MaGV");
                  System.out.println(ClsId+"\t"+SubjId+"\t"+ClsYear+"\t"+ClsSem+"\t"+TchId);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }
    
    public static void SearchCls(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        
        try{
            System.out.println("Search by Class's ID. Please enter the id: ");
            String ClsId = myObj.nextLine();
            
            String sqlcmd = "SELECT * FROM Lop WHERE MaLop = '" + ClsId + "'";
            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String SubjId = rs.getString("MaMH");
                  String ClsYear = rs.getString("NamHoc");
                  String ClsSem = rs.getString("HocKy");
                  String TchId = rs.getString("MaGV");
                  System.out.println(ClsId+"\t"+SubjId+"\t"+ClsYear+"\t"+ClsSem+"\t"+TchId);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }

    public static void AddStuCls(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        System.out.println("Enter the student's mark: ");
        String StuMark = myObj.nextLine();

        String sqlcmd = "INSERT INTO SinhVienLop values (?,?,?)";
        String[] sqlval = {StuId, ClsId, StuMark};

        bool = db.insertData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");
    }
    
    public static void DelStuCls(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the student id: ");
        String StuId = myObj.nextLine();

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        String sqlcmd = "DELETE FROM SinhVienLop WHERE MaSV = ? AND MaLop = ?";
        String[] sqlval = {StuId, ClsId};

        bool = db.deleteData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");
    }
    
    public static void DelCls(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the class id: ");
        String ClsId = myObj.nextLine();

        String sqlcmd = "DELETE FROM Lop WHERE MaLop = ?";
        String[] sqlval = {ClsId};

        bool = db.deleteData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");
    }
    
    public static void main(String[] args) {
        int choiceCls;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: Add Class.");
            System.out.println("2: Update Class.");
            System.out.println("3. Add Student into Class.");
            System.out.println("4: Delete Student from Class.");
            System.out.println("5: Delete Class.");
            System.out.println("6. Print Class.");
            System.out.println("Press any other number to exit");
            choiceCls = myObj.nextInt();

            switch (choiceCls) {
                case 1:
                    AddCls(db);
                    break;
                case 2:
                    UpdateCls(db);
                    break;
                case 3:
                    AddStuCls(db);
                    break;
                case 4:
                    DelStuCls(db);
                    break;
                case 5:
                    DelCls(db);
                    break;
                case 6:
                    PrintCls(db);
                    break;
            }
        } while (choiceCls == 1 || choiceCls == 2 || choiceCls == 3 || choiceCls == 4 || choiceCls == 5 || choiceCls == 6);
    }
}
