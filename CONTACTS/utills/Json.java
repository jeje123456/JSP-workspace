package utills;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.Contact;

public class Json {
	
	private ContactJson contactJson;
	private Gson gson;
	private PrintWriter out;
	private HttpServletResponse response;
	
	public Json(HttpServletResponse response) {
		contactJson = new ContactJson();
		gson = new Gson();
		
		this.response = response;
		this.response.setContentType("application/json; charset=utf-8");
		
		try {
			out = response.getWriter();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void sendContact(Contact contact) {
		contactJson.setStatus(true);
		contactJson.setContact(contact);
		
		sendResponse(gson.toJson(contactJson));
	}
	
	public void sendMessage(boolean status, String message) {
		contactJson.setStatus(status);
		contactJson.setMessage(message);
		
		sendResponse(gson.toJson(contactJson));
	}
	
	private void sendResponse(String response) {
		out.print(response);
		out.flush();
	}

}
