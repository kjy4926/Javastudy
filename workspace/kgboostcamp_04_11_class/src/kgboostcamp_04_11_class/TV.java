package kgboostcamp_04_11_class;

public class TV {
	// TV 자체 내부 값이므로 private
	private boolean power;
	private int channel;
	private int volume;
	
	// Constructor
	TV(){
		this.power = false;
		this.channel = 0;
		this.volume = 0;
	}
	// Getter
	public boolean getPower() {
		return this.power;
	}
	public int getChannel() {
		return this.channel;
	}
	public int getVolume() {
		return this.volume;
	}
	// Setter
	public void setPower() {
		this.power = !power;
	}
	public void setChannel(int n) {
		this.channel = n;
	}
	public void setVolume(int n) {
		this.volume = n;
	}
	public void printInfo() {
		System.out.printf("Power : %b / Channer : %d / Volume : %d\n", 
				this.getPower(), this.getChannel(), this.getVolume());
	}
}
