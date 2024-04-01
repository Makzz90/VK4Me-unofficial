public final class Class52 extends VKResponse {
   //private static Class Field152;

   public Class52() {
      super("friends.get");
      this.SetOrder("mobile");
      this.AddIntiger("extended", 1);
      this.AddParameter("fields", "crop_photo,photo_50,photo_100,online,online_app,online_mobile,last_seen,sex,status,screen_name");
   }

   private Class52(long user_id) {
      this();
      this.AddLong("user_id", user_id);
   }

   public Class52(long user_id, int count, int offset) {
      this(user_id);
      this.AddIntiger("count", count);
      this.AddIntiger("offset", offset);
   }

   public final Class52 SetOrder(String order) {
      this.AddParameter("order", order);
      return this;
   }
   
   
   public VKUser[] Items;

   public final boolean GotSomeItems() {
      return this.Items != null && this.Items.length > 0;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var10000 = (var1 = var1.Method180("response")) != null ? var1.optJSONArray("items") : null;
         JSONArray var4 = var10000;
         if (var10000 != null) {
            this.Items = new VKUser[var4.Count()];

            for(int i = 0; i < this.Items.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Items[i] = (VKUser)(new VKUser()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
   
}
