import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import java.util.List;
import java.util.Map;

public class xlsHelper {


    //输出xls
    public void exportXls(Workbook wb,Map<String, List<caseInfo>> data, String sheetName) throws Exception{
        if(wb==null){
            wb = newWorkBook();
        }
        Sheet sheet = wb.createSheet(sheetName);
        List<caseInfo>
        try{

        }


    }

    public Workbook newWorkBook(){
        return new HSSFWorkbook();
    }
}
