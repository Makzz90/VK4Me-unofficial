public final class VKConversationCanWrite extends DataJson {
   public boolean allowed;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.allowed = json.optGetBoolean("allowed");
         json.optGetInt("reason");
         return this;
      }
   }
}
