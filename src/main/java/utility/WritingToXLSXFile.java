package utility;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class WritingToXLSXFile {






    public static void writeToExcel(Object[][] emailAndPassword) {

        //change path depending on os system, content root not working atm
        String osName = System.getProperty("os.name").toLowerCase();
        String path = null ;

        if(osName.contains("win")) {
            path = GetPropertiesClass.getProperties("excel.path.windows") ;
        } else if (osName.contains("mac")) {
            path = GetPropertiesClass.getProperties("excel.path.mac") ;
        }

        try {
            FileInputStream fileInputStream = new FileInputStream(new File(path));
            XSSFWorkbook workbook1 = new XSSFWorkbook(fileInputStream);



            Sheet sheet1 = workbook1.getSheet("Java Books123");

            int rowCount = sheet1.getLastRowNum() + 1;

            for (Object[] data : emailAndPassword) {
                Row row = sheet1.createRow(rowCount++);

                int columnCount = 0;
                for (Object cellValue : data) {
                    Cell cell = row.createCell(columnCount++);
                    if (cellValue instanceof String) {
                        cell.setCellValue((String) cellValue);
                    } else if (cellValue instanceof Integer) {
                        cell.setCellValue((Integer) cellValue);
                    }
                }
            }

            try (FileOutputStream outputStream = new FileOutputStream(path)) {
                workbook1.write(outputStream);
            } catch (IOException e) {
                e.printStackTrace();
            }
            System.out.println("I SMSMNOIENDIENDIUEBNCIUEBCIUEBIUB");


        } catch (IOException e) {
            e.printStackTrace();
        }

        }









}
