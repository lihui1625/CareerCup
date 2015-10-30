package algorithm.graph.basic;

 
import java.util.Arrays;
import java.util.List;
import java.util.Map;



public class HashTest {

	 int intVar;
	 long longVar;
	 boolean booleanVar;
	 float floatVar;
	 double doubleVar;
	 byte byteVar;
	 String stringVar;
	 Object objectVar;
	 A aVar;
	 List<A> listVar;
	 Map<String, A> mapVar;	
	 HashTest hashTestVar;
	 HashTest[] hashTestArrayVar; 
	 long[] longArrayVar;
	 A[] socketArrayVar;
	 HashTest[][] hashTestArray2Var; 
	 long[][] longArray2Var;
	 A[][] socketArray2Var;
	 
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((aVar == null) ? 0 : aVar.hashCode());
		result = prime * result + (booleanVar ? 1231 : 1237);
		result = prime * result + byteVar;
		long temp;
		temp = Double.doubleToLongBits(doubleVar);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + Float.floatToIntBits(floatVar);
		result = prime * result + Arrays.hashCode(hashTestArray2Var);
		result = prime * result + Arrays.hashCode(hashTestArrayVar);
		result = prime * result
				+ ((hashTestVar == null) ? 0 : hashTestVar.hashCode());
		result = prime * result + intVar;
		result = prime * result + ((listVar == null) ? 0 : listVar.hashCode());
		result = prime * result + Arrays.hashCode(longArray2Var);
		result = prime * result + Arrays.hashCode(longArrayVar);
		result = prime * result + (int) (longVar ^ (longVar >>> 32));
		result = prime * result + ((mapVar == null) ? 0 : mapVar.hashCode());
		result = prime * result
				+ ((objectVar == null) ? 0 : objectVar.hashCode());
		result = prime * result + Arrays.hashCode(socketArray2Var);
		result = prime * result + Arrays.hashCode(socketArrayVar);
		result = prime * result
				+ ((stringVar == null) ? 0 : stringVar.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		HashTest other = (HashTest) obj;
		if (aVar == null) {
			if (other.aVar != null)
				return false;
		} else if (!aVar.equals(other.aVar))
			return false;
		if (booleanVar != other.booleanVar)
			return false;
		if (byteVar != other.byteVar)
			return false;
		if (Double.doubleToLongBits(doubleVar) != Double
				.doubleToLongBits(other.doubleVar))
			return false;
		if (Float.floatToIntBits(floatVar) != Float
				.floatToIntBits(other.floatVar))
			return false;
		if (!Arrays.deepEquals(hashTestArray2Var, other.hashTestArray2Var))
			return false;
		if (!Arrays.equals(hashTestArrayVar, other.hashTestArrayVar))
			return false;
		if (hashTestVar == null) {
			if (other.hashTestVar != null)
				return false;
		} else if (!hashTestVar.equals(other.hashTestVar))
			return false;
		if (intVar != other.intVar)
			return false;
		if (listVar == null) {
			if (other.listVar != null)
				return false;
		} else if (!listVar.equals(other.listVar))
			return false;
		if (!Arrays.deepEquals(longArray2Var, other.longArray2Var))
			return false;
		if (!Arrays.equals(longArrayVar, other.longArrayVar))
			return false;
		if (longVar != other.longVar)
			return false;
		if (mapVar == null) {
			if (other.mapVar != null)
				return false;
		} else if (!mapVar.equals(other.mapVar))
			return false;
		if (objectVar == null) {
			if (other.objectVar != null)
				return false;
		} else if (!objectVar.equals(other.objectVar))
			return false;
		if (!Arrays.deepEquals(socketArray2Var, other.socketArray2Var))
			return false;
		if (!Arrays.equals(socketArrayVar, other.socketArrayVar))
			return false;
		if (stringVar == null) {
			if (other.stringVar != null)
				return false;
		} else if (!stringVar.equals(other.stringVar))
			return false;
		return true;
	}
	 
	 
	 
}


class A{
	
	int a;
	long b;
	String c;
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + a;
		result = prime * result + (int) (b ^ (b >>> 32));
		result = prime * result + ((c == null) ? 0 : c.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		A other = (A) obj;
		if (a != other.a)
			return false;
		if (b != other.b)
			return false;
		if (c == null) {
			if (other.c != null)
				return false;
		} else if (!c.equals(other.c))
			return false;
		return true;
	}
	
	
}
