public final class Class217 extends VKUsersAndGroups {
   
	private VKWallReply[] Field589;
   public Class217() {
      super("wall.getComment");
   }

   public Class217(long owner_id, int var3) {
      this();
      this.AddLong("owner_id", owner_id);
      this.AddIntiger("comment_id", var3);
   }

   public final VKWallReply Method410() {
	      return this.Field589 != null && this.Field589.length > 0 ? this.Field589[0] : null;
	   }

	   public final boolean Method36() {
	      return this.Method410() != null;
	   }

	   public final DataJson ProcessFields(JSONObject var1) {
	      super.ProcessFields(var1);
	      if (var1 == null) {
	         return this;
	      } else {
	         if ((var1 = var1.Method180("response")) != null) {
	            var1.optGetInt("count");
	            JSONArray var4;
	            if ((var4 = var1.optJSONArray("items")) != null) {
	               this.Field589 = new VKWallReply[var4.Count()];

	               for(int i = 0; i < this.Field589.length; i++) {
	                  JSONObject var3;
	                  if ((var3 = var4.Method508(i)) != null) {
	                     this.Field589[i] = (VKWallReply)(new VKWallReply()).ProcessFields(var3);
	                  }
	               }
	            }
	         }

	         return this;
	      }
	   }
}
