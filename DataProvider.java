import java.util.*;
import java.sql.Date;

public class DataProvider {


     private TestResultInfo testResult = TestResultInfo.getInstance();
     //private List<Map<caseInfo>>  caseInfo = null;
     private static final String sql = "SELECT t.TEST_TOOLS,t.FILE_TYPE,t.FILENAME,t.COVERAGE_BRANCH_AMOUNT,t.TOTAL_BRANCH_NUM FROM test_coverage_info as  t WHERE t.APP_NAME=? and t.VERSION=? and t.INVOKE_TIME = ?";

     public DataProvider(String APPNAME,String VERSION) throws Exception{
         // 这三个值是关键词，不需要查出时一并查出，降低性能
         testResult.setAPP_Name(APPNAME);
         testResult.setVersion(VERSION);

         Date date = getSystemDate();
         if(date ==null){
             throw new Exception("日期获取失败");
         }
         testResult.setInvoke_Time(date);

     }




    public List<caseInfo> getTestResult(String APPNAME,String VERSION) throws Exception{
        // 查询关键字不得为空
        if(APPNAME==null || APPNAME.equals("")||VERSION ==null || VERSION.equals("")){
            throw new Exception("APPNAME 或 VERSION 为空");

        }
        try{

            // 查询数据库，获取具体的访问结果
            Object[] args = new Object[3];
            args[0] = APPNAME;
            args[1] = VERSION;
            args[2] = String.valueOf(testResult.getInvoke_Time());
            List<caseInfo> resultList = JDBCUtils.getInstance(caseInfo.class,sql,args);

            return resultList;

        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


    public List<caseInfo> calCoverageRate(List<caseInfo> caseInfos) throws Exception{
        List<caseInfo> result = new LinkedList<>();
        if(caseInfos==null){
            return null;
        }
        try{
            for(int i =0;i<caseInfos.size();i++){
                caseInfo caseInfo = caseInfos.get(i);
                caseInfo.setCOVERAGE_BRAND_RATE((double)(Integer.valueOf(caseInfo.getCOVERAGE_BRANCH_AMOUNT())*1.0d/Integer.valueOf(caseInfo.getTOTAL_BRANCH_AMOUNT())));
                result.add(caseInfo);

            }
            Map<String,List<caseInfo>> Result = new LinkedHashMap<>();
            Result.put(testResult.getAPP_Name(),result);
            return result;
        } catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }







    public Date getSystemDate(){
        try {
            Calendar calendar = Calendar.getInstance();
            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH)+1;
            int day = calendar.get(Calendar.DATE);
            String dateString = year + "-" + month + "-" + day;
            return Date.valueOf(dateString);
        } catch (IllegalArgumentException e){
            e.printStackTrace();
        }
        return null;
    }


    public static void main(String[] args) throws Exception {
        DataProvider dp = new DataProvider("ESSP","2019.12");
        List<caseInfo> result = dp.getTestResult(dp.testResult.getAPP_Name(),dp.testResult.getVersion());
        List<caseInfo> results = dp.calCoverageRate(result);
        System.out.println("success");
    }



}
