package backEnd;


import java.io.IOException;

import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




/**
 * Servlet implementation class Feed
 */
@WebServlet("/Feed")
public class Feed extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String tab[][];
	int row;
	String id;
	ArrayList<Report> list=new ArrayList<>();
	ArrayList<Report> list2=new ArrayList<>();
    public Feed() 
    {
        super();
        list.clear();
        list=new ArrayList<>();
        System.out.println("servlet is working");
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
    	doGet(request,response);
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		response.setContentType("text/html");
	    PrintWriter out = response.getWriter();
	    
	    
	    out.println("<!DOCTYPE html>\n" + 
	    		"<html lang=\"en\">\n" + 
	    		"\n" + 
	    		"<head>\n" + 
	    		"    <meta charset=\"utf-8\">\n" + 
	    		"    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" + 
	    		"    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n" + 
	    		"    <meta name=\"description\" content=\"\">\n" + 
	    		"    <meta name=\"author\" content=\"\">\n" + 
	    		"    <link rel=\"icon\" type=\"image/png\" sizes=\"16x16\" href=\"download.jpeg\">\n" + 
	    		"    <title>Dhundho</title>\n" + 
	    		"        <link href=\"assets/node_modules/morrisjs/morris.css\" rel=\"stylesheet\">\n" + 
	    		"        <link href=\"assets/node_modules/c3-master/c3.min.css\" rel=\"stylesheet\">\n" + 
	    		"        <link href=\"dist/css/style.css\" rel=\"stylesheet\">\n" + 
	    		"    <link href=\"dist/css/pages/dashboard1.css\" rel=\"stylesheet\">\n" + 
	    		"</head>\n" + 
	    		"\n" + 
	    		"<body class=\"skin-default-dark fixed-layout\">\n" + 
	    		"    <div class=\"preloader\">\n" + 
	    		"        <div class=\"loader\">\n" + 
	    		"            <div class=\"loader__figure\"></div>\n" + 
	    		"            <p class=\"loader__label\">DHUNDHO</p>\n" + 
	    		"        </div>\n" + 
	    		"    </div>\n" + 
	    		"    <div id=\"main-wrapper\">\n" + 
	    		"             <header class=\"topbar\">\n" + 
	    		"            <nav class=\"navbar top-navbar navbar-expand-md navbar-dark\">\n" + 
	    		"                <div class=\"navbar-header\">\n" + 
	    		"                    <a class=\"navbar-brand\" href=\"index.html\">\n" + 
	    		"                        <b>\n" + 
	    		"                            <img src=\"assets/images/download.jpeg\" alt=\"homepage\" class=\"dark-logo\" style=\"width :50px\" />\n" + 
	    		"                            <p></p>\n" + 
	    		"                        </b>\n" + 
	    		"                        <span>\n" + 
	    		"                         <p style=\"color:black;\"><strong>DHUNDHO</strong></p>\n" + 
	    		"                          </div>\n" + 
	    		"               \n" + 
	    		"                <div class=\"navbar-collapse\">\n" + 
	    		"                   \n" + 
	    		"                    <ul class=\"navbar-nav mr-auto\">\n" + 
	    		"                        <li class=\"nav-item hidden-sm-up\"> <a class=\"nav-link nav-toggler waves-effect waves-light\" href=\"javascript:void(0)\"><i class=\"ti-menu\"></i></a></li>\n" + 
	    		"                        <li class=\"nav-item search-box\"> <a class=\"nav-link waves-effect waves-dark\" href=\"javascript:void(0)\"><i class=\"fa fa-search\"></i></a>\n" + 
	    		"                            <form class=\"app-search\">\n" + 
	    		"                                <input type=\"text\" class=\"form-control\" placeholder=\"Search &amp; enter\"> <a class=\"srh-btn\"><i class=\"fa fa-times\"></i></a>\n" + 
	    		"                            </form>\n" + 
	    		"                        </li>\n" + 
	    		"                    </ul>\n" + 
	    		"                    <ul class=\"navbar-nav my-lg-0\">\n" + 
	    		"                      \n" + 
	    		"                        <li class=\"nav-item dropdown\">\n" + 
	    		"                            <a class=\"nav-link dropdown-toggle text-muted waves-effect waves-dark\" href=\"\" data-toggle=\"dropdown\" aria-haspopup=\"true\" aria-expanded=\"false\"></a>\n" + 
	    		"                        </li>\n" + 
	    		"                    </ul>\n" + 
	    		"                </div>\n" + 
	    		"            </nav>\n" + 
	    		"        </header>\n" + 
	    		"        \n" + 
	    		"        <aside class=\"left-sidebar\">\n" + 
	    		"            <div class=\"d-flex no-block nav-text-box align-items-center\">\n" + 
	    		"                <span> <p style=\"color:White;\"><strong>DHUNDHO</strong></p></span>\n" + 
	    		"                <a class=\"waves-effect waves-dark ml-auto hidden-sm-down\" href=\"javascript:void(0)\"><i class=\"ti-menu\"></i></a>\n" + 
	    		"                <a class=\"nav-toggler waves-effect waves-dark ml-auto hidden-sm-up\" href=\"javascript:void(0)\"><i class=\"ti-menu ti-close\"></i></a>\n" + 
	    		"            </div>\n" + 
	    		"            				<div class=scroll-sidebar> \n" + 
	    		"	    		                <nav class=sidebar-nav> \n" + 
	    		"	    		                    <ul id=sidebarnav> \n" + 
	    		"	    		                         <li> <a class=\"waves-effect waves-dark\" href=\"Report.html\" aria-expanded=\"false\"><i class=\"fa fa-exclamation\"></i><span class=\"hide-menu\"></span>Report Someone</a></li> \n" + 
	    		"	    		                        <li> <a class=\"waves-effect waves-dark\" href=\"Update.html\" aria-expanded=\"false\"><i class=\"fa fa-user-circle-o\"></i><span class=\"hide-menu\">Update Report using ID</span></a></li>  \n" + 
	    		"	    		                        <li> <a class=\"waves-effect waves-dark\" href=\"Fake.html\" aria-expanded=\"false\"><i class=\"fa fa-question-circle\"></i><span class=\"hide-menu\"></span>Missing Report is fake?</a></li> \n" + 
	    		"	    		                        <li> <a class=\"waves-effect waves-dark\" href=\"Help.html\" aria-expanded=\"false\"><i class=\"fa fa-sign-out\"></i><span class=\"hide-menu\"></span>Help?</a></li> \n" + 
	    		"	    		                        <li> <a class=\"waves-effect waves-dark\" href=\"index.html\" aria-expanded=\"false\"><i class=\"fa fa-sign-out\"></i><span class=\"hide-menu\"></span>log-out</a></li>                   \n" + 
	    		"	    		                        </ul> \n" + 
	    		"	    		                  </nav>            \n" + 
	    		"	    		             </div>\n" + 
	    		"	    	\n" + 
	    		"         \n" + 
	    		"        </aside>" + 
	    		"        <div class=\"page-wrapper\">\n" + 
	    		"           <div class=\"container-fluid\">\n" + 
	    		"                <div class=\"row page-titles\">\n" + 
	    		"                    <div class=\"col-md-5 align-self-center\">\n" + 
	    		"                        <h4 class=\"text-themecolor\">DASHBOARD :Missing People</h4>\n" + 
	    		"                    </div>\n" + 
	    		"                    <div class=\"col-md-7 align-self-center text-right\">\n" + 
	    		"                        <div class=\"d-flex justify-content-end align-items-center\">\n" + 
	    		"                            <ol class=\"breadcrumb\">\n" + 
	    		"                                <li class=\"breadcrumb-item\"><a href=\"javascript:void(0)\">Home</a></li>\n" + 
	    		"                                <li class=\"breadcrumb-item active\">DASHBOARD :Missing People</li>\n" + 
	    		"                            </ol>\n" + 
	    		"                            \n" + 
	    		"                        </div>\n" + 
	    		"                    </div>\n" + 
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
			//System.out.println(list.get(i).getName());
			out.println(" <div class=\"row\">\n" + 
					"                    <div class=\"col-12\">\n" + 
					"                        <div class=\"card\">\n" + 
					"                            <div class=\"card-body\" align=\"left\">\n" + 
					"                               \n" + 
					"                                <div class=\"container\">\n" + 
					"                                \n" + 
					"                                 <div class=\"container-fluid\" align=\"right\" style=\"background-color:#FFFFFF; max-width:800px\">\n" + 
					"                                            \n" + 
					"                                            <img src="+list.get(i).getPhoto()+" alt=\"Avatar\" style=\"width:50%;float:right;\" ></div>\n" + 
					"                                             <div>\n" + 
					"");
			

			out.println("<h5><b>PERSON REPORTED MISSING</b></h5>\n" + 
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
	    			out.println("UPDATES:\n");
	    		for(int j=0;j<list2.size();j++)
	    		{
	    			
	    			out.println("<p>Location last seen at:"+list2.get(j).getLoc()+ "</p>\n" + 
	    					"	<p>Description:"+list2.get(j).getDesc()+ "</p>\n");
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
	    	
	    
		// TODO Auto-generated method stub
		
	}

	public void print() throws Exception
	{
		//System.out.println("starts");
		DB acc = new DB();
		String arr[]=new String[1];
		arr[0]=id;
		String row1=acc.ConnectToDatabase(6,arr);
		int row=Integer.parseInt(row1);
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
		String row1=acc.ConnectToDatabase(8,arr);
		int row=Integer.parseInt(row1);
		list2.clear();
		
		for(int i=0;i<row;i++)
		{
    	list2.add(new Report(acc.upd.get(i).getID(),acc.upd.get(i).getDesc(),acc.upd.get(i).getLoc()));
       }
		
  }
}
