package by.iba.user01d.web.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import by.iba.user01d.common.*;

public class TeacherServlet extends HttpServlet {

	private static final long serialVersionUID = 6345194112526801506L;
	
	private final static List<Student> STUDENTS = new ArrayList<Student>();

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		req.setAttribute("students", STUDENTS);
		final RequestDispatcher dispatcher = req
				.getRequestDispatcher("/WEB-INF/jsp/index1.jsp");
		dispatcher.forward(req, resp);
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final int id = STUDENTS.size()+1;
		if(req.getParameter("formName").equals("add")){
			final String fname = req.getParameter("firstName");
			final String sname = req.getParameter("secondName");
			final String groupNumber = req.getParameter("groupNumber");	
			final int group = Integer.valueOf(groupNumber);
			final String format = "Name: %s, Second name: %s, Group Number: %d";
			System.out.println(String.format(format, fname, sname, group));
			STUDENTS.add(new Student(fname, sname, group,String.valueOf(id)));
			doGet(req, resp);
		}
		if(req.getParameter("formName").equals("delete")) {
					int rid=Integer.valueOf(req.getParameter("id"));
					STUDENTS.remove(rid-1);
					doGet(req,resp);
				}
			}
	}
