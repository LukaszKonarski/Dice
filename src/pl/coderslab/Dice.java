package pl.coderslab;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/dice")
public class Dice extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		Random r = new Random();
		int x = r.nextInt(6) + 1;
		String param = String.valueOf(x);

		HttpSession sess = request.getSession();

		if (sess.getAttribute("toss") == null) {
			Map<Integer, Integer> results = new HashMap<>();
			for(int i= 1; i<=6; i++) {
				results.put(i, 0);
			}
			int counter = 1;
			results.put(x, counter);
			sess.setAttribute("toss", results);

		} else {
			Map<Integer, Integer> results = (Map<Integer, Integer>) sess.getAttribute("toss");
			if(results.get(x)==0) {
				int counter =1;
				results.put(x, counter);
			} else {
				int counter = (results.get(x))+1;
				results.put(x, counter);
			}
			
			sess.setAttribute("toss", results);
		}
		
		request.setAttribute("currrentResult", param);
		RequestDispatcher rd = request.getRequestDispatcher("views/diceView.jsp");
		rd.forward(request, response);

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

}
