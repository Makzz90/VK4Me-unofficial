public class Class190 {
   public static Class229 Field603;
   public static String ApiUrl;
   public static String OauthUrl;
   public static String ProxyUrl;
   //public static Class374 Field607;
   //public static Class402 Field608;

   public static String GetApiUrl() {
      return ApiUrl == null ? "https://api.vk.com/" : ApiUrl;
   }

   public static void Print(String var0) {
      //if (Field607 != null) {
      //   Field607.PrintInfo(var0);
      //}
	   Logger.PrintToConsole(var0);

   }

   public static void Error(Throwable var0) {
      //if (Field607 != null) {
      //   Field607.PrintError(var0);
      //}
	   Logger.PrintError(var0);
   }
}
