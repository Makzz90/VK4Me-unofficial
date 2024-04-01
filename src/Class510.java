public class Class510 extends VKError {
   public int Field1356;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            var1.optGetInt("success");
            if (var1.optGetInt("friend_deleted") == 1) {
               this.Field1356 = 10;
            } else if (var1.optGetInt("out_request_deleted") == 1) {
               this.Field1356 = 20;
            } else if (var1.optGetInt("in_request_deleted") == 1) {
               this.Field1356 = 30;
            } else if (var1.optGetInt("suggestion_deleted") == 1) {
               this.Field1356 = 40;
            }
         }

         return this;
      }
   }
}
