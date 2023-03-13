package com.cts.library.bo;

import com.cts.library.exception.InvalidBookNameException;
import com.cts.library.exception.InvalidStudentIdException;
import com.cts.library.model.BookInfo;
import com.cts.library.model.StudentInfo;

public class LibraryBo {
	private StudentInfo stInfo;
	private BookInfo bkInfo;
	public  LibraryBo () {}
	public StudentInfo getStInfo() {
		return stInfo;
	}

	public void setStInfo(StudentInfo stInfo) {
		this.stInfo = stInfo;
	}

	public BookInfo getBkInfo() {
		return bkInfo;
	}

	public void setBkInfo(BookInfo bkInfo) {
		this.bkInfo = bkInfo;
	}

	public void validateStudentId(int stid) throws InvalidStudentIdException {
		if (!stInfo.getStDetails().containsKey(stid))
			throw new InvalidStudentIdException("The given Student id does not exist!!!");
	}

	public void validateBookName(String bookname) throws InvalidBookNameException {

		if (!bkInfo.getBookDetails().containsKey(bookname))
			throw new InvalidBookNameException("The given Book name does not exist!!!");

	}

	public int checkNoOfCopies(String bookname) {

		Integer noOfCopies = bkInfo.getBookDetails().get(bookname);

		if (noOfCopies > 0) 
			{
				//--noOfCopies;
				bkInfo.getBookDetails().replace(bookname, noOfCopies-1);

				
			}
			return noOfCopies;
		 

	}

	public int updateNoOfCopies(String bookname) {
		Integer noOfCopies = bkInfo.getBookDetails().get(bookname);
		bkInfo.getBookDetails().replace(bookname, ++noOfCopies);
        return noOfCopies;
	}
}
