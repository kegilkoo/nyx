package org.nyx;

import java.io.File;
import java.lang.management.ManagementFactory;
import java.lang.management.OperatingSystemMXBean;

public class Info {


	private String userName;
	private long diskSize;
	private long maxMemory;
	private long memorySize;
	private OperatingSystemMXBean osBean;	
	
	@SuppressWarnings("restriction")
	public Info(){
		this.diskSize = new File("/").getTotalSpace();
		this.userName = System.getProperty("user.name");
		this.maxMemory = Runtime.getRuntime().maxMemory();
		this.memorySize = ((com.sun.management.OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean()).getTotalPhysicalMemorySize();
		this.osBean = ManagementFactory.getOperatingSystemMXBean();
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public long getDiskSize() {
		return diskSize;
	}

	public void setDiskSize(long diskSize) {
		this.diskSize = diskSize;
	}

	public long getMaxMemory() {
		return maxMemory;
	}

	public void setMaxMemory(long maxMemory) {
		this.maxMemory = maxMemory;
	}

	public long getMemorySize() {
		return memorySize;
	}

	public void setMemorySize(long memorySize) {
		this.memorySize = memorySize;
	}

	public OperatingSystemMXBean getOsbean() {
		return this.osBean;
	}

	public void setOsbean(OperatingSystemMXBean osBean) {
		this.osBean = osBean;
	}
	
	public static String humanReadableByteCount(long bytes, boolean si) {
	    int unit = si ? 1000 : 1024;
	    if (bytes < unit) return bytes + " B";
	    int exp = (int) (Math.log(bytes) / Math.log(unit));
	    String pre = (si ? "kMGTPE" : "KMGTPE").charAt(exp-1) + (si ? "" : "i");
	    return String.format("%.1f %sB", bytes / Math.pow(unit, exp), pre)
	}

	@Override
	public String toString() {
		return "Infos : " +
				"<br/>userName=" + getUserName() 
			  + "<br/>diskSize=" + humanReadableByteCount(getDiskSize(),false)
			  + "<br/>maxMemory=" + humanReadableByteCount(getMaxMemory(),false) 
			  + "<br/>memorySize=" + humanReadableByteCount(getMemorySize(),false)
			  + "<br/>Architecture=" + getOsbean().getArch()
			  + "<br/>Processors=" + getOsbean().getAvailableProcessors()
			  + "<br/>System Load Average=" + getOsbean().getSystemLoadAverage();
	}
	

}
