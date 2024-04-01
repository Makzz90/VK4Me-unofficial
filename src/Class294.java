public class Class294 extends VKError {
   public VKGroup[] groups;

   public final boolean GotSomeGroups() {
      return this.groups != null && this.groups.length > 0;
   }

   public final DataJson ProcessFields(JSONObject json) {
      super.ProcessFields(json);
      if (json == null) {
         return this;
      } else {
         JSONArray var4 = (json = json.Method180("response")) != null ? json.optJSONArray("items") : null;
         
         if (var4 != null) {
            this.groups = new VKGroup[var4.Count()];

            for(int i = 0; i < this.groups.length; i++) {
               JSONObject jo= var4.Method508(i);
               if (jo != null) {
                  this.groups[i] = (VKGroup)(new VKGroup()).ProcessFields(jo);
               }
            }
         }

         return this;
      }
   }
}
