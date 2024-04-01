public class Class154 extends VKError {
   public String Field542;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            this.Field542 = var1.optGetString("upload_url");
         }

         return this;
      }
   }
}
