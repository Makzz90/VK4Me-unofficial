public class Class26 extends VKError {
   private JSONObject Field46;

   public final boolean Method26(int var1) {
      return this.Field46 != null && (this.Field46.optGetInt(String.valueOf(var1)) == 1 || this.Field46.optGetInt("response") == 1 || this.Field46.Method180("response") != null && this.Field46.Method180("response").optGetInt(String.valueOf(var1)) == 1);
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field46 = var1;
         return this;
      }
   }
}
