package Sort;


import Model.SellProduct;

import java.util.Comparator;

public class SortById implements Comparator<SellProduct> {
        @Override
        public int compare(SellProduct o1, SellProduct o2) {
            if (o1.getId()>(o2.getId())) {
                return 1;
            } else {
                return -1;
            }
        }
    }
