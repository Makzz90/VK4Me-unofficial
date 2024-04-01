public class Class225 extends VKUsersAndGroups {
   private VKPlayList[] Field727;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var1 = var1.Method180("response")) != null && (var4 = var1.optJSONArray("items")) != null) {
            this.Field727 = new VKPlayList[var4.Count()];

            for(int var2 = 0; var2 < var4.Count(); ++var2) {
               JSONObject var3;
               if ((var3 = var4.Method508(var2)) != null) {
                  this.Field727[var2] = (VKPlayList)(new VKPlayList()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
