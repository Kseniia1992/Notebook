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
 * Сервлет
 * @author Kseniia
 *
 */
public class DBServlet extends HttpServlet{
	/**	 */
	private static final long serialVersionUID = 1L;
	
	/**	JSP страница для добавления пользователя в базу данных */
	private static String INSERT = "/user.jsp";
    
	/**	JSP страница для обновления пользователя в базе данных */
	private static String Edit = "/edit.jsp";
	
	/**	JSP страница для отображения всех пользователей базы данных */
    private static String UserRecord = "/listUser.jsp";
    
    /**	JSP страница для поиска пользователей в базе данных */
    private static String Search = "/search.jsp";
   
    /** Объявление переменной для объектного типа UserService*/
    private UserService us;

    /**
     * Конструктор 
     */
    public DBServlet() {
        super();                //констрктор базового класса
        us = new UserService(); //объект UserService
    }

    /**
     * Переопределение метода doGet 
     * @param request запрос
     * @param response ответ
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
     * Переопределение метода doPost
     * @param request запрос
     * @param response ответ
     * @throws ServletException, IOException
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}


