package randomForest;

import quickml.data.AttributesMap;
import quickml.data.instances.ClassifierInstance;
import quickml.supervised.ensembles.randomForest.randomDecisionForest.RandomDecisionForest;
import quickml.supervised.ensembles.randomForest.randomDecisionForest.RandomDecisionForestBuilder;
import quickml.supervised.tree.attributeIgnoringStrategies.IgnoreAttributesWithConstantProbability;
import quickml.supervised.tree.decisionTree.DecisionTreeBuilder;

import java.io.IOException;
import java.util.List;

/**
 * Created by blou on 29/01/17.
 */
/*
Différence entre classification et prédiction :
If you are trying to classify existing data, e.g. group patients based on their known medical data and treatment outcome,
I would call it a classification. If you use a classification model to predict the treatment outcome for a new patient,
it would be a prediction.
*/

/**
 * Classe effectuant l'analyse RF.
 */
public class RandomForestAnalysis {
    /**
     * Selon les infos d'un jour, prédire osn profil à partir du dataset
     * @return
     * @throws IOException
     */
    public String basicPrediction(long pocket,long calling,long niu,long iu) throws IOException {
        //construct trees
        List<ClassifierInstance> irisDataset = PredictiveAccuracyTests.loadDataSet();
        final RandomDecisionForest randomForest = new RandomDecisionForestBuilder<>(new DecisionTreeBuilder<>()
                // The default isn't desirable here because this dataset has so few attributes
                .attributeIgnoringStrategy(new IgnoreAttributesWithConstantProbability(0.2)))
                .buildPredictiveModel(irisDataset);

        //trying to know predict is this unknown flower
        AttributesMap attributes = new AttributesMap();
        attributes.put(AttributeEnum.CALLING_TIME.getTxt(),calling);
        attributes.put(AttributeEnum.IN_USE_TIME.getTxt(),iu);
        attributes.put(AttributeEnum.NOT_IN_USE_TIME.getTxt(),niu);
        attributes.put(AttributeEnum.POCKET_TIME.getTxt(),pocket);

        System.out.println("Prediction: " + randomForest.predict(attributes));
        return randomForest.predict(attributes).toString();
    }
}
