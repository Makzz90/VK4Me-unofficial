public final class Class199 extends VKUsersAndGroups {
	public VKNewsfeedPost Field567;

   public Class199() {
      super("wall.getById");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   public Class199(long var1, int var3) {
      this();
      this.AddParameter("posts", var1 + "_" + var3);
   }
   
   public final DataJson ProcessFields(JSONObject json) {
	      super.ProcessFields(json);
	      if (json == null) {
	         return this;
	      } else {
	         JSONArray var2;
	         if ((json = json.Method180("response")) != null && (var2 = json.optJSONArray("items")) != null && var2.Count() > 0) {
	            this.Field567 = (VKNewsfeedPost)(new VKNewsfeedPost()).ProcessFields(var2.Method508(0));
	         }

	         return this;
	      }
	   }
}
