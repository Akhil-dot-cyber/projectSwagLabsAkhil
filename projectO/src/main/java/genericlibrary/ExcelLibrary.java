package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelLibrary implements FrameworkConstant {
	static FileInputStream fis;
	static FileOutputStream fos;
	static Workbook book;

	public static String readData(String Sheet, int row, int cell) {

		// 1. Convert the external file into java readable using fileInputStream class.
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Create a workbook using workbook factory.
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3. Read the data using using workbook sheet, row and column(cell).
		String data = book.getSheet(Sheet).getRow(row).getCell(cell).getStringCellValue();

		System.out.println("Read Data Success");

		return data;

	}

	public static void writeData_Existing(String Sheet, int row, int cell, String data) {

		// 1. Convert the external file into java readable using fileInputStream class.
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Create a workbook using workbook factory.
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// 3. Write the data in existing Sheet and Row
		book.getSheet(Sheet).getRow(row).createCell(cell).setCellValue(data);

		// 4. Convert java readable into external file
		try {
			fos = new FileOutputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 5. Call the write method
		try {
			book.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}

		System.out.println("Write Data Success");

	}

	public static void readDataSpecificRow(String Sheet, int row) {

		// 1. Convert the external file into java readable using fileInputStream class.
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Create a workbook using workbook factory.
		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int lastcellvalue = book.getSheet(Sheet).getRow(row).getLastCellNum();

		System.out.println("Last Column value is:" + lastcellvalue);

		// 3. Read the data using using workbook sheet, row and column(cell).
		for (int i = 0; i < lastcellvalue; i++) {
			String data = book.getSheet(Sheet).getRow(row).getCell(i).getStringCellValue();
			System.out.print(data + ", ");
		}
		System.out.println();
		System.out.println("*********************************************************");

	}

	public static void readDataSpecificColumn(String Sheet, int cell) {

		// 1. Convert the external file into java readable using fileInputStream class.
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Create a workbook using workbook factory.

		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int lastrowvalue = book.getSheet(Sheet).getLastRowNum();

		System.out.println("Last Row value is:" + lastrowvalue);

		// 3. Read the data using using workbook sheet, row and column(cell).
		for (int i = 1; i <= lastrowvalue; i++) {
			String data = book.getSheet(Sheet).getRow(i).getCell(cell).getStringCellValue();
			System.out.println(data);
		}
		System.out.println("*********************************************************");
	}

	public static void readDataAll(String Sheet, int row) {

		// 1. Convert the external file into java readable using fileInputStream class.
		try {
			fis = new FileInputStream(excelpath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// 2. Create a workbook using workbook factory.

		try {
			book = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		int lastcellvalue = book.getSheet(Sheet).getRow(row).getLastCellNum();
		System.out.println("Last Column value is:" + lastcellvalue);
		int lastrowvalue = book.getSheet(Sheet).getLastRowNum();
		System.out.println("Last Row value is:" + lastrowvalue);

		// 3. Read the data using using workbook sheet, row and column(cell).
		System.out.println(lastcellvalue * lastrowvalue + " Values are : ");
		for (int i = 1; i <= lastrowvalue; i++) {
			for (int j = 0; j < lastcellvalue; j++) {

				String data = book.getSheet(Sheet).getRow(i).getCell(j).getStringCellValue();
				System.out.print(data + ", ");
			}
			System.out.println();
		}
		System.out.println("*********************************************************");
	}
}
