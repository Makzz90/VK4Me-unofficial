public class Class210 extends VKError {
   public VKPhoto Field705;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var2;
         if ((var2 = var1.optJSONArray("response")) != null && var2.Count() > 0 && (var1 = var2.Method508(0)) != null) {
            this.Field705 = (VKPhoto)(new VKPhoto()).ProcessFields(var1);
         }

         return this;
      }
   }
}
