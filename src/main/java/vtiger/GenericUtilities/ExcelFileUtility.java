package vtiger.GenericUtilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelFileUtility {
public String datafromexcel(String sheet,int row,int cell) throws EncryptedDocumentException, IOException
{
	FileInputStream fis=new FileInputStream("C:\\BhargavFiles\\Datadriven.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheet);
	Row r=sh.getRow(row);
	Cell c=r.getCell(cell);
	String value=c.getStringCellValue();
	return value;
}
public int getrowcount(String sheet) throws Exception
{
	FileInputStream fis=new FileInputStream("C:\\BhargavFiles\\Datadriven.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Sheet sh=book.getSheet(sheet);
	int rowcount=sh.getLastRowNum();
	return rowcount;
}
public void writedataintoexcel(String sheet,int row,int cell,String value) throws Exception
{
	FileInputStream fis=new FileInputStream("C:\\BhargavFiles\\Datadriven.xlsx");
	Workbook book=WorkbookFactory.create(fis);
	Row r=book.getSheet(sheet).getRow(row);
	r.createCell(cell).setCellValue(value);
	FileOutputStream fos=new FileOutputStream("C:\\\\BhargavFiles\\\\Datadriven.xlsx");
	book.write(fos);
	System.out.println(value+"--->data added");
	book.close();
}
}
