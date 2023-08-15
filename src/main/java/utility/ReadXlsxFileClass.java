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

        //change path depending on os system, content root not working atm
        String osName = System.getProperty("os.name").toLowerCase();
        String path = null ;

        System.out.println(osName);

        if(osName.contains("win")) {
            path = GetPropertiesClass.getProperties("excel.path.windows") ;
        } else if (osName.contains("mac")) {
            path = GetPropertiesClass.getProperties("excel.path.mac") ;
        }


        try (FileInputStream fileInputStream = new FileInputStream(new File(path));
             Workbook workbook = new XSSFWorkbook(fileInputStream)) {

            Sheet sheet = workbook.getSheetAt(0);

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
