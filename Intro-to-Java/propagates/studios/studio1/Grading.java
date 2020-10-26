package studio1;

import cse131.ArgsProcessor;

public class Grading {
	public static void main(String[] args) {
		
	ArgsProcessor ap = new ArgsProcessor(args);
		
		int quiz = ap.nextInt("What is the score of quize?");
		int studios = ap.nextInt("What is the score of studios?");
		int labs = ap.nextInt("What is the score of labs?");
		int fp = ap.nextInt("What is the score of final projects?");
		int ext = ap.nextInt("What is the score of the extensions?");
		int exam1 = ap.nextInt("What is the score of exam1?");
		int exam2 = ap.nextInt("What is the score of exam2?");
		int exam3 = ap.nextInt("What is the score of exam3? ");
		int exer = ap.nextInt("What is the score of exercises?");
		int qs = ap.nextInt("What is the score of questions in studios?");
		int ce = ap.nextInt("What is the score of course evaluation?");
		
		double quizd = quiz*0.02;
		double studiosd = studios*0.08;
		double labsd = labs*0.25;
		double fpd = fp*0.05;
		double extd = ext*0.25;
		double exam = ((exam1+exam2+exam3)/3)*0.3;
		double exerd = exer*0.02;
		double qsd = qs*0.02;
		double ced = ce*0.01;
		
		double totalScore = quizd+studiosd+labsd+fpd+extd+exam+exerd+qsd+ced;
		int gradeForThisCourse = (int) totalScore;
		int rightM = gradeForThisCourse % 10;
		
		boolean plus = rightM >= 7;
		boolean minus = rightM <= 3;
		
		System.out.println("Shaw:");
		System.out.println("     Total Score:"+ totalScore);
		System.out.println("     Grade for this course:"+gradeForThisCourse);
		System.out.println("     Final Grade has a...");
		System.out.println("     Plus:"+plus);
		System.out.println("     Minus:"+minus);
		
		

}
	}
