package com.cts.library.service;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

import com.cts.library.bo.LibraryBo;
import com.cts.library.exception.InvalidBookNameException;
import com.cts.library.exception.InvalidStudentIdException;

public class LibraryService {
	private LibraryBo libBo;

	public LibraryBo getLibBo() {
		return libBo;
	}

	public void setLibBo(LibraryBo libBo) {
		this.libBo = libBo;
	}

	public boolean validateStudentId(int stid) throws InvalidStudentIdException {
		
			libBo.validateStudentId(stid);
			return true;
		

	}
	public boolean validateBookName(String bookname) throws InvalidBookNameException {
		
			libBo.validateBookName(bookname);
			return true;
		

	}

	public String issueBook(int stid, String bookname) {
       
		int noOfCopies=libBo.checkNoOfCopies(bookname);
		//System.out.println(noOfCopies);
		if (noOfCopies<=0) {
			return "Sorry!!!The Book is not available";
		} else {
			LocalDate issueDate = LocalDate.now();
			LocalDate returnDate = issueDate.plusDays(7);
			DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
			String returnDateStr = df.format(returnDate);
			
			return "The book Issued successfully.Return date is " + returnDateStr;


		}

	}

	public String returnBook(int stid, String bookname, LocalDate issueDate,LocalDate returnDate)
	{   libBo.updateNoOfCopies(bookname);
		int fine = calculateFine(issueDate,returnDate);
		DateTimeFormatter df = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		String iDate = df.format(issueDate);
		String rDate = df.format(returnDate);
		return "Student Id: " + stid + "\nBook Name :" + bookname + "\nIssueDate :" + iDate + "\nReturn Date :" + rDate
				+ "\nFine : " + fine+"Rs.";
	}
	public int calculateFine(LocalDate issueDate,LocalDate returnDate)
	{
		int fine = 0;
		LocalDate expectedDate = issueDate.plusDays(7);
		
		if (returnDate.isAfter(expectedDate)) {
			Period p = Period.between(expectedDate, returnDate);
			fine = p.getDays() * 50;
		}
		return fine;
	}
	

}
