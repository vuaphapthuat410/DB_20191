/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Subject;

/**
 *
 * @author vuaphapthuat410
 */
import java.sql.ResultSet;
import java.util.*;
import DB.connect.DBconnect;
import java.sql.SQLException;

public class Subject {

    public static void AddSubj(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool;

        System.out.println("Enter the subject id: ");
        String SubjId = myObj.nextLine();

        System.out.println("Enter the subject name: ");
        String SubjName = myObj.nextLine();

        System.out.println("Enter the number of course in this subject: ");
        String SubjNumber = myObj.nextLine();

        String sqlcmd = "INSERT INTO MonHoc values (?,?,?)";
        String[] sqlval = {SubjId, SubjName, SubjNumber};

        bool = db.insertData(sqlcmd, sqlval);

        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing is inserted");

    }

    public static void UpdateSubj(DBconnect db) {
        Scanner myObj = new Scanner(System.in);
        int bool = 0;

        System.out.println("Enter the subject id: ");
        String SubjId = myObj.nextLine();

        System.out.println("Enter the one you want to change 'TenMH'(1) or 'SoTC'(2): ");
        int SubjField = Integer.parseInt(myObj.nextLine());

        System.out.println("Enter the value you want to change:  ");
        String SubjVal = myObj.nextLine();
        
        if (SubjField == 1) {
            String sqlcmd = "UPDATE MonHoc SET TenMH = ? WHERE MaMH = '" + SubjId +"'";
            String[] sqlval = {SubjVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        else if (SubjField == 2) {
            String sqlcmd = "UPDATE MonHoc SET SoTC = ? WHERE MaMH = '" + SubjId +"'";
            String[] sqlval = {SubjVal};
            bool = db.updateData(sqlcmd, sqlval);
        }
        
        if (bool == 1) System.out.println("Success");
        else System.out.println("Nothing changed");
    }

    public static void PrintSubj(DBconnect db) {
        try{
            String sqlcmd = "SELECT * FROM MonHoc";

            ResultSet rs = db.retrieveData(sqlcmd);
            while(rs.next()) {
                  String ID = rs.getString("MaMH");
                  String Name = rs.getString("TenMH");
                  String Number = rs.getString("SoTC");
                  System.out.println(ID+"\t"+Name+"\t"+Number);
                  }          
              }catch (SQLException e) {
                  System.out.println(e);
              }
    }

    public static void main(String[] args) {
        int choiceSubj;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: Add Subject.");
            System.out.println("2: Update Subject.");
            System.out.println("3. Print Subject.");
            choiceSubj = myObj.nextInt();

            switch (choiceSubj) {
                case 1:
                    AddSubj(db);
                    break;
                case 2:
                    UpdateSubj(db);
                    break;
                case 3:
                    PrintSubj(db);
                    break;
            }
        } while (choiceSubj == 1 || choiceSubj == 2 || choiceSubj == 3);
    }
}
