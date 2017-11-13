package charts.builders;

import charts.builders.exceptions.ToManyArgumentsException;
import org.jfree.data.general.Dataset;

import java.util.List;

public interface IDataSetBuilder<X extends Number,Y extends Number> {
    IDataSetBuilder<X,Y> AddDataSeries(List<Y> values, X argumentsRange, String seriesName) throws ToManyArgumentsException;
    Dataset build();
}
