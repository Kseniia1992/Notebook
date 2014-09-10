package ua.cn.notebook.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ua.cn.notebook.domain.Users;
import ua.cn.notebook.service.UserService;

/**
 * Servlet
 * @author Kseniia
 *
 */
public class DBServlet extends HttpServlet{
	/**	 */
	private static final long serialVersionUID = 1L;
	
	/**	JSP page for adding of users */
	private static String INSERT = "/user.jsp";
    
	/**	JSP page for updating of users */
	private static String Edit = "/edit.jsp";
	
	/**	JSP page for listing of all users */
    private static String UserRecord = "/listUser.jsp";
    
    /**	JSP page for searching of users */
    private static String Search = "/search.jsp";
   
    /** Declaration a variable for the object type UserService*/
    private UserService us;

    /**
     * Constructor 
     */
    public DBServlet() {
        super();                //constructor of base class
        us = new UserService(); //initialization of UserService object
    }

    /**
     * Redefinition of doGet method 
     * @param request 
     * @param response 
     * @throws ServletException, IOException   
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String redirect="";
        String uId = request.getParameter("id");        
        String action = request.getParameter("action");
        if(!((uId)== null) && action.equalsIgnoreCase("insert"))
        {
                int id = Integer.parseInt(uId);
                Users user = new Users();
                user.setId(id);
                user.setSecondName(request.getParameter("secondName"));
                user.setFirstName(request.getParameter("firstName"));
                String uAge = request.getParameter("age");
                int age = Integer.parseInt(uAge);
                user.setAge(age);
                user.setGender(request.getParameter("gender"));
                user.setPhone(request.getParameter("phone"));
                us.addUser(user);
                redirect = UserRecord;
                request.setAttribute("users", us.getAllUsers());    
                System.out.println("Record Added Successfully");
        }
        else if (action.equalsIgnoreCase("delete")){
            String Id = request.getParameter("Id");
            int uid = Integer.parseInt(Id);
            us.removeUser(uid);
            redirect = UserRecord;
            request.setAttribute("users", us.getAllUsers());
            System.out.println("Record Deleted Successfully");
        }else if (action.equalsIgnoreCase("editform")){         
                redirect = Edit;            
        } else if (action.equalsIgnoreCase("edit")){
            String id = request.getParameter("id");
            int uid = Integer.parseInt(id);            
            Users user = new Users();
            user.setId(uid);
            user.setSecondName(request.getParameter("secondName"));
            user.setFirstName(request.getParameter("firstName"));
            String age = request.getParameter("age");
            int uAge = Integer.parseInt(age);
            user.setAge(uAge);
            user.setGender(request.getParameter("gender"));
            user.setPhone(request.getParameter("phone"));
            us.editUser(user);
            request.setAttribute("users", us.getAllUsers());
            redirect = UserRecord;
            System.out.println("Record updated Successfully");
         } else if (action.equalsIgnoreCase("listUser")){
            redirect = UserRecord;
            request.setAttribute("users", us.getAllUsers());
         }else if (action.equalsIgnoreCase("search")){
        	    redirect = Search;
        	    request.setAttribute("users", us.getAllUsers());        	 
         } else {
            redirect = INSERT;            
        }
        RequestDispatcher rd = request.getRequestDispatcher(redirect);
        rd.forward(request, response);
    }

    /**
     * Redefinition of doPost method
     * @param request 
     * @param response 
     * @throws ServletException, IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


