package library;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataRepository {
	private XSSFSheet sheet;
	private XSSFWorkbook workbook;

	public DataRepository(String filePath, String sheetName) throws Exception {
		try {
			File file = new File(filePath);
			FileInputStream inputStream = new FileInputStream(file);
			workbook = new XSSFWorkbook(inputStream);
			sheet = workbook.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public String getStringCellValue(String cellContent) {
		String cellValue = "";
		for (Row row : sheet) {
			for (Cell cell : row) {
				if (cell.getCellType() == CellType.STRING) {
					if (cell.getRichStringCellValue().getString().trim().equals(cellContent)) {
						cellValue = sheet.getRow(row.getRowNum()).getCell(cell.getColumnIndex() + 1)
								.getStringCellValue().toString().trim();
					}
				}
			}
		}
		return cellValue;
	}
}
