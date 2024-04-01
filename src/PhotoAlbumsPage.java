final class PhotoAlbumsPage extends Class446 {
   private final long _ownerId;

   PhotoAlbumsPage(String var1, boolean var2, long var3)
   {
      super(var1, true);
      this._ownerId = var3;
   }

   public final void LoadData() {
      Class198.Instance.SetInLoadingState(true);
      if (this.next_from == null) {
         this.next_from = new Integer(-1);
      }

      this.next_from = new Integer(((Integer)this.next_from).intValue() + 1);
      Class94 var1=new Class94(this._ownerId, ((Integer)this.next_from).intValue() * 5, 5);
      var1.GetResponse();
      Class198.Instance.SetInLoadingState(false);
      
      if (var1 != null && var1.Items != null && var1.Items.length > 0) {
         if (var1.Items.length < 5) {
            this.IsAllLoaded = true;
         }

         for(int i = 0; i < var1.Items.length; i++) {
            Class242 var3 = var1.Items[i];
            this.AddElement(new AttachmentItemUC(var3));
         }
      } else {
         this.IsAllLoaded = true;
         if (var1 == null) {
            Class198.Instance.ShowError(Localized.GetString("general.loadError"));
         }
      }

      
   }
}
