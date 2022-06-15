package model;

public class ErrMsgLogic {

	public static String executePersonal(String name, String pref, String city) {
		String errMsg = "";
		if (name == null || name.length() == 0) {
			errMsg += "名前が入力されていません<br>";
		}
		if (pref == null || pref.length() == 0) {
			errMsg += "都道府県が入力されていません<br>";
		}
		if (city == null || city.length() == 0) {
			errMsg += "市区町村が入力されていません<br>";
		}
		return errMsg;
	}

	public static String executeAnswer(String ans) {
		String errMsg = "";
		if (ans == null || ans.length() == 0) {
			errMsg += "<br>※回答が入力されていません。<br>";
		}
		return errMsg;
	}
}
