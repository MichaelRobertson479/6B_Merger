/**
  Represent a merge operation for sorted lists,
  as described in README.md
 */
import java.util.ArrayList;

public class Merger {

    ArrayList<String> usersData;

    /**
      Construct an instance from a list of data
      part of which is to be merged. See README
     */
    public Merger( ArrayList<String> list) {
        usersData = list;
    }


    /**
      Merge the sorted sub-lists.
     */
    public void merge(
      // indexes of sub-list boundaries; see README
        int start0  // index of first item in list0
      , int start1  // index of first item in list1
                    // = just past end of list0
      , int nItems  // number of items in the merged list
                    // = just past end of list1
      ) {

        ArrayList<String> merged = new ArrayList<String>();
        ArrayList<String> list0 = new ArrayList<String>();
        ArrayList<String> list1 = new ArrayList<String>();

        //for (int index = start1; index < nItems; index++)
        for (int index = nItems - 1; index > start1 - 1; index--)
        list1.add(0,usersData.remove(index));

        //for (int index = start0; index < start1; index++)
        for (int index = start1 - 1; index > start0 - 1; index--)
        list0.add(0,usersData.remove(index));

        // System.out.println("List 0:" + list0);
        // System.out.println("List 1:" + list1);

        while ((list0.size() > 0) && (list1.size() > 0)) {

          if (list0.get(0).compareTo(list1.get(0)) > 0)
          merged.add(list1.remove(0));

          else
          merged.add(list0.remove(0));
        }

        if (list0.size() == 0) {
          for (String element : list1)
          merged.add(element);
        }

        else {
          for (String element : list0)
          merged.add(element);
        }

        for (int count = 0; count < nItems - start0; count++)
        usersData.add(start0 + count, merged.remove(0));
    }


    /**
      @return a string representation of the user's data
     */
    public String toString() {
        return "" + usersData;
    }


    /**
      @return the boolean value of the statement
         "the data in the range are in ascending order"
     */
    public boolean isSorted( int startAt, int endBefore) {
        for( int i = startAt
           ; i < endBefore -1 // stop early, because comparing to next
           ; i++
           )
            if( usersData.get(i).compareTo( usersData.get(i+1)) > 0) return false;
        return true;
    }
}
