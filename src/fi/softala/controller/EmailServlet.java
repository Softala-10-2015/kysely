package fi.softala.controller;

import java.io.IOException;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fi.softala.helpers.EmailTools;
import fi.softala.helpers.PropertyReader;

/**
 * Servlet implementation class EmailServlet
 */
@WebServlet("/email")
public class EmailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private RequestDispatcher rd;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		rd = request.getRequestDispatcher("survey.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Haetaan käyttäjän syöttämä tieto
		String emailResponse=request.getParameter("InputMessage");
		String receiver = request.getParameter("receiver");
		
		Map<String, String[]> parameterMap = request.getParameterMap();
		String fullInfo="";
		for (Map.Entry<String, String[]> entry : parameterMap.entrySet()) {
		    String key = entry.getKey();
		    String[] value = entry.getValue();
		    fullInfo+=key+"   "+value[0]+"\n";
		} 
		System.out.println(fullInfo);
		
		//Haetaan tunnukset property filestä
		String acc = PropertyReader.getInstance().getProperty("email_account");
		String pwd = PropertyReader.getInstance().getProperty("email_password");
		System.out.println(acc);
		System.out.println(pwd);
		
		//Luodaan EmailTools-olio, joka lähettää sähköpostin haluttuun osoitteeseen
		EmailTools email = new EmailTools();
		email.lahetaSahkoposti(acc, pwd, receiver,  "Palaute", emailResponse);
		
		//Välitys seuraavalle jsp-sivulle
		rd = request.getRequestDispatcher("confirmation.jsp");
		rd.forward(request, response);
	}
}