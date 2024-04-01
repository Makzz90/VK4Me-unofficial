public class Class78 extends VKError {
   private JSONObject Field224;

   public final boolean Method26(int var1) {
      return this.Field224 != null && (this.Field224.optGetInt(String.valueOf(var1)) == 1 || this.Field224.optGetInt("response") == 1 || this.Field224.Method180("response") != null && this.Field224.Method180("response").optGetInt(String.valueOf(var1)) == 1);
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field224 = var1;
         return this;
      }
   }
}
