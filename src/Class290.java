public class Class290 extends VKError {
   public String server;
   public String key;
   public int ts;

   public final boolean IsSucsess()
   {
      return super.IsSucsess() && !IsStringEmpty(this.server) && !IsStringEmpty(this.key) && this.ts != 0;
   }

   public final DataJson ProcessFields(JSONObject var1) {
      super.ProcessFields(var1);
      if (var1 == null)
      {
         return this;
      }
      else
      {
         if ((var1 = var1.Method180("response")) != null)
         {
            this.ts = var1.optGetInt("ts");
            this.server = var1.optGetString("server");
            this.key = var1.optGetString("key");
         }

         return this;
      }
   }
}
