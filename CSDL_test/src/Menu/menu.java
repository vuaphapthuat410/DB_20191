/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Menu;

/**
 *
 * @author vuaphapthuat410
 */
import Backup_Restore.Bk_Rs;
import java.util.*;
import Subject.Subject;
import Teacher.Teacher;
import Student.Student;
import Class.Class_ql;
import Mark.Mark;
import ResetDB.ResetDB;
import ImCSV.ImCSV;
import BestMark.Bestmark;

public class menu {
    public static void main(String[] args) {
        int choice;
        Scanner myObj = new Scanner(System.in);

        do {
        System.out.println("Enter choice: ");
        System.out.println("1: Subject.");
        System.out.println("2: Teacher.");
        System.out.println("3. Student.");
        System.out.println("4: Class.");
        System.out.println("5: Mark.");
        System.out.println("6: Backup and Restore.");
        System.out.println("7: Factory reset.");
        System.out.println("8: Import from CSV files.");
        System.out.println("9: Find 3 best student based on year and semester.");
        System.out.println("Press any other number to exit");
        choice = myObj.nextInt();
        switch (choice) {
            case 1:
                Subject subj = new Subject();
                subj.main(args);
                break;
            case 2:
                Teacher tch = new Teacher();
                tch.main(args);
                break;
            case 3:
                Student stu = new Student();
                stu.main(args);
                break;
            case 4:
                Class_ql cls = new Class_ql();
                Class_ql.main(args);
                break;
            case 5:
                Mark mark = new Mark();
                mark.main(args);
                break;
            case 6:
                Bk_Rs bk_rs = new Bk_Rs();
                bk_rs.main(args);
                break;
            case 7:
                ResetDB reset = new ResetDB();
                reset.main(args);
                break;
            case 8:
                ImCSV csvfile = new ImCSV();
                csvfile.main(args);
                break;
            case 9:
                Bestmark score = new Bestmark();
                score.main(args);
                break;
                        
        }
        } while (choice == 1 || choice == 2 || choice == 3 || choice == 4 || choice == 5 || choice == 6 || choice == 7 || choice == 8 || choice == 9);
    }
}
