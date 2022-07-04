package kgitbank.boostcamp.jy.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@RequiredArgsConstructor
public class PageVO {
	@NonNull private Long maxPage;
	@NonNull private Long start;
	@NonNull private Long end;
	private String title;
}