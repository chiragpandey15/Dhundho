package backEnd;

import java.io.IOException;
import java.util.Scanner;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class UpdateReport
 */
@WebServlet("/UpdateReport")
public class UpdateReport extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
	String arr[]=new String[10];
    Scanner sc=new Scanner(System.in);   
    
    public UpdateReport() 
    {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		System.out.println("dopost is working");
		arr[0]=request.getParameter("ID");
		arr[1]=request.getParameter("Location");
        arr[2] = request.getParameter("Description");
        try
		{
			insert();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		doGet(request, response);
	}
	protected void insert() throws Exception
	{
		DB acc=new DB();
		String res=acc.ConnectToDatabase(4,arr);
		System.out.println(res);
		//doGet(request, response);
	}

}
