import java.util.Enumeration;
import java.util.Hashtable;

public final class JSONObject {
	
	/**
     * The hash map where the JSONObject's properties are kept.
     */
   private Hashtable myHashMap;
   
   /**
    * It is sometimes more convenient and less ambiguous to have a
    * <code>NULL</code> object than to use Java's <code>null</code> value.
    * <code>JSONObject.NULL.equals(null)</code> returns <code>true</code>.
    * <code>JSONObject.NULL.toString()</code> returns <code>"null"</code>.
    */
   public static final Object NULL = new Null();

   public JSONObject() {
      this.myHashMap = new Hashtable();
   }

   public JSONObject(JSONTokener x) throws JSONException {
      this();
     
	      if (x.nextClean() != '{') {
	         throw x.syntaxError("A JSONObject text must begin with '{'");
	      } else {
	         while(true) {
	            switch(x.nextClean()) {
	            case '\u0000':
	               throw x.syntaxError("A JSONObject text must end with '}'");
	            case '}':
	               return;
	            default:
	               x.back();
	               String var3 = x.nextString().toString();
	               char var2;
	               if ((var2 = x.nextClean()) == '=') {
	                  if (x.Method202() != '>') {
	                     x.back();
	                  }
	               } else if (var2 != ':') {
	                  throw x.syntaxError("Expected a ':' after a key");
	               }
	
	               this.put(var3, x.nextString());
	               switch(x.nextClean()) {
	               case ',':
	               case ';':
	                  if (x.nextClean() == '}') {
	                     return;
	                  }
	
	                  x.back();
	                  break;
	               case '}':
	                  return;
	               default:
	                  throw x.syntaxError("Expected a ',' or '}'");
	               }
	            }
	         }
	      }
      }
   

   public JSONObject(String var1) throws Exception  {
      this(new JSONTokener(var1));
   }

   /**
    * Get the value object associated with a key.
    *
    * @param key   A key string.
    * @return      The object associated with the key.
    * @throws   JSONException if the key is not found.
    */
   public Object get(String key) throws JSONException {
       Object o = opt(key);
       if (o == null) {
           throw new JSONException("JSONObject[" + quote(key) +
                   "] not found.");
       }
       return o;
   }

   private double Method168(String paramString) throws Exception{
	    Object object = this.get(paramString);
	    if (object instanceof Byte)
	      return ((Byte)object).byteValue(); 
	    if (object instanceof Short)
	      return ((Short)object).shortValue(); 
	    if (object instanceof Integer)
	      return ((Integer)object).intValue(); 
	    if (object instanceof Long)
	      return ((Long)object).longValue(); 
	    if (object instanceof Float)
	      return ((Float)object).floatValue(); 
	    if (object instanceof Double)
	      return ((Double)object).doubleValue(); 
	    if (object instanceof String)
	      try {
	        return Double.valueOf((String)object).doubleValue();
	      } catch (Exception exception) {
	        throw new JSONException("JSONObject[" + quote(paramString) + "] is not a number.");
	      }  
	    throw new JSONException("JSONObject[" + quote(paramString) + "] is not a number.");
	  }

   /**
    * Determine if the JSONObject contains a specific key.
    * @param key   A key string.
    * @return      true if the key exists in the JSONObject.
    */
   public boolean has(String key) {
       return this.myHashMap.containsKey(key);
   }

   /**
    * Get an enumeration of the keys of the JSONObject.
    *
    * @return An iterator of the keys.
    */
   public Enumeration keys() {
       return this.myHashMap.keys();
   }

   /**
    * Get the number of keys stored in the JSONObject.
    *
    * @return The number of keys in the JSONObject.
    */
   public int length() {
       return this.myHashMap.size();
   }

   private static String numberToString(Object n) throws JSONException {
      if (n == null) {
         throw new JSONException("Null pointer");
      } else {
         testValidity(n);
         String var1;
         if ((var1 = n.toString()).indexOf(46) > 0 && var1.indexOf(101) < 0 && var1.indexOf(69) < 0) {
            while(var1.endsWith("0")) {
               var1 = var1.substring(0, var1.length() - 1);
            }

            if (var1.endsWith(".")) {
               var1 = var1.substring(0, var1.length() - 1);
            }
         }

         return var1;
      }
   }

   private Object opt(String var1) {
      return var1 == null ? null : this.myHashMap.get(var1);
   }

   public final boolean optGetBoolean(String var1) {
      return this.getBoolean(var1, false);
   }

   public final boolean getBoolean(String key, boolean defaultValue) {
      try {
         String var3 = key;
         Object var5;
         if (!(var5 = this.get(key)).equals(Boolean.FALSE) && (!(var5 instanceof String) || !((String)var5).equalsIgnoreCase("false"))) {
            if (!var5.equals(Boolean.TRUE) && (!(var5 instanceof String) || !((String)var5).equalsIgnoreCase("true"))) {
               throw new JSONException("JSONObject[" + quote(var3) + "] is not a Boolean.");
            } else {
               return true;
            }
         } else {
            return false;
         }
      } catch (Exception var4) {
         return defaultValue;
      }
   }

   public final JSONObject put(String key, boolean value) throws JSONException{
      this.put(key, value ? Boolean.TRUE : Boolean.FALSE);
      return this;
   }

   public final int optGetInt(String var1) {
      return this.getInt(var1, 0);
   }

   public final int getInt(String key, int paramInt) {
	    try {
	      String str = key;
	      //Class346 class346;
	      Object object;
	      if ((object = this.get(str)) instanceof Byte)
	        return ((Byte)object).byteValue(); 
	      if (object instanceof Short)
	        return ((Short)object).shortValue(); 
	      if (object instanceof Integer)
	        return ((Integer)object).intValue(); 
	      if (object instanceof Long)
	        return (int)((Long)object).longValue(); 
	      if (object instanceof Float)
	        return (int)((Float)object).floatValue(); 
	      if (object instanceof Double)
	        return (int)((Double)object).doubleValue(); 
	      if (object instanceof String)
	        return (int)this.Method168(str); 
	      throw new JSONException("JSONObject[" + quote(str) + "] is not a number.");
	    } catch (Exception exception) {
	      return paramInt;
	    } 
	  }

   
   /**
    * Get an optional JSONArray associated with a key.
    * It returns null if there is no such key, or if its value is not a
    * JSONArray.
    *
    * @param key   A key string.
    * @return      A JSONArray which is the value.
    */
   public JSONArray optJSONArray(String key) {
       Object o = opt(key);
       return o instanceof JSONArray ? (JSONArray)o : null;
   }

   public final JSONObject Method180(String var1) {
      Object var2;
      return (var2 = this.opt(var1)) instanceof JSONObject ? (JSONObject)var2 : null;
   }

   public final long optLong(String var1) {
      return this.getLong(var1, 0L);
   }

   private long getLong(String key, long defaultValue) {
	    try {
	      String str = key;
	      
	      Object object= this.get(str);
	      if (object instanceof Byte)
	        return ((Byte)object).byteValue(); 
	      if (object instanceof Short)
	        return ((Short)object).shortValue(); 
	      if (object instanceof Integer)
	        return ((Integer)object).intValue(); 
	      if (object instanceof Long)
	        return ((Long)object).longValue(); 
	      if (object instanceof Float)
	        return (long)((Float)object).floatValue(); 
	      if (object instanceof Double)
	        return (long)((Double)object).doubleValue(); 
	      if (object instanceof String)
	        return (long)this.Method168(str); 
	      throw new JSONException("JSONObject[" + quote(str) + "] is not a number.");
	    } catch (Exception exception) {
	      return 0L;
	    } 
	  }

   public final String optGetString(String var1) {
      return this.getString(var1, null);
   }

   public final String getString(String key, String defaultValue) {
      Object var3;
      return (var3 = this.opt(key)) != null ? var3.toString() : defaultValue;
   }

   /**
    * Put a key/int pair in the JSONObject.
    *
    * @param key   A key string.
    * @param value An int which is the value.
    * @return this.
    * @throws JSONException If the key is null.
    */
   public JSONObject put(String key, int value) throws JSONException {
       put(key, new Integer(value));
       return this;
   }

   public final JSONObject put(String key, Object value) throws JSONException{
      if (key == null)
      {
         throw new JSONException("Null key.");
      } else
      {
         if (value != null)
         {
            testValidity(value);
            this.myHashMap.put(key, value);
         }
         else
         {
            this.myHashMap.remove(key);
         }

         return this;
      }
   }

   private static String quote(String var0) {
      if (var0 != null && var0.length() != 0) {
         char var2 = 0;
         int var4 = var0.length();
         StringBuffer var5;
         (var5 = new StringBuffer(var4 + 4)).append('"');

         for(int i = 0; i < var4; i++) {
            char var1 = var2;
            switch(var2 = var0.charAt(i)) {
            case '\b':
               var5.append("\\b");
               break;
            case '\t':
               var5.append("\\t");
               break;
            case '\n':
               var5.append("\\n");
               break;
            case '\f':
               var5.append("\\f");
               break;
            case '\r':
               var5.append("\\r");
               break;
            case '"':
            case '\\':
               var5.append('\\');
               var5.append(var2);
               break;
            case '/':
               if (var1 == '<') {
                  var5.append('\\');
               }

               var5.append(var2);
               break;
            default:
               if (var2 < ' ') {
                  String var6 = "000" + Integer.toHexString(var2);
                  var5.append("\\u" + var6.substring(var6.length() - 4));
               } else {
                  var5.append(var2);
               }
            }
         }

         var5.append('"');
         return var5.toString();
      } else {
         return "\"\"";
      }
   }

   private static void testValidity(Object var0) throws JSONException{
      if (var0 != null) {
         if (var0 instanceof Double) {
            if (((Double)var0).isInfinite() || ((Double)var0).isNaN()) {
               throw new JSONException("JSON does not allow non-finite numbers");
            }
         } else if (var0 instanceof Float && (((Float)var0).isInfinite() || ((Float)var0).isNaN())) {
            throw new JSONException("JSON does not allow non-finite numbers.");
         }
      }

   }

   public final String toString() {
      try
      {
         Enumeration enumerator = this.myHashMap.keys();
         StringBuffer sb = new StringBuffer("{");

         while(enumerator.hasMoreElements())
         {
            if (sb.length() > 1)
            {
               sb.append(',');
            }

            Object var3 = enumerator.nextElement();
            sb.append(quote(var3.toString()));
            sb.append(':');
            sb.append(valueToString(this.myHashMap.get(var3)));
         }

         sb.append('}');
         return sb.toString();
      } catch (Exception var4) {
         return null;
      }
   }

   /**
    * Make a JSON text of an Object value. If the object has an
    * value.toJSONString() method, then that method will be used to produce
    * the JSON text. The method is required to produce a strictly
    * conforming text. If the object does not contain a toJSONString
    * method (which is the most common case), then a text will be
    * produced by the rules.
    * <p>
    * Warning: This method assumes that the data structure is acyclical.
    * @param value The value to be serialized.
    * @return a printable, displayable, transmittable
    *  representation of the object, beginning
    *  with <code>{</code>&nbsp;<small>(left brace)</small> and ending
    *  with <code>}</code>&nbsp;<small>(right brace)</small>.
    * @throws JSONException If the value is or contains an invalid number.
    */
   static String valueToString(Object value) throws JSONException{
      if (value != null && !value.equals(null)) {
         if (value instanceof JSONString) {
            String var2;
            try {
               var2 = ((JSONString)value).toJSONString();
            } catch (Exception var1) {
               throw new JSONException(var1);
            }

            if (var2 instanceof String) {
               return (String)var2;
            } else {
               throw new JSONException("Bad value from toJSONString: " + var2);
            }
         } else if (!(value instanceof Float) && !(value instanceof Double) && !(value instanceof Byte) && !(value instanceof Short) && !(value instanceof Integer) && !(value instanceof Long)) {
            return !(value instanceof Boolean) && !(value instanceof JSONObject) && !(value instanceof JSONArray) ? quote(value.toString()) : value.toString();
         } else {
            return numberToString(value);
         }
      } else {
         return "null";
      }
   }
}
