package s5.clase;

public class Utils {
	public static int lastPosMaxValue(int[] v) throws CustomException {
		if (v == null || v.length == 0) {
			throw new CustomException();
		}
		int max = v[0];
		int pos = 0;
		for (int i = 0; i < v.length; i++) {
			if (v[i] >= max) {
				max = v[i];
				pos = i;
			}
		}
		
		return pos;
	}
	
	public static int getPosVal(int[] v, int x) throws CustomException {
		// conditii: v-ul este strict sortat
		// Returneaza pozitia lui x in v
		// -1 daca x nu apare
		if (v == null || v.length == 0) {
			throw new CustomException();
		}
		int pos = -1;
		for (int i = 0; i < v.length; i++) {
			if(v[i] == x) {
				pos = i;
				return pos;
			}
		}
		return pos;
	}
}