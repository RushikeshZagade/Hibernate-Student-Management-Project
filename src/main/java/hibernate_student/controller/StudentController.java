package hibernate_student.controller;

import java.util.Scanner;

import hibernate_student.dao.StudentDao;
import hibernate_student.dto.Student;

public class StudentController {

	public static void main(String[] args) {
		Student student = new Student();
		StudentDao dao = new StudentDao();

		Scanner scanner = new Scanner(System.in);
		System.out.println(
				"1.Add Student \n2.Delete Student \n3.Fetch All Student \n4.Fetch By Id \n5.Update Student \n6.Fetch By Phone \n7.Fetch By Email \n8.Fetch By Address");

		System.out.println("Enter your choice :");
		switch (scanner.nextInt()) {
		case 1: {
			System.out.println("Enter The Id :");
			student.setId(scanner.nextInt());
			System.out.println("Enter the Name :");
			student.setName(scanner.next());
			System.out.println("Ente the Phone :");
			student.setPhone(scanner.nextLong());
			System.out.println("Enter the Father Name :");
			student.setFatherName(scanner.next());
			System.out.println("Enter the Mother Name :");
			student.setMotherName(scanner.next());
			System.out.println("Enter the Email  :");
			student.setEmail(scanner.next());
			System.out.println("Enter the  Address :");
			student.setAddress(scanner.next());
			System.out.println("Enter the Mock Rating :");
			student.setMock_rating(scanner.nextDouble());

			dao.saveStudent(student);
			break;
		}
		case 2: {
			System.out.println("Enter the Id : ");
			int id = scanner.nextInt();
			dao.deleteStudent(id);

			break;
		}
		case 3: {
			dao.fetchAllStudent();

			break;
		}
		case 4: {
			System.out.println("Enter the Id You Want To Fetch :");
			int id = scanner.nextInt();

			dao.findById(id);
			break;
		}
		case 5: {
			System.out.println("Enter The Id You Want To Update : ");
			int id = scanner.nextInt();
			System.out.println("Enter the Name :");
			student.setName(scanner.next());
			System.out.println("Ente the Phone :");
			student.setPhone(scanner.nextLong());
			System.out.println("Enter the Father Name :");
			student.setFatherName(scanner.next());
			System.out.println("Enter the Mother Name :");
			student.setMotherName(scanner.next());
			System.out.println("Enter the Email  :");
			student.setEmail(scanner.next());
			System.out.println("Enter the  Address :");
			student.setAddress(scanner.next());
			System.out.println("Enter the Mock Rating :");
			student.setMock_rating(scanner.nextDouble());
			dao.updateStudent(id, student);
			break;
		}
		case 6: {
			System.out.println("Enter the Phone No. Yor Want To Fetch :");
			long phone = scanner.nextLong();
			dao.findByPhone(phone);

			break;
		}
		case 7: {
			System.out.println("Enter the Email You Want To Fetch :");
			String email = scanner.next();
			dao.fetchByEmail(email);

			break;
		}
		case 8: {
			System.out.println("Enter the Address You Want To Fetch :");
			String address = scanner.next();
			dao.fetchByAddress(address);

			break;
		}

		default:
			break;
		}
	}
}
