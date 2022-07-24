package daolayer.model;

public class CustomStatusMessage {
	
	private String myMessage1;
	private String myMessage2;
	public CustomStatusMessage() {
		super();
		// TODO Auto-generated constructor stub
	}
	public CustomStatusMessage(String myMessage1, String myMessage2) {
		super();
		this.myMessage1 = myMessage1;
		this.myMessage2 = myMessage2;
	}
	public String getMyMessage1() {
		return myMessage1;
	}
	public void setMyMessage1(String myMessage1) {
		this.myMessage1 = myMessage1;
	}
	public String getMyMessage2() {
		return myMessage2;
	}
	public void setMyMessage2(String myMessage2) {
		this.myMessage2 = myMessage2;
	}
	@Override
	public String toString() {
		return "CustomStatusMessage [myMessage1=" + myMessage1 + ", myMessage2=" + myMessage2 + "]";
	}
	
}
