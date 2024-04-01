public class Class431 extends VKError {
   public boolean Field1200;
   public int Field1201;
   public int Field1202;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            this.Field1200 = Method433(var1.optGetInt("success"));
            var1.optGetInt("post_id");
            this.Field1201 = var1.optGetInt("reposts_count");
            this.Field1202 = var1.optGetInt("likes_count");
         }

         return this;
      }
   }
}
