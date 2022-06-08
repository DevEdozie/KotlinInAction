import java.util.ArrayList;
import java.util.Collection;
//import strings.JoinKt;
import strings.Boy;

import strings.StringFunctions;
//import strings.BoyKt;
import strings.BoyKt;
import strings.Human;
import strings.Boy;
public class Practice  {



    public static void main(String[] args) {
        /*
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        System.out.println(joinToString(list,",","{","}"));
        System.out.println(joinToString(list));
        System.out.println(StringFunctions.joinToString(list,",","{","}"));
        BoyKt.sayMyName("Michael");
        System.out.println(BoyKt.AGE);
        System.out.println(BoyKt.middleChar("Jack"));
        System.out.println(BoyKt.append("John","Kennedy"));
        Human human = new Boy();
        human.talk();
        BoyKt.dance(human);
        Boy boy = new Boy();
        boy.talk();
        boy.dance();
        Character val = BoyKt.getFirstChar("Java");
        //
        BoyKt.getFirstChar("Hole");
        */

    }

public static String joinToString(ArrayList list, String seperator, String prefix, String postFix){
    StringBuilder result = new StringBuilder(prefix);
    int i;
    for( i = 0; i < list.size();i++){
        if(i > 0) result.append(seperator);
        result.append(list.get(i));
    }
    result.append(postFix);
    return result.toString();
}

static String joinToString(ArrayList list){
    StringBuilder result = new StringBuilder("{");
    int i;
    for( i = 0; i < list.size();i++){
        if(i > 0) result.append(",");
        result.append(list.get(i));
    }
    result.append("}");
    return result.toString();
}

}
