//**************************************************************************************************
// CLASS: Main (Main.java)
//
// DESCRIPTION
// The Main class for Project 2.
//
// COURSE AND PROJECT INFO
// CSE205 Object Oriented Programming and Data Structures, Spring B 2019
// Project Number: 2
//
// AUTHOR: Vincent Hoang, vnhoang, vnhoang@asu.edu
//**************************************************************************************************

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    /**
     * main()
     * <p>
     * Instantiate a Main object and call run() on the object. Note that essentially now,
     * run() becomes the starting point of execution for the program.
     */
    public static void main(String[] args) {
        new Main().run();
    }

    /**
     * run()
     * <p>
     * Calls other methods to implement the sw requirements.
     * <p>
     * PSEUDOCODE
     * Declare ArrayList<Student> object named studentList and initialize it to null
     * <p>
     * -- In the try-catch block we try to read the list of students from p02-students.txt
     * -- storing the students in the studentList list. If we cannot open the input file for
     * -- reading, then we output an error message and terminate the program.
     * try
     * studentList = readFile()
     * catch (FileNotFoundException)
     * Print "Sorry, could not open 'p02-students.txt' for reading. Stopping."
     * Call System.exit(-1)
     * end try-catch
     * <p>
     * -- Calculate the tuition for each Student in studentList
     * calcTuition(studentList)
     * <p>
     * -- Sort the students in studentList into ascending order based on student identifier
     * -- Note that Sorter.insertionSort() is a static/class method so we do not have to instantiate
     * -- an object of the Sorter class, we just write class-name.static-method-name() to call a
     * -- static method in a class.
     * Call Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING) to sort the list
     * <p>
     * -- In the try-catch block we try to write the list of students and their calculated tuitions
     * -- to p02-tuition.txt If we cannot open the output file for writing, then we output an error
     * -- message and terminate the program.
     * try
     * writeFile(studentList)
     * catch (FileNotFoundException)
     * Print "Sorry, could not open 'p02-tuition.txt' for writing. Stopping."
     * Call System.exit(-1)
     * end try-catch
     */
    private void run() {
        ArrayList<Student> studentList = new ArrayList<>();

        try {
            studentList = readFile();
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, could not open \'p02-students.txt\' for reading. Stopping.");
            System.exit(-1);
        }

        calcTuition(studentList);

        Sorter.insertionSort(studentList, Sorter.SORT_ASCENDING);

        try {
            writeFile(studentList);
        } catch (FileNotFoundException e) {
            System.out.println("Sorry, could not open \'p02-tuition.txt\' for writing. Stopping.");
            System.exit(-1);
        }
    }

    /**
     * calcTuition()
     * <p>
     * Calculates the tuition for each Student in pStudentList. Write an enhanced for loop that
     * iterates over each Student in pStudentList. For each Student, call calcTuition() on that
     * Student object. Note: this is a polymorphic method call. What does that mean?
     * <p>
     * PSEUDOCODE
     * Enhanced ForEach student in pStudentList Do
     * student.calcTuition()
     * End Enhanced ForEach
     */
    private void calcTuition(ArrayList<Student> pStudentList) {
        for (Student s : pStudentList) {
            s.calcTuition();
        }
    }

    /**
     * readFile()
     * <p>
     * Reads the student information from "p02-students.txt" and returns the list of students as
     * an ArrayList<Student> object. Note that this method throws FileNotFoundException if the
     * input file could not be opened. The exception is caught and handled in run().
     * <p>
     * PSEUDOCODE
     * Declare and create an ArrayList<Student> object named studentList
     * Open "p02-students.txt" for reading using a Scanner object named in
     * While in.hasNext() returns true Do
     * String studentType <= read next string from in
     * If studentType is "C" Then
     * studentList.add(readOnCampusStudent(in))
     * Else
     * studentList.add(readOnlineStudent(in))
     * End If
     * End While
     * Close the scanner
     * Return studentList
     */
    private ArrayList<Student> readFile() throws FileNotFoundException {
        ArrayList<Student> studentList = new ArrayList<>();

        Scanner in = new Scanner(new File("p02-students.txt"));

        while (in.hasNext()) {
            String studentType = in.next();

            if (studentType.equals("C")) {
                studentList.add(readOnCampusStudent(in));
            } else {
                studentList.add(readOnlineStudent(in));
            }
        }

        in.close();

        return studentList;
    }

    /**
     * readOnCampusStudent()
     * <p>
     * Reads the information for an on-campus student from the input file.
     * <p>
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnCampusStudent object. Pass id, fname, and lname as params to ctor.
     * Declare String object named res and assign pIn.next() to res
     * Declare double variable named fee and assign pIn.nextDouble() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If res.equals("R") Then
     * Call setResidency(OnCampusStudent.RESIDENT) on student
     * Else
     * Call setResidency(OnCampusStudent.NON_RESIDENT) on student
     * End If
     * Call setProgramFee(fee) on student
     * Call setCredits(credits) on student
     * Return student
     */
    private OnCampusStudent readOnCampusStudent(Scanner pIn) {
        String id = pIn.next();
        String lastName = pIn.next();
        String firstName = pIn.next();

        OnCampusStudent student = new OnCampusStudent(id, firstName, lastName);

        String res = pIn.next();
        double fee = pIn.nextDouble();
        int credits = pIn.nextInt();

        if (res.equals("R")) {
            student.setResidency(OnCampusStudent.RESIDENT);
        } else {
            student.setResidency(OnCampusStudent.NON_RESIDENT);
        }

        student.setProgramFee(fee);
        student.setCredits(credits);

        return student;
    }

    /**
     * readOnlineStudent()
     * <p>
     * Reads the information for an online student from the input file.
     * <p>
     * PSEUDOCODE
     * Declare String object id and assign pIn.next() to id
     * Declare String object named lname and assign pIn.next() to lname
     * Declare String object named fname and assign pIn.next() to fname
     * Declare and create an OnlineStudent student. Pass id, fname, lname as params to the ctor.,
     * Declare String object named fee and assign pIn.next() to fee
     * Declare int variable named credits and assign pIn.nextInt() to credits
     * If fee.equals("T")) Then
     * Call setTechFee(true) on student
     * Else
     * Call setTechFee(false) on student
     * End If
     * Call setCredits(credits) on student
     * Return student
     */
    private OnlineStudent readOnlineStudent(Scanner pIn) {
        String id = pIn.next();
        String lastName = pIn.next();
        String firstName = pIn.next();

        OnlineStudent student = new OnlineStudent(id, firstName, lastName);

        String fee = pIn.next();
        int credits = pIn.nextInt();

        if (fee.equals("T")) {
            student.setTechFee(true);
        } else {
            student.setTechFee(false);
        }

        student.setCredits(credits);

        return student;
    }

    /**
     * writeFile()
     * <p>
     * Writes the output to "p02-tuition.txt" per the software requirements. Note that this method
     * throws FileNotFoundException if the output file could not be opened. The exception is caught
     * and handled in run().
     * <p>
     * PSEUDOCODE
     * Declare and create a PrintWriter object named out, opening "p02-tuition.txt" for writing
     * Enhanced ForEach student in pStudentList Do
     * Using out.printf() output the student information per SW Requiremment 3
     * End Enhanced ForEach
     * Close the output file
     */
    private void writeFile(ArrayList<Student> pStudentList) throws FileNotFoundException {
        PrintWriter out = new PrintWriter("p02-tuition.txt");

        // %[argument_index$][flags][width]conversion
        // id left-just width 16
        // last-name left-just width 20
        // first-name left-just width 15
        // tuition right-just width 8 precision 2
        for (Student s : pStudentList) {
            out.printf("%-15s %-19s %-14s %8.2f", s.getId(), s.getLastName(), s.getFirstName(), s.getTuition());
            out.print("\n");
            out.flush();
        }

        out.close();
    }
}
