public final class VKConversation extends DataJson implements Class313 {
   private VKConversationPeer peer;
   public int in_read;
   public int out_read;
   public int unread_count;
   private VKConversationCanWrite can_write;
   public VKConversationSettings chat_settings;
   public VKConversationPushSettings push_settings;

   public final long GetPeerId() {
      return this.Method212() ? this.peer.id : 0L;
   }

   private boolean Method211() {
      return this.Method37() && this.chat_settings.is_group_channel;
   }

   public final boolean GetCanWrite() {
      return this.can_write != null && this.can_write.allowed;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         JSONObject obj;
         if ((obj = json.Method180("peer")) != null) {
            this.peer = (VKConversationPeer)(new VKConversationPeer()).ProcessFields(obj);
         }

         if ((obj = json.Method180("can_write")) != null) {
            this.can_write = (VKConversationCanWrite)(new VKConversationCanWrite()).ProcessFields(obj);
         }

         if ((obj = json.Method180("chat_settings")) != null) {
            this.chat_settings = (VKConversationSettings)(new VKConversationSettings()).ProcessFields(obj);
         }

         if ((obj = json.Method180("push_settings")) != null) {
            this.push_settings = (VKConversationPushSettings)(new VKConversationPushSettings()).ProcessFields(obj);
         }

         this.in_read = json.optGetInt("in_read");
         this.out_read = json.optGetInt("out_read");
         this.unread_count = json.optGetInt("unread_count");
         json.optGetBoolean("important");
         json.optGetBoolean("unanswered");
         return this;
      }
   }

   public final boolean IsDialog() {
      return this.Method212() && (this.peer.type.equals("user") || this.peer.type.equals("group")) && !this.Method211();
   }

   public final boolean Method40() {
      return !this.IsDialog() && !this.Method211();
   }

   private boolean Method212() {
      return this.peer != null;
   }

   public final String Method39() {
      VKGroupOrUser var1 = this.IsDialog() ? Class31.GetUser(this.peer.id) : null;
      if (this.IsDialog()) {
         return var1 != null ? var1.GetName("nom") : null;
      } else {
         return this.Method37() ? this.chat_settings.title : null;
      }
   }

   public final boolean Method213() {
      return this.Method37() && this.chat_settings.photo != null && !Class489.IsStringEmpty(this.chat_settings.photo.Field1336);
   }

   public final boolean Method37() {
      return this.chat_settings != null;
   }
}
