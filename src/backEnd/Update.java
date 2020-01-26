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
 * Servlet implementation class Update
 */
@WebServlet("/Update")
public class Update extends HttpServlet {
	private static final long serialVersionUID = 1L;
    String id,Loc,Desc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Update() {
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
		System.out.println("dopost is working");
		System.out.println("Hey There");
		 id=request.getParameter("ID");
		 Loc=request.getParameter("Loc");
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
				out.println("location='Update.html';");
				out.println("</script>");
			}
				//response.sendRedirect("Register.html");
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
		arr[1]=Loc;
		arr[2]=Desc;
		System.out.println(arr[1]);
		DB acc=new DB();
		String res=acc.ConnectToDatabase(4,arr);
		return res;
	}
}
