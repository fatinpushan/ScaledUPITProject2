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

        try {
            FileInputStream fileInputStream = new FileInputStream(new File("/Users/fatinpushan/Documents/Fatin/Selenium/ScaledUPITProject2/src/main/resources/readingFrom_XLSX_File_.xlsx"));
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

            try (FileOutputStream outputStream = new FileOutputStream("/Users/fatinpushan/Documents/Fatin/Selenium/ScaledUPITProject2/src/main/resources/readingFrom_XLSX_File_.xlsx")) {
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
