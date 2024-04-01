public final class VKImageWithSize extends DataJson 
{
   public String type;
   public String url;
   public int width;
   public int height;

   public final DataJson ProcessFields(JSONObject json)
   {
      if (json == null)
      {
         return this;
      }
      else
      {
         this.type = json.optGetString("type");
         this.url = json.optGetString("url");
         this.width = json.optGetInt("width");
         this.height = json.optGetInt("height");
         if (!IsStringEmpty(this.type) && (this.width == 0 || this.height == 0))
         {
            short size;
            switch(this.type.charAt(0)) {
            case 'm':
            case 'o':
               size = 130;
               break;
            case 'n':
            case 't':
            case 'u':
            case 'v':
            default:
               size = 0;
               break;
            case 'p':
               size = 200;
               break;
            case 'q':
               size = 320;
               break;
            case 'r':
               size = 510;
               break;
            case 's':
               size = 75;
               break;
            case 'w':
               size = 2560;
               break;
            case 'x':
               size = 604;
               break;
            case 'y':
               size = 807;
               break;
            case 'z':
               size = 1080;
            }

            this.width = Math.max(this.width, size);
            this.height = Math.max(this.height, size);
         }

         return this;
      }
   }

public int compareTo(Object obj1) {
	int p1 = ((VKImageWithSize) obj1).height;
    int p2 = this.height;

    if (p1 > p2) {
        return 1;
    } else if (p1 < p2){
        return -1;
    } else {
        return 0;
    }
}
}
