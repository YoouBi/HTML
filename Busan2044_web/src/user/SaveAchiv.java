package user;

public class SaveAchiv {
	private int Victory;
	private int Dath;
	private int ZoombiDath;
	private String attain;
	private String ending;
	private String Achiv;
	
	public SaveAchiv() {}

	public SaveAchiv(int victory, int dath, int zoombiDath, String attain, String ending, String achiv) {
		Victory = victory;
		Dath = dath;
		ZoombiDath = zoombiDath;
		this.attain = attain;
		this.ending = ending;
		Achiv = achiv;
	}
	
	public int getVictory() {
		return Victory;
	}
	public void setVictory(int victory) {
		Victory = victory;
	}
	public int getDath() {
		return Dath;
	}
	public void setDath(int dath) {
		Dath = dath;
	}
	public int getZoombiDath() {
		return ZoombiDath;
	}
	public void setZoombiDath(int zoombiDath) {
		ZoombiDath = zoombiDath;
	}
	public String getAttain() {
		return attain;
	}
	public void setAttain(String attain) {
		this.attain = attain;
	}
	public String getEnding() {
		return ending;
	}
	public void setEnding(String ending) {
		this.ending = ending;
	}
	public String getAchiv() {
		return Achiv;
	}
	public void setAchiv(String achiv) {
		Achiv = achiv;
	}
}