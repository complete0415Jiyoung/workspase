package com.kh.opendata.model.vo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Air {
	//item에 있는 데이터 중 필요한 부분만 필드에 담는다. 

	//필드
	private String stationName; //측정소명
	private String dataTime; //측정일시
	private String khaiValue; //통합대기환경수치

	private String pm10Value; //미세먼지농도
	private String so2Value; //아황산가스농도
	private String coValue;//일산화탄소농도
	private String no2Value;//이산화질소농도
	private String o3Value;//오존농도
}
