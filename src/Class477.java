final class Class477 extends Button {
   private final VKUser Field1310;
   private final Class467 Field1311;

   Class477(Class467 var1, String var2, VKUser var3) {
      super(var2);
      this.Field1311 = var1;
      this.Field1310 = var3;
   }

   public final void CommandExecuted() {
      switch(this.Field1310.friend_status) {
      case 1:
      case 3:
         Class510 var1;
         if ((var1 = (Class510)(new Class445(this.Field1310.GetId())).DoDispatch()) != null) {
            switch(var1.Field1356) {
            case 10:
               this.SetLable(Localized.GetString("action.acceptFriendsRequest"));
               this.Field1310.friend_status = 2;
               Class31.AddToCache(this.Field1310);
               this.Field1311.Field1289 = this.Field1310;
               return;
            default:
               this.SetLable(Localized.GetString("action.addToFriends"));
               this.Field1310.friend_status = 0;
               Class31.AddToCache(this.Field1310);
               this.Field1311.Field1289 = this.Field1310;
               return;
            }
         }

         Class198.Instance.ShowError(Localized.GetString("element.friendRemoveError"));
         return;
      case 2:
      default:
         Class235 var2;
         if ((var2 = (Class235)(new Class4(this.Field1310.GetId())).DoDispatch()) != null) {
            switch(var2.Field743) {
            case 1:
            case 4:
               this.SetLable(Localized.GetString("action.cancelFriendsRequest"));
               this.Field1310.friend_status = 1;
               Class31.AddToCache(this.Field1310);
               this.Field1311.Field1289 = this.Field1310;
               break;
            case 2:
               this.SetLable(Localized.GetString("action.removeFromFriends"));
               this.Field1310.friend_status = 3;
               Class31.AddToCache(this.Field1310);
               this.Field1311.Field1289 = this.Field1310;
            case 3:
            default:
               return;
            }
         } else {
            Class198.Instance.ShowError(Localized.GetString("element.friendSendError"));
         }

      }
   }
}
