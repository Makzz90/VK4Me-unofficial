public class Class418 extends VKError {
   private int Field1169;

   public final boolean IsSucsess() {
      return super.IsSucsess() && this.Field1169 != 0;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field1169 = var1.optGetInt("response");
         return this;
      }
   }
}
