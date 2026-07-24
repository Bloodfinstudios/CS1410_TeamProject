package biquadApp;

public class ParametricEQFilter extends Filter {
	private double quality;
	private double gain;
	
	/**
	 * @param sampleRate
	 * @param filterFrequency
	 * @param quality
	 * @param gain
	 */
	public ParametricEQFilter(int sampleRate, double filterFrequency, double quality, double gain) {
		super(sampleRate, filterFrequency);
		this.quality = quality;
		this.gain = gain;
	}
	
	@Override
	public Coefficients calculateCoefficients() {
		double omega = (2.0 * Math.PI * getFilterFrequency()) / getSampleRate();
		double alpha = (Math.sin(omega)) / (2.0 * quality);
		double bigA  = Math.pow(10, (gain / 40.0));
		
		double b0 = 1.0 + (alpha * bigA);
		double b1 = -2.0 * Math.cos(omega);
		double b2 = 1.0 - (alpha * bigA);
		double a0 = 1.0 + (alpha / bigA);
		double a1 = -2.0 * Math.cos(omega);
		double a2 = 1.0 - (alpha / bigA);
		
		b0 = b0/a0;
		b1 = b1/a0;
		b2 = b2/a0;
		a1 = a1/a0;
		a2 = a2/a0;
		
		return new Coefficients(b0, b1, b2, a0, a1, a2);
		
	}
	
}
