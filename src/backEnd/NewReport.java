package backEnd;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class NewReport
 */
@WebServlet("/NewReport")
public class NewReport extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	String Name,Age,Height,Location,Gender,Desc,Image;
    public NewReport() {
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
        Name = request.getParameter("Name");
		Age = request.getParameter("age");
		Height = request.getParameter("Height");
		Location = request.getParameter("Loc");
		Gender = request.getParameter("Gender");
		Desc = request.getParameter("Desc");
		Image=request.getParameter("Upload");
		try
		{
			String res=insert();
			if(res.equals("successful"))
			{
				RequestDispatcher rd=request.getRequestDispatcher("/Feed");
				rd.forward(request, response);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
	protected String insert() throws Exception
	{
		String arr[]=new String[7];
		arr[0]=Name;
		arr[1]=Age;
		arr[2]=Height;
		arr[3]=Gender;
		arr[4]=Location;
		arr[5]=Desc;
		arr[6]=Image;
		
		System.out.println(arr[0]);
		DB acc=new DB();
		String res=acc.ConnectToDatabase(3,arr);
		return res;
			
	}


}
