package com.spring_crud.Spring_Crud.payloads;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PostPaginationResponse {
    private List<PostDTO> data;
    private  int pageNumber;
    private  int pageSize;
    private  long totalElements;
    private  int totalPages;
    private boolean isLastPage;

}
