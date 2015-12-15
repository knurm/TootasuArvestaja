package tootasuArvestaja;

public class Arvestaja {
	
	public static void main(String[] args) {
		System.out.println(bruto(4.5, 38.5));
	}
	
	public static double bruto(double tunnipalk, double tööaeg) {
		return tunnipalk * tööaeg;
	}
	
	public static double ttkm(double bruto) {
		return bruto * 0.016;
	}
	
	public static double kogumisp(double bruto, double kogumispension) {
		return bruto * kogumispension;
	}
	
	public static double tulumaks(double bruto, double ttkm, double kogumisp, boolean mvm) {
		double tulumaks;
		if (mvm == true) {
			tulumaks = (bruto - 154 - ttkm - kogumisp) * 0.2;
		} else {
			tulumaks = (bruto - ttkm - kogumisp) * 0.2;
		}
		return tulumaks;
	}
	
	public static double neto(double bruto, double tulumaks, double ttkm, double kogumisp) {
		return bruto - tulumaks - ttkm - kogumisp;
	}
	
	public static double sotsmaks(double bruto) {
		return bruto * 0.33;
	}
	
	public static double tatkm(double bruto) {
		return bruto * 0.008;
	}

}
