public class Class297 extends VKError {
   public boolean Field928;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field928 = Method433(var1.optGetInt("response"));
         return this;
      }
   }
}
