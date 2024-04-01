public final class VKMessage extends DataJson {
   public long peer_id;
   public long from_id;
   public int id;
   private int date;
   private int update_time;
   public VKAttachment[] attachments;
   public boolean out;
   public VKMessage[] fwd_messages;
   public VKMessage reply_message;
   public VKMessageAction action;
   public String text;/*
   public static String Field994 = "¬ы";
   public static String Field995 = "создало беседу";
   public static String Field996 = "создал беседу";
   public static String Field997 = "создала беседу";
   public static String Field998 = "присоединилось";
   public static String Field999 = "присоединилс€";
   public static String Field1000 = "присоединилась";
   public static String Field1001 = "пригласило";
   public static String Field1002 = "пригласил";
   public static String Field1003 = "пригласила";
   public static String Field1004 = "к беседе";
   public static String Field1005 = "к беседе по ссылке";
   public static String Field1006 = "из беседы";
   public static String Field1007 = "исключило";
   public static String Field1008 = "исключил";
   public static String Field1009 = "исключила";
   public static String Field1010 = "вышло";
   public static String Field1011 = "вышел";
   public static String Field1012 = "вышла";
   public static String Field1013 = "*пусто*";
   public static String Field1014 = "[¬ложение]";
   public static String Field1015 = "[¬ложени€]";
   public static String Field1016 = "[ѕересланное]";
   public static String Field1017 = "[ѕересланные]";
   public static String Field1018 = "[ќтвет]";
   public static String Field1019 = "название беседы на";
   public static String Field1020 = "фото беседы";
   public static String Field1021 = "сообщение";
   public static String Field1022 = "обновило";
   public static String Field1023 = "обновил";
   public static String Field1024 = "обновила";
   public static String Field1025 = "удалило";
   public static String Field1026 = "удалил";
   public static String Field1027 = "удалила";
   public static String Field1028 = "закрепило";
   public static String Field1029 = "закрепил";
   public static String Field1030 = "закрепила";
   public static String Field1031 = "открепило";
   public static String Field1032 = "открепил";
   public static String Field1033 = "открепила";*/

   public final DataJson ProcessFields(JSONObject var1) {
      if (var1 == null) {
         return this;
      } else {
         this.update_time = var1.optGetInt("update_time");
         this.id = var1.optGetInt("id");
         this.out = Method433(var1.optGetInt("out"));
         var1.optGetInt("conversation_message_id");
         var1.optGetBoolean("is_hidden");
         this.date = var1.optGetInt("date");
         this.peer_id = var1.optLong("peer_id");
         this.from_id = var1.optLong("from_id");
         this.text = var1.optGetString("text");
         var1.optLong("random_id");
         JSONArray var2  = var1.optJSONArray("attachments");
         int i;
         JSONObject json;
         if (var2 != null)
         {
            this.attachments = new VKAttachment[var2.Count()];

            for(i = 0; i < this.attachments.length; i++)
            {
               if ((json = var2.Method508(i)) != null)
               {
            	   this.attachments[i] = new VKAttachment();
                  this.attachments[i].ProcessFields(json);
               }
            }
         }

         var1.optGetBoolean("important");
         if ((var2 = var1.optJSONArray("fwd_messages")) != null) {
            this.fwd_messages = new VKMessage[var2.Count()];

            for(i = 0; i < this.fwd_messages.length; i++)
            {
               if ((json = var2.Method508(i)) != null)
               {
                  this.fwd_messages[i] = (VKMessage)(new VKMessage()).ProcessFields(json);
               }
            }
         }

         JSONObject var5;
         if ((var5 = var1.Method180("reply_message")) != null) {
            this.reply_message = (VKMessage)(new VKMessage()).ProcessFields(var5);
         }

         if ((var5 = var1.Method180("action")) != null) {
            this.action = (VKMessageAction)(new VKMessageAction()).ProcessFields(var5);
         }

         return this;
      }
   }

   public final boolean IsAction() {
      return this.action != null && !IsStringEmpty(this.action.type);
   }

   public final boolean Method2() {
      return this.fwd_messages != null && this.fwd_messages.length > 0;
   }

   public final boolean Method40() {
      return this.reply_message != null;
   }

   public final String Method216(boolean var1, boolean var2, boolean var3, boolean var4, boolean var5, VKGroupOrUser owner) {
      String var6 = "";
      //VKGroupOrUser owner;
      if (var1) {
         //owner = Class31.GetUser(this.from_id);
         if (!var2) {
            var6 = var6 + (this.out ? Localized.GetString("j2vk.you") : (owner != null ? (var3 ? owner.GetTitle("nom") : owner.GetName("nom")) : ""));
         } else {
            var6 = var6 + (this.out ? Localized.GetString("j2vk.you") : "");
         }

         if (!var2 || this.out) {
            var6 = var6 + ": ";
         }
      }

      if (this.IsAction()) {
         //owner = Class31.GetUser(this.from_id);
         String var8 = "";
         var4 = (long)this.action.member_id == this.from_id;
         if (var1) {
            var8 = var8 + (owner != null ? (!var3 ? owner.GetName("nom") : owner.GetTitle("nom")) : "");
            var8 = var8 + " ";
         }

         StringBuffer var10000;
         String var10001;
         if (this.action.type.equals("chat_create")) {
            if (owner != null) {
               var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.created_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.created_f") : Localized.GetString("j2vk.created_m")));
            }

            var10000 = (new StringBuffer()).append(var8).append(" \"");
            var10001 = this.action.text;
         } else {
            if (this.action.type.equals("chat_invite_user")) {
               if (owner != null) {
                  if (!var4) {
                     var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.invited_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.invited_f") : Localized.GetString("j2vk.invited_m")));
                  } else {
                     var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.joined_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.joined_f") : Localized.GetString("j2vk.joined_m")));
                  }
               }

               if (!var4)
               {
            	   owner = Class31.GetUser((long)this.action.member_id);
                  if (owner != null)
                  {
                     var8 = var8 + " " + (var3 ? owner.GetTitle("acc") : owner.GetName("acc"));
                  }
               } else {
                  var8 = var8 + " " + Localized.GetString("j2vk.to_chat");
               }

               return var8;
            }

            if (this.action.type.equals("chat_kick_user")) {
               if (owner != null) {
                  if (!var4) {
                     var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.kicked_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.kicked_f") : Localized.GetString("j2vk.kicked_m")));
                  } else {
                     var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.left_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.left_f") : Localized.GetString("j2vk.left_m")));
                  }
               }

               if (!var4)
               {
            	   owner = Class31.GetUser((long)this.action.member_id);
                  if (owner != null) {
                     var8 = var8 + " " + (var3 ? owner.GetTitle("acc") : owner.GetName("acc"));
                  }
               } else {
                  var8 = var8 + " " + Localized.GetString("j2vk.from_chat");
               }

               return var8;
            }

            if (this.action.type.equals("chat_invite_user_by_link")) {
               if (owner != null) {
                  var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.joined_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.joined_f") : Localized.GetString("j2vk.joined_m")));
               }

               var8 = var8 + " " + Localized.GetString("j2vk.to_chat_via_link");
               return var8;
            }

            if (this.action.type.equals("chat_photo_remove")) {
               if (owner != null) {
                  var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.removed_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.removed_f") : Localized.GetString("j2vk.removed_m")));
               }

               var8 = var8 + " " + Localized.GetString("j2vk.chat_photo");
               return var8;
            }

            if (this.action.type.equals("chat_photo_update")) {
               if (owner != null) {
                  var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.updated_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.updated_f") : Localized.GetString("j2vk.updated_m")));
               }

               var8 = var8 + " " + Localized.GetString("j2vk.chat_photo");
               return var8;
            }

            if (this.action.type.equals("chat_title_update")) {
               if (owner != null) {
                  var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.updated_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.updated_f") : Localized.GetString("j2vk.updated_m")));
               }

               var10000 = (new StringBuffer()).append(var8).append(" ").append(Localized.GetString("j2vk.chat_title_to")).append(" \"");
               var10001 = this.action.text;
            } else {
               if (this.action.type.equals("chat_unpin_message")) {
                  if (owner != null) {
                     var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.unpinned_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.unpinned_f") : Localized.GetString("j2vk.unpinned_m")));
                  }

                  var8 = var8 + " " + Localized.GetString("j2vk.message");
                  return var8;
               }

               if (!this.action.type.equals("chat_pin_message")) {
                  return var8;
               }

               if (owner != null) {
                  var8 = var8 + (owner.is_group ? Localized.GetString("j2vk.pinned_it") : (((VKUser)owner).sex == 1 ? Localized.GetString("j2vk.pinned_f") : Localized.GetString("j2vk.pinned_m")));
               }

               var8 = var8 + " " + Localized.GetString("j2vk.message");
               if (IsStringEmpty(this.action.message)) {
                  return var8;
               }

               var10000 = (new StringBuffer()).append(var8).append(" \"");
               var10001 = this.action.message.length() > 24 ? this.action.message.substring(0, 24) + "..." : this.action.message;
            }
         }

         var8 = var10000.append(var10001).append("\"").toString();
         return var8;
      } else {
         if (var4 && this.Method40() && Class31.GetUser(this.reply_message.from_id) != null) {
            var6 = var6 + Localized.GetString("j2vk.reply") + "\n";
         }

         if (this.Method213()) {
            if (this.attachments.length > 1) {
               var6 = var6 + Localized.GetString("j2vk.attachs") + "\n";
            } else {
               var6 = var6 + Localized.GetString("j2vk.attach") + "\n";
            }
         }

         if (var5 && this.Method2()) {
            if (this.fwd_messages.length > 1) {
               var6 = var6 + Localized.GetString("j2vk.forwards") + "\n";
            } else {
               var6 = var6 + Localized.GetString("j2vk.forward") + "\n";
            }
         }

         if (!Class291.IsNullOrEmpty(this.text)) {
            var6 = var6 + this.text.trim();
         } else if (!this.Method213() && var5 && !this.Method2()) {
            var6 = var6 + Localized.GetString("j2vk.empty");
         }

         return var6;
      }
   }

   public final String toString() {
      return this.Method216(false, false, false, true, true,null);
   }

   public final boolean Method213() {
      return this.attachments != null && this.attachments.length > 0;
   }

   public final int Method217() {
      return this.update_time > this.date ? this.update_time : this.date;
   }

   public final boolean Method37() {
      return !Class291.IsNullOrEmpty(this.text);
   }

   public final boolean Method211() {
      return (System.currentTimeMillis() / 1000L - (long)this.date) / 86400L < 1L;
   }
}
