public class Class394 extends VKError {
   public VKGroup[] Field1137;

   public final boolean Method36() {
      return this.Field1137 != null && this.Field1137.length > 0;
   }

   public final VKGroup Method350() {
      return this.Method36() ? this.Field1137[0] : null;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var4 = var1.optJSONArray("response")) != null) {
            this.Field1137 = new VKGroup[var4.Count()];

            for(int i = 0; i < this.Field1137.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Field1137[i] = (VKGroup)(new VKGroup()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
