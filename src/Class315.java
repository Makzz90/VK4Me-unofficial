

final class Class315 implements Runnable {
   Class315(Class329 var1) {
   }

   public final void run() {
      if (!Settings.Instance.IsAutorized()) {
         Settings.Instance.ApplyUrls();
      } else {
         Class198.Instance.ShowError(Localized.GetString("error.proxyRestartRequired"));
      }
   }
}
