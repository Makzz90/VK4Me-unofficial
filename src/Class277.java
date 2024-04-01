import java.util.Vector;
//Class277
public final class Class277
{
  public byte[] Field873;
  
  public String[] Text;
  
  public boolean Field875;
  
  public int Field876;
  
  public Class277(String paramString) {
    Method380(paramString);
  }
  
  private void Method380(String text) {
    if (text == null) {
      this.Field873 = new byte[0];
      this.Text = new String[0];
      this.Field875 = false;
      this.Field876 = 0;
      return;
    }
    /*
    while (text.indexOf("…") != -1)
      text = Class291.Method438(text, "…", "..."); 
    while (text.indexOf("–") != -1)
      text = Class291.Method438(text, "–", "-"); 
    while (text.indexOf("️") != -1)
      text = Class291.Method438(text, "️", "");
      */
    char[] arrayOfChar = text.toCharArray();
    StringBuffer stringBuffer = new StringBuffer();
    boolean bool1 = false;
    Vector vector = new Vector();
    Vector vector1 = new Vector();
    boolean bool2 = false;
    byte i;
    /*
    for (i = 0; i < arrayOfChar.length; i++)
    {
      if (arrayOfChar[i] == ' ')//todo
      {
        if (stringBuffer.length() != 0) {
          vector.addElement(stringBuffer.toString());
          vector1.addElement(Boolean.FALSE);
          stringBuffer.setLength(0);
        } 
        if (!vector.isEmpty() && vector1.lastElement().equals(Boolean.TRUE)) {
          stringBuffer.append(Method382(vector.lastElement().toString()));
          vector1.removeElementAt(vector1.size() - 1);
          vector.removeElementAt(vector.size() - 1);
        } 
        stringBuffer.append(arrayOfChar[i]);
        bool2 = true;
      }
      else if (arrayOfChar[i] == ' ' || arrayOfChar[i] == ' ' || (arrayOfChar[i] >= ' ' && arrayOfChar[i] <= ' ' && arrayOfChar[i] != ' '))
      {
        if (stringBuffer.length() != 0 && !bool2) {
          vector.addElement(stringBuffer.toString());
          vector1.addElement(Boolean.FALSE);
          stringBuffer.setLength(0);
        } 
        stringBuffer.append(arrayOfChar[i]);
        if (i + 2 < arrayOfChar.length && arrayOfChar[i + 1] == '?' && arrayOfChar[i + 2] >= '?' && arrayOfChar[i + 2] <= '?') {
          stringBuffer.append(arrayOfChar[i + 1]);
          stringBuffer.append(arrayOfChar[i + 2]);
          i += 2;
        } 
        vector.addElement(Method381(stringBuffer.toString()));
        vector1.addElement(Boolean.TRUE);
        stringBuffer.setLength(0);
        bool2 = false;
        bool1 = true;
      }
      else if (i + 1 < arrayOfChar.length && arrayOfChar[i] >= '?' && arrayOfChar[i] <= '?' && arrayOfChar[i + 1] >= ' ' && arrayOfChar[i + 1] <= '?')
      {
        if (stringBuffer.length() != 0 && !bool2) {
          vector.addElement(stringBuffer.toString());
          vector1.addElement(Boolean.FALSE);
          stringBuffer.setLength(0);
        } 
        stringBuffer.append(arrayOfChar[i]);
        stringBuffer.append(arrayOfChar[i + 1]);
        if (i + 3 < arrayOfChar.length && arrayOfChar[i] == '?' && arrayOfChar[i + 1] >= '?' && arrayOfChar[i + 1] <= '?' && arrayOfChar[i + 2] == '?' && arrayOfChar[i + 3] >= '?' && arrayOfChar[i + 3] <= '?') {
          stringBuffer.append(arrayOfChar[i + 2]);
          stringBuffer.append(arrayOfChar[i + 3]);
          i += 2;
        } else if (i + 3 < arrayOfChar.length && arrayOfChar[i + 2] == '?' && arrayOfChar[i + 3] >= '?' && arrayOfChar[i + 3] <= '?') {
          stringBuffer.append(arrayOfChar[i + 2]);
          stringBuffer.append(arrayOfChar[i + 3]);
          i += 2;
        } 
        vector.addElement(Method381(stringBuffer.toString()));
        vector1.addElement(Boolean.TRUE);
        stringBuffer.setLength(0);
        bool2 = false;
        bool1 = true;
        i++;
      }
      else
      {
        stringBuffer.append(arrayOfChar[i]);
      } 
    }*/
    //
    stringBuffer.append(text);
    //
    if (stringBuffer.length() != 0) {
      vector.addElement(stringBuffer.toString());
      vector1.addElement(Boolean.FALSE);
    } 
    this.Field875 = bool1;
    this.Field873 = new byte[vector1.size()];
    this.Field876 = 0;
    this.Text = new String[vector.size()];
    vector.copyInto((Object[])this.Text);
    for (i = 0; i < this.Field873.length; i++) {
      this.Field873[i] = (byte) (((Boolean)vector1.elementAt(i)).booleanValue() ? 1 : 0);
      if (this.Field873[i] == 1) {
        this.Field876++;
      } else {
        this.Field876 += this.Text[i].length();
      } 
    } 
  }
  
  private static String Method381(String paramString) {
    byte[] arrayOfByte;
    if (paramString == null)
      return null; 
    try {
      arrayOfByte = paramString.getBytes(Class514.Field1364);
    } catch (Exception exception) {
      return "";
    } 
    StringBuffer stringBuffer = new StringBuffer();
    for (byte i = 0; i < arrayOfByte.length; i++) {
      String str;
      if ((str = Integer.toHexString(0xFF & arrayOfByte[i])).length() == 1)
        stringBuffer.append('0'); 
      stringBuffer.append(str);
    } 
    return stringBuffer.toString();
  }
  
  public static String Method382(String paramString) {
    int i;
    byte[] arrayOfByte = new byte[(i = paramString.length()) / 2];
    for (byte b = 0; b < i; b += 2)
      arrayOfByte[b / 2] = (byte)((Character.digit(paramString.charAt(b), 16) << 4) + Character.digit(paramString.charAt(b + 1), 16)); 
    try {
      return new String(arrayOfByte, Class514.Field1364);
    } catch (Exception exception) {
      return "";
    } 
  }
  
  public final String toString() {
    StringBuffer stringBuffer = new StringBuffer();
    for (byte b = 0; b < this.Field873.length; b++) {
      if (this.Field873[b] == 1) {
        stringBuffer.append(Method382(this.Text[b]));
      } else {
        stringBuffer.append(this.Text[b]);
      } 
    } 
    return stringBuffer.toString();
  }
  
  public final Class277 Method383() {
    if (this.Field873.length > 0) {
      Class277 class277 = new Class277(null);
      if (this.Field873[this.Field873.length - 1] == 1 || this.Text[this.Field873.length - 1].length() < 2) {
        class277.Text = new String[this.Field873.length - 1];
        System.arraycopy(this.Text, 0, class277.Text, 0, this.Field873.length - 1);
        class277.Field873 = new byte[this.Field873.length - 1];
        System.arraycopy(this.Field873, 0, class277.Field873, 0, this.Field873.length - 1);
        class277.Field875 = false;
        for (byte b = 0; b < class277.Field873.length; b++) {
          if (class277.Field873[b] == 1) {
            class277.Field875 = true;
            break;
          } 
        } 
      } else {
        class277.Text = new String[this.Field873.length];
        System.arraycopy(this.Text, 0, class277.Text, 0, this.Field873.length);
        String str = class277.Text[class277.Text.length - 1];
        class277.Text[class277.Text.length - 1] = str.substring(0, str.length() - 1);
        class277.Field873 = new byte[this.Field873.length];
        System.arraycopy(this.Field873, 0, class277.Field873, 0, this.Field873.length);
        class277.Field875 = this.Field875;
      } 
      this.Field876--;
      return class277;
    } 
    return this;
  }
}