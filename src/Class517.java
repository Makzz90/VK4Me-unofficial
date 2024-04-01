public class Class517 extends VKUsersAndGroups {
   private VKConversation[] Field1367;

   public final VKConversation Method348() {
      return this.Field1367 != null && this.Field1367.length > 0 ? this.Field1367[0] : null;
   }

   public final boolean Method36() {
      return this.Method348() != null;
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
               this.Field1367 = new VKConversation[var4.Count()];

               for(int i = 0; i < this.Field1367.length; i++) {
                  JSONObject var3;
                  if ((var3 = var4.Method508(i)) != null) {
                     this.Field1367[i] = (VKConversation)(new VKConversation()).ProcessFields(var3);
                  }
               }
            }
         }

         return this;
      }
   }
}
