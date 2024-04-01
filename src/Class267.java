public class Class267 extends VKUsersAndGroups {
   public VKWallReply[] Field830;

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
            JSONArray var4;
            if ((var4 = var1.optJSONArray("items")) != null) {
               this.Field830 = new VKWallReply[var4.Count()];

               for(int i = 0; i < this.Field830.length; i++) {
                  JSONObject var3;
                  if ((var3 = var4.Method508(i)) != null) {
                     this.Field830[i] = (VKWallReply)(new VKWallReply()).ProcessFields(var3);
                  }
               }
            }
         }

         return this;
      }
   }
}
