package Automation.framework.Utilities;

public enum ExecutionStatus {

	PASS("Pass"), FAIL("Fail"), INFO("Info"), WARNING("Warning");
	
	private String logtype;
	
	ExecutionStatus(String logtype) {
		this.logtype=logtype;
	}
	
	public String getStatus() {
		return logtype;
	}
	
	public String toString() {
		return logtype;
	}
}
