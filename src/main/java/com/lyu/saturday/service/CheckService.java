package com.lyu.saturday.service;

import com.lyu.saturday.common.exception.SaturdayServiceException;
import com.lyu.saturday.common.utils.IBeanUtils;
import com.lyu.saturday.entity.Check;
import com.lyu.saturday.repository.CheckRepository;
import com.lyu.saturday.vo.CheckVO;
import com.lyu.saturday.vo.MonthVO;
import com.lyu.saturday.vo.TotalChecksVO;
import jakarta.annotation.Resource;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

@Service
public class CheckService {

	@Resource
	private CheckRepository checkRepository;

	public TotalChecksVO getChecks() {

		List<Check> totalChecks = checkRepository.findAll();
		Integer totalChecksCount = totalChecks.size();
		return new TotalChecksVO(totalChecks, totalChecksCount);
	}

	public void createCheck(CheckVO checkVO) throws SaturdayServiceException {
		Check check = new Check();
		BeanUtils.copyProperties(checkVO, check);
		check.setCreateTime(LocalDate.parse(checkVO.getCreateTime()));
		check.setCashNumber(BigDecimal.valueOf(checkVO.getCheckNumber()));
		checkRepository.save(check);
	}

	@Transactional
	public void editCheck(CheckVO checkVO, long id) throws SaturdayServiceException {
		var check = getCheck(id).orElseThrow(() -> new SaturdayServiceException("the check doesn't exist"));
		IBeanUtils.copyNotNullProperties(checkVO, check);
		check.setCashNumber(BigDecimal.valueOf(checkVO.getCheckNumber()));
		if (null != checkVO.getCreateTime()) {
			check.setCreateTime(LocalDate.parse(checkVO.getCreateTime()));
		}
		checkRepository.save(check);
	}


	public void deleteCheck(long id) throws SaturdayServiceException {
		checkRepository.deleteById(id);
	}

	public MonthVO getMonthExpense(String status) throws SaturdayServiceException {
		var nowDate = LocalDate.now();
		var year = nowDate.getYear();
		var month = nowDate.getMonth();
		var startDate = LocalDate.of(year, month, 1);
		var endDate = LocalDate.of(year, month, nowDate.getMonth().maxLength());
		var monthVo = new MonthVO();

		String monthExpense = getMonthData(startDate, endDate, status).orElseThrow(SaturdayServiceException :: new).toString();
		String lastMonthExpense = getMonthData(startDate.minusMonths(1),
				endDate.minusMonths(1), status).orElseThrow(SaturdayServiceException :: new).toString();
		monthVo.setMonthCheck(monthExpense);
		monthVo.setLastMonthCheck(lastMonthExpense);
		return monthVo;
	}

	private Optional<BigDecimal> getMonthData(LocalDate startDate, LocalDate endDate, String status) {
		return checkRepository.findChecksByCreateTimeBetween(startDate, endDate)
				.filter(check -> check.getStatus().equals(status))
				.map(Check :: getCashNumber)
				.stream().reduce(BigDecimal :: add);
	}

	private Optional<Check> getCheck(long id) {
		return checkRepository.findById(id);
	}

}
