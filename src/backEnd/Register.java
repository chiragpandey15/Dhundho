package backEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Register
 */
@WebServlet("/Register")
public class Register extends HttpServlet {
	private static final long serialVersionUID = 1L; 
	String arr[]=new String[5];
    Scanner sc=new Scanner(System.in);
    
    public Register() 
    {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		// TODO Auto-generated method stub
		System.out.println("dopost is working");
		arr[0]=request.getParameter("name");
        arr[1] = request.getParameter("Number");
        arr[2]=request.getParameter("email_id");
        arr[3]=request.getParameter("Location");
		arr[4]= request.getParameter("pass");
		String x=request.getParameter("pass1");
		System.out.println(arr[4]+"   "+x);
		if(!x.equals(arr[4]));
		{
			response.setContentType("text/html");
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
			out.println("alert('Sorry Password Mismatch');");
			out.println("location='register.html';");
			out.println("</script>");
			
		}
		
		try
		{
			String res=insert();
			System.out.println("Ye result hai "+res);
			if(res.equals("successful"))
			{
				System.out.println("Me idher hu");
				Cookie cookie=new Cookie("ID",res);
				response.addCookie(cookie);
				HttpSession mySession= request.getSession();
				if (mySession== request.getSession(false))
				{
					DB.currentUserId=res;
					RequestDispatcher rd=request.getRequestDispatcher("/Feed");
					rd.forward(request, response);
				}
				else
				{
					response.setContentType("text/html");
					PrintWriter out = response.getWriter();
					out.println("<script type=\"text/javascript\">");
					out.println("alert('Some error occured');");
					out.println("location='register.html';");
					out.println("</script>");
				}
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Phone number is already taken. Please try to log in...');");
				out.println("location='register.html';");
				out.println("</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		//doGet(request, response);
	}
	
	protected String insert() throws Exception
	{
		DB acc=new DB();
		String res=acc.ConnectToDatabase(2,arr);
		return res;
	}

}
