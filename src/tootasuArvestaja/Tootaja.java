package tootasuArvestaja;

public class Tootaja {
	
	public Tootaja(String eesnimi, String perenimi, double tunnipalk, double mvm, double kogumisP) {
		eesnimi = eesnimi;
		perenimi = perenimi;
		tunnipalk = tunnipalk;
		mvm = mvm;
		kogumisP = kogumisP;
	}
	
	public class TootajaInfo {
		private String eesnimi;
		private String perenimi;
		private double tunnipalk;
		double mvm;
		double kogumisP;
		
		@Override
		public String toString() {
			return super.toString();
		}
		
		public TootajaInfo(String eesnimi, String perenimi, double tunnipalk, double mvm, double kogumisP) {
			this.eesnimi = eesnimi;
			this.perenimi = perenimi;
			this.tunnipalk = tunnipalk;
			this.mvm = mvm;
			this.kogumisP = kogumisP;
		}
	}

}
