public class Class183 extends VKError {
   public String upload_url;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         if ((json = json.Method180("response")) != null) {
            this.upload_url = json.optGetString("upload_url");
         }

         return this;
      }
   }
}
