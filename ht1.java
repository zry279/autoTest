import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.File;
import java.io.IOException;

public class ht1 {


    public static void main(String[] args) throws IOException {
        Workbook wb = WorkbookFactory.create(new File("MyExcle.xls"));
        

    }



}
