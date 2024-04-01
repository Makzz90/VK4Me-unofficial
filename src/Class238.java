public class Class238 extends VKError {
   public String Field749;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            this.Field749 = var1.optGetString("token");
         }

         return this;
      }
   }
}
