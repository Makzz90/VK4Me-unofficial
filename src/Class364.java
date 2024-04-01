public class Class364 extends VKError {
   public VKAttachment Field1052;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         if ((json = json.Method180("response")) != null) {
            this.Field1052.ProcessFields(json);
         }

         return this;
      }
   }
}
