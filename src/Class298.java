public class Class298 extends VKError {
   public int Field929;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            this.Field929 = var1.optGetInt("delay");
         }

         return this;
      }
   }
}
