public class Class185 extends VKError {
   public VKUser[] Field597;

   public final boolean Method36() {
      return this.Field597 != null && this.Field597.length > 0;
   }

   public final VKUser Method351() {
      return this.Method36() ? this.Field597[0] : null;
   }

   public final boolean Method213() {
      return this.Method351() != null;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var4 = var1.optJSONArray("response")) != null) {
            this.Field597 = new VKUser[var4.Count()];

            for(int i = 0; i < this.Field597.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Field597[i] = (VKUser)(new VKUser()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
