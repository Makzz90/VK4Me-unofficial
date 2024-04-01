

final class Class460 implements Runnable {
   Class460(Class326 var1) {
   }

   public final void run() {
      if (Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
