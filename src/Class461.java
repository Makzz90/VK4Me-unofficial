public final class Class461 extends VKResponse {
   

   public Class461(long owner_id, int album_id, int offset, int var5) {
      super(/*Field1281 == null ? (Field1281 = Method4("sa")) : Field1281,*/ "photos.get");
      this.AddLong("owner_id", owner_id);
      this.AddIntiger("album_id", album_id);
      this.AddIntiger("photo_sizes", 1);
      this.AddIntiger("count", 5);
      this.AddIntiger("offset", offset);
   }

   
   public VKPhoto[] Field1348;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var1 = var1.Method180("response")) != null && (var4 = var1.optJSONArray("items")) != null) {
            this.Field1348 = new VKPhoto[var4.Count()];

            for(int i = 0; i < this.Field1348.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Field1348[i] = (VKPhoto)(new VKPhoto()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
