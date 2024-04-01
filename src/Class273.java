public final class Class273 extends VKResponse {
   

   public Class273() {
      super("groups.get");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "can_message,ban_info,can_write_private_message,can_see_audio,followers,friend_status,common_count,blacklisted,blacklisted_by_me,fixed_post,ban_info,members_count,counters,photo_50,photo_100,text,views,reposts,likes,status,sex,online,online_app,online_mobile,last_seen,first_name_nom,first_name_gen,first_name_dat,first_name_acc,first_name_ins,first_name_abl,last_name_nom,last_name_gen,last_name_dat,last_name_acc,last_name_ins,last_name_abl,screen_name,image_status,emoji_status");
   }

   private Class273(long user_id) {
      this();
      this.AddLong("user_id", user_id);
   }

   public Class273(long user_id, int count, int offset) {
      this(user_id);
      this.AddIntiger("count", count);
      this.AddIntiger("offset", offset);
   }

   public final DataJson ProcessFields(JSONObject json) {
	      super.ProcessFields(json);
	      if (json == null) {
	         return this;
	      } else {
	         JSONArray var4 = (json = json.Method180("response")) != null ? json.optJSONArray("items") : null;
	         
	         if (var4 != null) {
	            this.items = new VKGroup[var4.Count()];

	            for(int i = 0; i < this.items.length; i++) {
	               JSONObject jo= var4.Method508(i);
	               if (jo != null) {
	                  this.items[i] = (VKGroup)(new VKGroup()).ProcessFields(jo);
	               }
	            }
	         }

	         return this;
	      }
	   }
   
   public VKGroup[] items;

   public final boolean GotSomeGroups() {
      return this.items != null && this.items.length > 0;
   }
}
