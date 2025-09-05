package com.utility;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ui.pojo.User;

public class ExcelReaderUtility {
	public static Iterator<User> readExcelFile(String fileName)  {
		File xlsxFile = new File(System.getProperty("user.dir")+"//testData//"+fileName);
		//XLSX File
		XSSFWorkbook xssfWorkbook = null;
		List<User> userList = null;;
		Iterator<Row> rowIterator;
		Row row;
		Cell emailAddressCell;
		Cell passwordCell;
		User user;
		XSSFSheet xssfsheet;
		try {
			xssfWorkbook = new XSSFWorkbook(xlsxFile);
			xssfsheet = xssfWorkbook.getSheet("LoginTestData");
			userList = new ArrayList<User>();
			rowIterator = xssfsheet.iterator();
			rowIterator.next(); //Skipping column name
			while(rowIterator.hasNext()) {
				row = rowIterator.next();
				emailAddressCell = row.getCell(0);
				passwordCell = row.getCell(1);
				user= new User(emailAddressCell.toString(),passwordCell.toString());
				userList.add(user);
				xssfWorkbook.close();
			}
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return userList.iterator();
	}

}
