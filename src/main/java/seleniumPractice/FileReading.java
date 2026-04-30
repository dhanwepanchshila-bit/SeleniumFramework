package seleniumPractice;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FileReading {
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		
		FileInputStream file = new FileInputStream("C:\\Users\\ec1003au\\Downloads\\Annual Salary Details (4).xls");
		Workbook wb = WorkbookFactory.create(file);
		Sheet sh =  wb.getSheet("Sheet1");
		int columnsize = sh.getRow(0).getLastCellNum();
		int rowSize = sh.getLastRowNum();
		System.out.println(rowSize);
		
		for(int i=0; i<columnsize; i++)
		{
			for(int j=0; j<rowSize; j++) {
			Cell cell = sh.getRow(1).getCell(i);
			CellType celltype = cell.getCellType();
			if(celltype==CellType.STRING) {
			System.out.println(cell.getStringCellValue());
			}
			else if(celltype==CellType.NUMERIC)
			{
				System.out.println(cell.getNumericCellValue());

			}
			}
			}
		}
	}


