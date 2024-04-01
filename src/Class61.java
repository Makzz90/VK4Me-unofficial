public final class Class61 extends VKUsersAndGroups {
	public VKNewsfeedPost[] Field691;

   public Class61() {
      super( "wall.get");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
      String var2 = "all";
      this.AddParameter("filter", var2);
   }

   private Class61(long owner_id) {
      this();
      this.AddLong("owner_id", owner_id);
   }

   public Class61(long var1, int var3, int var4) {
      this(var1);
      byte var2 = 20;
      this.AddIntiger("count", var2);
      this.AddIntiger("offset", var4);
   }
   
   public final DataJson ProcessFields(JSONObject var1) {
	      super.ProcessFields(var1);
	      if (var1 == null) {
	         return this;
	      } else {
	         JSONArray var4;
	         if ((var1 = var1.Method180("response")) != null && (var4 = var1.optJSONArray("items")) != null) {
	            this.Field691 = new VKNewsfeedPost[var4.Count()];

	            for(int i = 0; i < this.Field691.length; i++) {
	               JSONObject var3;
	               if ((var3 = var4.Method508(i)) != null) {
	                  this.Field691[i] = (VKNewsfeedPost)(new VKNewsfeedPost()).ProcessFields(var3);
	               }
	            }
	         }

	         return this;
	      }
	   }

}
