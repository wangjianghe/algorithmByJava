package leetcode.face;

public class 写一个函数来判断s2是否包含s1的排列 {
    public boolean checkInclusion(String s1, String s2) {
        if (s1.length()>s2.length()){
            return false;
        }
        char[] nums1=new char[26];
        char[] nums2=new char[26];
        for (int i = 0; i < s1.length(); i++) {
            nums1[s1.charAt(i)-'a']++;
            nums2[s2.charAt(i)-'a']++;
        }
        int k=0;
        while (k<s2.length()-s1.length()){
            if (match(nums1,nums2)){
                return true;
            }
            nums2[s2.charAt(k+s1.length())-'a']++;
            nums2[s2.charAt(k)-'a']--;
            k++;
        }
        return match(nums1,nums2);

    }
    private boolean match(char[] nums1,char[] nums2){
        for (int i = 0; i < nums1.length; i++) {
            if (nums1[i]!=nums2[i]){
                return false;
            }
        }
        return true;

    }
}
