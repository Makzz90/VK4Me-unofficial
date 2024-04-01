public final class Class392 extends VKError {
   public VKUser[] Field1136;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var1 = var1.Method180("response")) != null && (var4 = var1.optJSONArray("items")) != null) {
            this.Field1136 = new VKUser[var4.Count()];

            for(int var2 = 0; var2 < this.Field1136.length; ++var2) {
               JSONObject var3;
               if ((var3 = var4.Method508(var2)) != null) {
                  this.Field1136[var2] = (VKUser)(new VKUser()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
