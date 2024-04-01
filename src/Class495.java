public class Class495 extends VKError {
   public VKPhoto[] Field1348;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var1 = var1.Method180("response")) != null && (var4 = var1.optJSONArray("items")) != null) {
            this.Field1348 = new VKPhoto[var4.Count()];

            for(int i = 0; i < this.Field1348.length; i++) {
               JSONObject var3;
               if ((var3 = var4.Method508(i)) != null) {
                  this.Field1348[i] = (VKPhoto)(new VKPhoto()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
