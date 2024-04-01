public class Class235 extends VKError {
   public int Field743;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field743 = var1.getInt("response", -1);
         return this;
      }
   }
}
