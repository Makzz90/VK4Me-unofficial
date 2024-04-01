public class Class57 extends VKError {
   public VKDocument[] Field155;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var10000 = (var1 = var1.Method180("response")) != null ? var1.optJSONArray("items") : null;
         JSONArray var4 = var10000;
         if (var10000 != null) {
            this.Field155 = new VKDocument[var4.Count()];

            for(int var2 = 0; var2 < this.Field155.length; ++var2) {
               JSONObject var3;
               if ((var3 = var4.Method508(var2)) != null) {
                  this.Field155[var2] = (VKDocument)(new VKDocument()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
