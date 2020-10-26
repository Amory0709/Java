package studio1;

import cse131.ArgsProcessor;

public class Grade {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArgsProcessor ap=new ArgsProcessor(args);
	       int quizzes = ap.nextInt("Quizzes score?");
	       int studios = ap.nextInt("Studios score?");
	       int labs = ap.nextInt("Labs score?");
	       int finalProject = ap.nextInt("Final project score?");
	       int extensions = ap.nextInt("Extensions score?");
	       int exam1 = ap.nextInt("Exam 1 score?");
	       int exam2 = ap.nextInt("Exam 2 score?");
	       int exam3 = ap.nextInt("Exam 3 score?");
	       int exercises = ap.nextInt("Exercises score?");
	       int questionsForStudio = ap.nextInt("Questions for Studio score?");
	       int courseEvaluation = ap.nextInt("Course Evaluation score?");
	       double score= 0.02*quizzes + 0.08*studios + 0.25*labs + 0.05* finalProject+0.25*extensions+0.3*(exam1+exam2+exam3)/3+0.02*exercises+0.02*questionsForStudio+0.01*courseEvaluation;
	       int grade=(int)score;
	       int digitGrade = grade%10;
	       boolean plus=digitGrade>7;//
	       boolean minus= digitGrade<3;
	       System.out.println("Total score: "+score+" Grade for this course:"+grade+"Plus: "+plus+"Minus:"+minus);
	       
	}

}
