package model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Question implements Serializable{
	private List<String> qList = new ArrayList<>();
	
	public Question(String name, String pref, String city) {
		//質問文を持つリストの作成
		String q1 = name + "さんが、" + pref + city + "に住んでいる年数をお知らせください。";
		String q2 = "現在、" + pref + city + "が「充実している」と思うことをお書きください。";
		String q3 = "今後、" + pref + city + "が「改善すべき」と思うことをお書きください。";
		String q4 = "今後も" + pref + city + "に住み続けたいと思いますか。";
		String q5 = pref + city + "に対してご意見・ご要望がございましたら、ご自由にお書きください。";
		qList.add(q1);
		qList.add(q2);
		qList.add(q3);
		qList.add(q4);
		qList.add(q5);
	}
	
	public List<String> getQustion(){
		return this.qList;
	}
}
