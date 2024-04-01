public final class VKConversationSettings extends DataJson {
   public String title;
   public VKMessage pinned_message;
   public Class489 photo;
   public boolean is_group_channel;
   private long[] active_ids;
   private long[] admin_ids;
   private int owner_id;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.owner_id = json.optGetInt("owner_id");
         json.optGetInt("members_count");
         this.title = json.optGetString("title");
         json.optGetString("state");
         JSONObject var2;
         if ((var2 = json.Method180("pinned_message")) != null) {
            this.pinned_message = (VKMessage)(new VKMessage()).ProcessFields(var2);
         }

         if ((var2 = json.Method180("photo")) != null) {
            this.photo = (Class489)(new Class489()).ProcessFields(var2);
         }

         this.is_group_channel = json.optGetBoolean("is_group_channel");
         int i;
         JSONArray var6;
         if ((var6 = json.optJSONArray("active_ids")) != null) {
            this.active_ids = new long[var6.Count()];

            for(i = 0; i < this.active_ids.length; i++) {
               this.active_ids[i] = var6.Method509(i, 0L);
            }
         }

         if ((var6 = json.optJSONArray("admin_ids")) != null) {
            this.admin_ids = new long[var6.Count()];

            for(i = 0; i < this.admin_ids.length; i++) {
               this.admin_ids[i] = var6.Method509(i, 0L);
            }
         }

         return this;
      }
   }

   public final boolean Method192(long var1) {
      if ((long)this.owner_id == var1) {
         return true;
      } else if (this.admin_ids == null || this.admin_ids.length <= 0) {
         return false;
      } else {
         for(int i = 0; i < this.admin_ids.length; ++i) {
            if (var1 == this.admin_ids[i]) {
               return true;
            }
         }

         return false;
      }
   }
}
