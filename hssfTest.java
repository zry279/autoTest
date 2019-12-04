import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Date;

public class hssfTest {

    public static void main(String[] args) {
        Workbook wb = new HSSFWorkbook();
        Sheet sheet = wb.createSheet("helloWorld");
        Row row = sheet.createRow(0);
        Cell cell = row.createCell(0);
        cell.setCellValue("案例名称");
        row.createCell(1).setCellValue("案例编号");
        CreationHelper ch = wb.getCreationHelper();
        ch.createRichTextString("This is a String");
        row.createCell(2).setCellValue(true);
        CellStyle cellStyle = wb.createCellStyle();
        cellStyle.setDataFormat(ch.createDataFormat().getFormat("m/d/yy h:mm"));
        Cell cell1_3 = row.createCell(3);
        cell1_3.setCellValue(new Date());
        cell1_3.setCellStyle(cellStyle);


        try {
            OutputStream fileOut = new FileOutputStream("workbook.xls");
            wb.write(fileOut);

        } catch (IOException e) {
            e.printStackTrace();

        }
    }
}
