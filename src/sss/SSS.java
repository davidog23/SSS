package sss;

import java.util.concurrent.atomic.AtomicBoolean;

public class SSS {
	
	private DLatch[] biestables;
	
	public SSS(DLatch[] b) {
		biestables = b;
	}
	
	public AtomicBoolean[] getOutputs(){
		AtomicBoolean[] res = new AtomicBoolean[biestables.length];
		for(int i = 0; i < biestables.length; i++) {
			res[i] = biestables[i].getOutput();
		}
		return res;
	}
	
	public void update(){
		for(int i = 0; i < biestables.length; i++){
			biestables[i].updateIn();
		}
		for(int i = 0; i < biestables.length; i++){
			biestables[i].updateOut();
		}
	}
}
