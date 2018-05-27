package utilitiesFunctionLibrary;


import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;


/**
 * @author mujeeb
 *
 */
public class ExcelOperations 
{
	private static XSSFSheet ExcelSheet;

	private static XSSFWorkbook ExcelBook;

	private static String sheetdata;

	private static XSSFRow Row;

	private static XSSFCell Cell;

	private Workbook Workbook; 
	public static int row_no=16380;
	public static int colm_no=16380;
	

	@SuppressWarnings({ "deprecation", "static-access" })
	public static String SetExcelPath(String Path,String SheetName,int rowNum,int cellNum) throws Exception
	{
		try
		{
			FileInputStream ExcelFile = new FileInputStream(Path);

			// Access the required test data sheet

			ExcelBook = new XSSFWorkbook(ExcelFile);

			ExcelSheet = ExcelBook.getSheet(SheetName);

			Row = ExcelSheet.getRow(rowNum);
			
						
			if(Row.getCell(cellNum).getCellType()== Cell.CELL_TYPE_NUMERIC)
			{
				double cellNumericData = Row.getCell(cellNum).getNumericCellValue();
				sheetdata = Double.toString(cellNumericData);
			}
			else
			{
				sheetdata = Row.getCell(cellNum).getStringCellValue();
			}
			return sheetdata;

		}

		catch(Exception e)
		{
			throw (e);

		}

	}
	
	public static String getExcelData(String excelFilePath,String sheetName, int rowNum, int cellNum)
            throws Exception {
     @SuppressWarnings("unused")
	int cellNumericData ;
     FileInputStream fs = new FileInputStream(excelFilePath);
     Workbook wb = WorkbookFactory.create(fs);
     Sheet sh = wb.getSheet(sheetName);
     Row row = sh.getRow(rowNum);
     Cell cell=row.getCell(cellNum);
     
     DataFormatter df = new DataFormatter();
     String sheetdata = df.formatCellValue(cell);
     

     return sheetdata;
}


	public int getColNo(Sheet sheet,String colName) throws InterruptedException 
	{
		Row row =null;
		int total_rows =sheet.getLastRowNum();
		//int colm_no=16380;
		boolean flag=false;
		for (int i=0; i<=total_rows;i++)
		{
			row=sheet.getRow(i);
			for(int j=0;j<=row.getLastCellNum();j++)
			{
				if(row.getCell(j)!=null)
				{
					if(row.getCell(j).toString().trim().equals(colName))
					{
						flag = true;
						colm_no=j;
						break;
					}
				}
			}
			if (flag==true)
				break;
		}


		return colm_no;
	}

	public int getRowNo(Sheet sheet,String colName) 
	{
		Row row =null;
		int total_rows =sheet.getLastRowNum();
		
	//	int row_no=16380;
		boolean flag=false;
		
		for (int i=0; i<=total_rows;i++)
		{
			row=sheet.getRow(i);
			//System.out.println("total columns  " + row.getLastCellNum());
			for(int j=0;j<=row.getLastCellNum();j++)
			{

				if(row.getCell(j)!=null)
				{
					if(row.getCell(j).toString().trim().equals(colName))
					{
						flag = true;
						break;
					}
				}

			}
			if (flag==true)
			{
				row_no =i;
				break;
			}

		}
		return row_no;
	}

	private Workbook getWorkbook(String WorkbookPath) throws IOException
	{

		if(WorkbookPath.contains(".xlsx"))
		{
			Workbook = new XSSFWorkbook(WorkbookPath);

			//System.err.println("workbook.getNumberOfSheets() : " + workbook.getNumberOfSheets());
		}
		else
		{				
			FileInputStream inp = new FileInputStream(WorkbookPath);
			Workbook = new HSSFWorkbook(new POIFSFileSystem(inp));	
			//System.err.println("workbook.getNumberOfSheets() : " + workbook.getNumberOfSheets());
		}
		return Workbook;

	}

	private Sheet getSheet(String WorkbookPath, String SheetName) throws IOException
	{
		Sheet sheet = null;
		Workbook workbook = getWorkbook(WorkbookPath);
		sheet = workbook.getSheet(SheetName.trim());
		return sheet;

	}

	public int getRowCount(String WorkbookPath, String SheetName) throws IOException
	{
		@SuppressWarnings("unused")
		int sheetRow;
		Sheet sheet = null;
		Workbook workbook = getWorkbook(WorkbookPath);
		sheet = workbook.getSheet(SheetName.trim());
		return sheetRow = sheet.getLastRowNum();
	}

	@SuppressWarnings({ "deprecation", "static-access" })
	public String getCellContentRowName( String WorkbookPath, String SheetName, String RowName, String ColName) throws InterruptedException
	{
		String CellContent = null;
		Sheet sheet = null;
		try 
		{

			sheet = getSheet(WorkbookPath,SheetName);


			Cell cell  = sheet.getRow(getRowNo(sheet,RowName)).getCell(getColNo(sheet,ColName));
			if(cell==null || cell.getCellType() == Cell.CELL_TYPE_BLANK)
			{
				CellContent = "";
			}
			else
			{
				CellContent = cell.toString().trim();
			}

		} 
		catch (IOException e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();	
			System.err.println("Excl Exception :" + WorkbookPath);
			System.err.println("Excl Exception :" + SheetName);
			System.err.println(e.getMessage());
		}

		return CellContent;

	} 

	@SuppressWarnings({ "deprecation", "static-access" })
	public String getCellContentRowNo( String WorkbookPath, String SheetName, int RowNo, String ColName) throws InterruptedException
	{
		String CellContent = null;
		Sheet sheet=null;
		try 
		{


			sheet = getSheet(WorkbookPath,SheetName);


			System.out.println("getColNo : " + getColNo(sheet,ColName));

			Cell cell  = sheet.getRow(RowNo).getCell(getColNo(sheet,ColName));
			if(cell==null || cell.getCellType() == Cell.CELL_TYPE_BLANK)
			{
				//System.err.println("OK-");
				CellContent = "";
			}
			else
			{
				CellContent = cell.toString().trim();

			}

		} 
		catch (IOException e) 
		{

			e.printStackTrace();	
			System.err.println("Excl Exception :" + WorkbookPath);
			System.err.println("Excl Exception :" + SheetName);
			System.err.println(e.getMessage());
		}
		return CellContent;

	}

	@SuppressWarnings({ "static-access", "deprecation" })
	public static void setCellData(String Result,  int RowNum, int ColNum, String Path) throws Exception	{

		try{

			Row  = ExcelSheet.getRow(RowNum);

			Cell = Row.getCell(ColNum, Row.RETURN_BLANK_AS_NULL);

			if (Cell == null) {

				Cell = Row.createCell(ColNum);

				Cell.setCellValue(Result);

			} else {

				Cell.setCellValue(Result);

			}

			// Constant variables Test Data path and Test Data file name

			FileOutputStream fileOut = new FileOutputStream(Path);

			ExcelBook.write(fileOut);

			fileOut.flush();

			fileOut.close();

		}catch(Exception e){

			throw (e);

		}

	}


}
