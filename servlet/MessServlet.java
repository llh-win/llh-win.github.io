package servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

@WebServlet("/mes/*")
public class MessServlet extends BaseServlet {
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

    public void getMessage(HttpServletRequest req, HttpServletResponse resp){
    	try {
			req.setCharacterEncoding("utf-8");
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	 HttpSession session = req.getSession();
       System.out.println("jinlaile ");
        String name = req.getParameter("name");
        String message = req.getParameter("message");
        System.out.println("游客:"+name+"*********留言内容："+message);
        req.getSession().setAttribute("name",name);
        req.getSession().setAttribute("message",message);
        try {
			req.getRequestDispatcher("/admin/showMeg.jsp").forward(req,resp);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
