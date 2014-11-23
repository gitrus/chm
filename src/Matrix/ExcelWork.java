package Matrix;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
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
        Sheet sheet = workbook.createSheet("Matrix["+height+"]["+width+"]");
        for ( int i = 0; i < height; ++i)
        {
            Row row = sheet.createRow(i);
            for ( int j = 0; j < width; ++j)
            {
                row.createCell(j).setCellValue(matrix.getValueAt(i, j));
            }
        }

        FileOutputStream createdFile = new FileOutputStream(fileName);
        workbook.write(createdFile);
        createdFile.close();
        System.out.println(fileName + " written successfully");
    }

    public static void readExcel(String fileName) throws IOException
    {

        FileInputStream fileInput  = new FileInputStream(fileName);

        Workbook workbook = new HSSFWorkbook(fileInput);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        while (rowIterator.hasNext())
        {
            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();

            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch(cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        System.out.println(cell.getNumericCellValue());
                }
            }
        }
    }

}