package stackandqueue;

public class dynamicstack extends stackusingarray {

	dynamicstack() throws Exception {
		this(defaultcap);

	}

	dynamicstack(int cap) throws Exception {
		super(cap);
	}

	@Override
	public void push(int val) throws Exception {
		if (this.size() == this.data.length) {
			int[] ndata = new int[2 * this.data.length];
			for (int i = 0; i < this.data.length; i++) {
				ndata[i] = this.data[i];
			}
			this.data = ndata;
		}

		super.push(val);
	}

}
