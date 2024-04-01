public class Class159 extends VKError {
   private int Field550;

   public final boolean IsSucsess() {
      return super.IsSucsess() && this.Field550 != 0;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field550 = var1.optGetInt("response");
         return this;
      }
   }
}
