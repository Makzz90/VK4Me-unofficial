public final class VKMessageAction extends DataJson {
   public String text;
   public String type;
   public String message;
   public int member_id;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.text = json.optGetString("text");
         json.optGetString("email");
         this.type = json.optGetString("type");
         this.member_id = json.optGetInt("member_id");
         this.message = json.optGetString("message");
         if ((json = json.Method180("photo")) != null) {
            (new Class489()).ProcessFields(json);
         }

         return this;
      }
   }
}
