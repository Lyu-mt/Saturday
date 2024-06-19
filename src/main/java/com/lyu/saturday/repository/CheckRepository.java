package com.lyu.saturday.repository;

import com.lyu.saturday.entity.Check;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.util.Streamable;

import java.time.LocalDate;

public interface CheckRepository extends JpaRepository<Check, Long> {
	Streamable<Check> findChecksByCreateTimeBetween(LocalDate startDate, LocalDate endDate);
}
