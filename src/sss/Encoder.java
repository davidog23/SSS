package sss;

import java.util.concurrent.atomic.AtomicBoolean;

import utils.MathUtil;

//Está diseñado solo para 8 entradas. Quizá la extienda para n entradas.
public class Encoder {
	private int nOutputs;
	private AtomicBoolean[] inputs;
	
	public Encoder(AtomicBoolean[] inputs) {
		switch(inputs.length) {
			case 8:
				this.inputs = inputs;
				this.nOutputs = (int)MathUtil.log2(inputs.length);
				break;
			default:
				System.out.println("El número de entradas del codificador ha de ser potencia de base 2");
		}
	}
	
	public boolean[] getOutputs() {
		boolean[] res = new boolean[nOutputs];
		res[0] = inputs[1].get() || inputs[3].get() || inputs[5].get() || inputs[7].get();
		res[1] = inputs[2].get() || inputs[3].get() || inputs[6].get() || inputs[7].get();
		res[2] = inputs[4].get() || inputs[5].get() || inputs[6].get() || inputs[7].get();
		return res;
	}
	
	

}
