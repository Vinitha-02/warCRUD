package war;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import org.json.simple.JSONObject;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import logic.DeleteLogic;

public class DeleteEmployee extends HttpServlet {
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException {
		res.setContentType("application/json");
		PrintWriter out = res.getWriter();
		try {
			BufferedReader reader = req.getReader();
			JSONObject jo = JsonController.Controller(reader);/*
																 * Converting the request to JSON format from
																 * BufferReader and return the JSON value
																 */
			int employeeCode = Integer.parseInt(jo.get("employeeCode").toString());
			out.println(DeleteLogic.delete(employeeCode));
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}
