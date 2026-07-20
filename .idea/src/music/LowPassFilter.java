package music;

/**
 * One of the filters classess needed to
 * alter the sound of a speaker. This class
 * also inherits from the Filter Class
 *
 * @author Marcus W.
 */
public class LowPassFilter extends Filter {

    private double quality;

    /**
     * This constructor creates the filter and uses three
     * seperate parameter for that
     * @param sampleRate
     * @param filterFrequency
     * @param quality
     */
    public LowPassFilter(int sampleRate, double filterFrequency, double quality) {
        super(sampleRate, filterFrequency);
        this.quality = quality;
    }

    /**
     * This section does all of the math for the filter
     * and applies the emodication towards it. And then returns
     * the alterted filter
     *
     * @return a new Coefficients
     */
    @Override
    public Coefficients calculateCoefficients() {
        double omega = 2.0 * Math.PI * filterFrequency / sampleRate;
        double sin = Math.sin(omega);
        double cos = Math.cos(omega);
        double alpha = sin / (2.0 * quality);

        // RBJ Audio EQ Cookbook - Low Pass Filter
        double b0 = (1 - cos) / 2;
        double b1 = 1 - cos;
        double b2 = (1 - cos) / 2;
        double a0 = 1 + alpha;
        double a1 = -2 * cos;
        double a2 = 1 - alpha;

        // Normalize coefficients
        b0 /= a0;
        b1 /= a0;
        b2 /= a0;
        a1 /= a0;
        a2 /= a0;
        a0 = 1.0;

        return new Coefficients(b0, b1, b2, a0, a1, a2);
    }

    @Override
    public String toString() {
        return "LowPassFilter{" +
                "sampleRate=" + sampleRate +
                ", filterFrequency=" + filterFrequency +
                ", quality=" + quality +
                '}';
    }
}