public final class Class3 extends VKResponse {
   

   public Class3(int count, int offset) {
      this(count, offset, 0);
   }

   private Class3(int count, int offset, int var3) {
      super("docs.get");
      this.AddIntiger("offset", offset);
      this.AddIntiger("count", count);
      this.AddIntiger("type", 0);
      this.AddIntiger("return_tags", 0);
   }
   
   
   public VKDocument[] Items;

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         JSONArray var10000 = (json = json.Method180("response")) != null ? json.optJSONArray("items") : null;
         JSONArray var4 = var10000;
         if (var10000 != null) {
            this.Items = new VKDocument[var4.Count()];

            for(int i = 0; i < this.Items.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Items[i] = (VKDocument)(new VKDocument()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }

}
