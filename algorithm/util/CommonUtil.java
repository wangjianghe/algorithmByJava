package util;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;

/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class CommonUtil {
    private static final String TXT_PATH="algorithm/util/value.txt";
    private static final int ALLOCATE=40;
    public static void main(String[] args) throws IOException {
        //ReadValueTxtIntArray();
        writeIntToTxt(40);
        System.out.println(Arrays.toString(readIntToTxt(40)));
    }
    public static int[] ReadValueTxtIntArray() throws IOException {
        File file=new File("algorithm/util/value.txt");
        FileInputStream fis=new FileInputStream(file);
        BufferedReader bufferedReader=new BufferedReader(new FileReader(file));
        String str;
        int[] result = null;
        while ((str=bufferedReader.readLine())!=null){
            String[] strArray=str.split(" ");
            System.out.println(Arrays.toString(strArray));
            result=new int[strArray.length];
            for (int index=0;index<strArray.length;index++){
                result[index]=Integer.parseInt(strArray[index]);
            }
        }
        return result;
    }
    public static void writeIntToTxt(int num) throws IOException {
        FileOutputStream fos=new FileOutputStream(TXT_PATH);
        DataOutputStream dos=new DataOutputStream(fos);
        SecureRandom sr=new SecureRandom();
        for (int index=0;index<num;index++){
            int random=sr.nextInt(99999999);
            dos.writeInt(random);
        }
        fos.flush();
        fos.close();
        dos.flush();
        dos.close();
    }
    public static int[] readIntToTxt(int num) throws IOException {
        int[] result = new int[num];
        ArrayList<Integer> arrayList=new ArrayList<>();
        FileInputStream fis=new FileInputStream(TXT_PATH);
        DataInputStream dis=new DataInputStream(fis);
        for (int index=0;index<num;index++){
            result[index]=dis.readInt();
        }
        return result;
    }
    public static int[] getRandomArray(int n,int left,int right){
        int[] arr=new int[n];
        SecureRandom sr=new SecureRandom();
        for (int i=0;i<n;i++){
            arr[i]=sr.nextInt(right-left)+left;
        }
        return arr;
    }
    public static boolean JudgeSortBigToSmall(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]<arr[i+1]){
                return false;
            }
        }
        return true;
    }
    public static boolean JudgeSortSmallToBig(int[] arr){
        for (int i=0;i<arr.length-1;i++){
            if (arr[i]>arr[i+1]){
                return false;
            }
        }
        return true;
    }
}
