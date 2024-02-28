import java.util.*;
/**
 * VigenereCipher
 */
public class VigenereCipher {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String os="";
        System.out.println("Enter the sentence");
        String ps=sc.nextLine();
        ps=ps.toUpperCase();
        System.out.println("Enter the key stream");
        String ks=sc.nextLine();  
        int keylength=ks.length();     
        while (keylength>ps.length()) {
            System.out.println("Key stream is larger than plain string\n\t Enter the key again:");
            ks="";
            ks=sc.nextLine();
            System.out.println(ks);
        }
        keylength=ks.length(); 
        ks=ks.toUpperCase();
        while (ks.length()<ps.length()) {
            for (int i=0;i<keylength;i++){
                char c=ks.charAt(i);
                if(ks.length()<ps.length())
                ks=ks+c;
                //System.out.println(ks);
            }
           
        }
        System.out.println("Key stream: "+ks);
        String cs="";
        for (int i = 0; i < ps.length(); i++) {
            char a=ps.charAt(i);
            char b=ks.charAt(i);
            int x=(int)a;
            int y=(int)b;
            int z=((x+y)-130)%26;
            cs=cs+(char)(z+65);
        }
        System.out.println("Encrypted text: "+cs);

        //Decryption
        int z=0;
        for (int i = 0; i < cs.length(); i++){
            char a=cs.charAt(i);
            char b=ks.charAt(i);
            int x=(int)a;
            int y=(int)b;
            if ((x-y)<0) {
                z=91+(x-y);
            }else{
            z=((x-y)+65);
            }
            //System.out.println(z);
            os=os+(char)(z);
        }
        System.out.println("Decrypted text: "+os);
    }  
}