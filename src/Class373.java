public class Class373 extends VKUsersAndGroups {
   //public Class422[] Items;
   public int Count;

   //public final boolean Method36() {
   //   return this.Items != null && this.Items.length > 0;
   //}

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         if ((var1 = var1.Method180("response")) != null) {
            var1.optGetInt("count");
            JSONArray var2;
            if ((var2 = var1.optJSONArray("items")) != null) {
               this.Items = new Class422[var2.Count()];

               for(int i = 0; i < this.Items.length; i++) {
                  JSONObject var4;
                  if ((var4 = var2.Method508(i)) != null) {
                     this.Items[i] = (Class422)(new Class422()).ProcessFields(var4);
                  }
               }
            }

            this.Count = var1.optGetInt("unread_count");
         }

         return this;
      }
   }
}
