package biquadApp;

/**
 * Low pass filter object
 * @author Marcus
 */
public class LowPassFilter extends Filter {
	private double quality;

	/**
	 * @param sampleRate
	 * @param filterFrequency
	 * @param quality
	 */
	public LowPassFilter(int sampleRate, double filterFrequency, double quality) {
		super(sampleRate, filterFrequency);
		this.quality = quality;
	}
	
	@Override
	public Coefficients calculateCoefficients() {
		double omega = (2.0 * Math.PI * getFilterFrequency()) / getSampleRate();
		double alpha = (Math.sin(omega)) / (2.0 * quality);
		
		double a0 = 1.0 + alpha;
		double b0 = ((1.0 - Math.cos(omega)) / 2.0) / a0;
		double b1 = ((1.0 - Math.cos(omega))) / a0;
		double b2 = ((1.0 - Math.cos(omega)) / 2.0) / a0;
		double a1 = (-2.0 * Math.cos(omega)) / a0;
		double a2 = (1.0 - alpha) / a0;
		
		return new Coefficients(b0, b1, b2, a0, a1, a2);
	}
	
}
