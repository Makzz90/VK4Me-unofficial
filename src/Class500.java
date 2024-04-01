public class Class500 extends VKUsersAndGroups {
   public VKMessage[] items;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            var1.optGetInt("count");
            JSONArray var4;
            if ((var4 = var1.optJSONArray("items")) != null) {
               this.items = new VKMessage[var4.Count()];

               for(int i = 0; i < this.items.length; i++) {
                  JSONObject var3;
                  if ((var3 = var4.Method508(i)) != null) {
                     this.items[i] = (VKMessage)(new VKMessage()).ProcessFields(var3);
                  }
               }
            }
         }

         return this;
      }
   }

   public final boolean Method36() {
      return this.items != null && this.items.length > 0;
   }
}
