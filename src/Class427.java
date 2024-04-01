public class Class427 extends VKError {
   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         var1.optGetInt("response");
         return this;
      }
   }
}
