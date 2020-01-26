package backEnd;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Admin
 */
@WebServlet("/Admin")
public class Admin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	public String tab[][];
	int row;
	ArrayList<Report> list=new ArrayList<>();
	ArrayList<String> list2=new ArrayList<>();
    public Admin() {
        super();
        list.clear();
        list=new ArrayList<>();
        System.out.println("servlet is working");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Welcome to Admin Portal");
		System.out.println("Hey there");
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    out.println("<!DOCTYPE html>\r\n" + 
	    		"<html lang=\"en\">\r\n" + 
	    		"\r\n" + 
	    		"<head>\r\n" + 
	    		"    <meta charset=\"utf-8\">\r\n" + 
	    		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\r\n" + 
	    		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n" + 
	    		"    <meta name=\"description\" content=\"\">\r\n" + 
	    		"    <meta name=\"author\" content=\"\">\r\n" + 
	    		"    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"download.jpeg\">\r\n" + 
	    		"    <title>Dhundho</title>\r\n" + 
	    		"        <link href=\"assets/node_modules/morrisjs/morris.css\" rel=\"stylesheet\">\r\n" + 
	    		"        <link href=\"assets/node_modules/c3-master/c3.min.css\" rel=\"stylesheet\">\r\n" + 
	    		"        <link href=\"dist/css/style.css\" rel=\"stylesheet\">\r\n" + 
	    		"    <link href=\"dist/css/pages/dashboard1.css\" rel=\"stylesheet\">\r\n" + 
	    		"</head>\r\n" + 
	    		"\r\n" + 
	    		"<body class=\"skin-default-dark fixed-layout\">\r\n" + 
	    		"    <div class=\"preloader\">\r\n" + 
	    		"        <div class=\"loader\">\r\n" + 
	    		"            <div class=\"loader__figure\"></div>\r\n" + 
	    		"            <p class=\"loader__label\">DHUNDHO</p>\r\n" + 
	    		"        </div>\r\n" + 
	    		"    </div>\r\n" + 
	    		"    <div id=\"main-wrapper\">\r\n" + 
	    		"             <header class=\"topbar\">\r\n" + 
	    		"            <nav class=\"navbar top-navbar navbar-expand-md navbar-dark\">\r\n" + 
	    		"                <div class=\"navbar-header\">\r\n" + 
	    		"                    <a class=\"navbar-brand\" href=\"index.html\">\r\n" + 
	    		"                        <b>\r\n" + 
	    		"                            <img src=\"assets/images/download.jpeg\" alt=\"homepage\" class=\"dark-logo\" style=\"width :50px\" />\r\n" + 
	    		"                            <p></p>\r\n" + 
	    		"                        </b>\r\n" + 
	    		"                        <span>\r\n" + 
	    		"                         <p style=\"color:black;\"><strong>DHUNDHO</strong></p>\r\n" + 
	    		"                          </div>\r\n" + 
	    		"               \r\n" + 
	    		"                <div class=\"navbar-collapse\">\r\n" + 
	    		"                   \r\n" + 
	    		"                    <ul class=\"navbar-nav mr-auto\">\r\n" + 
	    		"                        <li class=\"nav-item hidden-sm-up\"> <a class=\"nav-link nav-toggler waves-effect waves-light\" href=\"javascript:void(0)\"><i class=\"ti-menu\"></i></a></li>\r\n" + 
	    		"                        <li class=\"nav-item search-box\"> <a class=\"nav-link waves-effect waves-dark\" href=\"javascript:void(0)\"><i class=\"fa fa-search\"></i></a>\r\n" + 
	    		"                            <form class=\"app-search\">\r\n" + 
	    		"                                <input type=\"text\" class=\"form-control\" placeholder=\"Search &amp; enter\"> <a class=\"srh-btn\"><i class=\"fa fa-times\"></i></a>\r\n" + 
	    		"                            </form>\r\n" + 
	    		"                        </li>\r\n" + 
	    		"                    </ul>\r\n" + 
	    		"                    <ul class=\"navbar-nav my-lg-0\">\r\n" + 
	    		"                      \r\n" + 
	    		"                        <li class=\"nav-item dropdown\">\r\n" + 
	    		"                            <a class=\"nav-link dropdown-toggle text-muted waves-effect waves-dark\" href=\"\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"></a>\r\n" + 
	    		"                        </li>\r\n" + 
	    		"                    </ul>\r\n" + 
	    		"                </div>\r\n" + 
	    		"            </nav>\r\n" + 
	    		"        </header>\r\n" + 
	    		"        \r\n" + 
	    		"        <aside class=\"left-sidebar\">\r\n" + 
	    		"            <div class=\"d-flex no-block nav-text-box align-items-center\">\r\n" + 
	    		"                <span> <p style=\"color:White;\"><strong>DHUNDHO</strong></p></span>\r\n" + 
	    		"                <a class=\"waves-effect waves-dark ml-auto hidden-sm-down\" href=\"javascript:void(0)\"><i class=\"ti-menu\"></i></a>\r\n" + 
	    		"                <a class=\"nav-toggler waves-effect waves-dark ml-auto hidden-sm-up\" href=\"javascript:void(0)\"><i class=\"ti-menu ti-close\"></i></a>\r\n" + 
	    		"            </div>\r\n" + 
	    		"            \r\n" + 
	    		"            <div class=\"scroll-sidebar\">\r\n" + 
	    		"                <nav class=\"sidebar-nav\">\r\n" + 
	    		"                    <ul id=\"sidebarnav\">\r\n" + 
	    		"                        <li> <a class=\"waves-effect waves-dark\" href=\"Fallegation.html\" aria-expanded=\"false\"><i class=\"fa fa-id-card\"></i><span class=\"hide-menu\">False Allegation</span></a></li>\r\n" + 
	    		"                        <li> <a class=\"waves-effect waves-dark\" href=\"delete.html\" aria-expanded=\"false\"><i class=\"fa fa-id-card\"></i><span class=\"hide-menu\">Approved Fake</span></a></li>\r\n" + 
	    		"                         <li> <a class=\"waves-effect waves-dark\" href=\"index.html\" aria-expanded=\"false\"><i class=\"fa fa-sign-out\"></i><span class=\"hide-menu\"></span>log-out</a></li>\r\n" + 
	    		"                       \r\n" + 
	    		"                    </ul>\r\n" + 
	    		"                </nav>\r\n" + 
	    		"             \r\n" + 
	    		"            </div>\r\n" + 
	    		"         \r\n" + 
	    		"        </aside>\r\n" + 
	    		"        \r\n" + 
	    		"        <div class=\"page-wrapper\">\r\n" + 
	    		"           <div class=\"container-fluid\">\r\n" + 
	    		"                <div class=\"row page-titles\">\r\n" + 
	    		"                    <div class=\"col-md-5 align-self-center\">\r\n" + 
	    		"                        <h4 class=\"text-themecolor\">DASHBOARD :Reported Fake</h4>\r\n" + 
	    		"                    </div>\r\n" + 
	    		"                    <div class=\"col-md-7 align-self-center text-right\">\r\n" + 
	    		"                        <div class=\"d-flex justify-content-end align-items-center\">\r\n" + 
	    		"                            <ol class=\"breadcrumb\">\r\n" + 
	    		"                                <li class=\"breadcrumb-item\"><a href=\"javascript:void(0)\">Home</a></li>\r\n" + 
	    		"                                <li class=\"breadcrumb-item active\">DASHBOARD :Reported Fake</li>\r\n" + 
	    		"                            </ol>\r\n" + 
	    		"                            \r\n" + 
	    		"                        </div>\r\n" + 
	    		"                    </div>\r\n" + 
	    		"                </div>");
	    try 
	    {
	    	
			print();
		}
	    catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i=0;i<list.size();i++) 
	    {
			System.out.println(list.get(i).getName());
			out.println("<div class=\"row\">\r\n" + 
					"                    <div class=\"col-12\">\r\n" + 
					"                        <div class=\"card\">\r\n" + 
					"                            <div class=\"card-body\" align=\"left\">\r\n" + 
					"                               \r\n" + 
					"                                <div class=\"container\">\r\n" + 
					"                                \r\n" + 
					"                                 <div class=\"container-fluid\" align=\"right\" style=\"background-color:#FFFFFF; max-width:800px\">\r\n" + 
					"                                            \r\n" + 
					"                                            <img src="+list.get(i).getPhoto()+" alt=\"Avatar\" style=\"width:50%;float:right;\" ></div>\r\n" + 
					"                                             <div>");
			out.println("<h5><b>REPORTED FAKE</b></h5>\n" + 
					"											<p>Report ID:"+list.get(i).getID()+"</p>\n"+
					"                                            <p>Name:"+list.get(i).getName()+ "</p>\n" + 
					"                                            <p>Gender:"+list.get(i).getGender()+ "</p>\n" + 
					"                                         <p>Estimated height:"+list.get(i).getHeight()+"</p>\n" + 
					"                                          <p>Estimated age:"+list.get(i).getAge()+"</p>\n" + 
					"                                           <p>Location last seen at:"+list.get(i).getLoc()+ "</p>\n" + 
					"                                            <p>Description:"+list.get(i).getDesc()+ "</p>\n" + 
					"                                            \n" + 
					"  \n" + 
					"");
			try {
					updates(list.get(i).getID());
					if(list2.size()>0)
						out.println("REASON:\n");
					for(int j=0;j<list2.size();j++)
					{
	    			
						out.println("<p>"+list2.get(j)+ "</p>\n" );
					}
					out.println("</div>\n" +  
						"                                        </div>\n" + 
						"                                </div>\n" + 
						"                            </div>\n" + 
						"                        </div>\n" + 
						"                    </div>\n" + 
						"                </div>\n" + 
						"                           </div>\n" + 
 
						"    </div>\n" );

	    		}
	    		catch(Exception e)
	    		{
	    			e.printStackTrace();
	    		}
	    }
			out.println( 
					
					"    <script src=\"assets/node_modules/jquery/jquery-3.2.1.min.js\"></script>\n" + 
					"\n" + 
					"    <script src=\"assets/node_modules/popper/popper.min.js\"></script>\n" + 
					"    <script src=\"assets/node_modules/bootstrap/dist/js/bootstrap.min.js\"></script>\n" + 
					"    <script src=\"dist/js/perfect-scrollbar.jquery.min.js\"></script>\n" + 
					"    <script src=\"dist/js/waves.js\"></script>\n" + 
					"    <script src=\"dist/js/sidebarmenu.js\"></script>\n" + 
					"    <script src=\"dist/js/custom.min.js\"></script>\n" + 
					"    <script src=\"assets/node_modules/raphael/raphael-min.js\"></script>\n" + 
					"    <script src=\"assets/node_modules/morrisjs/morris.min.js\"></script>\n" + 
					"    <script src=\"assets/node_modules/jquery-sparkline/jquery.sparkline.min.js\"></script>\n" + 
					"    <script src=\"assets/node_modules/d3/d3.min.js\"></script>\n" + 
					"    <script src=\"assets/node_modules/c3-master/c3.min.js\"></script>\n" + 
					"    <script src=\"dist/js/dashboard1.js\"></script>\n" + 
					"</body>\n" + 
					"\n" + 
					"</html>");
	   
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

	public void print() throws Exception
	{
		System.out.println("starts");
		DB acc = new DB();
		String arr[]=new String[1];
		String row1=acc.ConnectToDatabase(9,arr);
		int row=Integer.parseInt(row1);
		System.out.println(row);
		list.clear();
		for(int i=0;i<row;i++)
		{
    	list.add(new Report(acc.rep.get(i).getID(),acc.rep.get(i).getName(),acc.rep.get(i).getHeight(),acc.rep.get(i).getAge(),acc.rep.get(i).getDesc(),acc.rep.get(i).getGender(),acc.rep.get(i).getLoc(),acc.rep.get(i).getPhoto()));
       }
		
  }
	public void updates(int id) throws Exception
	{
		System.out.println("starts");
		DB acc = new DB();
		String arr[]=new String[1];
    	arr[0]=String.valueOf(id);
		String row1=acc.ConnectToDatabase(10,arr);
		int row=Integer.parseInt(row1);
		list2.clear();
		
		for(int i=0;i<row;i++)
		{
    	list2.add(new String(acc.des.get(i)));
       }
		
  }
}
