public final class Class226 extends VKResponse {
   

   public Class226(long var1, int id, String var4) {
      super(/*Field728 == null ? (Field728 = Method4("ss")) : Field728,*/ "execute.getPlaylist");
      this.AddLong("owner_id", var1);
      this.AddIntiger("id", id);
      this.AddParameter("access_key", var4);
   }

   
   
   public VKAudio[] Items;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         JSONArray var4;
         if ((json = json.Method180("response")) != null && (var4 = json.optJSONArray("audios")) != null) {
            this.Items = new VKAudio[var4.Count()];

            for(int i = 0; i < var4.Count(); i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Items[i] = (VKAudio)(new VKAudio()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
