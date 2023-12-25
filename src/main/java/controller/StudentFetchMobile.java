package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.StudentDao;
import dto.Student;

@WebServlet("/fetchmobile")
public class StudentFetchMobile extends HttpServlet
{
@Override
protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	long mobile=Long.parseLong(req.getParameter("mob"));
	
	StudentDao dao=new StudentDao();
	PrintWriter out=resp.getWriter();
	List<Student> list=dao.fetchByMobile(mobile);
	if(list.isEmpty())
	{
		out.print("<h1>Data Not found check Mobile Number</h1>");
	}
	else {
	out.print("<h1>Student Details</h1>");
	
	out.print("<table border='1'>");
	
	out.print("<tr>");
	out.print("<th>ID</th>");
	out.print("<th>Name</th>");
	out.print("<th>Mobile</th>");
	out.print("<th>Email</th>");
	out.print("<th>Date of Birth</th>");
	out.print("<th>Gender</th>");
	out.print("<th>Country</th>");
	out.print("<th>Address</th>");
	out.print("<th>Age</th>");
	out.print("<th>Hobbies</th>");
	out.print("</tr>");
	
	for(Student student:list)
	{
		out.print("<tr>");
		out.print("<td>"+student.getId()+"</td>");
		out.print("<td>"+student.getName()+"</td>");
		out.print("<td>"+student.getMobile()+"</td>");
		out.print("<td>"+student.getEmail()+"</td>");
		out.print("<td>"+student.getDob()+"</td>");
		out.print("<td>"+student.getGender()+"</td>");
		out.print("<td>"+student.getCountry()+"</td>");
		out.print("<td>"+student.getAddress()+"</td>");
		out.print("<td>"+student.getAge()+"</td>");
		out.print("<td>"+Arrays.toString(student.getHobbies())+"</td>");
		out.print("</tr>");
	}
		
	out.print("</table>");
	}
}
}
