package net.cineplex.tag;



import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import net.cineplex.model.Movie;
import net.cineplex.model.Plan;
import net.cineplex.model.Seat;
import net.cineplex.webmodel.SeatListInHall;
import net.cineplex.webmodel.SeatListInRow;
import net.cineplex.webmodel.UsedSeatList;

public class SeatSelect extends SimpleTagSupport{
	public void doTag() throws IOException {
		 PageContext pageContext = (PageContext)this.getJspContext();
	
		 HttpServletRequest request = (HttpServletRequest)pageContext.getRequest();
      
         HttpSession session = request.getSession();
         SeatListInHall slih=(SeatListInHall) session.getAttribute("seatListInHall");
         UsedSeatList usl=(UsedSeatList) session.getAttribute("usedSeatList");
        // System.out.println(usl.getList().size());
         
           
         JspWriter out = pageContext.getOut();
        // System.out.println(slih.getSize());
         for(int i=0;i<slih.getSize();i++){
        	 SeatListInRow slir=slih.getItem(i);
        	 out.println("<div class=\"seatline\">");
        	 for(int j=0;j<slir.getSeatNum();j++){
        		 Seat seat=slir.getSeat(j);
        		 out.print( "<img src=\"/cineplex/system/assets/i/");
        		 if(usl.ifUsed(String.valueOf(seat.getSid()))){
        			out.print("seat_unavail");
        			
        		 }else{
        			out.print("seat_avail"); 
        		
        		 }
        		 out.print(".png\" alt=\"");
        		 if(usl.ifUsed(String.valueOf(seat.getSid()))){
        			 out.print("unavail");
        		 }else{
        			 out.print("avail");
        		 }
        		 out.print("\"  title=\"");
        		 out.print(slir.getRow());
        		 out.print("ÅÅ");
        		 out.print(seat.getSeatIndex());	
        		 out.print("×ù\"  id=\"");
        		 out.print(seat.getSid());
        		 out.print("\" ");
        		 out.print("    style=\"cursor:pointer\"  ");
        		 if(usl.ifUsed(String.valueOf(seat.getSid()))){
        			
        		 }else{
        			 out.print("onclick=\"chooseSeats('");
        			 out.print(seat.getSid());
        			 out.print("');\"");
        		 }
        		 out.print("/>");
        	 } 
        	 out.println("</div>");
         
         }
	}
}
