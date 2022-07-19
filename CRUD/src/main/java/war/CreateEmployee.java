package war;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.CreateLogic;
import logic.ListLogic;

public class CreateEmployee extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		JSONObject jo = new JSONObject();
		try {
			BufferedReader reader = req.getReader();
			jo = JsonController.Controller(reader);/*
													 * Converting the request to JSON format from BufferReader and
													 * return the JSON value
													 */
			int employeeCode = Integer.parseInt(jo.get("employeeCode").toString());
			String employeeName = jo.get("employeeName").toString();
			String Designation = jo.get("Designation").toString();
			Double Salary = Double.parseDouble(jo.get("Salary").toString());
			out.println(CreateLogic.database(employeeCode, employeeName, Designation, Salary));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
