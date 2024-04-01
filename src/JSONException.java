public final class JSONException extends Exception {
   public JSONException(String var1) {
      super(var1);
   }

   public JSONException(Throwable var1) {
      super(var1.getMessage());
   }
}
