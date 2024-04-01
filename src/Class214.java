public class Class214 extends VKError {
   public boolean Field717;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field717 = Method433(var1.optGetInt("response"));
         return this;
      }
   }
}
