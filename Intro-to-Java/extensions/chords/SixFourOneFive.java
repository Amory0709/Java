package chords;

import java.awt.Color;
import java.util.Random;

import chords.gui.*;
import chords.music.*;
import sedgewick.StdDraw;

public class SixFourOneFive {
		

	public static void main(String[] args) {
		//x Tone , y Chords
		TwoDimensionalGUI display = new TwoDimensionalGUI(0, .25, 0, .25, "Tune", "Chords");
		while (true) {
			StdDraw.clear();
			//background
			
			DiatonicScale ds = new DiatonicScale(3);
			Triad a = new Triad(ds,-2);
			Triad F = new Triad(ds,3);
			Triad C = new Triad(ds,0);
			Triad G = new Triad(ds,4);
			
			//tune
			SWPoint p = display.update();
			//
			// Show the nominal (x,y) value
			//
			StdDraw.setPenColor(Color.GREEN);
			StdDraw.setPenRadius(.015);
			StdDraw.point(1, 1);

			StdDraw.show(10);
			
			//Interval
			int intervalSplit = (int)(p.getY() * 4 + 1);
			//Pitch
			Pitch random = ds.getPitch((int)(8*p.getX()));
			SingleTone ram = new SingleTone(random.getHertz());
			Samples oneSec = ram.getSamples(100, 1/intervalSplit);
			for(int i=1; i < intervalSplit;++i) {
				oneSec = oneSec.concat(ram.getSamples(100, 1/intervalSplit));
			}
			//play this noise
			a.getSamples(100, 1).combine(oneSec).concat(F.getSamples(100, 1)).combine(oneSec).concat(C.getSamples(100, 1)).combine(oneSec).concat(G.getSamples(100, 1)).combine(oneSec).play();
			

		}
       
	 }


}
