package backEnd;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Fake
 */
@WebServlet("/Fake")
public class Fake extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String id,Desc;
  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Fake() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Fake.java is working");
		System.out.println("Hey There");
		 id=request.getParameter("ID");
		 Desc=request.getParameter("Desc");
		try
		{
			String res=insert();
			if(res.equals("successful"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/Feed");
				rd.forward(request, response);
			}
			else
			{
				response.setContentType("text/html");
				PrintWriter out = response.getWriter();
				out.println("<script type=\"text/javascript\">");
				out.println("alert('There is no such report ID');");
				out.println("location='Fake.html';");
				out.println("</script>");
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		doGet(request, response);
	}
	protected String insert() throws Exception
	{
		String arr[]=new String[3];
		arr[0]=id;
		arr[1]=Desc;
		System.out.println(arr[1]);
		DB acc=new DB();
		String res=acc.ConnectToDatabase(5,arr);
		return res;
	}
		
		
	

}
