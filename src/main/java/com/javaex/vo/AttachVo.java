package com.javaex.vo;

public class AttachVo {

	private int no;
	private String orgName;
	private String saveName;
	private String filePath;
	private long filesize;

	public AttachVo() {

	}

	public AttachVo(String orgName, String saveName, String filePath, long filesize) {
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.filesize = filesize;
	}

	public AttachVo(int no, String orgName, String saveName, String filePath, long filesize) {
		this.no = no;
		this.orgName = orgName;
		this.saveName = saveName;
		this.filePath = filePath;
		this.filesize = filesize;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getOrgName() {
		return orgName;
	}

	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

	public String getSaveName() {
		return saveName;
	}

	public void setSaveName(String saveName) {
		this.saveName = saveName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public long getFilesize() {
		return filesize;
	}

	public void setFilesize(long filesize) {
		this.filesize = filesize;
	}

	@Override
	public String toString() {
		return "AttachVo [no=" + no + ", orgName=" + orgName + ", saveName=" + saveName + ", filePath=" + filePath
				+ ", filesize=" + filesize + "]";
	}

}
