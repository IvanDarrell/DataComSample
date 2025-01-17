package Actions;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openxmlformats.schemas.spreadsheetml.x2006.main.CalcChainDocument;
import org.testng.annotations.Test;

public class ExcelReader {
	
	
	public String data;
	private String path;
	private FileInputStream file = null;
	private XSSFWorkbook workbook = null;
	private XSSFSheet sheet = null;
	private XSSFRow row = null;
	private XSSFCell cell = null;

	
	
	public ExcelReader (String path) {
		
		this.path = path;
		
		
		
		try {
			
			
			file = new FileInputStream(path);
			workbook = new XSSFWorkbook(file);
			XSSFSheet sheet= workbook.getSheetAt(0);  
			
			
			
			
		} catch (Exception e) {
			
			
		}
		
		
		
	}
	
	
	public int getRowCount (String sheetName) {
		
		int index = workbook.getSheetIndex(sheetName);
		
		if (index == -1) {
			
			return 0;
		} else {
			
			
			
			sheet = workbook.getSheetAt(index);
			int number = sheet.getLastRowNum()+1;
			return number;
		}
		 
		
	
		
		
		
	}
	
	public String getCellData (String sheetName, String colName, int rowNum) {
		
		try {
			
			if (rowNum <= 0) 
			return "";
			
			int index = workbook.getSheetIndex(sheetName);
			
			int col_Num = 1;
			if (index == -1)
			return "";
			
			
			sheet = workbook.getSheetAt(index);
			
			row = sheet.getRow(0);
			
			for (int i=0; i < row.getLastCellNum(); i++) {
				
				
				if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
					col_Num=i;
				
			}
			
			if (col_Num==-1) {
				return "";
			}
			
			sheet = workbook.getSheetAt(index);
			
			row = sheet.getRow(rowNum - 1);
			if (row == null)
				return "";
			
			cell = row.getCell(col_Num);
			
			
			
			
			
			
			if (cell == null)
				return "";
			
			
			if (cell.getCellType()==Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			
			else if (cell.getCellType()== Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA ) {
				
				String cellText = String.valueOf(cell.getNumericCellValue());
				
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					
					double d = cell.getNumericCellValue();
					
					Calendar cal = Calendar.getInstance();
					
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" + cal.get(Calendar.MONTH)+1 +"/" + cellText;
					
					
				}
				
				return cellText;
				
			} else if (cell.getCellType()==Cell.CELL_TYPE_BLANK)
				return "";
			
			else 
				return String.valueOf(cell.getBooleanCellValue());
			
			
		} catch (Exception e) {
			e.printStackTrace();
			return "row " + rowNum + " or column " + colName + " does not exist in xls";
			
			
		}
		

	}

	
	public String getCellData (String sheetName,int colNum, int rowNum) {
		
		try {
			
			if (rowNum <= 0)
				return "";
			
			int index = workbook.getSheetIndex(sheetName);
			
			if (index ==1)
				return "";
			
			
			sheet = workbook.getSheetAt(index);
			row = sheet.getRow(rowNum -1);
			
			
			if (row ==null)
				return "";
			
			cell = row.getCell(colNum);
			
			if (cell == null)
				return "";
			
			if (cell.getCellType() == Cell.CELL_TYPE_STRING)
				return cell.getStringCellValue();
			
			else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC || cell.getCellType() == Cell.CELL_TYPE_FORMULA) {
				
				String cellText = String.valueOf(cell.getNumericCellValue());
				
				if (HSSFDateUtil.isCellDateFormatted(cell)) {
					
					double d = cell.getNumericCellValue();
					
					Calendar cal = Calendar.getInstance();
					cal.setTime(HSSFDateUtil.getJavaDate(d));
					cellText = (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
					cellText = cal.get(Calendar.MONTH) + 1 + "/" + cal.get(Calendar.DAY_OF_MONTH) + "/" + cellText;
					
					
				}
				return cellText;
			} else if (cell.getCellType() == Cell.CELL_TYPE_BLANK)
				return "";
			
			else 
				return String.valueOf(cell.getBooleanCellValue());
			
		} catch (Exception e) {
			
			e.printStackTrace();
			return "row " + rowNum + " or column " + colNum + " does not exist in xls";
			
		}
		
		
		
		
		

		
	}
	
	
	@Test
	public void excel () throws IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\IVAN DARRELL\\eclipse-workspace\\CRM\\Book 1.xlsx");
		
		
		
		//Creating a workbook
		XSSFWorkbook workbook = new XSSFWorkbook(file);
		
		
		XSSFSheet sheet= workbook.getSheetAt(0);  
		

		System.out.println(sheet.getRow(1).getCell(0));
		System.out.println(sheet.getRow(0).getCell(1));
		
		//int test = findRow(sheet,"URL");
		
	
		
		
		

		
		
		//System.out.print(tests);
			
	}
	
	
	
	
	
	
		
		
		
		
		

}

