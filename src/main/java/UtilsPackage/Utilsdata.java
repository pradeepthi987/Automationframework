package UtilsPackage;


import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.System.Logger;
import java.util.logging.FileHandler;
import java.util.logging.LogManager;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import BasePackage.BaseClass;

public class Utilsdata extends BaseClass{
	 public Utilsdata() throws IOException {
	        super();
	    }
	  
	    public static Object[][] getExcelData(String fileName, String sheetName) {
	        Object[][] data = null;
	        XSSFWorkbook wb = null;
	 
	        try {
	            wb = new XSSFWorkbook("C:\\Users\\deept\\eclipse-workspace\\Automationframework\\src\\main\\java\\Datafolder\\Testdata.xlsx");
	            XSSFSheet sheet = wb.getSheet(sheetName);
	            int rowsIndex = sheet.getLastRowNum();  //return last  row number ie, how many data sets we want to run-row index starts from 0, so last row no is 4
	             //return last row number ie, how many data sets we want to run-row index starts from 0, so last row no is 4
	           // Log.info("Total rows:" + rowsIndex);
	            data = new Object[rowsIndex][];
	            //this loop is to enter into each row
	            for (int i = 1; i <= rowsIndex; i++) {   //we are not accessing row 0 as it is the heading
	                XSSFRow row = sheet.getRow(i);
	                int cols = row.getLastCellNum();   //returns no:of columns- index start from 0
	              //  Log.info("total cols:" + cols);
	                Object[] colData = new Object[cols];
	                //this loop is to enter into each cell
	                for (int j = 0; j < cols; j++) {
	                    colData[j] = row.getCell(j).toString();
	                }
	                data[i - 1] = colData;
	            }
	        } catch (IOException e) {
	           // Log.error("TestUtil exception:" + e);
	        } finally {
	            try {
	                wb.close();
	            } catch (IOException e) {
	            }
	        }
	    return data;
	    }
	    public static void takeScreenshotAtEndOfTest() throws IOException {
	        File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);   //take screenshot and store it in a file
	        String currentDir = System.getProperty("C:\\Users\\deept\\Desktop");    //give the location where we have to save the screenshot taken
	        FileUtils.copyFile(srcFile, new File(currentDir + "/screenshots/" + System.currentTimeMillis() + ".png"));   //finally copy the screenshot taken to the location

	      }
	
}