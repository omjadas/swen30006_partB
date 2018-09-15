package robot;

import automail.IMailDelivery;
import exceptions.FragileItemBrokenException;
import exceptions.ItemTooHeavyException;
import strategies.IMailPool;
import automail.MailItem;


public class Weak extends Robot {
	
	private static int MAX_WEIGHT = 2000;

	public Weak(IMailDelivery delivery, IMailPool mailPool) {
		super(delivery, mailPool, false, 4);
		// TODO Auto-generated constructor stub
	}
	
	/**
     * Sets the route for the robot
     */
    protected void setRoute() throws ItemTooHeavyException{
    	/** Pop the item from the StorageUnit */
        deliveryItem = tube.pop();
        if (deliveryItem.getWeight() > MAX_WEIGHT) throw new ItemTooHeavyException(); 
	    /** Set the destination floor */
	    destination_floor = deliveryItem.getDestFloor();
    }
    
    public static int getMaxWeight() {
    	return MAX_WEIGHT;
    }

}
