import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.*;

import java.sql.Date;
import java.util.List;
import java.util.Map;


public class TestResultInfo {

    /**
     * APPName ----应用名
     * Version ----版本
     * TestTools ---- 测试工具
     * FileType ---- 文件类型
     * Threshold ----分支覆盖率基线
     * Author ----作者
     */
    private static String APP_Name = "";
    private static String Version = "";
    private static Date Invoke_Time;
    public static final double Threshold = 0.5;
    private Map<String,caseInfo> TestResult;

    public Map<String, caseInfo> getTestResult() {
        return TestResult;
    }

    public void setTestResult(Map<String, caseInfo> testResult) {
        TestResult = testResult;
    }

    public static String getAPP_Name() {
        return APP_Name;
    }

    public static void setAPP_Name(String APP_Name) {
        TestResultInfo.APP_Name = APP_Name;
    }

    public static String getVersion() {
        return Version;
    }

    public static void setVersion(String version) {
        Version = version;
    }

    public static Date getInvoke_Time() {
        return Invoke_Time;
    }

    public static void setInvoke_Time(Date invoke_Time) {
        Invoke_Time = invoke_Time;
    }

    public static TestResultInfo getInstance(){
        return new TestResultInfo();
    }


    // 被测程序信息








}
