public class caseInfo {
    private String FILENAME;
    private String COVERAGE_BRANCH_AMOUNT;
    private String TOTAL_BRANCH_NUM;
    private Double COVERAGE_BRAND_RATE;
    //private String Author;
    private String TEST_TOOLS;
    private String FILE_TYPE;

    public String getFILENAME() {
        return FILENAME;
    }

    public void setFILENAME(String FILENAME) {
        this.FILENAME = FILENAME;
    }

    public String getCOVERAGE_BRANCH_AMOUNT() {
        return COVERAGE_BRANCH_AMOUNT;
    }

    public void setCOVERAGE_BRANCH_AMOUNT(String COVERAGE_BRANCH_AMOUNT) {
        this.COVERAGE_BRANCH_AMOUNT = COVERAGE_BRANCH_AMOUNT;
    }

    public String getTOTAL_BRANCH_AMOUNT() {
        return TOTAL_BRANCH_NUM;
    }

    public void setTOTAL_BRANCH_AMOUNT(String TOTAL_BRANCH_AMOUNT) {
        this.TOTAL_BRANCH_NUM = TOTAL_BRANCH_AMOUNT;
    }

    public Double getCOVERAGE_BRAND_RATE() {
        return COVERAGE_BRAND_RATE;
    }

    public void setCOVERAGE_BRAND_RATE(double COVERAGE_BRAND_RATE) {
        this.COVERAGE_BRAND_RATE = COVERAGE_BRAND_RATE;
    }

    public String getTEST_TOOLS() {
        return TEST_TOOLS;
    }

    public void setTEST_TOOLS(String TEST_TOOLS) {
        this.TEST_TOOLS = TEST_TOOLS;
    }

    public String getFILE_TYPE() {
        return FILE_TYPE;
    }

    public void setFILE_TYPE(String FILE_TYPE) {
        this.FILE_TYPE = FILE_TYPE;
    }
}
