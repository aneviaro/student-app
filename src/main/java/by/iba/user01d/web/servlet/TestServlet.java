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

import com.fasterxml.jackson.databind.ObjectMapper;

import by.iba.user01d.common.*;
import by.iba.user01d.dao.StudentDao;
import by.iba.user01d.reader.StudentReader;
import by.iba.user01d.writer.StudentWriter;

public class TestServlet extends HttpServlet {

	private static final long serialVersionUID = 6345194112526801506L;
	
	private StudentDao studentDao;
	private final ObjectMapper mapper = new ObjectMapper();
	@Override
	public void init() throws ServletException{
		// TODO Auto-generated method stub
		try{
			List<Student> students = new StudentReader("C:\\Users\\Student\\git\\student-app\\src\\main\\java\\resources\\students.csv").read();
			studentDao=new StudentDao(students);
		} catch(IOException e){
			
			throw new ServletException(e);
		}
		
	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		resp.setContentType("application/json");
		PrintWriter pw = resp.getWriter();
		pw.write(mapper.writeValueAsString(studentDao.findAll()));
		pw.close();
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		final String fname = req.getParameter("firstName");
		final String sname = req.getParameter("secondName");
		final String groupNumber = req.getParameter("groupNumber");	
		final int group = Integer.valueOf(groupNumber);
		studentDao.create(new Student(fname, sname, group,null));
		doGet(req, resp);
	}
	@Override
	public void destroy() {
		try{
		new StudentWriter("C:\\Users\\Student\\git\\student-app\\src\\main\\java\\resources\\students.csv").write(studentDao.findAll());
		}catch (IOException e){
			System.out.println("Error. Could not write");
		}
		
	}
}
//	private static String toJson(List<Student> students){
//		String result ="";
//		if(students!=null){
//			result="[";
//			boolean firstItem=true;
//			for(Student student : students){
//				if(!firstItem){
//					result+=", ";
//					
//				}
//				result+= toJson(student);
//				firstItem=false;
//			}
//			result+="]";
//		}
//		return result;
//	}
//	private static String toJson(Student student){
//		return "{" +
//					"\"id\": \"" + student.getId()+"\","+		
//					"\"firstName\": \"" + student.getFirstName()+"\","+		
//					"\"secondName\": \"" + student.getSecondName()+"\","+		
//					"\"avgMark\": \"" + student.getAvgMark()+"\","+		
//					"\"groupNumber\": \"" + student.getGroupNumber()+"\""+
//					"}";
//	}
//}
