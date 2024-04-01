public final class Class191 extends MethodsWithParameters {
   //private static Class Field609;

   public Class191(String var1) {
      super(/*Field609 == null ? (Field609 = Method4("kl")) : Field609,*/ "auth.validatePhone");
      this.AddParameter("api_id", "2274003");
      this.AddParameter("client_id", "2274003");
      this.AddParameter("client_secret", "hHbZxrka2uZ6jB1inYsH");
      this.AddParameter("sid", var1);
   }

   public final VKError DoDispatch()  {
      String var1 = Class278.Method376(this);

      JSONObject json;
      try {
         json = new JSONObject(var1);
      } catch (Exception var3) {//Class116
         Logger.PrintError(var3);
         json = null;
      }

      VKError error = new VKError();//this.GetErrorFromClass();
      error.ProcessFields(json);
      return error;
      //return json != null && error != null ? (VKError)error.ProcessFields(json) : error;
   }
/*
   private static Class Method4(String var0) {
      try {
         return Class.forName(var0);
      } catch (ClassNotFoundException var1) {
         throw new NoClassDefFoundError(var1.getMessage());
      }
   }*/
}
