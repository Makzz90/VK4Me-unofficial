public class Class66 extends VKError {
   public int Field195 = -1;

   public final boolean IsSucsess() {
      return this.Field195 != -1;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            this.Field195 = var1.getInt("comment_id", -1);
         } else {
            this.Field195 = -1;
         }

         return this;
      }
   }
}
