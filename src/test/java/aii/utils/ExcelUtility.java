package aii.utils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {

	private static Workbook book;
	private static Sheet sheet;

	private static void openExcel(String filePath) {
		try {
			FileInputStream fileIS = new FileInputStream(filePath);
			book = new XSSFWorkbook(fileIS);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private static void loadSheet(String sheetName) {
		sheet = book.getSheet(sheetName);
	}

	private static int rowCount() {
		return sheet.getPhysicalNumberOfRows();
	}

	private static int colCount(int rowIndex) {
		return sheet.getRow(rowIndex).getLastCellNum();
	}

	private static String cellData(int rowIndex, int colIndex) {
		return sheet.getRow(rowIndex).getCell(colIndex).toString();
	}

	// Return a 2D-Object array
	public static Object[][] excelIntoArray(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		int rows = rowCount();
		int cols = colCount(0);

		// I said row-1 to skip the header
		Object[][] data = new Object[rows - 1][cols];

		// Iterate rows
		for (int row = 1; row < rows; row++) {

			// Iterate the columns
			for (int col = 0; col < cols; col++) {

				// Store the cell value into the Object[][]
				data[row - 1][col] = cellData(row, col);
			}
		}

		return data;
	}

	
	// Return a List of Map<String, String>
	public static List<Map<String, String>> excelIntoListOfMaps(String filePath, String sheetName) {

		openExcel(filePath);
		loadSheet(sheetName);

		List<Map<String, String>> list = new ArrayList<>();

		for (int row = 1; row < rowCount(); row++) {
			// for every data row create a map
			Map<String, String> rowMap = new LinkedHashMap<>();

			// fill the map
			for (int col = 0; col < colCount(row); col++) {
				rowMap.put(cellData(0, col), cellData(row, col));
			}

			// add the map to the list
			list.add(rowMap);
		}

		return list;
	}

}
