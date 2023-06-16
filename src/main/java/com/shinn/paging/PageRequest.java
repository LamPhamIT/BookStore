package com.shinn.paging;

import com.shinn.sort.Sorter;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@NoArgsConstructor
@Data
public class PageRequest implements Pageble{
    private Integer page;
    private Integer maxPageItem;
    private Sorter sorter;
    private int totalPage;
    private Integer totalItem;
    public PageRequest(Integer page, Integer maxPageItem, Sorter sorter) {
        this.page =page;
        this.maxPageItem = maxPageItem;
        this.sorter = sorter;
    }
    @Override
    public Integer getPage() {
        return this.page;
    }
    @Override
    public Integer getOffSet() {
        if(page != null && maxPageItem != null) {
            return (this.page - 1) * this.maxPageItem;
        }
        return null;
    }
    @Override
    public Integer getLimit() {
        return this.maxPageItem;
    }
}
