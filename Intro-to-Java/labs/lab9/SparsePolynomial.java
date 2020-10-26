package lab9;

import java.util.HashMap;
import java.util.Map;

import lab8.Polynomial;

public class SparsePolynomial implements Polynomial {
    private final Map <Integer, Double> sparse = new HashMap <Integer, Double>();
	
	public SparsePolynomial() {
		this.sparse.getOrDefault(0, 0.0);
	}
	
	public SparsePolynomial(double coefficient, int degree, Map<Integer, Double> prevMap) {
		Map<Integer,Double> newMap = MapDegreeToCoefficientUtils.createNextMap(coefficient, degree, prevMap);
//		for(Integer key: newMap.keySet()) {
//			sparse.put(key, newMap.get(key));
//		}
		sparse.putAll(newMap);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((sparse == null) ? 0 : sparse.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		SparsePolynomial other = (SparsePolynomial) obj;
		if (sparse == null) {
			if (other.sparse != null)
				return false;
		} else if (!sparse.equals(other.sparse))
			return false;
		return true;
	}

	/**
	 * Return a new Polynomial that includes the supplied coefficient and degree
	 * term. If the supplied term is of the same degree as an already existing Term
	 * in this Polynomial, then the coefficients of the supplied and existing terms
	 * are summed in the returned new Polynomial.
	 * 
	 * This Polynomial must not be disturbed by this method. Be sure to return a new
	 * Polynomial that is like this one, but with the extra term included.
	 * 
	 * @param coefficient
	 * @param degree
	 * @return new Polynomial as described above
	 */
	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		if(coefficient!=0) {
			SparsePolynomial sp = new SparsePolynomial(coefficient, degree, sparse);
			return sp;	
		}else {
			return this;
		}
		
	}

	/**
	 * Return the degree of this Polynomial, computed as the highest degree Term of
	 * this Polynomial over all Terms with non-zero coefficients. The degree of all
	 * Polynomials is at least 0, because a Polynomial with no Terms is equivalent
	 * to 0.0 x^0
	 * 
	 * @return the degree of this Polynomial
	 */
	@Override
	public int degree() {
		int max = 0;
		for(Integer key:sparse.keySet()) {
			if (key > max) {
				max = key;
			}
		}
		return max;
	}

	/**
	 * Returns the coefficient of the term at the specified degree. If no such term
	 * exists in the Polynomial, 0.0 should be returned.
	 * 
	 * @param degree of interest
	 * @return coefficient of the degree of interest
	 */
	@Override
	public double getCoefficientAtDegree(int degree) {
		return sparse.getOrDefault(degree, 0.0);
	}

	/**
	 * Evaluate this Polynomial at the specified value for x
	 * 
	 * @param x value of the unknown
	 * @return the sum of all terms evaluated at x
	 */
	@Override
	public double evaluate(double x) {
		double sum = 0;
		for(Integer key : sparse.keySet()) {
			sum = sum + sparse.get(key) * Math.pow(x, key);
		}
		return sum;
	}

	/**
	 * Returns a new Polynomial that is the derivative of this one. Be sure not to
	 * modify this Polynomial.
	 * 
	 * @return
	 */
	@Override
	public Polynomial derivative() {
//		Map<Integer,Double> tmp = MapDegreeToCoefficientUtils.copyMap(sparse);
		Polynomial deri = new SparsePolynomial();
		
		for(Integer key: sparse.keySet()) {
			deri = deri.addTerm(sparse.get(key)*key, (key-1));
		}
		return deri;
	}

	/**
	 * Return a new Polynomial that is the sum of this one and the other one. Be
	 * sure not to disturb this Polynomial.
	 * 
	 * @param other another Polynomial
	 * @return the sum of this and the other Polynomial
	 */
	@Override
	public Polynomial sum(Polynomial other) {
//		SparsePolynomial sum = new SparsePolynomial(0.0, 0, sparse);
		for(Integer key: sparse.keySet()) {
			other = other.addTerm(sparse.get(key), key);
		}
		return other;
	}

	@Override
	public String toString() {
		String s;
		if(this.degree()==0) {
		   s = ""+this.getCoefficientAtDegree(this.degree());
		}
		if(this.degree()==1) {
		  s = "" + this.getCoefficientAtDegree(this.degree()) + "x";
		}
		else {
		   s = ""+this.getCoefficientAtDegree(this.degree())+"x^"+this.degree();
		}
		 
		for (Integer key: sparse.keySet()) {
			
		    if (key == 0){
				s = s + "+" + this.getCoefficientAtDegree(key);
			}
		    if (key == 1) {
				s = s + "+" + this.getCoefficientAtDegree(key) + "x";
			}
		    else {
		    	s = s + " + " + this.getCoefficientAtDegree(key)+"x^"+key;
		    }
				
		}
		return s;
	}
	

}
