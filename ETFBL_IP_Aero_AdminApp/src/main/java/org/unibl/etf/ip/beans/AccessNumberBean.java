package org.unibl.etf.ip.beans;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;


import org.primefaces.model.charts.ChartData;
import org.primefaces.model.charts.bar.BarChartDataSet;
import org.primefaces.model.charts.bar.BarChartModel;
import org.primefaces.model.charts.line.LineChartModel;
import org.primefaces.model.charts.pie.PieChartModel;
import org.unibl.etf.ip.dao.AccessNumberDAO;
import org.unibl.etf.ip.dto.AccessNumberDTO;

@ManagedBean(name = "accessNumberBean")
@RequestScoped
public class AccessNumberBean implements Serializable {

	private static final long serialVersionUID = -8675086949639277253L;
	private LineChartModel lineModel;
	private BarChartModel barModel = new BarChartModel();
	private ArrayList<AccessNumberDTO> list = new ArrayList<AccessNumberDTO>();
	private PieChartModel pieModel;

	public AccessNumberBean() {
		super();
		createChart();
	}

	public LineChartModel getLineModel() {
		return lineModel;
	}

	public void setLineModel(LineChartModel lineModel) {
		this.lineModel = lineModel;
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	public void setBarModel(BarChartModel barModel) {
		this.barModel = barModel;
	}

	public ArrayList<AccessNumberDTO> getList() {
		return list;
	}

	public void setList(ArrayList<AccessNumberDTO> list) {
		this.list = list;
	}

	public PieChartModel getPieModel() {
		return pieModel;
	}

	public void setPieModel(PieChartModel pieModel) {
		this.pieModel = pieModel;
	}

	public void createChart() {
		list = AccessNumberDAO.getAllAccess();
		barModel = new BarChartModel();
		lineModel = new LineChartModel();
		ChartData data = new ChartData();
		BarChartDataSet dataSet = new BarChartDataSet();
		ArrayList<Number> numbers = new ArrayList<Number>();
		ArrayList<String> dates = new ArrayList<String>();
		
		for (AccessNumberDTO accessNumberDTO : list) {
			numbers.add(accessNumberDTO.getNumber());
			dates.add(accessNumberDTO.getDate());
			// date.set(accessNumberDTO.getDate(), accessNumberDTO.getNumber());
		}
		
		Collections.sort(dates);
		
		dataSet.setLabel("BarChart for access number in UserApp");
		dataSet.setData(numbers);
		dataSet.setBorderColor("rgb[255, 255, 51]");
		dataSet.setBackgroundColor("rgb[255, 255, 51]");
		data.addChartDataSet(dataSet);
		data.setLabels(dates);

		barModel.setData(data);

	}

}
