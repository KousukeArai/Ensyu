package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.UserModel;

/**
 * Servlet implementation class TopServlet
 */
@WebServlet("/TopServlet")
public class TopServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		//問題リストと回答リストの要素取得のためのインデックスとなる数
		Integer cnt = 0;
		
		//リクエストパラメータを取得
		request.setCharacterEncoding("UTF-8");
		String name = request.getParameter("name");
		String pref = request.getParameter("pref");
		String city = request.getParameter("city");

		//個人情報をプロパティに設定
		UserModel userModel = new UserModel(name, pref, city);

		//質問文を持つリストの作成
		String q1 = name + "さんが、" + pref + city + "に住んでいる年数をお知らせください。";
		String q2 = "現在、" + pref + city + "が「充実している」と思うものをすべてお知らせください。";
		String q3 = "今後、" + pref + city + "が「改善すべき」と思うものをすべてお知らせください。";
		String q4 = "今後も" + pref + city + "に住み続けたいと思いますか。";
		String q5 = pref + city + "に対してご意見・ご要望がございましたら、ご自由にお書きください。";
		List<String> qList = new ArrayList<>();
		qList.add(q1);
		qList.add(q2);
		qList.add(q3);
		qList.add(q4);
		qList.add(q5);
		
		//回答を持つリストの作成
		List<String> ansList = new ArrayList<>();
		
		//セッションスコープにオブジェクトの保存
		HttpSession session = request.getSession();
		session.setAttribute("qList", qList);
		session.setAttribute("ansList", ansList);
		session.setAttribute("user", userModel);
		session.setAttribute("cnt", cnt);

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer.jsp");
		dispatcher.forward(request, response);
	}
}
