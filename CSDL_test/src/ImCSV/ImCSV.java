/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ImCSV;

/**
 *
 * @author vuaphapthuat410
 */
import java.util.*;
import DB.connect.DBconnect;
import java.io.IOException;

public class ImCSV {
    public static void ImMH(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool1,bool2,bool3;

        System.out.println("Enter the file path: ");
        String file = myObj.nextLine();
        
        String setFKNull = "SET FOREIGN_KEY_CHECKS = 0";
        String setFKNNull = "SET FOREIGN_KEY_CHECKS = 1";
        String sqlcmd = "LOAD DATA INFILE '" + file + "' REPLACE INTO TABLE MonHoc FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String[] values = {};
        
        bool1 = db.executeUpdate(setFKNull, values);
        bool2 = db.insertData(sqlcmd, values);
        bool3 = db.executeUpdate(setFKNNull, values);
        
        System.out.println("Success");
    }
    
    public static void ImGV(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool1,bool2,bool3;

        System.out.println("Enter the file path: ");
        String file = myObj.nextLine();
        
        String setFKNull = "SET FOREIGN_KEY_CHECKS = 0";
        String setFKNNull = "SET FOREIGN_KEY_CHECKS = 1";
        String sqlcmd = "LOAD DATA INFILE '" + file + "' REPLACE INTO TABLE GiaoVien FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String[] values = {};
        
        bool1 = db.executeUpdate(setFKNull, values);
        bool2 = db.insertData(sqlcmd, values);
        bool3 = db.executeUpdate(setFKNNull, values);
        
        System.out.println("Success");
    }
    
    public static void ImSV(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool1,bool2,bool3;

        System.out.println("Enter the file path: ");
        String file = myObj.nextLine();
        
        String setFKNull = "SET FOREIGN_KEY_CHECKS = 0";
        String setFKNNull = "SET FOREIGN_KEY_CHECKS = 1";
        String sqlcmd = "LOAD DATA INFILE '" + file + "' REPLACE INTO TABLE SinhVien FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String[] values = {};
        
        bool1 = db.executeUpdate(setFKNull, values);
        bool2 = db.insertData(sqlcmd, values);
        bool3 = db.executeUpdate(setFKNNull, values);
        
        System.out.println("Success");
    }
    
    public static void ImLop(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool1,bool2,bool3;

        System.out.println("Enter the file path: ");
        String file = myObj.nextLine();
        
        String setFKNull = "SET FOREIGN_KEY_CHECKS = 0";
        String setFKNNull = "SET FOREIGN_KEY_CHECKS = 1";
        String sqlcmd = "LOAD DATA INFILE '" + file + "' REPLACE INTO TABLE Lop FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String[] values = {};
        
        bool1 = db.executeUpdate(setFKNull, values);
        bool2 = db.insertData(sqlcmd, values);
        bool3 = db.executeUpdate(setFKNNull, values);
        
        System.out.println("Success");
    }
    
    public static void ImSVLop(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool1,bool2,bool3;

        System.out.println("Enter the file path: ");
        String file = myObj.nextLine();
        
        String setFKNull = "SET FOREIGN_KEY_CHECKS = 0";
        String setFKNNull = "SET FOREIGN_KEY_CHECKS = 1";
        String sqlcmd = "LOAD DATA INFILE '" + file + "' REPLACE INTO TABLE SinhVienLop FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String[] values = {};
        
        bool1 = db.executeUpdate(setFKNull, values);
        bool2 = db.insertData(sqlcmd, values);
        bool3 = db.executeUpdate(setFKNNull, values);
        
        System.out.println("Success");
    }
    
    public static void ImAll(DBconnect db){
        Scanner myObj = new Scanner(System.in);
        int bool1,bool2,bool3,bool4,bool5,bool6,bool7,tmp;

        System.out.println("Enter the folder path: ");
        String file = myObj.nextLine();
        
        String setFKNull = "SET FOREIGN_KEY_CHECKS = 0";
        String setFKNNull = "SET FOREIGN_KEY_CHECKS = 1";
        String sqlcmd1 = "LOAD DATA INFILE '" + file + "/MonHoc.csv' REPLACE INTO TABLE MonHoc FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String sqlcmd2 = "LOAD DATA  INFILE '" + file + "/GiaoVien.csv' REPLACE INTO TABLE GiaoVien FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String sqlcmd3 = "LOAD DATA INFILE '" + file + "/SinhVien.csv' REPLACE INTO TABLE SinhVien FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String sqlcmd4 = "LOAD DATA INFILE '" + file + "/Lop.csv' REPLACE INTO TABLE Lop FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String sqlcmd5 = "LOAD DATA INFILE '" + file + "/SinhVienLop.csv' REPLACE INTO TABLE SinhVienLop FIELDS TERMINATED BY ',' ENCLOSED BY '\"' LINES TERMINATED BY '\\n'";
        String[] values = {};
        
        bool1 = db.executeUpdate(setFKNull, values);
        
        bool2 = db.insertData(sqlcmd1, values);
        //bool3 = db.insertData(sqlcmd2, values);
        bool4 = db.insertData(sqlcmd3, values);
        bool5 = db.insertData(sqlcmd4, values);
        bool6 = db.insertData(sqlcmd5, values);
        
        bool7 = db.executeUpdate(setFKNNull, values);
        
        System.out.println("Success");
    }
    
    public static void main(String[] args) {
        int choice;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: MonHoc.csv");
            System.out.println("2: GiaoVien.csv.");
            System.out.println("3: SinhVien.csv.");
            System.out.println("4: Lop.csv.");
            System.out.println("5: SinhVienLop.csv.");
            System.out.println("6: Tat ca.");
            System.out.println("Press any other number to exit");
            choice = myObj.nextInt();

            switch (choice) {
                case 1:
                    ImMH(db);
                    break;
                case 2:
                    ImGV(db);
                    break;
                case 3:
                    ImSV(db);
                    break;
                case 4:
                    ImLop(db);
                    break;
                case 5:
                    ImSVLop(db);
                    break;
                case 6:
                    ImAll(db);
                    break;
            }
        } while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6);
    }
}
