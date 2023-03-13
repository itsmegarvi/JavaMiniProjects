/*

package com.cts.library.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Map;
import java.util.TreeMap;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.cts.library.bo.LibraryBo;
import com.cts.library.exception.InvalidBookNameException;
import com.cts.library.exception.InvalidStudentIdException;
import com.cts.library.model.BookInfo;
import com.cts.library.model.StudentInfo;
import com.cts.library.service.LibraryService;
import java.util.*;
public class LibraryAppTest {

	ApplicationContext context;
	private LibraryBo libBo;
	private LibraryService libService;
	private StudentInfo stInfo;
	private BookInfo bkInfo;
public LibraryAppTest(){}
	@BeforeEach
	public void setUp() throws Exception {
		try {
			context = new ClassPathXmlApplicationContext("beans.xml");
			libBo = (LibraryBo) context.getBean("libBo");
			libService = (LibraryService) context.getBean("libService");
			// items=new ArrayList<>();
		} catch (NoSuchBeanDefinitionException n) {
			fail("Failed to create bean in spring configuration file :-" + n.getMessage());
		}

	}

	@Test

	public void testBeanCreation() {
		try {
			stInfo = (StudentInfo) context.getBean("stinfo");
			bkInfo = (BookInfo) context.getBean("bkinfo");
			libBo = (LibraryBo) context.getBean("libBo");
			libService = (LibraryService) context.getBean("libService");

		} catch (NoSuchBeanDefinitionException n) {
			fail("Failed to create bean in spring configuration file :-" + n.getMessage());
		}
	}

	@Test
	public void testValidateStudentId1() {
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap<>();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);
		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);
		LibraryService libService = new LibraryService();
		libService.setLibBo(libBo);

		try {
			if (libService.validateStudentId(1111) == false)
				fail("Validating Student Id failed!!! ");
			if (libService.validateStudentId(101) == true)
				fail("Validating Student Id failed!!! ");
		} catch (InvalidStudentIdException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testValidateStudentId2() {
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);
		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);
		LibraryService libService = new LibraryService();
		libService.setLibBo(libBo);
		Assertions.assertThrows(InvalidStudentIdException.class, () -> libService.validateStudentId(101));
	}

	@Test
	public void testValidateBookName1() {
		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);
		LibraryBo libBo = new LibraryBo();
		libBo.setBkInfo(bkInfo);
		LibraryService libService = new LibraryService();
		libService.setLibBo(libBo);

		try {
			if (libService.validateBookName("Pro Spring") == false)
				fail("Validating Book Name failed!!!");
			if (libService.validateBookName("let Us C") == true)
				fail("Validating Book Name failed!!!");
		} catch (InvalidBookNameException e) {
			// TODO Auto-generated catch block
			System.out.println(e.getMessage());
		}

	}

	@Test
	public void testValidateBookName2() {
		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);
		LibraryBo libBo = new LibraryBo();
		libBo.setBkInfo(bkInfo);
		LibraryService libService = new LibraryService();
		libService.setLibBo(libBo);

		Assertions.assertThrows(InvalidBookNameException.class, () -> libService.validateBookName("let Us C"));
	}

	@Test

	public void testIssueBook() {
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap<>();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);

		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);

		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);
		libBo.setBkInfo(bkInfo);

		LibraryService libService = new LibraryService();
		libService.setLibBo(libBo);
		String msg = "Sorry!!!The Book is not available";

		if (!msg.equals(libService.issueBook(1111, "Spring MVC")))
			fail("Issue Book in service class failed!!!");
		LocalDate returnDate = LocalDate.now().plusDays(7);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String rdate = df.format(returnDate);
		msg = "The book Issued successfully.Return date is " + rdate;

		if (!msg.equals(libService.issueBook(1111, "Pro Spring")))
			fail("Issue Book in service class failed!!!");

	}

	@Test

	public void testReturnBook() {
		LocalDate issueDate = LocalDate.parse("2000-11-02");
		LocalDate expectedDate = LocalDate.parse("2000-11-09");
		LocalDate returnDate = LocalDate.parse("2000-11-13");
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String idate = df.format(issueDate);
		String rdate = df.format(returnDate);
		int fine = 200;
		String msg = "Student Id: 1111" + "\nBook Name :Pro Spring" + "\nIssueDate :" + idate + "\nReturn Date :"
				+ rdate + "\nFine : " + fine + "Rs.";
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap<>();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);

		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);

		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);
		libBo.setBkInfo(bkInfo);

		LibraryService libService = new LibraryService();
		libService.setLibBo(libBo);
		if (!msg.equals(libService.returnBook(1111, "Pro Spring", issueDate, returnDate)))
			fail("Return Book logic of service class failed!!! ");

	}

	@Test
	public void testCalculateFine() {
		LocalDate issueDate = LocalDate.parse("2000-11-02");
		LocalDate returnDate = LocalDate.parse("2000-11-13");
		LibraryService libService = new LibraryService();
		if (libService.calculateFine(issueDate, returnDate) != 200)
			fail("Calculate fine in service class failed!!!");
	}

	@Test
	public void testCheckNoOfCopies() {
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap<>();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);

		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);

		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);
		libBo.setBkInfo(bkInfo);
		if (libBo.checkNoOfCopies("Spring MVC") != 0)
			fail("Check Number Of Copies in Business Object class failed!!!");

		if (libBo.checkNoOfCopies("Pro Spring") != 6)
			fail("Check Number Of Copies in Business Object class failed!!!");
		if (libBo.getBkInfo().getBookDetails().get("Pro Spring") != 5)
			fail("Check Number Of Copies in Business Object class failed!!!");
	}

	@Test
	public void testUpdateNoOfCopies() {
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap<>();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);

		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);

		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);
		libBo.setBkInfo(bkInfo);
		if (libBo.updateNoOfCopies("Head First") != 4)
			fail("Update Number Of Copies in Business Object class failed!!!");
	}

	@Test
	public void testValidateStudentIdBo() {
		StudentInfo stInfo = new StudentInfo();
		Map<Integer, String> stDetails = new TreeMap<>();
		stDetails.put(1111, "9820345611");
		stDetails.put(2222, "8009245660");
		stDetails.put(3333, "9901123568");
		stInfo.setStDetails(stDetails);

		LibraryBo libBo = new LibraryBo();
		libBo.setStInfo(stInfo);

		Assertions.assertThrows(InvalidStudentIdException.class, () -> libBo.validateStudentId(101));

	}

	@Test
	public void testValidateBookNameBo() {

		BookInfo bkInfo = new BookInfo();
		Map<String, Integer> bkDetails = new TreeMap<>();
		bkDetails.put("Pro Spring", 6);
		bkDetails.put("Head First", 3);
		bkDetails.put("Test Driven", 7);
		bkDetails.put("Spring MVC", 0);
		bkInfo.setBookDetails(bkDetails);

		LibraryBo libBo = new LibraryBo();

		libBo.setBkInfo(bkInfo);
		Assertions.assertThrows(InvalidBookNameException.class, () -> libBo.validateBookName("Let Us C"));

	}

}
*/