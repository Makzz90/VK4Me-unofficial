public final class Class94 extends VKResponse {
   

   public Class94(long owner_id, int offset, int var4) {
      super(/*Field281 == null ? (Field281 = Method4("cv")) : Field281,*/ "photos.getAlbums");
      this.AddLong("owner_id", owner_id);
      this.AddIntiger("photo_sizes", 1);
      this.AddIntiger("need_system", 1);
      this.AddIntiger("need_covers", 1);
      this.AddIntiger("count", 5);
      this.AddIntiger("offset", offset);
   }

   
   public Class242[] Items;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         JSONArray var4;
         if ((json = json.Method180("response")) != null && (var4 = json.optJSONArray("items")) != null) {
            this.Items = new Class242[var4.Count()];

            for(int i = 0; i < this.Items.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Items[i] = (Class242)(new Class242()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
