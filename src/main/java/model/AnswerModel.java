package model;

import java.io.Serializable;

public class AnswerModel implements Serializable{
	
	private int count;
	private String ans;
	
	
	public AnswerModel() {}
	public AnswerModel(int count, String ans) {
		this.count = count;
		this.ans = ans;
	}
}
