/*
Copyright (c) 2002 JSON.org
 
Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:
 
The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.
 
The Software shall be used for Good, not Evil.
 
THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
 */

/**
 * A JSONTokener takes a source string and extracts characters and tokens from
 * it. It is used by the JSONObject and JSONArray constructors to parse
 * JSON source strings.
 * @author JSON.org
 * @version 2
 */
public final class JSONTokener
{
	/**
     * The index of the next character.
     */
    private int myIndex;
    
    
    /**
     * The source string being tokenized.
     */
    private String mySource;
    
    
    /**
     * Construct a JSONTokener from a string.
     *
     * @param s     A source string.
     */
    public JSONTokener(String s) {
        this.myIndex = 0;
        this.mySource = s;
    }
    
    
    /**
     * Back up one character. This provides a sort of lookahead capability,
     * so that you can test for a digit or letter before attempting to parse
     * the next number or identifier.
     */
    public void back() {
        if (this.myIndex > 0) {
            this.myIndex -= 1;
        }
    }

   public final char Method202() {
      if (this.myIndex < this.mySource.length()) {
         char var1 = this.mySource.charAt(this.myIndex);
         ++this.myIndex;
         return var1;
      } else {
         return '\u0000';
      }
   }

   private String next(int n) throws JSONException {
      int var2;
      int var3;
      if ((var3 = (var2 = this.myIndex) + n) >= this.mySource.length()) {
         throw this.syntaxError("Substring bounds error");
      } else {
         this.myIndex += n;
         return this.mySource.substring(var2, var3);
      }
   }

   public final char nextClean() throws JSONException{
      label50:
      while(true) {
         char var1;
         if ((var1 = this.Method202()) == '/') {
            switch(this.Method202()) {
            case '*':
               while((var1 = this.Method202()) != 0) {
                  if (var1 == '*') {
                     if (this.Method202() == '/') {
                        continue label50;
                     }

                     this.back();
                  }
               }

               throw this.syntaxError("Unclosed comment.");
            case '/':
               while(true) {
                  if ((var1 = this.Method202()) == '\n' || var1 == '\r' || var1 == 0) {
                     continue label50;
                  }
               }
            default:
               this.back();
               return '/';
            }
         } else if (var1 == '#') {
            while((var1 = this.Method202()) != '\n' && var1 != '\r' && var1 != 0) {
            }
         } else if (var1 == 0 || var1 > ' ') {
            return var1;
         }
      }
   }

   public final Object nextString() throws JSONException{
      char var1;
      char var3;
      switch(var1 = this.nextClean()) {
      case '"':
      case '\'':
         char var2 = var1;
         JSONTokener var10 = this;
         StringBuffer var4 = new StringBuffer();

         while(true) {
            switch(var3 = var10.Method202()) {
            case '\u0000':
            case '\n':
            case '\r':
               throw var10.syntaxError("Unterminated string");
            case '\\':
               switch(var3 = var10.Method202()) {
               case 'b':
                  var4.append('\b');
                  continue;
               case 'c':
               case 'd':
               case 'e':
               case 'g':
               case 'h':
               case 'i':
               case 'j':
               case 'k':
               case 'l':
               case 'm':
               case 'o':
               case 'p':
               case 'q':
               case 's':
               case 'v':
               case 'w':
               default:
                  var4.append(var3);
                  continue;
               case 'f':
                  var4.append('\f');
                  continue;
               case 'n':
                  var4.append('\n');
                  continue;
               case 'r':
                  var4.append('\r');
                  continue;
               case 't':
                  var4.append('\t');
                  continue;
               case 'u':
                  var4.append((char)Integer.parseInt(var10.next(4), 16));
                  continue;
               case 'x':
                  var4.append((char)Integer.parseInt(var10.next(2), 16));
                  continue;
               }
            default:
               if (var3 == var2) {
                  return var4.toString();
               }

               var4.append(var3);
            }
         }
      case '[':
         this.back();
         return new JSONArray(this);
      case '{':
         this.back();
         return new JSONObject(this);
      default:
         StringBuffer var12 = new StringBuffer();

         for(var3 = var1; var1 >= ' ' && ",:]}/\\\"[{;=#".indexOf(var1) < 0; var1 = this.Method202()) {
            var12.append(var1);
         }

         this.back();
         String var11;
         if ((var11 = var12.toString().trim()).equals("")) {
            throw this.syntaxError("Missing value.");
         } else if (var11.equalsIgnoreCase("true")) {
            return Boolean.TRUE;
         } else if (var11.equalsIgnoreCase("false")) {
            return Boolean.FALSE;
         } else if (var11.equalsIgnoreCase("null")) {
            return JSONObject.NULL;
         } else if ((var3 < '0' || var3 > '9') && var3 != '.' && var3 != '-' && var3 != '+') {
            return var11;
         } else {
            if (var3 == '0') {
               if (var11.length() > 2 && (var11.charAt(1) == 'x' || var11.charAt(1) == 'X')) {
                  try {
                     return new Integer(Integer.parseInt(var11.substring(2), 16));
                  } catch (Exception var9) {
                  }
               } else {
                  try {
                     return new Integer(Integer.parseInt(var11, 8));
                  } catch (Exception var8) {
                  }
               }
            }

            try {
               return Integer.valueOf(var11);
            } catch (Exception var7) {
               try {
                  return new Long(Long.parseLong(var11));
               } catch (Exception var6) {
                  try {
                     return Double.valueOf(var11);
                  } catch (Exception var5) {
                     return var11;
                  }
               }
            }
         }
      }
   }

   public final JSONException syntaxError(String var1) {
      return new JSONException(var1 + this.toString());
   }

   public final String toString() {
      return " at character " + this.myIndex + " of " + this.mySource;
   }
}
