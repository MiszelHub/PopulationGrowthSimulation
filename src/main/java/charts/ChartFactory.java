package charts;

import org.jfree.data.general.Dataset;

public interface ChartFactory<T> {

    T CreateChart(final Dataset dataset,final String title, final String xAxisLabel, final String yaxisLabel);
}
