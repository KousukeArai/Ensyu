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

/**
 * Servlet implementation class AnswerServlet
 */
@WebServlet("/AnswerServlet")
public class AnswerServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer.jsp");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/answer.jsp");
		dispatcher.forward(request, response);
	}

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		
		request.setCharacterEncoding("UTF-8");
		String ans = request.getParameter("ans");

		String errMsg = "";
		if (ans == null || ans.length() == 0) {
			errMsg += "回答が入力されていません<br>";
		}
		if (errMsg.length() != 0) {
			session.setAttribute("errMsg", errMsg);
			session.setAttribute("path", "/WEB-INF/jsp/answer.jsp");
			//ここをどうするか！！！！！！
			session.setAttribute("back", "戻る");
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/error.jsp");
			dispatcher.forward(request, response);
			session.removeAttribute("errMsg");
		}

		//セッションスコープの取得
		//HttpSession session = request.getSession();
		Integer cnt = (Integer) session.getAttribute("cnt");
		List<String> ansList = (List<String>) session.getAttribute("ansList");
		ansList.add(cnt, ans);
		cnt++;

		session.setAttribute("cnt", cnt);
		session.setAttribute("asnList", ansList);
		String path = "";
		if (cnt >= 5) {
			path = "/WEB-INF/jsp/result.jsp";
		} else {
			path = "/WEB-INF/jsp/answer.jsp";
			//path = "/answer.jsp";
		}

		//フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(path);
		dispatcher.forward(request, response);
	}

}
