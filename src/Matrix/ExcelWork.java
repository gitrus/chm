package Matrix;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

/**
 * Created by Vladimir on 16.11.2014.
 */


public class ExcelWork
{
    public static void writeExcel(String fileName, Matrix matrix) throws IOException
    {
        int width = matrix.getM();
        int height = matrix.getN();
        Workbook workbook = new HSSFWorkbook();
        Sheet sheet = workbook.createSheet("list");
        for ( int i = 0; i < height; ++i)
        {
            Row row = sheet.createRow(i);
            for ( int j = 0; j < width; ++j)
            {
                row.createCell(j).setCellValue(matrix.getMatrix(i,j));
            }
        }
        //lets write to file
        FileOutputStream createdFile = new FileOutputStream(fileName);
        workbook.write(createdFile);
        createdFile.close();
        System.out.println(fileName + " written successfully");
    }

}