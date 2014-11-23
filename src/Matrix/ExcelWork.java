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
import org.apache.poi.hssf.usermodel.HSSFRow;



import javax.swing.text.html.*;

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

    public static Matrix readExcel(String fileName) throws IOException
    {

        FileInputStream fileInput  = new FileInputStream(fileName);

        Workbook workbook = new HSSFWorkbook(fileInput);
        Sheet sheet = workbook.getSheetAt(0);
        Iterator<Row> rowIterator = sheet.iterator();
        int i = 0;
        int j;
        int createCount = -1;
        Matrix returnedMatrix = new Matrix();
        while (rowIterator.hasNext())
        {

            Row row = rowIterator.next();
            if ( createCount == -1 )
            {
                returnedMatrix = new Matrix(sheet.getLastRowNum() + 1, row.getLastCellNum());
                createCount = 0;
            }
            Iterator<Cell> cellIterator = row.cellIterator();
            j = 0;
            while (cellIterator.hasNext())
            {
                Cell cell = cellIterator.next();
                switch(cell.getCellType())
                {
                    case Cell.CELL_TYPE_NUMERIC:
                        returnedMatrix.setValueAt(i, j, cell.getNumericCellValue());
                }
            ++j;
            }
        ++i;
        }
    return returnedMatrix;
    }

}