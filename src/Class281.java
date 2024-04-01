public class Class281 extends VKError {
   private int Field881;

   public final boolean IsSucsess() {
      return this.Field881 != -1;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field881 = var1.getInt("response", -1);
         return this;
      }
   }
}
