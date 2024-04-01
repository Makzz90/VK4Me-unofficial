public class Class520 extends VKError {
   private int Field1371;

   public final boolean IsSucsess() {
      return this.Field1371 == 1;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         this.Field1371 = var1.optGetInt("response");
         return this;
      }
   }
}
