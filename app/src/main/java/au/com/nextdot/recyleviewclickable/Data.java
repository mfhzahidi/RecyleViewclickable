package au.com.nextdot.recyleviewclickable;

/**
 * Created by sakib on 2/14/2018.
 */

public class Data {
    int image_no;
    String head,details;

    public Data(int image_no, String head, String details) {
        this.setDetails(details);
        this.setHead(head);
        this.setImage_no(image_no);
    }

    public int getImage_no() {

        return image_no;
    }

    public void setImage_no(int image_no) {
        this.image_no = image_no;
    }

    public String getHead() {
        return head;
    }

    public void setHead(String head) {
        this.head = head;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }
}
