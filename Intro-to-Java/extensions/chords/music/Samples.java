package chords.music;

import sedgewick.StdAudio;

/**
 * Represent a double[] samples array.
 * A Samples object has-a double[] array of samples, which it hides and does not expose except through
 *    the methods defined below.
 * @author roncytron
 *
 */

public class Samples {
	
	private final double [] newSamples;
	/**
	 * Capture the specified samples in our local array, so that they are safe from modification
	 * @param samples
	 */
	public Samples(double[] samples) {
//		this.newSamples = samples.clone();
		this.newSamples = new double [samples.length];
		for(int i = 0; i < samples.length; ++i){
			this.newSamples[i] = samples[i];
		}
	}
	
	/**
	 * Construct samples of the specified length, all zero.
	 * @param length
	 */
	public Samples(int length) {
		this.newSamples  = new double [length];
		for(int i = 0; i < this.newSamples.length; ++i) {
			this.newSamples[i] = 0.0;
		}
	}
	
	/**
	 * Concatenate this and the other sample, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the concatenation of these samples with the other samples
	 */
	public Samples concat(Samples other) {
		double [] conca = new double [this.newSamples.length + other.getNumSamples()];
		for(int i = 0; i < this.newSamples.length; ++i) {
			conca[i] = this.newSamples[i];
		}
		for(int i = this.newSamples.length; i < this.newSamples.length + other.getNumSamples(); ++i) {
			conca[i] = other.getSample(i-this.newSamples.length);
		}
		Samples newConcat = new Samples(conca);
		return newConcat; 
	}
	
	/**
	 * Combine this and the other samples, padding by 0 if necessary, returning a NEW samples object, and leaving the two inputs unchanged
	 * @param other
	 * @return the numerical addition of these and the other samples, padded by 0 where necessary
	 */
	public Samples combine(Samples other) {
		double [] comb = new double [Math.max(this.newSamples.length, other.getNumSamples())];
		for(int i = 0; i < this.newSamples.length; ++i) {
			comb[i] = this.newSamples[i]; 
		}
		for(int i = 0; i < other.getNumSamples(); ++i) {
			comb[i] = comb[i] + other.getSample(i);
		}
		
		Samples newComb = new Samples(comb);
		return newComb; 
	}
	
	/**
	 * 
	 * @return the number of samples
	 */
	
	public int getNumSamples() {
		return this.newSamples.length;
	}
	
	/**
	 * Play these samples, by calling StdAudio.play(..) passing in the double array of samples
	 */
	public void play() {
		StdAudio.play(this.newSamples);
	}
	
	public String toString() {
		return "Samples with " + this.getNumSamples() + " values";
	}

	/**
	 * Accessor to return a particular sample
	 * @param i the sample to be returned, with 0 as the first sample
	 * @return the specified sample value
	 */
	public double getSample(int i) {
		return this.newSamples[i]; 
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the maximum value of all samples
	 * @return the maximum value
	 */
	public double getMax() {
		double max = 0;
		for(int i = 0; i < this.newSamples.length; ++i) {
			max = Math.max(max, this.newSamples[i]);
		}
		return max;  // FIXME
	}
	
	/**
	 * Valid only for a positive number of samples, this method returns the minimum value of all samples
	 * @return the minimum value
	 */
	public double getMin() {
		double min = 1000000000;
		for(int i = 0; i < this.newSamples.length; ++i) {
			min = Math.min(min, this.newSamples[i]);
		}
		return min;  
	}

}
