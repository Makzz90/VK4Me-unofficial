public class Class464 extends VKUsersAndGroups {
   private VKMessage[] Field1285;

   public final VKMessage Method194() {
      return this.Field1285 != null && this.Field1285.length > 0 ? this.Field1285[0] : null;
   }

   public final boolean Method36() {
      return this.Method194() != null;
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
               this.Field1285 = new VKMessage[var4.Count()];

               for(int i = 0; i < this.Field1285.length; i++) {
                  JSONObject var3;
                  if ((var3 = var4.Method508(i)) != null) {
                     this.Field1285[i] = (VKMessage)(new VKMessage()).ProcessFields(var3);
                  }
               }
            }
         }

         return this;
      }
   }
}
