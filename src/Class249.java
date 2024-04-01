public class Class249 extends VKError {
   private JSONObject Field791;

   public final boolean Method26(int var1) {
      return this.Field791 != null && (this.Field791.optGetInt(String.valueOf(var1)) == 1 || this.Field791.optGetInt("response") == 1 || this.Field791.Method180("response") != null && this.Field791.Method180("response").optGetInt(String.valueOf(var1)) == 1);
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field791 = var1;
         return this;
      }
   }
}
