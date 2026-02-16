package stackV1;


//كل عنصر جديد يتم انشائه مثال  Element el =new Element
//يكون موجد فيه مكانين فارغين الاول value
//والثاني هو المكان الفارغ اللذي مرتبط مع value
// value.........Element next
//Element next:    لكن عندما ننشآ العنصر الاول يكون في البداية فارغ  Element ايضآ عنصر


public class Element {
  public    int value;
   public Element next;
//kunstructor
    //  هذا هو المنشأ اللذي ينشأ لي عنصر جديد من الكلاسة السابقة
    public Element(int value) {
        this.value = value;
        this.next = null;
    }
}
