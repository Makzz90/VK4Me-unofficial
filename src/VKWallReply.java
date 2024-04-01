

public class VKWallReply extends DataJson implements Class353 {
   public int id;
   public long from_id;
   public long owner_id;
   public int date;
   public String text;
   private int[] parents_stack;
   public VKAttachment[] attachments;
   public Class186 thread;
   public int post_id;
   public boolean Field840;
   public VKWallReply Field841;
   private boolean deleted;
   //public static String Field843 = "Комментарий удалён пользователем или руководителем страницы";

   public final boolean Method36() {
      return this.deleted || this.from_id == 0L;
   }

   public final boolean Method2() {
      return this.thread != null;
   }

   public final String Method359(boolean var1, boolean var2, boolean var3, boolean var4) {
      if (this.Method36()) {
         return Localized.GetString("j2vk.comment_deleted");
      } else {
         String var6 = "";
         if (var1) {
            VKGroupOrUser var5 = Class31.GetUser(this.from_id);
            var6 = var6 + (this.Field840 ? Localized.GetString("j2vk.you") : (var5 != null ? (var3 ? var5.GetTitle("nom") : var5.GetName("nom")) : ""));
            var6 = var6 + ": ";
         }

         if (var4 && this.Method40() && Class31.GetUser(this.Field841.from_id) != null) {
            var6 = var6 + Localized.GetString("j2vk.reply") + "\n";
         }

         if (this.IsAttachmentsExists()) {
            if (this.attachments.length > 1) {
               var6 = var6 + Localized.GetString("j2vk.attachs") + "\n";
            } else {
               var6 = var6 + Localized.GetString("j2vk.attach") + "\n";
            }
         }

         if (!Class291.IsNullOrEmpty(this.text)) {
            var6 = var6 + this.text.trim();
         }

         return var6;
      }
   }

   public final String toString() {
      return "wall_reply" + this.owner_id + "_" + this.id;
   }

   public final boolean Method40() {
      return this.Field841 != null;
   }

   public final boolean IsAttachmentsExists() {
      return this.attachments != null && this.attachments.length > 0;
   }

   public final boolean IsStringExists() {
      return !IsStringEmpty(this.text);
   }

   public final boolean Method211() {
      return (System.currentTimeMillis() / 1000L - (long)this.date) / 86400L < 1L;
   }

   public final int GetDate() {
      return this.date;
   }

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         this.deleted = json.optGetBoolean("deleted");
         this.id = json.optGetInt("id");
         this.from_id = json.optLong("from_id");
         this.Field840 = this.from_id == Settings.Instance.UserId/*Field603.Field734*/;
         this.date = json.optGetInt("date");
         json.optGetInt("reply_to_user");
         json.optGetInt("reply_to_comment");
         this.text = json.optGetString("text");
         this.post_id = json.optGetInt("post_id");
         this.owner_id = json.optLong("owner_id");
         JSONObject var2 = json.Method180("thread");
         if(var2!=null)
         {
        	 this.thread = (Class186)(new Class186()).ProcessFields(var2);
         }
         /*
         var2 = json.Method180("likes");
         
         if (var2 != null)
         {
            (new VKLike()).ProcessFields(var2);
         }
*/
         int i;
         JSONArray var6 = json.optJSONArray("parents_stack");
         if (var6 != null)
         {
            this.parents_stack = new int[var6.Count()];

            for(i = 0; i < this.parents_stack.length; i++) {
               this.parents_stack[i] = var6.Method506(i, 0);
            }
         }
         
         var6 = json.optJSONArray("attachments");
        		 
         if (var6 != null)
         {
            this.attachments = new VKAttachment[var6.Count()];

            for(i = 0; i < this.attachments.length; i++)
            {
            	json = var6.Method508(i);
               if (json != null)
               {
            	   this.attachments[i] = new VKAttachment();
                  this.attachments[i].ProcessFields(json);
               }
            }
         }

         return this;
      }
   }

   public final String GetType() {
      return "comment";
   }

   public final long GetOwnerId() {
      return this.owner_id;
   }

   public final int GetId() {
      return this.id;
   }
}
