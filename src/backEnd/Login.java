package backEnd;

import java.io.IOException;
import java.io.PrintWriter;


import javax.servlet.http.Cookie;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
    public static String Phone,Pwd; 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub;
    }
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		
		// TODO Auto-generated method stub
		System.out.println("dopost is working");
        Phone = request.getParameter("Phone");
		Pwd = request.getParameter("pass");
		try
		{
			String res=insert();
			//System.out.println("Result="+res);
			int flag=res.indexOf('-');
			if(!res.equals("0"))
			{
				if(flag==-1)
				{
					
					HttpSession mySession= request.getSession();
					if (mySession== request.getSession(false)) {
						DB.currentUserId=res;
						Cookie ck=new Cookie("ID",res);
						ck.setMaxAge(60*60*24);
						response.addCookie(ck);
						RequestDispatcher rd=request.getRequestDispatcher("/Feed");
						rd.forward(request, response);
					}
					else
					{
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Some error occured');");
						out.println("location='Login.html';");
						out.println("</script>");
					}
				}
				else
				{
					
					res=res.substring(1);
					
					DB.currentUserId=res;
					HttpSession mySession= request.getSession();
					if (mySession== request.getSession(false))
					{
						Cookie ck=new Cookie("ID",res);
						response.addCookie(ck);
						ck.setMaxAge(60*60*24);
						RequestDispatcher rd=request.getRequestDispatcher("/Admin");
						rd.forward(request, response);
					}
					else
					{
						response.setContentType("text/html");
						PrintWriter out = response.getWriter();
						out.println("<script type=\"text/javascript\">");
						out.println("alert('Some error occured');");
						out.println("location='Login.html';");
						out.println("</script>");
					}
				}
				
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('Incorrect Login credentials');");
				out.println("location='Login.html';");
				out.println("</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected String insert() throws Exception
	{
		String arr[]=new String[2];
		arr[0]=Phone;
		arr[1]=Pwd;
		DB acc=new DB();
		String res=acc.ConnectToDatabase(1,arr);
		return res;
			
	}

}
