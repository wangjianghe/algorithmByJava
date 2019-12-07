/**
 *<p>Description:${Description}</p>
 *<p>Company:tope</p>
 *<p>Create Date:2019年11月30日</p>
 *@author:wangjianghe
 *@version 1.0
 */
public class SortCompareMain {
    public static void main(String[] args) {
        String zipName="dads.jpg";
        String zipFileName =zipName;
        zipFileName=zipFileName.substring(zipFileName.lastIndexOf('\\')+1);
        System.out.println(zipFileName);
    }
}
