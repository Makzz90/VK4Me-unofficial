import javax.microedition.rms.RecordStore;

public class RecordStoreHelper {
   public boolean Field374;
   private long _startTime;
   private int _millis;
   public int Field377;
   public int Field378;
   public int Field379;
   public byte AnimationType;

   public RecordStoreHelper() {
   }

   public static boolean DeleteRecord(String key) {
      try {
         RecordStore.deleteRecordStore("ph_" + key);
         return true;
      } catch (Exception ex) {
         return false;
      }
   }

   public static byte[] GetRecord(String key) {
      byte[] var1 = null;

      try {
         RecordStore store = RecordStore.openRecordStore("ph_" + key, true);
         if (store.getNumRecords() > 0) {
            var1 = store.getRecord(1);
         }

         store.closeRecordStore();
      } catch (Exception ex) {
      }

      return var1;
   }

   public static boolean AddRecord(String key, byte[] content) {
      try {
         DeleteRecord(key);
         RecordStore store = RecordStore.openRecordStore("ph_" + key, true);
         store.addRecord(content, 0, content.length);
         store.closeRecordStore();
         return true;
      } catch (Exception ex) {
         return false;
      }
   }

   public RecordStoreHelper(int var1) {
      this.AnimationType = (byte)var1;
   }

   public void Method153(int var1) {
      this._millis = 100;
      this._startTime = System.currentTimeMillis();
      this.Field374 = true;
      this.Field377 = this.Field379;
   }

   public void SetAnimationDuration(int millis) {
      this._millis = millis;
      this._startTime = System.currentTimeMillis();
      this.Field374 = true;
      this.Field379 = this.Field377;
      //System.out.println("SetAnimationDuration->"+this.Field379);
   }

   public void Method155() {
      this.Field379 = this.Field378;
      this.Field374 = false;
      //System.out.println("Method155->"+this.Field379+"AnimationType="+AnimationType);
   }

   public boolean Method156() {
      if (!this.Field374)
      {
         return false;
      }
      else
      {
         long millis = System.currentTimeMillis() - this._startTime;
         if (millis >= (long)this._millis)
         {
            this.Method155();
            return true;
         }
         else
         {
            switch(this.AnimationType)
            {
            case 1:
               millis = millis * millis / (long)this._millis;
               break;
            case 2:
               millis = (long)this._millis - millis;
               millis = millis * millis / (long)this._millis;
               millis = (long)this._millis - millis;
               break;
            case 3:
               millis = (long)((int)Class198.Method491((0.5D - Math.cos((double)millis * 3.141592653589793D / (double)this._millis) / 2.0D) * (double)this._millis));
            }

            long var3 = (long)this._millis - millis;
            this.Field379 = (int)(((long)this.Field377 * var3 + (long)this.Field378 * millis) / (long)this._millis);
            //System.out.println("Method156->"+this.Field379+"millis="+millis+"var3="+var3+"AnimationType="+AnimationType);
            return false;
         }
      }
   }
}
