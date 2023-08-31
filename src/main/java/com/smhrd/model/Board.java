package com.smhrd.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Board {
	private int num;
	private String title;
	private String writer;
	private String fileName;
	private String content;
	private String b_Date;
}
