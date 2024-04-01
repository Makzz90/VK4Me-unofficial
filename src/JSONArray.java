import java.util.Vector;

public final class JSONArray {
   private Vector myArrayList;

   public JSONArray() {
      this.myArrayList = new Vector();
   }

   /**
    * Construct a JSONArray from a JSONTokener.
    * @param x A JSONTokener
    * @throws JSONException If there is a syntax error.
    */
   public JSONArray(JSONTokener x) throws JSONException   {
      this();
      if (x.nextClean() != '[') {
         throw x.syntaxError("A JSONArray text must start with '['");
      } else if (x.nextClean() != ']') {
         x.back();

         while(true) {
            if (x.nextClean() == ',') {
               x.back();
               this.myArrayList.addElement(null);
            } else {
               x.back();
               this.myArrayList.addElement(x.nextString());
            }

            switch(x.nextClean()) {
            case ',':
            case ';':
               if (x.nextClean() == ']') {
                  return;
               }

               x.back();
               break;
            case ']':
               return;
            default:
               throw x.syntaxError("Expected a ',' or ']'");
            }
         }
      }
   }

   /**
    * Construct a JSONArray from a source sJSON text.
    * @param string     A string that begins with
    * <code>[</code>&nbsp;<small>(left bracket)</small>
    *  and ends with <code>]</code>&nbsp;<small>(right bracket)</small>.
    *  @throws JSONException If there is a syntax error.
    */
   public JSONArray(String string) throws JSONException  {
      this(new JSONTokener(string));
   }

   /**
    * Get the double value associated with an index.
    *
    * @param index The index must be between 0 and length() - 1.
    * @return      The value.
    * @throws   JSONException If the key is not found or if the value cannot
    *  be converted to a number.
    */
   private double getDouble(int index) throws JSONException {
      Object o = this.get(index);
      if (o == null)
      {
         throw new JSONException("JSONArray[" + index + "] not found.");
      }
      else
      {
         try
         {
            return Double.valueOf(o.toString()).doubleValue();
         } catch (Exception var4) {
            throw new JSONException("JSONArray[" + index + "] is not a number.");
         }
      }
   }

   /**
    * Make a string from the contents of this JSONArray. The
    * <code>separator</code> string is inserted between each element.
    * Warning: This method assumes that the data structure is acyclical.
    * @param separator A string that will be inserted between the elements.
    * @return a string.
    * @throws JSONException If the array contains an invalid number.
    */
   private String join(String separator) throws JSONException {
      int len = this.myArrayList.size();
      StringBuffer sb = new StringBuffer();

      for(int i = 0; i < len; i++) {
         if (i > 0) {
            sb.append(separator);
         }

         sb.append(JSONObject.valueToString(this.myArrayList.elementAt(i)).toString());
      }

      return sb.toString();
   }

   public final int Count() {
      return this.myArrayList.size();
   }

   private Object get(int index) {
      return index >= 0 && index < this.myArrayList.size() ? this.myArrayList.elementAt(index) : null;
   }

   
   public final int Method506(int index, int defaultValue) {
       try {
           return (int)getDouble(index);
       } catch (Exception e) {
           return defaultValue;
       }
   }

   public final JSONArray optJSONArray(int index) {
      Object o = this.get(index);
      return o instanceof JSONArray ? (JSONArray)o : null;
   }

   public final JSONObject Method508(int var1) {
      Object var2;
      return (var2 = this.get(var1)) instanceof JSONObject ? (JSONObject)var2 : null;
   }

   public final long Method509(int var1, long var2) {
      try {
         return (long)this.getDouble(var1);
      } catch (Exception var4) {
         return 0L;
      }
   }

   public final String Method510(int var1) {
      String var3 = "";
      Object var4;
      return (var4 = this.get(var1)) != null ? var4.toString() : var3;
   }

   /**
    * Append an object value. This increases the array's length by one.
    * @param value An object value.  The value should be a
    *  Boolean, Double, Integer, JSONArray, JSONObject, Long, or String, or the
    *  JSONObject.NULL object.
    * @return this.
    */
   public final JSONArray put(Object value) {
      this.myArrayList.addElement(value);
      return this;
   }

   public final String toString() {
      try {
         return '[' + this.join(",") + ']';
      } catch (Exception var1) {
         return null;
      }
   }
}
