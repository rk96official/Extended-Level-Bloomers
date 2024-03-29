/*Design an code a class barArray as a wrapper to a vector of bars
 * it will have the following private member variables
 * A Vector of bars  Vector<bar> v 
 * symbol of the security
 * A default constructor that creates a default vector
 * A constructor that accepts a size of the vector and creates a vector fo that sise.
 * Methods: 
 * At(int index) returns the bar at that index
 * insertAt (Bar b, int index ) same as insertElement 
 * print() will print all the bars in the array
 * int size() return the number of bars in the Vector
 *VERY IMPORTANT!!
 */
//TODO
import java.util.*;
public class barArray {
	//has member Vector of bars
	Vector<Bar> list;
	public barArray() {
		list = new Vector<Bar>(4000);
	}
	public barArray(int s) {
		list = new Vector<Bar>(s);
	}
	public barArray(int s, int incr) {
		list = new Vector<Bar>(s, incr);
	}
	//method to insert a bar at specific index
	public void insert(Bar b) {
		//call the Vector method insetElement
		list.addElement(b);
	}
	public int size() {
		return list.size();
	}
	public Bar elementAt(int index){
		return list.elementAt(index);
	}

}