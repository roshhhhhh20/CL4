package grader;
import java.io.FileWriter;
import java.util.Scanner;

public class CreateInputFile {
    public static void main(String[] args) throws Exception {

        try (Scanner sc = new Scanner(System.in)) {
			FileWriter fw = new FileWriter(System.getProperty("user.dir") + "/students.txt");
			System.out.println("Enter number of students:");
			int n = sc.nextInt();

			for (int i = 0; i < n; i++) {
			    System.out.println("Enter name and marks:");
			    String name = sc.next();
			    int marks = sc.nextInt();

			    fw.write(name + " " + marks + "\n");
			}

			fw.close();
		}
        System.out.println("Input file created successfully!");
       
    }
}
