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
		String emailResponse=request.getParameter("input_message");
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
		String senderEmail = PropertyReader.getInstance().getProperty("emailAccount");
		String senderPassword = PropertyReader.getInstance().getProperty("emailPassword");
		System.out.println(senderEmail);
		System.out.println(senderPassword);
		
		//Luodaan EmailTools-olio, joka lähettää sähköpostin haluttuun osoitteeseen
		EmailTools email = new EmailTools();
		if(senderEmail == null || senderPassword == null || emailResponse == null ){
			System.out.println("AAAAAAAAAASD");
			System.out.println(senderEmail);
			System.out.println(senderPassword);
			System.out.println(emailResponse);
		}
		email.sendEmail(senderEmail, senderPassword, receiver,  "Palaute", emailResponse +"\n"+ receiver);
		
		//Välitys seuraavalle jsp-sivulle
		rd = request.getRequestDispatcher("confirmation.jsp");
		rd.forward(request, response);
	}
}