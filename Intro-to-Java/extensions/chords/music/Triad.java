package chords.music;

public class Triad {
	private SingleTone t1;
	private SingleTone t2;
	private SingleTone t3;
	
	/**
	 * Diatonic triad starting at the specified note
	 * @param ds  Scale for the triad
	 * @param root  Starting note of the triad
	 */
	public Triad(DiatonicScale ds, int root) {
		this.t1 = new SingleTone(ds.getPitch(root).getHertz());
		this.t2 = new SingleTone(ds.getPitch(root+2).getHertz());
		this.t3 = new SingleTone(ds.getPitch(root+4).getHertz());
	}
	
	/**
	 * Returns the root, middle, and top note of the triad as an array
	 * @return an array with the root, middle, top notes of this triad
	 */
	public SingleTone[] getTones() {
		SingleTone[] getT = {this.t1, this.t2, this.t3};
		return getT; 
	}
	
	public String toString() {
		return "A triad";  // FIXME with more detail if you like
	}
	
	/**
	 * Return samples of this triad that have the specified amplitude and duration.
	 * @param amplitude the amplitude of the combined samples.  This means the individual tones must be scaled to fit
	 *    within the specified amplitude.
	 * @param duration the length in seconds of the returned samples
	 * @return samples of this triad at the specified amplitude and duration
	 */
	public Samples getSamples(double amplitude, double duration) {
		Samples tmp = this.t1.getSamples(amplitude/3, duration);
		Samples tmp2 = tmp.combine(this.t2.getSamples(amplitude/3, duration));
		Samples tmp3 = tmp2.combine(this.t3.getSamples(amplitude/3, duration));
		return tmp3;
//		this.t1.getSamples(amplitude, duration).combine(this.t2.getSamples(amplitude, duration)).combine(this.t3.getSamples(amplitude, duration));
	}

}
