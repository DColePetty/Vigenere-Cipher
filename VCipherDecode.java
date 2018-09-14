// COLE PETTY 
// "VIGENERE CIPHER DECODER" 
// Independant side project, solo
// VIGENERE CIPHER DECODER
/*
 * The key for this cipher will never be "a", "aa", or any variation of only "a" characters because in
 * a Vigenere Cipher, a has the first value, that is 0, so shifting any letters by zero will leave them 
 * in their current state. 
 */
import java.util.Scanner;
import java.util.ArrayList;

public class VCipherDecode
{
  public static Scanner sc = new Scanner(System.in);
  public static String key = "", keyLarge= "", plainText = "", encryptedText  = "", decryptedText = "";
  public static ArrayList<Integer> spacesAt = new ArrayList<Integer>();
  public static int ArrayCounter =0, textCode = 0, keyCode = 0, spaceIndex =0;
  // key 
  // the quick brown fox jumped over the lazy dog
  
  public static void MakeKeyLarge(String str)
  {
    for(int a = 0; a < plainText.length(); a++)
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
      Evalue = ( ((int)(textCode) % 97) + (26 - (int)(keyCode) % 97));
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
  
  public static void AddTheSpaces()
  {
     String result = encryptedText;
     for(int f = 0; f < spacesAt.size(); f++)
    {
      spaceIndex = spacesAt.get(f);
      result = encryptedText.substring(0,spaceIndex) + " " + encryptedText.substring(spaceIndex);
      encryptedText = result;
    }
  }

  public static void main(String[] args)
  {
    System.out.println("Please Enter the Sentence you would like to decrypt");
    plainText = sc.nextLine().toLowerCase();
    
    System.out.println("Please Enter an Encryption Key");
    key = sc.nextLine().trim().toLowerCase();
    
    IndexSpaces(plainText);
    RemoveSpaces(plainText);
    MakeKeyLarge(key);
    MakeKeyEqualLength();
    RemoveSpaces(plainText);
    
    Encrypt(keyLarge, plainText);
    
    System.out.println("KEY-repeated:\n" + keyLarge + "\n");    
    System.out.println("ENCRYPTED TEXT: \n" + plainText + "\n");   
    System.out.println("DECRYPTED TEXT: \n" + encryptedText + "\n");
    System.out.println("SPACES AT INDEXES: \n" + SpacesHere() + "\n");
    AddTheSpaces();
    System.out.println("DECRYPTED TEXT WITH SPACES: \n" + encryptedText + "\n");
  }
}