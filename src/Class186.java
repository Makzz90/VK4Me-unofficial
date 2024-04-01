public final class Class186 extends DataJson {
   public VKWallReply[] Items;

   public final DataJson ProcessFields(JSONObject json) {
      if (json == null) {
         return this;
      } else {
         json.optGetInt("count");
         json.optGetBoolean("can_post");
         json.optGetBoolean("show_reply_button");
         json.optGetBoolean("groups_can_post");
         JSONArray var4 = json.optJSONArray("items");
         if (var4 != null)
         {
            this.Items = new VKWallReply[var4.Count()];

            for(int i = 0; i < this.Items.length; i++)
            {
               JSONObject var3 = var4.Method508(i);
               if (var3 != null) {
                  this.Items[i] = (VKWallReply)(new VKWallReply()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
