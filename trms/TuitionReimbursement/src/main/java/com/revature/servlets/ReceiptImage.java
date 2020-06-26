//package com.revature.servlets;
//
//import java.io.IOException;
//import java.io.InputStream;
//import java.io.OutputStream;
//
//import javax.servlet.ServletException;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
//import org.apache.commons.io.IOUtils;
//
//import com.revature.service.RequestService;
//
///**
// * Servlet implementation class ReceiptImage
// */
//public class ReceiptImage extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//	RequestService req = new RequestService();
//    /**
//     * Default constructor. 
//     */
//    public ReceiptImage() {
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		InputStream is = null;
//		int requestNum = Integer.parseInt(request.getParameter("requestNumber"));
//
//		OutputStream os = response.getOutputStream();
//		
//		HttpSession session = request.getSession(false);
//		int employeeId =  (Integer) session.getAttribute("employeeID");
//		
//		is = req.getReceipt(employeeId, requestNum);
//		
//		
//		if(is == null) {
//			response.setContentType("text/plain");
//			os.write("Failed to send image".getBytes());
//		}else {
//			byte[] bytes = IOUtils.toByteArray(is);
//			os.write(bytes);
//		}		
//		
//		os.close();
//
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
