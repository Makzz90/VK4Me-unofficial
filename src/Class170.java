public class Class170 extends VKError {
   public VKUser[] Field571;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var10000 = (var1 = var1.Method180("response")) != null ? var1.optJSONArray("items") : null;
         JSONArray var4 = var10000;
         if (var10000 != null) {
            this.Field571 = new VKUser[var4.Count()];

            for(int i = 0; i < this.Field571.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Field571[i] = (VKUser)(new VKUser()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
