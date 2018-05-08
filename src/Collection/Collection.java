package Collection;
import java.util.ArrayList;
import java.util.List;

public class Collection {
    public List retStudent(int Student_id,String sec)
    {
        List lst=new ArrayList();
        lst.add(Student_id);
        lst.add(sec);

        return lst;

    }
}
