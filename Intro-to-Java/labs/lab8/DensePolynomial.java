package lab8;

import java.util.Arrays;

public class DensePolynomial implements Polynomial {
    private final double [] coef;

	public DensePolynomial() {
		this.coef = new double [] {0.0};
	}
	public DensePolynomial(double coef, int degree, double [] preCoef) {
		this.coef = CoefficientArrayUtils.createNextCoefficients(coef, degree, preCoef);
	}

	@Override
	public Polynomial addTerm(double coefficient, int degree) {
		if(coefficient != 0) {
			DensePolynomial dp = new DensePolynomial(coefficient, degree,this.coef);
			return dp;
		}else {
			return this;
		}
	}

	@Override
	public int degree() {
		return this.coef.length - 1;
	}

	@Override
	public double getCoefficientAtDegree(int degree) {
		if(degree > this.coef.length - 1) {
			return 0.0;
		}
		else {
			double d = this.coef[degree];
			return d;
		}
		
	}

	@Override
	public double evaluate(double x) {
		double sum = 0;
		for(int i = 0; i < this.coef.length;++i) {
			sum = sum + this.getCoefficientAtDegree(i) * Math.pow(x, i);
		}
		return sum;
	}

	@Override
	public Polynomial derivative() {
		double [] d = new double [this.degree()];
		for(int i = 1; i < this.coef.length; ++i) {
			d[i-1] = this.coef[i] * i;
		}
		DensePolynomial a = new DensePolynomial(0,0,d);
		return a;
	}

	@Override
	public Polynomial sum(Polynomial other) {
		double [] add = this.coef;
		for(int i = 0; i <= other.degree();++i) {
			add = CoefficientArrayUtils.createNextCoefficients(other.getCoefficientAtDegree(i), i, add);
		}
		DensePolynomial dp = new DensePolynomial(0, 0, add);
		return dp;
//		int i = other.degree();
//		
//		if(other.degree()==0) {
//			return this.addTerm(other.getCoefficientAtDegree(other.degree()), other.degree());
//		}
//		
//		return sum();
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
		 
		for (int i = this.degree()-1;i >= 0;--i) {
			
		    if (i == 0){
				s = s + "+" + this.getCoefficientAtDegree(i);
			}
		    if (i == 1) {
				s = s + "+" + this.getCoefficientAtDegree(i) + "x";
			}
		    else {
		    	s = s + " + " + this.getCoefficientAtDegree(i)+"x^"+i;
		    }
				
		}
		return s;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(coef);
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
		DensePolynomial other = (DensePolynomial) obj;
		if (!Arrays.equals(coef, other.coef))
			return false;
		return true;
	}
	
	
    

	
    
}
