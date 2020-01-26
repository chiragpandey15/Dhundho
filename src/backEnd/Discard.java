package backEnd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Discard
 */
@WebServlet("/Discard")
public class Discard extends HttpServlet {
	private static final long serialVersionUID = 1L;
     String ID;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Discard() {
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
		 ID=request.getParameter("ID");
		try
		{
			String res=insert();
			if(res.equals("Discard"))
			{
				Admin obj=new Admin();
				obj.doGet(request, response);
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
		arr[0]=ID;
		System.out.println(arr[1]);
		DB acc=new DB();
		String res=acc.ConnectToDatabase(12,arr);
		return res;
	}

}
