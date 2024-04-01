public class Class60 extends VKError {
   public int likes = -1;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         if ((json = json.Method180("response")) != null) {
            this.likes = json.getInt("likes", -1);
         }

         return this;
      }
   }
}
