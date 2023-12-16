package com.bean;

public class ExamBean {

	private int eId;
	private String eName;
	private int perQuestionMarks;
	private int totalNoQues;
	private boolean isNag;
	private int subId;
	private String subName;

	public int getSubId() {
		return subId;
	}

	public void setSubId(int subId) {
		this.subId = subId;
	}

	public String getSubName() {
		return subName;
	}

	public void setSubName(String subName) {
		this.subName = subName;
	}

	public int geteId() {
		return eId;
	}

	public void seteId(int eId) {
		this.eId = eId;
	}

	public String geteName() {
		return eName;
	}

	public void seteName(String eName) {
		this.eName = eName;
	}

	public int getPerQuestionMarks() {
		return perQuestionMarks;
	}

	public void setPerQuestionMarks(int perQuestionMarks) {
		this.perQuestionMarks = perQuestionMarks;
	}

	public int getTotalNoQues() {
		return totalNoQues;
	}

	public void setTotalNoQues(int totalNoQues) {
		this.totalNoQues = totalNoQues;
	}

	public boolean isNag() {
		return isNag;
	}

	public void setNag(boolean isNag) {
		this.isNag = isNag;
	}

}
