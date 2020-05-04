/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Teacher;

/**
 *
 * @author vuaphapthuat410
 */
import java.sql.ResultSet;
import java.util.*;
import DB.connect.DBconnect;
import java.sql.SQLException;

public class Teacher {

    public static void AddTch(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the teacher id: ");
        String TchId = myObj.nextLine();

        System.out.println("Enter the teacher first name: ");
        String TchFName = myObj.nextLine();

        System.out.println("Enter the teacher rest name: ");
        String TchRName = myObj.nextLine();

        System.out.println("Enter the place where he/she works: ");
        String TchPlace = myObj.nextLine();

        String sqlcmd = "INSERT INTO GiaoVien values (?,?,?,?)";
        String[] sqlval = {TchId, TchFName, TchRName, TchPlace};

        bool = db.insertData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");

    }

    public static void UpdateTch(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool = 0;

        System.out.println("Enter the techer id: ");
        String TchId = myObj.nextLine();

        System.out.println("Enter the one you want to change 'HoGV'(1) or 'TenGv'(2) or 'DonVi'(3): ");
        int TchField = Integer.parseInt(myObj.nextLine());

        System.out.println("Enter the value you want to change:  ");
        String TchVal = myObj.nextLine();
        
        if (TchField == 1) {
            String sqlcmd = "UPDATE GiaoVien SET HoGV = ? WHERE MaGV = '" + TchId +"'";
            String[] sqlval = {TchVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (TchField == 2) {
            String sqlcmd = "UPDATE GiaoVien SET TenGV = ? WHERE MaGV = '" + TchId +"'";
            String[] sqlval = {TchVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (TchField == 3) {
            String sqlcmd = "UPDATE GiaoVien SET DonVi = ? WHERE MaGV = '" + TchId +"'";
            String[] sqlval = {TchVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        
        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing changed");
    }

    public static void PrintTch(DBconnect db) {
        try{
            String sqlcmd = "SELECT * FROM GiaoVien";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ID = rs.getString("MaGV");
                  String FName = rs.getString("HoGV");
                  String RName = rs.getString("TenGV");
                  String Place = rs.getString("DonVi");
                  System.out.println(ID+"\t"+FName+" "+RName+"\t"+Place);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }
    
    public static void SearchTch(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        
        try{
            System.out.println("Search by Teacher's ID. Please enter the id: ");
            String TchId = myObj.nextLine();
            
            String sqlcmd = "SELECT * FROM GiaoVien WHERE MaGV = '" + TchId + "'";
            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ID = rs.getString("MaGV");
                  String FName = rs.getString("HoGV");
                  String RName = rs.getString("TenGV");
                  String Place = rs.getString("DonVi");
                  System.out.println(ID+"\t"+FName+" "+RName+"\t"+Place);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }

    public static void main(String[] args) {
        int choiceTch;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: Add Teacher.");
            System.out.println("2: Update Teacher.");
            System.out.println("3. Print Teacher.");
            System.out.println("4. Search Teacher.");
            choiceTch = myObj.nextInt();

            switch (choiceTch) {
                case 1:
                    AddTch(db);
                    break;
                case 2:
                    UpdateTch(db);
                    break;
                case 3:
                    PrintTch(db);
                    break;
                case 4:
                    SearchTch(db);
                    break;
            }
        } while (choiceTch == 1 || choiceTch == 2 || choiceTch == 3 || choiceTch == 4);
    }
}
