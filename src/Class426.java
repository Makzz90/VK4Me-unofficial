public class Class426 extends VKError {
   private JSONObject Field1190;

   public final boolean Method26(int var1) {
      return this.Field1190 != null && (this.Field1190.optGetInt(String.valueOf(var1)) == 1 || this.Field1190.optGetInt("response") == 1 || this.Field1190.Method180("response") != null && this.Field1190.Method180("response").optGetInt(String.valueOf(var1)) == 1);
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field1190 = var1;
         return this;
      }
   }
}
