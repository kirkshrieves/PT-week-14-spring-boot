package com.promineotech.jeep.controller;

import java.math.BigDecimal;

import com.promineotech.jeep.entity.JeepModel;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data // @Data = @Getter, @Setter, @EqualsAndHashCode, @ToString, @NoArgsConstructor
@Builder // @Builder = builder design patter; turns no args constructor into an all args constructor
@NoArgsConstructor // still needed to create more jeep objects in the future
@AllArgsConstructor// needed to unbreak @Builder because it needs an @AllArgsConstructor

public class Jeep {
	
	private Long modelPK;
	private JeepModel modelId;
	private String trimLevel;
	private int numDoors;
	private int wheelSize;
	private BigDecimal basePrice;
}
