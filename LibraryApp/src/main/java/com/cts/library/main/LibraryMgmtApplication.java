package com.cts.library.main;

import java.time.LocalDate;
import java.util.Scanner;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.library.exception.InvalidBookNameException;
import com.cts.library.exception.InvalidStudentIdException;
import com.cts.library.service.LibraryService;
import com.cts.library.skeletonvalidator.SkeletonValidator;

public class LibraryMgmtApplication {

	public static void main(String[] args) {
		// SpringApplication.run(LibraryAppApplication.class, args);
		String choice = "yes";
		SkeletonValidator validator = new SkeletonValidator();
		ApplicationContext ctx = new ClassPathXmlApplicationContext("beans.xml");
		LibraryService libService = (LibraryService) ctx.getBean("libService");
		do {
			System.out.println("Choose the option:- 1 . Issue Book   2. Return  Book");
			Scanner sc = new Scanner(System.in);
			int ch = sc.nextInt();
			if (ch == 1) {
				System.out.println("Enter Student id");
				int stid = sc.nextInt();
				try {
					if (libService.validateStudentId(stid)) {
						sc.nextLine();
						System.out.println("Enter Book Name");
						String bookname = sc.nextLine();
						if (libService.validateBookName(bookname))
							System.out.println(libService.issueBook(stid, bookname));

					}
				} catch (InvalidStudentIdException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (InvalidBookNameException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}
			} else if (ch == 2) {
				System.out.println("Enter Student id");
				int stid = sc.nextInt();
				sc.nextLine();
				try {
					if (libService.validateStudentId(stid)) {

						System.out.println("Enter Book Name");
						String bookname = sc.nextLine();
						if (libService.validateBookName(bookname)) {
							System.out.println("Enter Issue Date(yyyy-MM-dd)");
							String idate = sc.next();
							LocalDate issueDate = LocalDate.parse(idate);
							System.out.println("Enter Return Date(yyyy-MM-dd)");
							String rdate = sc.next();
							LocalDate returnDate = LocalDate.parse(rdate);
							System.out.println(libService.returnBook(stid, bookname, issueDate, returnDate));
						}
					}
				} catch (InvalidStudentIdException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				} catch (InvalidBookNameException e) {
					// TODO Auto-generated catch block
					System.out.println(e.getMessage());
				}

			} else {
				System.out.println("Invalid Choice");
			}
			System.out.println("Would you like to continue?yes/no");
			choice = sc.next();

		} while (choice.equalsIgnoreCase("yes"));

	}
}
