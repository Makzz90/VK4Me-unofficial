public final class MessageActionItemUC extends TextBlock implements Class498 {
   private VKMessage _msg;

   public MessageActionItemUC(VKConversation var1, VKMessage msg) {
      super(msg.Method216(true, !var1.Method40(), true, !msg.Method40(), !msg.Method2(), null));
      this._msg = msg;
      super.Field1199 = (byte)1;
      TextBlock var10000 = this.Method55(Class6.ColorsInstanse.Field344);
      
      var10000.Field959 = false;
   }

   public final VKMessage GetMessageData() {
      return this._msg;
   }
}
