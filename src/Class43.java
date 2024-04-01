final class Class43 extends Class28 {
   private final ConversationHistoryPage Field94;

   Class43(ConversationHistoryPage var1, String var2) {
      super(var2);
      this.Field94 = var1;
   }

   public final void CommandExecuted() {
      synchronized(this.Field94._obj) {
         this.Field94.Field923 = this.Field94._startMessageId = -1;
         this.Field94.Field919 = true;
         this.Field94.IsLoaded = this.Field94.IsDone = this.Field94.Initialized = false;
         this.Field94.Clear();
         this.Field94.Method0();
      }

      Class198.Instance.Method487();
   }
}
