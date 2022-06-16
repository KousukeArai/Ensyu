package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ErrMsgLogic;

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//回答用ページへのフォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer.jsp");
		dispatcher.forward(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		//セッションスコープの取得
		HttpSession session = request.getSession();
		request.setCharacterEncoding("UTF-8");

		//入力した回答の取得
		String ans = request.getParameter("ans");
		List<String> qList = (List<String>) session.getAttribute("qList");
		Integer cnt = (Integer) session.getAttribute("cnt");
		String path = "";

		//回答がnullだった際の処理
		String errMsgText = ErrMsgLogic.executeAnswer(ans);

		//エラーメッセージの有無による条件分岐
		//エラーメッセージがあればerror.jspへ。なければ次へ
		if (errMsgText.length() != 0) {
			String errMsg = "Q" + (cnt + 1) + ". " + qList.get(cnt) + errMsgText;
			session.setAttribute("errMsg", errMsg);
			session.setAttribute("path", "/Ensyu/AnswerServlet");
			/*			
			 
			 		 ここをどうするか！！！！！！
					↑answer.jspを改変し、getでAnswerServletに飛ばしてdoGetで処理してもらう方針になりました。
					これでanswer.jspをWEB-INF直下に置いて直接アクセスされる、ということを避けることができます。
					また、「戻る」を押しても次の問題に進んでしまうという不具合ですが、
					原因は先日話した「return後の処理が通らないように、forward後の処理を通らない」
					というドヤ顔で語っていた私の大きな間違いから生じたものでした。大変失礼しました。
					正しくは、forwardの後も処理が走り、それが原因でcntの値が増えていました。
					解決のために下にもありますが、returnを使って処理を終了しています。
					 
			*/
			session.setAttribute("back", "戻る");
			path = "/WEB-INF/jsp/error.jsp";
			//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			//dispatcher.forward(request, response);
			//session.removeAttribute("errMsg");

			//処理を終了するためにreturnする
			//return;
		} else {
			//問題と回答を格納するリストのインデックスの数字に1追加し、スコープに保存して次の回答ページへ
			List<String> ansList = (List<String>) session.getAttribute("ansList");
			ansList.add(cnt, ans);
			cnt++;
			session.setAttribute("cnt", cnt);
			session.setAttribute("asnList", ansList);
			//String path = "";
			if (cnt >= qList.size()) {
				path = "/WEB-INF/jsp/result.jsp";
			} else {
				path = "/WEB-INF/jsp/answer.jsp";
			}
		}

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
