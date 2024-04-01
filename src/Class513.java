public class Class513 extends VKError {
   public VKAudio[] Field1363;

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null) {
         return this;
      } else {
         JSONArray var4;
         if ((var1 = var1.Method180("response")) != null && (var4 = var1.optJSONArray("audios")) != null) {
            this.Field1363 = new VKAudio[var4.Count()];

            for(int var2 = 0; var2 < var4.Count(); ++var2) {
               JSONObject var3;
               if ((var3 = var4.Method508(var2)) != null) {
                  this.Field1363[var2] = (VKAudio)(new VKAudio()).ProcessFields(var3);
               }
            }
         }

         return this;
      }
   }
}
