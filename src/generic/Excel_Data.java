package generic;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel_Data 
{
	//Method to Read data from Excel sheet
	public static String getValue(String path, String sheet, int r, int c)
	{
		String v="";
		try
		{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			v=wb.getSheet(sheet).getRow(r).getCell(c).toString();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return v;
	}
	
	//Method to Count Number of Row values in excel
	public static int getRowCount(String path, String sheet)
	{
		int rc=0;
		try
		{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			rc=wb.getSheet(sheet).getLastRowNum();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return rc;
	}
	
	//Method to read count of column values
	public static int getColumnCount(String path, String sheet, int r)
	{
		int cc=0;
		try
		{
			Workbook wb=WorkbookFactory.create(new FileInputStream(path));
			cc=wb.getSheet(sheet).getRow(r).getLastCellNum();
		}
		catch (Exception e) 
		{
			// TODO: handle exception
		}
		return cc;
	}
}


/* or 
 
 package generic;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelData 
{
	//Method to Read data from Excel sheet
	public static String getValue(String path, String sheet, int r, int c ) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		String v="";
		WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getCell(c).toString();
		return v;	
	}
	
	//Method to Count Number of Row values in excel
	public static int getRowCount(String path, String sheet) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		int rc=0;
		WorkbookFactory.create(new FileInputStream (path)).getSheet(sheet).getLastRowNum();
		return rc;	
	}
	
	//Method to read count of column values
	public static int getColumnCount(String path, String sheet, int r) throws EncryptedDocumentException, InvalidFormatException, FileNotFoundException, IOException
	{
		int cc=0;
		WorkbookFactory.create(new FileInputStream(path)).getSheet(sheet).getRow(r).getLastCellNum();
		return cc;
	}
}

 
 */
