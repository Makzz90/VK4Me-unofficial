public class Class446 extends Page {
   public Object next_from;
   public Object LastElementId;
   public final Object _obj = new Object();
   public boolean IsAllLoaded = false;
   public boolean Field1227 = false;

   public final Page ShowOutOfMemoryError() {
      this.IsAllLoaded = true;
      return super.ShowOutOfMemoryError();
   }

   public Class446(String lable, boolean var2)  {
      super(lable);
      this.Field825 = new Class36(Localized.GetString("general.actions"));
      this.Field825.AddElement((new Class258(this, Localized.GetString("action.refresh"))).SetRleIcon("new/refresh.rle"));
      if (var2) {
         this.Method20();
      }

   }

   public void Method20()  {
      if (!this.Field1227) {
         synchronized(this._obj) {
            Class446 var2 = this;
            if (!this.Field1227) {
               synchronized(this._obj) {
                  var2.Clear();
                  var2.next_from = null;
                  var2.LastElementId = null;
                  var2.IsAllLoaded = false;
               }
            }

            this.Method21();
         }
      }
   }

   public final void Method8() {
      if (!this.IsAllLoaded && this.ScrollableHeight - this.Field813 - Class198.Instance.Field646 < Class198.Instance._tbNormal.Height << 2 + Class198.Instance.CharSpaceWidth) {
         this.Method21();
      }

   }

   public void LoadData() /*throws Exception*/ {
   }

   public final void Method21() {
      if (!this.Field1227 && !this.IsAllLoaded) {
         this.Field1227 = true;
         (new Class260(this)).start();
      }
   }
}
