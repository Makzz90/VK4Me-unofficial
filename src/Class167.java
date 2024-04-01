public class Class167 extends VKUsersAndGroups {
   public VKNewsfeedPost Field567;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var2;
         if ((var1 = var1.Method180("response")) != null && (var2 = var1.optJSONArray("items")) != null && var2.Count() > 0) {
            this.Field567 = (VKNewsfeedPost)(new VKNewsfeedPost()).ProcessFields(var2.Method508(0));
         }

         return this;
      }
   }
}
