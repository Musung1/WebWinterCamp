package com.example.myboard.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedListDto {
	//시작일
	private String startDate;
	//종료일
	private String endDate;
	//선택한 페이지 번호
	private int selectedPage;
	//한 번에 볼 요소들의 갯수
	private int pageSize;
	//정렬 기준
	private String orderby;
	//정렬 방향
	private String orderway;

	public int[] afterBuild(int listsize){
		if(pageSize <= 0){
			pageSize = 10;
		}
		int pagesize_remain = listsize % pageSize;
		int pagesize = listsize / pageSize;
		if(pagesize_remain > 0){
			pagesize++;
		}
		if(pagesize == 0){
			pagesize++;
		}

		if(selectedPage < 1){
			selectedPage = 1;
		} else if(selectedPage > pagesize){
			selectedPage = pagesize;
		}
		int offset = (selectedPage - 1) * pageSize;
		int[] result = {selectedPage, pagesize, pageSize, listsize};
		selectedPage = offset;
		return result;
	}
}