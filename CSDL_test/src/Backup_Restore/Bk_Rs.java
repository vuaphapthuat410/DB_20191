/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Backup_Restore;

import java.util.*;
import DB.connect.DBconnect;
import java.io.IOException;
/**
 *
 * @author vuaphapthuat410
 */
public class Bk_Rs {
    
    public static void backup(DBconnect db){
        String[] BkCmd = new String[] {"/bin/sh","-c","docker exec database_test /usr/bin/mysqldump -u vuaphapthuat410 --password=manhto99 CourseDB > db_CourseDB.sql"};
        try{
            Process BK = new ProcessBuilder(BkCmd).start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void restore(DBconnect db){
        String[] RsCmd = {"/bin/sh","-c","cat db_CourseDB.sql | docker exec -i database_test /usr/bin/mysql -u vuaphapthuat410 --password=manhto99 CourseDB"};
        try{
            Process RS = Runtime.getRuntime().exec(RsCmd);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static void main(String[] args) {
        int choice;
        DBconnect db = new DBconnect();
        boolean bool = db.initialize("vuaphapthuat410", "manhto99");

        Scanner myObj = new Scanner(System.in);

        do {
            System.out.println("Enter the choice: ");
            System.out.println("1: Backup database.");
            System.out.println("2: Restore database.");
            System.out.println("Press any other number to exit");
            choice = myObj.nextInt();

            switch (choice) {
                case 1:
                    backup(db);
                    break;
                case 2:
                    restore(db);
                    break;
            }
        } while (choice == 1 || choice == 2);
    }
}


