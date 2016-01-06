package tootasuArvestaja;

public class Arvestaja {
	
	public static void main(String[] args) {
		System.out.println();
	}
	
	public static double bruto(double tunnipalk, double tooaeg) {
		return tunnipalk * tooaeg;
	}
	
	public static double ttkm(double bruto) {
		return bruto * 0.016;
	}
	
	public static double kogumisp(double bruto, double kogumisP) {
		return bruto * kogumisP;
	}
	
	public static double tulumaks(double bruto, double ttkm, double kogumisP, double mvm) {
		return (bruto - mvm - ttkm - kogumisP) * 0.2;
	}
	
	public static double neto(double bruto, double tulumaks, double ttkm, double kogumisP) {
		return bruto - tulumaks - ttkm - kogumisP;
	}
	
	public static double sotsmaks(double bruto) {
		return bruto * 0.33;
	}
	
	public static double tatkm(double bruto) {
		return bruto * 0.008;
	}
}
