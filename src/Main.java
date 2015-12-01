import java.util.Scanner;
import java.util.concurrent.atomic.AtomicBoolean;

import sss.DLatch;
import sss.Encoder;
import sss.SSS;

public class Main {

	public static void main(String[] args) {
		DLatch latch0 = new DLatch(0, true);
		DLatch latch1 = new DLatch(1, false);
		DLatch latch2 = new DLatch(2, false);
		DLatch latch3 = new DLatch(3, false);
		
		latch0.setLatchInput(latch3);
		latch1.setLatchInput(latch0);
		latch2.setLatchInput(latch1);
		latch3.setLatchInput(latch2);
		
		DLatch[] biestables = {latch0, latch1, latch2, latch3};
		
		SSS contador = new SSS(biestables);
		
		final AtomicBoolean falseB = new AtomicBoolean();
		AtomicBoolean[] sCont = contador.getOutputs();
		AtomicBoolean[] encoderInputs = {sCont[0], sCont[1], falseB, sCont[3], falseB, sCont[2], falseB, falseB};
		Encoder encoder = new Encoder(encoderInputs);
		printOutputs(encoder.getOutputs());
		System.out.println();
		
		Scanner scan = new Scanner(System.in);
		String text;
		do {
			contador.update();
			printOutputs(encoder.getOutputs());
			text = scan.nextLine();
		} while(text.equals(""));
		scan.close();

	}
	
	public static void printOutputs(boolean[] outs){
		//Hay que hacerlo decreciente para que tenga el peso correcto.
		for(int i = outs.length - 1; 0 <= i; i--) {
			if(outs[i]) {
				System.out.print("1");
			} else {
				System.out.print("0");
			}
		}
		System.out.print("");
	}

}
