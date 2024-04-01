public final class Class282 extends VKUsersAndGroups {
	public VKWallReply[] Items;

   public Class282() {
      super("wall.getComments");
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
      this.AddIntiger("extended", 1);
      this.AddIntiger("thread_items_count", 10);
      this.AddIntiger("need_likes", 1);
      this.Method404("asc");
   }

   public Class282(int var1, int offset) {
      this();
      byte count = 5;
      this.AddIntiger("count", count);
      this.AddIntiger("offset", offset);
   }

   public final Class282 Method404(String var1) {
      this.AddParameter("sort", var1);
      return this;
   }

   public final DataJson ProcessFields(JSONObject var1) {
	      super.ProcessFields(var1);
	      if (var1 == null) {
	         return this;
	      } else {
	         if ((var1 = var1.Method180("response")) != null) {
	            var1.optGetInt("count");
	            var1.optGetInt("current_level_count");
	            var1.optGetBoolean("can_post");
	            var1.optGetBoolean("show_reply_button");
	            var1.optGetBoolean("groups_can_post");
	            JSONArray var4= var1.optJSONArray("items");
	            if (var4 != null) {
	               this.Items = new VKWallReply[var4.Count()];

	               for(int i = 0; i < this.Items.length; i++) {
	                  JSONObject var3;
	                  if ((var3 = var4.Method508(i)) != null) {
	                     this.Items[i] = (VKWallReply)(new VKWallReply()).ProcessFields(var3);
	                  }
	               }
	            }
	         }

	         return this;
	      }
	   }
}
