package utility;

import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ReadXlsxFileClass {

   public static List<String> userEmail = new ArrayList<>();
  public static List<String> userPassword = new ArrayList<>();

    public static void setXLSXFileInfo() {
        try (FileInputStream fileInputStream = new FileInputStream(new File("/Users/fatinpushan/Documents/Fatin/Selenium/ScaledUPITProject2/src/main/resources/readingFrom_XLSX_File_.xlsx"));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(1);

            for (Row row : sheet) {

                Cell emailCell = row.getCell(0) ;
                Cell passwordCell = row.getCell(1) ;

                if(emailCell != null  && emailCell.getCellType() == CellType.STRING){
                    userEmail.add(emailCell.getStringCellValue()  ) ;
                }
                if (passwordCell != null && passwordCell.getCellType() == CellType.STRING) {

                    userPassword.add(passwordCell.getStringCellValue());
                }


            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static int getListSize(){
        return userEmail.size() ;
    }


}
