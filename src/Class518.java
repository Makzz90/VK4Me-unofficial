final class Class518 extends Button {
   private final VKGroup Field1368;
   private final Class467 Field1369;

   Class518(Class467 var1, String var2, VKGroup var3) {
      super(var2);
      this.Field1369 = var1;
      this.Field1368 = var3;
   }

   public final void CommandExecuted()  {
      if (this.Field1368.Field857) {
         Class214 var1;
         if ((var1 = (Class214)(new Class179(this.Field1368.Method354())).DoDispatch()) == null) {
            Class198.Instance.ShowError(Localized.GetString("element.groupLeaveError"));
            return;
         }

         if (!var1.Field717) {
            return;
         }

         this.SetLable(this.Field1368.is_closed == 0 ? Localized.GetString("action.joinGroup") : Localized.GetString("action.sendRequest"));
         this.Field1368.Field857 = false;
         this.Field1368.invited_by = 0;
         Class31.AddToCache(this.Field1368);
         this.Field1369.Field1289 = this.Field1368;
      } else {
         Class297 var2;
         if ((var2 = (Class297)(new Class303(this.Field1368.Method354())).DoDispatch()) != null) {
            if (var2.Field928) {
               this.SetLable(Localized.GetString("action.leaveGroup"));
               this.Field1368.Field857 = true;
               Class31.AddToCache(this.Field1368);
               this.Field1369.Field1289 = this.Field1368;
               return;
            }
         } else {
            Class198.Instance.ShowError(Localized.GetString("element.groupJoinError"));
         }
      }

   }
}
