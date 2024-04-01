public final class VKConversationWithLastMessage extends DataJson {
   public VKConversation conversation;
   public VKMessage last_message;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         JSONObject obj = json.Method180("conversation");
         if (obj  != null)
         {
            this.conversation = (VKConversation)(new VKConversation()).ProcessFields(obj);
         }
         obj = json.Method180("last_message");
         if (obj != null)
         {
            this.last_message = (VKMessage)(new VKMessage()).ProcessFields(obj);
         }

         return this;
      }
   }
}
