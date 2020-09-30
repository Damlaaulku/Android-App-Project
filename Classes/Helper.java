import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/*
 * Helper methods for general operations
 */
public class Helper {

	// Remove an item from a list
	public static void removeFromList(ArrayList l, Object o) {
		Iterator i=l.iterator();
		
		while(i.hasNext()) {
			Object t=i.next();
			
			if(o.equals(t)) {
				i.remove();
				break;
			}
		}
	}
	// end removeFromList
	
}
