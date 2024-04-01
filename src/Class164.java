public class Class164 extends VKError {
   public VKMessage Field561;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            this.Field561 = (VKMessage)(new VKMessage()).ProcessFields(var1);
         }

         return this;
      }
   }
}
