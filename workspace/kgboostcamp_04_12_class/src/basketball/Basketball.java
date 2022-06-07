package basketball;

// ³ó±¸ÀÇ µæÁ¡ ±ÔÄ¢Àº ¿©·¯°³ÀÏ ÀÌÀ¯°¡ ¾øÀ¸¹Ç·Î static
// ³ó±¸ µæÁ¡ÀÌ Á¤ÀÇµÈ Å¬·¡½º·Î 1,2,3 µæÁ¡ÀÌ Á¤ÀÇµÊ
public class Basketball {
	private static int oneScore = 1;
	private static int twoScore = 2;
	private static int threeScore = 3;
	
	// 1Á¡ µæÁ¡
	public static int getOneScore() {
		return oneScore;
	}
	// 2Á¡ µæÁ¡
	public static int getTwoScore() {
		return twoScore;
	}
	// 3Á¡ µæÁ¡
	public static int getThreeScore() {
		return threeScore;
	}
}