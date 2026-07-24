package biquadApp;

public abstract class Filter {
	private int sampleRate;
	private double filterFrequency;
	/**
	 * @param sampleRate
	 * @param filterFrequency
	 */
	public Filter(int sampleRate, double filterFrequency) {
		this.sampleRate = sampleRate;
		this.filterFrequency = filterFrequency;
	}
	
	public Coefficients calculateCoefficients() {
		return null;
	}

	/**
	 * @return the sampleRate
	 */
	public int getSampleRate() {
		return sampleRate;
	}

	/**
	 * @return the filterFrequency
	 */
	public double getFilterFrequency() {
		return filterFrequency;
	}
	
	
}

