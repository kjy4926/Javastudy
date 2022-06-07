package kgboostcamp_03_28;

public class operation {
	public static void main(String []args){
        int a = 5, b = 6, c = 10, d = 0;
        boolean bo = false;
        d = ++a * b--;
        System.out.printf("a = %d, b = %d, d = %d\n",a,b,d);
        d = a++ + ++c - b--;
        System.out.printf("a = %d, b = %d, c = %d, d = %d\n",a,b,c,d);
        a = 1;
        b = 0;
        bo = a++ > 0 || 1 < ++b * d-- / ++c;
        System.out.printf("a = %d, b = %d, c = %d, d = %d\n",a,b,c,d);
        bo = b++ > 0 && 1 < ++a / ++c * d++;
        System.out.printf("a = %d, b = %d, c = %d, d = %d\n",a,b,c,d);
   }
}