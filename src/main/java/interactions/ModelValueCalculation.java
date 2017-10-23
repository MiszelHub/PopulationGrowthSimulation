package interactions;

import models.BasePopulationModel;

/**
 * Created by Marcinn on 2017-10-17.
 */
public interface ModelValueCalculation<T> {
    BasePopulationModel calculateValue(BasePopulationModel model, T timeUnit);
}
