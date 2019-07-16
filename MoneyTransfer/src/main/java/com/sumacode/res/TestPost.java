/**
 * 
 */
package com.sumacode.res;

import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.sumacode.model.Order;

/**
 * @author sumandutta
 *
 */
@Path("/posting")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class TestPost {

	/**
	 * 
	 */
	public TestPost() {
		// TODO Auto-generated constructor stub
	}
	private static Map<Integer, Order> orders = new HashMap<Integer, Order>();
	
	/*@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	 public String getMessage(Order order) {
	        return "Testing  Post\n";
	 }
	*/
	@POST
    public void createOrder(Order order) {

        orders.put(order.id, order);
    }
	
	 @GET
	    @Path("/{id}")
	    public Order getOrder(@PathParam("id") int id) {
	        Order order = orders.get(id);
	        if (order == null) {
	            order = new Order();
	        }
	        return order;
	    }

}
