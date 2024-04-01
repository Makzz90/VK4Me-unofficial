public final class VKConversationPeer extends DataJson {
   public long id;
   public String type;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.id = json.optLong("id");
         json.optLong("local_id");
         this.type = json.optGetString("type");
         return this;
      }
   }
}
