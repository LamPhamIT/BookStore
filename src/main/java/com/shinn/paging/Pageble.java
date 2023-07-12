package com.shinn.paging;

import com.shinn.sort.Sorter;

public interface Pageble {
    Integer getPage();
    Integer getOffSet();
    Integer getLimit();
    Sorter getSorter();

}
