// COLE PETTY 
// "VIGENERE CIPHER + 1" ( backwards compatible, see notation below )
// Independant side project, solo
// VIGENERE CIPHER
/*
 * In this cipher, as per historically accurate, using an "a" or "aaa" any variation here will NOT encrypt
 * the input string in any way. This is because we as programmers begin counting at 0, and assigning a to the
 * value of 0, as it is the first digit, then a shift to the entire string by 0 makes for no variation.
 * To check my work I utilized http://rumkin.com/tools/cipher/vigenere.php, I am in no way affiliated with 
 * the creators of this website nor the code they used to create their version of the cipher. 
 * 
 * If one wishes for a to be a shift of 1 and z's to become the "zero shift" character, replace all 97's in
 * this code to 96's. Thank you.
 * 
 */
import java.util.Scanner;
import java.util.ArrayList;

public class VCipher
{
  public static Scanner sc = new Scanner(System.in);
  public static String key = "", keyLarge= "", plainText = "", encryptedText  = "", decryptedText = "";
  public static ArrayList<Integer> spacesAt = new ArrayList<Integer>();
  public static int ArrayCounter =0, textCode = 0, keyCode = 0;
  // key 
  // the quick brown fox jumped over the lazy dog
  
  public static void MakeKeyLarge(String str)
  {
    for(int a =0; a < plainText.length(); a++)
    {
      keyLarge = keyLarge.concat(str);
    }
  }
  public static void IndexSpaces(String str)
  {
    for(int b = 0; b < str.length(); b++)
    {
      if(str.charAt(b) == ' ')
      {
        int b1 = b;
        spacesAt.add(b1);
        ArrayCounter++;
      }
    }
  }
  
  public static void RemoveSpaces(String str)
  {
    for(int c = 0; c < str.length(); c++)
    {
      plainText = plainText.replace(" ", "");
    }
  }
  
  public static void MakeKeyEqualLength()
  {
    keyLarge = keyLarge.substring(0, plainText.length());
  }
  
  public static void Encrypt(String key, String text)
  {
    for(int d =0; d < text.length(); d++)
    {
      
      textCode = text.charAt(d);
      keyCode = key.charAt(d);
      int Evalue = 0;
      Evalue = ( ((int)(textCode) % 97) + ((int)(keyCode) % 97));
      if(Evalue >= 26)
        Evalue %= 26;
      //System.out.print((char)(Evalue + 97));
      encryptedText = encryptedText.concat( "" + (char)(Evalue + 97));
    }
  }
  public static String SpacesHere()
  {
    String result = "";
    for(int e =0; e < spacesAt.size(); e++)
    {
      result += spacesAt.get(e) + " ";
    }
    return result;
  }
  
  public static void main(String[] args)
  {
    System.out.println("Please Enter an Encryption Key");
    key = sc.nextLine().trim().toLowerCase();
    
    System.out.println("Please Enter the Sentence you would like to encrypt");
    plainText = sc.nextLine().toLowerCase();
    
    IndexSpaces(plainText);
    RemoveSpaces(plainText);
    MakeKeyLarge(key);
    MakeKeyEqualLength();
    RemoveSpaces(plainText);
    
    Encrypt(keyLarge, plainText);
    
    System.out.println("KEY-repeated:\n" + keyLarge + "\n");     //System.out.print("\t Number of characters:" + keyLarge.length() + "\n"); 
    System.out.println("ORIGINAL TEXT: \n" + plainText + "\n");    //System.out.print("\t Number of characters:" + plainText.length() + "\n");
    System.out.println("ENCRYPTED TEXT: \n" + encryptedText + "\n");
    System.out.println("SPACES AT INDEXES: " + SpacesHere() + "\n");
    /* Remembe that once a space is added to the beginning of a string, it incremets the indices
     * of all the following elements, and by exxtention, the following spaces.
     */
  }
}