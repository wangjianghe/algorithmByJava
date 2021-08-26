package leetcode.array;

public class Code_12 {
    static int[] val = new int[]{1000,900,500,400,100,90,50,40,10,9,5,4,1};
    static String[] str = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
    public String intToRoman(int x) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < val.length && x > 0; i++) {
            int cv = val[i];
            String cs = str[i];
            while (x >= cv) {
                sb.append(cs);
                x -= cv;
            }
        }
        return sb.toString();
    }
    public static String intoRoman(int num){
        StringBuilder builder=new StringBuilder();
        for (int i=0;i<str.length&&num>0;i++){
            int value=val[i];
            String romanString=str[i];
            while (num>=value){
                builder.append(romanString);
                num-=value;
            }
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(intoRoman(32));
    }
}
