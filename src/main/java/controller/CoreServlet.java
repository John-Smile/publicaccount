package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import service.CoreService;
import util.SignUtil;

public class CoreServlet extends HttpServlet {

	private static final long serialVersionUID = 5897779749298272507L;
	private static final String ENCODING_UFT8 = "UTF-8";
	private static final String PARAM_SIGNATURE = "signature";
	private static final String PARAM_TIMESTAMP = "timestamp";
	private static final String PARAM_NONCE = "nonce";
	private static final String PARAM_ECHOSTR = "echostr";
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String signature = request.getParameter(PARAM_SIGNATURE);
		String timestamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		String echostr = request.getParameter(PARAM_ECHOSTR);
		PrintWriter out = response.getWriter();
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			out.print(echostr);
		}
		out.close();
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding(ENCODING_UFT8);
		response.setCharacterEncoding(ENCODING_UFT8);
		
		String signature = request.getParameter(PARAM_SIGNATURE);
		String timestamp = request.getParameter(PARAM_TIMESTAMP);
		String nonce = request.getParameter(PARAM_NONCE);
		
		PrintWriter out = response.getWriter();
		if (SignUtil.checkSignature(signature, timestamp, nonce)) {
			String respXml = CoreService.processRequest(request);
			out.print(respXml);
		}
		out.close();
	}
}
