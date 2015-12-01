package sss;

import java.util.concurrent.atomic.AtomicBoolean;

public class DLatch {
	
	public final int ID;
	private AtomicBoolean output, input = new AtomicBoolean();
	private DLatch inputL;
	
	public DLatch(int id, boolean initOut){
		ID = id;
		output = new AtomicBoolean(initOut);
	}
	
	public void updateIn(){
		input.set(inputL.output.get());
	}
	
	public void updateOut() {
		output.set(input.get());
	}
	
	public AtomicBoolean getOutput(){
		return output;
	}
	
	public void setLatchInput(DLatch in){
		inputL = in;
	}
}
