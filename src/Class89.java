final class Class89 extends Thread {
   private final Class118 Field273;

   Class89(Class118 var1) {
      this.Field273 = var1;
   }

   public final void run() {
      try {
         synchronized(this.Field273._obj) {
            this.Field273.Method23();
            this.Field273.Initialized = true;
            this.Field273.IsLoading = false;
            this.Field273.Method8();
         }
      } catch (Exception var4) {
         Class198.Instance.ShowError(var4);
      } catch (OutOfMemoryError var5) {
         this.Field273.ShowOutOfMemoryError();
      }

      Class198.Instance.SetInLoadingState(false);
   }
}
