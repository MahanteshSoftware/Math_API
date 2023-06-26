package src.main.java.com.example.Math_API.controller;

public class CompareVersion {

    public static void main(String[] args) {
        String version1 = "1.3.4";
        String version2 = "1.10";

        int result = compareVersion(version1, version2);

        if (result < 0)
            System.out.println("Result is : "+result+", "+version1 + " < " + version2);
        else if (result > 0)
            System.out.println("Result is : "+result+", "+version1 + " > " + version2);
        else
            System.out.println("Result is : "+result+", "+version1 + " = " + version2);
    }

    public static int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i=0;
        while(i<arr1.length || i<arr2.length)
        {
            if(i<arr1.length && i<arr2.length)
            {
                if(Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i]))
                {
                    return -1;
                }
                else if(Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i]))
                {
                    return 1;
                }
            }
            else if(i<arr1.length)
            {
                if(Integer.parseInt(arr1[i]) != 0)
                {
                    return 1;
                }
            }
            else if(i<arr2.length)
            {
                if(Integer.parseInt(arr2[i]) != 0)
                {
                    return -1;
                }
            }
            i++;
        }
        return 0;
    }

}
