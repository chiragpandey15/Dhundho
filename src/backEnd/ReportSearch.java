package backEnd;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ReportSearch
 */
@WebServlet("/ReportSearch")
public class ReportSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
      String Gender,Age;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportSearch() {
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
		System.out.println("Search working");
		Gender=request.getParameter("Gender");
		Age=request.getParameter("Age");
		if(Age==null && Gender!=null)
		{
			System.out.println("Abe Gender!!");
		}
		else if(Age!=null & Gender==null)
		{
			System.out.println("Abe Age!!");
		}
		else if(Age!=null && Gender!=null)
		{
			System.out.println("Abe!!");
		}
		else
		{
			System.out.println("Abe kuch to daal!!");
		}
		doGet(request, response);
	}

}
