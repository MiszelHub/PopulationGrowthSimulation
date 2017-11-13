package charts.builders;

import charts.builders.exceptions.ToManyArgumentsException;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.general.Dataset;

import java.util.List;

public class DataSetBuilder<X extends Number, Y extends Number> implements IDataSetBuilder<X, Y> {

    private final DefaultCategoryDataset dataSet = new DefaultCategoryDataset();

    @Override
    public IDataSetBuilder<X, Y> AddDataSeries(List<Y> values, X argumentsRange, String seriesName) throws ToManyArgumentsException {

        if (values.size() < argumentsRange.intValue())
            throw new ToManyArgumentsException("Argument count exceeds values count provided in list");

        for (int i = 0; i < argumentsRange.intValue(); i++) {

            dataSet.addValue(values.get(i), seriesName, String.valueOf(i));
        }

        return this;

    }

    @Override
    public Dataset build() {
        return this.dataSet;
    }
}
