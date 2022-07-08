package com.selenium.repository;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONObject;

public class ReadConfig {

	private Properties prop;
	private File file;
	private static ReadConfig readConfig = null;
	private FileInputStream fis = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;

	private ReadConfig() {
	}

	public static ReadConfig getInstance() {
		if (readConfig == null) {
			readConfig = new ReadConfig();
		}
		return readConfig;
	}

	public String getConfigProperty(String key) {
		file = new File("src/main/java/com/selenium/repository/Config.properties");
		try {
			FileInputStream fis = new FileInputStream(file);
			prop = new Properties();
			prop.load(fis);
		} catch (Exception e) {
			System.out.println("Exception is " + e.getMessage());
		}
		return prop.getProperty(key);
	}

	public String getLocator(String objectName, String key) {
		file = new File(new String("src/main/java/com/selenium/repository/ObjectRepo.json"));
		String locator = null;
		try {
			String content = new String(Files.readAllBytes(Paths.get(file.toURI())));
			JSONObject jsonObject = new JSONObject(content);
			locator = (String) jsonObject.getJSONObject(objectName).get(key);
		} catch (IOException e) {
			System.out.println("Exception is " + e.getMessage());
		}
		return locator;

	}


	public XSSFWorkbook excelConfiguration(String sheetName) throws IOException {
		if (workbook == null) {
			file = new File("src/main/java/com/selenium/repository/Test.xlsx");
			fis = new FileInputStream(file);
			workbook = new XSSFWorkbook(fis);
			sheet = workbook.getSheet(sheetName);
		}
		return workbook;
	}

	public String getDataFromExcel(String sheetName, int row, int column) throws IOException {
		excelConfiguration(sheetName);
		String tempString = getCellValue(sheet.getRow(row).getCell(column));
		fis.close();
		workbook.close();
		return tempString;
	}

	public static String getCellValue(Cell cell) {

		if (cell != null) {
			switch (cell.getCellType()) {
			case NUMERIC:
				return String.valueOf(cell.getNumericCellValue());
			case BOOLEAN:
				return String.valueOf(cell.getBooleanCellValue());
			case STRING:
				return cell.getStringCellValue();
			case BLANK:
				return "Cell contains BLANK Value";
			default:
				return cell.getStringCellValue();
			}
		}

		return "Cell contains NULL Value";

	}
	

	
	public void PrintAllDataFromExcel(String sheetName) throws IOException {
		excelConfiguration(sheetName);
		int rowCount = sheet.getPhysicalNumberOfRows();
		for (int i = 0; i < rowCount; i++) {
			XSSFRow row = sheet.getRow(i);
			int cellCount = row.getPhysicalNumberOfCells();
			for (int j = 0; j < cellCount; j++) {
				XSSFCell cell = row.getCell(j);
				String cellValue2 = getCellValue(cell);
				System.out.print("||" + cellValue2);
			}
			System.out.println();
			fis.close();
			workbook.close();
		}

	}

	
}
