package backEnd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Search
 */
@WebServlet("/Search")
public class Search extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	String Age,Gender;
    public Search() {
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
		 Gender=request.getParameter("Gender");
		 Age=request.getParameter("Age");
		 try
			{
				String res=insert();
				if(res.equals("successful"))
				{
					Feed obj=new Feed();
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
		String arr[]=new String[2];
		arr[0]=Gender;
		arr[1]=Age;
		System.out.println(arr[1]);
		DB acc=new DB();
		String res=acc.ConnectToDatabase(4,arr);
		return res;
	}
}
