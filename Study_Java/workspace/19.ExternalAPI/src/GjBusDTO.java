public class GjBusDTO {
	private String DIR_DOWN_NAME;
	private int RUN_INTERVAL;
	private String LAST_RUN_TIME;
	private int LINE_NUM;
	private String FIRST_RUN_TIME;
	private String DIR_UP_NAME;
	private int LINE_ID, LINE_KIND;
	private String LINE_NAME;
	
	public GjBusDTO() {}

	public GjBusDTO(String dIR_DOWN_NAME, int rUN_INTERVAL, String lAST_RUN_TIME, int lINE_NUM, String fIRST_RUN_TIME,
			String dIR_UP_NAME, int lINE_ID, int lINE_KIND, String lINE_NAME) {
		super();
		DIR_DOWN_NAME = dIR_DOWN_NAME;
		RUN_INTERVAL = rUN_INTERVAL;
		LAST_RUN_TIME = lAST_RUN_TIME;
		LINE_NUM = lINE_NUM;
		FIRST_RUN_TIME = fIRST_RUN_TIME;
		DIR_UP_NAME = dIR_UP_NAME;
		LINE_ID = lINE_ID;
		LINE_KIND = lINE_KIND;
		LINE_NAME = lINE_NAME;
	}

	public String getDIR_DOWN_NAME() {
		return DIR_DOWN_NAME;
	}

	public void setDIR_DOWN_NAME(String dIR_DOWN_NAME) {
		DIR_DOWN_NAME = dIR_DOWN_NAME;
	}

	public int getRUN_INTERVAL() {
		return RUN_INTERVAL;
	}

	public void setRUN_INTERVAL(int rUN_INTERVAL) {
		RUN_INTERVAL = rUN_INTERVAL;
	}

	public String getLAST_RUN_TIME() {
		return LAST_RUN_TIME;
	}

	public void setLAST_RUN_TIME(String lAST_RUN_TIME) {
		LAST_RUN_TIME = lAST_RUN_TIME;
	}

	public int getLINE_NUM() {
		return LINE_NUM;
	}

	public void setLINE_NUM(int lINE_NUM) {
		LINE_NUM = lINE_NUM;
	}

	public String getFIRST_RUN_TIME() {
		return FIRST_RUN_TIME;
	}

	public void setFIRST_RUN_TIME(String fIRST_RUN_TIME) {
		FIRST_RUN_TIME = fIRST_RUN_TIME;
	}

	public String getDIR_UP_NAME() {
		return DIR_UP_NAME;
	}

	public void setDIR_UP_NAME(String dIR_UP_NAME) {
		DIR_UP_NAME = dIR_UP_NAME;
	}

	public int getLINE_ID() {
		return LINE_ID;
	}

	public void setLINE_ID(int lINE_ID) {
		LINE_ID = lINE_ID;
	}

	public int getLINE_KIND() {
		return LINE_KIND;
	}

	public void setLINE_KIND(int lINE_KIND) {
		LINE_KIND = lINE_KIND;
	}

	public String getLINE_NAME() {
		return LINE_NAME;
	}

	public void setLINE_NAME(String lINE_NAME) {
		LINE_NAME = lINE_NAME;
	}
	
	
}
