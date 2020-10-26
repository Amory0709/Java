package studio4;

import java.awt.Color;

import cse131.ArgsProcessor;
import sedgewick.StdAudio;
import sedgewick.StdDraw;
import sedgewick.StdIn;

public class Flag {

	
	public static void main(String[] args) {
		   
        // play it using standard audio
		StdDraw.setCanvasSize(512, 300); 
		StdDraw.setPenColor(Color.BLACK);
		StdDraw.filledRectangle(0, 0.2, 1.1, 1.1);
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(0, 0, 1.1, 0.3);
		StdDraw.setPenColor(Color.WHITE);
		StdDraw.filledRectangle(0, 0.6, 1.1, 0.3);
		StdDraw.setPenColor(Color.RED);
		StdDraw.filledRectangle(0, 1, 1.1, 0.3);
		StdDraw.setPenColor();
		StdDraw.setPenRadius(0.8);
		StdDraw.text(0.5,0.9, "Austria");
		 double textx = 1.0;
		 double texty = 0.0;
			StdDraw.setPenColor();
			StdDraw.setPenRadius(0.8);
			 ArgsProcessor.useStdInput("music");
		 while (true) {
			 int pitch = StdIn.readInt();

	            // read in duration in seconds
	            double duration = StdIn.readDouble();

	            // build sine wave with desired frequency
	            double hz = 440 * Math.pow(2, pitch / 12.0);
	            int N = (int) (StdAudio.SAMPLE_RATE * duration);
	            double[] a = new double[N+1];
	            for (int i = 0; i <= N; i++) {
	                a[i] = Math.sin(2 * Math.PI * i * hz / StdAudio.SAMPLE_RATE);
	            }
	            StdAudio.play(a);
			 textx = textx + .05;
			 texty = texty - .05;
			 StdDraw.show(100);
			 StdDraw.text(textx,texty, "Austria");
			 if(textx > 1.0 & texty < 1.0) {
				 textx = 0;
				 texty = 1;	
				StdDraw.setPenColor(Color.BLACK);
				StdDraw.filledRectangle(0, 0.2, 1.1, 1.1);
					StdDraw.setPenColor(Color.RED);
				StdDraw.filledRectangle(0, 0, 1.1, 0.3);
				StdDraw.setPenColor(Color.WHITE);
				StdDraw.filledRectangle(0, 0.6, 1.1, 0.3);
					StdDraw.setPenColor(Color.RED);
					StdDraw.filledRectangle(0, 1, 1.1, 0.3);
				StdDraw.setPenColor();
					StdDraw.setPenRadius(0.8);
					StdDraw.text(0.5,0.9, "Austria");
			 }
	
		        }
		    }

		   }
//		
        

	




