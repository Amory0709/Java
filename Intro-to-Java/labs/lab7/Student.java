package lab7;

public class Student {
	private String first;
	private String last;
	private final int id;
	private int attempt;
	private int pass;
	private double gp;
	private double quality;
	private double depositBearBucks;
	/**
	 * 
	 * @param first
	 * @param last
	 * @param id
	 */
	public Student(String first, String last, int id) {
		this.first = first;
		this.last = last;
		this.id = id;
	}
	/**
	 * 
	 * @return full name
	 */
	public String getFullName() {
		return first+" "+last;
	}
	/**
	 * 
	 * @return ID
	 */
	public int getId() {
		return this.id;
	}
	/**
	 * 
	 * @param grade
	 * @param credits
	 */
	public void submitGrade(double grade, int credits) {
		this.attempt = this.attempt + credits;
		this.gp = this.gp + grade;
		this.quality = this.quality + grade * credits;
		if(grade >= 1.7) {
			this.pass = this.pass +credits;
		}
		
	}
	/**
	 * 
	 * @return attempted credits
	 */
	public int getTotalAttemptedCredits() {
		return this.attempt;
	}
	/**
	 * 
	 * @return passing credits
	 */
	public int getTotalPassingCredits() {
		return this.pass;
	}
	/**
	 * 
	 * @return GPA
	 */
	public double calculateGradePointAverage() {
		return this.quality/this.attempt;
	}
	
	/**
	 * 
	 * @return class standing
	 */
	public String getClassStanding() {
			if(this.pass < 30 && this.pass>=0) {
				return "FirstYear";
			}
			else if(this.pass>= 30 && this.pass < 60) {
				return "Sophomore";
			}
			else if(this.pass>= 60 && this.pass < 90) {
				return "Junior";
			}
			else {
				return "Senior";
			}
			
	}
//	public double getPoint() {
//		return gp;
//	}
	/**
	 * 
	 * @return quality
	 */
	public double getQuality() {
		return quality;
	}
	/**
	 * 
	 * @return whether the student is eligible for PhiBetaKappa
	 */
	public boolean isEligibleForPhiBetaKappa() {
		//a student who has completed at least 98 credits with a cumulative GPA of at least 3.60
		//a student who has completed at least 75 credits with a cumulative GPA of at least 3.80
		if(this.pass >= 98 && (this.quality/this.attempt) >= 3.6) {
			return true;
		}
		else if(this.pass >= 75 && (this.quality/this.attempt) >= 3.8) {
			return true;
		}
		else {
			return false;
		}
	}
	/**
	 * 
	 * @param amount
	 */
	public void depositBearBucks(double amount) {
		this.depositBearBucks = this.depositBearBucks + amount;
	}
	/**
	 * 
	 * @param amount
	 */
	public void deductBearBucks(double amount) {
		this.depositBearBucks = this.depositBearBucks - amount;
	}
	/**
	 * 
	 * @return bear buck balance
	 */
	public double getBearBucksBalance() {
		return this.depositBearBucks;
	}
	/**
	 * 
	 * @return cash out bear buck amount
	 */
	public double cashOutBearBucks() {
//		Remaining balance will be refunded, minus a $10 administrative fee.
//		Balances of $10 or less will be forfeited.
		double a = this.depositBearBucks;
		if(a >=0) {
			if(a > 10) {
				deductBearBucks(a);
				return (a - 10);
			}
			else {
				deductBearBucks(a);
				return 0;
			}
		}
		else {
			return -1;
		}
	}
	/**
	 * 
	 * @param firstName
	 * @param otherParent
	 * @param isHyphenated
	 * @param id
	 * @return
	 */
	public Student createLegacy(String firstName, Student otherParent, boolean isHyphenated, int id) {
//		The newly-created legacy's state will be determined by:
//		The legacy's first name and id (as you might have imagined) will determined by the firstName and id parameters.
//		The legacy's last name with either be the last name of this or a hyphenated combination of this-other depending on the value of isHyphenated.
//		The legacy's Bear Bucks Balance will be the result of cashing out the two parents' accounts
		if(isHyphenated) {
			Student s = new Student(firstName, this.last+"-"+otherParent.last, id);
			double pa1Cash = otherParent.cashOutBearBucks();
			double pa2Cash = this.cashOutBearBucks();
			double allCash = pa1Cash + pa2Cash;
			s.depositBearBucks(allCash);
			return s;
		}
		else {
			Student s = new Student(firstName,this.last,id);
			double pa1Cash = otherParent.cashOutBearBucks();
			double pa2Cash = this.cashOutBearBucks();
			double allCash = pa1Cash + pa2Cash;
			s.depositBearBucks(allCash);
			return s;
		}
	}
	/**
	 * 
	 */
	public String toString() {
		return ""+this.first+" "+this.last+" "+this.id+"";
	}

}//end of class
